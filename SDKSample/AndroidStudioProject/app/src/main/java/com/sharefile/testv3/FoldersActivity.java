package com.sharefile.testv3;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sharefile.api.constants.SFKeywords;
import com.sharefile.api.enumerations.SFV3ElementType;
import com.sharefile.api.exceptions.SFInvalidStateException;
import com.sharefile.api.exceptions.SFNotAuthorizedException;
import com.sharefile.api.exceptions.SFSDKException;
import com.sharefile.api.interfaces.ISFApiClient;
import com.sharefile.api.interfaces.ISFApiResultCallback;
import com.sharefile.api.interfaces.ISFQuery;
import com.sharefile.api.interfaces.ISFReAuthHandler;
import com.sharefile.api.interfaces.ISFReExecuteQuery;
import com.sharefile.api.models.SFAccessControl;
import com.sharefile.api.models.SFFolder;
import com.sharefile.api.models.SFItem;
import com.sharefile.api.models.SFODataFeed;
import com.sharefile.api.models.SFSymbolicLink;
import com.sharefile.testv3.Core.Core;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FoldersActivity extends Activity implements ISFReExecuteQuery
{
    private static final SFLogger SLog = new SFLogger();
    private static final String TAG = "FolderActivity";
    private ListView mSFItemListView = null;
	private Activity thisActivity = null;
	private ProgressBar mThrobber = null;
	private String TOP = "top";
	
	private Map<String, SFFolder> mapFolderContents = new HashMap<String, SFFolder>();
	private Stack<String> mFolderIdStack = new Stack<String>();
		
	private void navigateForward(String link) throws URISyntaxException
	{
		SLog.d("GET", "Nav to: " + link);
		confirmExit = false;
		mFolderIdStack.push(link);
		getContents(link);
	}

	private void storeToCache(String folderId,SFFolder object)
	{
		mapFolderContents.put(folderId, object);
	}
	
	private void navigateBack() throws URISyntaxException
	{		
		String link  = mFolderIdStack.peek();
		
		if(!link.contains(TOP))
		{
			link = mFolderIdStack.pop();
			link  = mFolderIdStack.peek();
			getContents(link);
		}				
		else
		{		
			if(confirmExit)
			{
				finish();
			}
			else
			{
				confirmExit = true;
				showToast("Press back again to exit");
				getContents(link);
			}			
		}				
	}
		
		
	private void showBusy(boolean busy)
	{
		if(mThrobber!=null)
		{
			if(busy)
			{
				mThrobber.setVisibility(View.VISIBLE);
			}
			else
			{
				mThrobber.setVisibility(View.INVISIBLE);
			}
		}
	}
	
	private void callCreateFolderApi(String folderName,String folderDescription)
            throws URISyntaxException, SFInvalidStateException
    {
		String parenturl = mFolderIdStack.peek();
		SFFolder folder = new SFFolder();
		folder.setName(folderName);
		folder.setDescription(folderDescription);
		
		Core.getApiClient()
            .items()
            .createFolder(new URI(parenturl), folder,false)
            .executeAsync(new ISFApiResultCallback<SFFolder>()
            {

                @Override
                public void onSuccess(SFFolder object)
                {
                    showToast("success");
                }

                @Override
                public void onError(SFSDKException error,ISFQuery<SFFolder> sfapiApiqueri)
                {
                    showToast(error.getLocalizedMessage());
                }
            })        ;

	}

    private void callGetAccessControlApi() throws URISyntaxException, SFInvalidStateException
    {
		String parenturl = mFolderIdStack.peek();

        Core.getApiClient()
            .accessControls()
            .getByItem(new URI(parenturl))
            .executeAsync(new ISFApiResultCallback<SFODataFeed<SFAccessControl>>() {
                @Override
                public void onSuccess(SFODataFeed<SFAccessControl> object) {
                    showToast("success");
                }

                @Override
                public void onError(SFSDKException v3error, ISFQuery<SFODataFeed<SFAccessControl>> asApiqueri) {
                    showToast(v3error.getLocalizedMessage());
                }
            });

	}

	private void callUploadApi()
	{
		/*
		String parentid = mFolderIdStack.peek();
		final File file = new File("/storage/sdcard0/sharefile/v3upload.bin");
		ISFQuery<SFUploadSpecification> query = SFItemsEntity.upload(parentid, SFUploadMethod.Streamed, true, "v3upload.bin", (long) file.length(), null, false, true, false, false, "sfsdk", true, "hello.txt", "sfsdk upload", false, null, null, 1, "json", false, 365);		
		
		try 
		{
			FullscreenActivity.mSFApiClient.executeQuery(query, new ISFApiResultCallback<SFUploadSpecification>()
			{														

				@Override
				public void onSuccess(SFUploadSpecification object)
				{
					SLog.d("SFSDK","getItem success: ");
					showToast("Actuall upload of file");				
					
					FileInputStream fis;
					try 
					{
						fis = new FileInputStream(file);
						FullscreenActivity.mSFApiClient.uploadFile(object, 0, file.length(), "v3upload.bin", fis, mUploadListener);
					} 
					catch (FileNotFoundException | SFInvalidStateException e) 
					{						
						SLog.d("SFSDK","!!Exception: "+ Log.getStackTraceString(e) );
					}						
				}

				@Override
				public void onError(SFSDKException v3error,ISFQuery<SFUploadSpecification> asApiqueri)
				{
					SLog.d("SFSDK","get Item failed: ");
					showToast("Failed");						
				}

			},null);
		} 
		catch (SFInvalidStateException e) 
		{							
			e.printStackTrace();
			showToast("Exception "+ e.getLocalizedMessage());							
		}
		*/
	}
	
	private void showCreateFolderDialog()
	{		
		final Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.dlg_create_folder);
		dialog.setTitle("Create Folder");

		// set the custom dialog components - text, image and button
		final EditText edxfolderName = (EditText) dialog.findViewById(R.id.create_folder_name);
		final EditText edxfolderDetails = (EditText) dialog.findViewById(R.id.create_folder_details);
		
		Button okButton = (Button) dialog.findViewById(R.id.ok);
		
		okButton.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				String folderName = edxfolderName.getText().toString().trim();
				String folderDetails = edxfolderDetails.getText().toString().trim();
				
				try
                {
					callCreateFolderApi(folderName, folderDetails);
				}
                catch (Exception e)
                {
					Log.e(TAG,"",e);
				}
				
				dialog.dismiss();
			}
		});
		
		
		Button cancelButton = (Button) dialog.findViewById(R.id.cancel);
		
		cancelButton.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				dialog.dismiss();
			}
		});

		WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
	    lp.copyFrom(dialog.getWindow().getAttributes());
	    lp.width = WindowManager.LayoutParams.MATCH_PARENT;
	    lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
	    dialog.show();
	    dialog.getWindow().setAttributes(lp);
	    
		
	}

    @Override
    public void execute(ISFApiClient sfApiClient,
                        ISFQuery query,
                        ISFApiResultCallback listener,
                        ISFReAuthHandler reauthHandler)
    {
        try
        {
            query.executeAsync(listener);
        }
        catch (SFInvalidStateException e)
        {
            Log.e(TAG,"",e);
        }
    }


    private interface GetCredsCallback
	{
		public void doneGetCreds(String userName,String password);
	}
	
	private void showGetCredsDialog(final GetCredsCallback callback)
	{		
		final Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.dlg_get_creds);
		dialog.setTitle("Enter Credentials");

		// set the custom dialog components - text, image and button
		final EditText edxUserName = (EditText) dialog.findViewById(R.id.getcreds_username);
		final EditText edxPassword = (EditText) dialog.findViewById(R.id.getcreds_password);
		
		Button okButton = (Button) dialog.findViewById(R.id.ok);
		
		okButton.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				String userName = edxUserName.getText().toString().trim();
				String password = edxPassword.getText().toString().trim();
				
				callback.doneGetCreds(userName, password);
				
				dialog.dismiss();
			}
		});
		
		
		Button cancelButton = (Button) dialog.findViewById(R.id.cancel);
		
		cancelButton.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				dialog.dismiss();
			}
		});

		WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
	    lp.copyFrom(dialog.getWindow().getAttributes());
	    lp.width = WindowManager.LayoutParams.MATCH_PARENT;
	    lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
	    dialog.show();
	    dialog.getWindow().setAttributes(lp);
	}
	
	public void showToast(final String msg)
	{
		runOnUiThread(new Runnable() 
		{			
			@Override
			public void run() 
			{				
				Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();;
			}
		});
	}
		
	private void showContentsList(SFFolder object)
	{
		SFFolder folderItem = (SFFolder) object;
		SFItemListViewAdapter adapter = new SFItemListViewAdapter(thisActivity, R.layout.sf_item, folderItem.getChildren());
						
		try
		{
			mSFItemListView.setAdapter(adapter);
			mSFItemListView.invalidate();
		}
		catch(Exception e)
		{
			SLog.d("Act", "Exception: "+ Log.getStackTraceString(e));							
		}
		
		showBusy(false);
	}
	
	boolean confirmExit = false;
	
	@Override
	public void onBackPressed() 
	{		
		//super.onBackPressed();
		
		try 
		{
			navigateBack();
		} 
		catch (Exception e) 
		{
			if(confirmExit)
			{
				finish();
			}
			else
			{
				confirmExit = true;
				showToast("Press back again to exit");
				return;
			}
		}		
								
	}
				
	private SFFolder getFromCache(String folderid)
	{		
		return mapFolderContents.get(folderid);
	}
	
	private URI getUriFromLink(String link) throws URISyntaxException
	{
		URI uri = null;
		
		SLog.d("GET", "build link for = " + link);

		uri = new URI(link);

		SLog.d("GET", "ret URI = " + uri.toString());
		
		return uri;
	}


    private synchronized void getContents(final String link) throws URISyntaxException
	{		
		SFFolder folder = getFromCache(link);
						
		if(folder!=null)
		{						
			showContentsList(folder);
			return;
		}

        showBusy(true);

		try 
		{
            Core.getApiClient()
                    .items()
                    .get(getUriFromLink(link),false)
                    .expand(SFKeywords.CHILDREN)
                    .expand(SFKeywords.REDIRECTION).executeAsync(getContentsListener);
		} 
		catch (SFInvalidStateException e) 
		{							
			showBusy(false);
			showToast("Exception "+ e.getLocalizedMessage());
		}
	}
		
	ISFApiResultCallback<SFItem> getContentsListener = new ISFApiResultCallback<SFItem>()
	{										
		@Override
		public void onSuccess(final SFItem object)
		{
            if(SFV3ElementType.isFolderType(object))
            {
                storeToCache(object.geturl().toString(), (SFFolder) object);
                showContentsList((SFFolder) object);
            }
		}

		@Override
		public void onError(final SFSDKException v3error,final ISFQuery<SFItem> asApiqueri)
		{									
			SLog.e(TAG,"",v3error);

            showToast("Failed Get Item: " + v3error.getLocalizedMessage());

            showBusy(false);

            if(v3error  instanceof SFNotAuthorizedException)
            {
                showGetCredsDialog(new GetCredsCallback()
                {
                    @Override
                    public void doneGetCreds(final String userName, final String password)
                    {
                        showBusy(true);

                        try
                        {
                            ((SFNotAuthorizedException) v3error).getReAuthContext().
                                    reExecuteQueryWithCredentials(userName,
                                            password,
                                            FoldersActivity.this);
                        }
                        catch (SFInvalidStateException e)
                        {
                            Log.e(TAG,"",e);
                        }
                    }
                });

            }
            else
            {
                showToast(v3error.getLocalizedMessage());
            }
		}
	};
		
	
	private void initUIControls()
	{
		Button createFolder = (Button) findViewById(R.id.folderActions_buttonCreateFolder);
		
		createFolder.setOnClickListener(new OnClickListener() 
		{			
			@Override
			public void onClick(View v) 
			{				
				showCreateFolderDialog();
			}
		});
		
		
		Button getAccessControlList = (Button) findViewById(R.id.folderActions_buttonPreferences);
		
		getAccessControlList.setOnClickListener(new OnClickListener() 
		{			
			@Override
			public void onClick(View v) 
			{				
				try
                {
					callGetAccessControlApi();
				}
                catch (Exception e)
                {
					Log.e(TAG,"",e);
				}
			}
		});
		
		
		Button upload = (Button) findViewById(R.id.folderActions_buttonUpload);
		
		upload.setOnClickListener(new OnClickListener() 
		{			
			@Override
			public void onClick(View v) 
			{				
				callUploadApi();
			}
		});
		
		//////////////////  List View///////////////////////
		mSFItemListView = (ListView) findViewById(R.id.Folder_listview);
		mThrobber = (ProgressBar)findViewById(R.id.Folder_throbber);
		
		mSFItemListView.setOnItemClickListener(new OnItemClickListener() 
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) 
			{
				//SFItem item = (SFItem) view.getTag();
				SwipeListItemState state = (SwipeListItemState) view.getTag();
				SFItem item = state.mSFItem;				
				
				if(item!=null)
				{
					if(SFV3ElementType.isFolderType(item)) 
					{						
							String fid = item.getId();								
							String link = null;
							
							if(item instanceof SFSymbolicLink)
							{
								link = ((SFSymbolicLink)item).getLink().toString();
							}
							else
							{
								link = item.geturl().toString();
							}
														
							//getContents(fid,link);
							try
                            {
								navigateForward(item.geturl().toString());
							}
                            catch (URISyntaxException e)
                            {
								e.printStackTrace();
							}
					}
					else if(SFV3ElementType.isFileType(item))
					{
						showToast("Starting download for: " + item.getName());
						
						callDownloadApi(item.getId());
					}
				}
			}
         }); 	
	}
	
	
	private void callDownloadApi(String itemid )
	{
		/*
		ISFQuery<SFDownloadSpecification> downloadQuery = SFItemsEntity.download(itemid, true);
		
		try {
				FullscreenActivity.mSFApiClient.executeQuery(downloadQuery, new ISFApiResultCallback<SFDownloadSpecification>()
					{

						@Override
						public void onSuccess(SFDownloadSpecification object)
						{	
							showToast("Start actual download...");
							
							SLog.d("download","dspec = %s", object.getDownloadUrl() );
							
							FileOutputStream fileOutpuStream;
							try 
							{
								fileOutpuStream = new FileOutputStream("/storage/sdcard0/sharefile/v3download.bin");
								FullscreenActivity.mSFApiClient.downloadFile(object, 0, fileOutpuStream, mDownloadloadProgressListener);
							} 
							catch (FileNotFoundException | SFInvalidStateException e) 
							{								
								SLog.d("download", "!!Exception: %s" , Log.getStackTraceString(e));
							}																					
						}

						@Override
						public void onError(SFSDKException error,ISFQuery<SFDownloadSpecification> asApiqueri)
						{	
							SLog.d("download","error = %s" , error.message.value);
						}
			});
		}
		catch (SFInvalidStateException e) 
		{			
			e.printStackTrace();
		}*/		
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{		
		thisActivity = this;
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.folder);
		
		initUIControls();
	}
			
	@Override
	protected void onStart() 
	{		
		super.onStart();			

		try
        {
            mFolderIdStack.clear();
			navigateForward(Core.getApiClient().getTopUrl().toString());
		}
        catch (URISyntaxException e)
        {
			Log.e(TAG,"",e);
		}
	}
}