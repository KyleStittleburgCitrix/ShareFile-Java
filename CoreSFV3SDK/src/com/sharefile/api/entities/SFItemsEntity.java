
// ------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//  
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
//     
//	   Copyright (c) 2014 Citrix ShareFile. All rights reserved.
// </auto-generated>
// ------------------------------------------------------------------------------

package com.sharefile.api.entities;

import com.sharefile.api.entities.*;
import com.sharefile.api.models.*;
import com.sharefile.api.models.internal.*;
import com.sharefile.api.SFApiQuery;
import com.sharefile.api.interfaces.ISFQuery;


import java.io.InputStream;
import java.util.ArrayList;
import java.net.URI;
import java.util.Date;
 
import com.google.gson.annotations.SerializedName;
import com.sharefile.api.enumerations.SFSafeEnum;

public class SFItemsEntity extends SFODataEntityBase
{
    /**
	* Get HomeFolder for Current User
	* Returns home folder for current user.
	* Note that home folders are not available for client users, or if the account doesn't have the "My Files & Folders" feature enabled.
	* @return home folder for current user
    */
	public ISFQuery<SFItem> get()
	{
		SFApiQuery<SFItem> sfApiQuery = new SFApiQuery<SFItem>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get Item by ID
	* Returns a single Item.
	* Special Id's:home, favorites, allshared, connectors, box, top. home - Return home folder.
	* favorites - Return parent favorite item; use .../Items(favorites)/Children to get the favorite folders.
	* allshared - Return parent Shared Folders item; use .../Items(allshared)/Children to get the shared folders.
	* connectors - Return parent Connectors item; use .../Items(connectors)/Children to get indiviual connectors.
	* box - Return the FileBox folder. top - Returns the Top item; use .../Items(top)/Children to get the home, favorites, and shared folders as well as the connectors
	* @param url 	
	* @param includeDeleted 	
	* @return a single Item
    */
	public ISFQuery<SFItem> get(URI url, Boolean includeDeleted)
	{
		SFApiQuery<SFItem> sfApiQuery = new SFApiQuery<SFItem>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.addIds(url);
		sfApiQuery.addQueryString("includeDeleted", includeDeleted);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get TreeView
	* Retrieves a folder list structure tailored for TreeView navigation - used by clients
	* to create folder trees for specific operations.
	* This operation will enforce a specific $select and $expand operators. You can provide
	* additional $expand, for example Children, which is not added by default. The $select
	* operator will apply to the expanded objects as well. You can also specify additional
	* $select elements.
	* @param url 	
	* @param treeMode 	
	* @param sourceId 	
	* @param canCreateRootFolder 	
	* @param fileBox 	
	* @return A tree root element.
    */
	public ISFQuery<SFItem> get(URI url, SFSafeEnum<SFTreeMode> treeMode, String sourceId, Boolean canCreateRootFolder, Boolean fileBox)
	{
		SFApiQuery<SFItem> sfApiQuery = new SFApiQuery<SFItem>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.addIds(url);
		sfApiQuery.addQueryString("treeMode", treeMode);
		sfApiQuery.addQueryString("sourceId", sourceId);
		sfApiQuery.addQueryString("canCreateRootFolder", canCreateRootFolder);
		sfApiQuery.addQueryString("fileBox", fileBox);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get Symbolic Links of a Connector Group
	* Retrieves the Symbolic Links of the provided Connector Group type. Connector Groups define
	* classes of external data connectors - such as SharePoint, Network Shares. Symbolic Links
	* represent a single Connector point to such classes - for example, a single SharePoint site,
	* or a network share drive.
	* @param parentUrl 	
	* @return The list of Symbolic Links associated with the given connector group.
    */
	public ISFQuery<SFODataFeed<SFItem>> getChildrenByConnectorGroup(URI parentUrl)
	{
		SFApiQuery<SFODataFeed<SFItem>> sfApiQuery = new SFApiQuery<SFODataFeed<SFItem>>();
		sfApiQuery.setFrom("ConnectorGroups");
		sfApiQuery.setAction("Children");
		sfApiQuery.addIds(parentUrl);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get Stream
	* Retrieves the versions of a given Stream. The ID parameter must be a StreamID, otherwise an empty list is returned.
	* StreamID is a property of all Items, representing the "Stream", ie., the collection of all versions of a file. In
	* contrast, an Item ID represents a single version of a file.
	* For example, when users upload or modify an existing file, a new Item
	* is created with the same StreamID. All default Item enumerations return only the latest version of a given stream.
	* Use this method to retrieve previous versions of a given stream.
	* @param url 	
	* @param includeDeleted 	
    */
	public ISFQuery<SFODataFeed<SFItem>> stream(URI url, Boolean includeDeleted)
	{
		SFApiQuery<SFODataFeed<SFItem>> sfApiQuery = new SFApiQuery<SFODataFeed<SFItem>>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("Stream");
		sfApiQuery.addIds(url);
		sfApiQuery.addQueryString("includeDeleted", includeDeleted);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get Item by Path
	* Retrieves an item from its path. The path is of format /foldername/foldername/filename
	* This call may redirect the client to another API provider, if the path
	* contains a symbolic link.
	* @param path 	
	* @return An item identified by a path
    */
	public ISFQuery<SFItem> byPath(String path)
	{
		SFApiQuery<SFItem> sfApiQuery = new SFApiQuery<SFItem>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("ByPath");
		sfApiQuery.addQueryString("path", path);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get Item by relative Path from ID
	* Retrieves an item from its path, relative to the provided ID.
	* The path is of format /foldername/foldername/filename
	* This call may redirect the client to another API provider, if the path
	* contains a symbolic link.
	* @param url 	
	* @param path 	
	* @return An item identified by a path
    */
	public ISFQuery<SFItem> byPath(URI url, String path)
	{
		SFApiQuery<SFItem> sfApiQuery = new SFApiQuery<SFItem>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("ByPath");
		sfApiQuery.addIds(url);
		sfApiQuery.addQueryString("path", path);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get Parent Item
	* Retrieves the Parent navigation property of a single Item.
	* @param url 	
	* @return the Parent Item of the give object ID.
    */
	public ISFQuery<SFItem> getParent(URI url)
	{
		SFApiQuery<SFItem> sfApiQuery = new SFApiQuery<SFItem>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("Parent");
		sfApiQuery.addIds(url);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get Children
	* Handler for the Children navigation property of a given Item.
	* A 302 redirection is returned if the folder is a SymbolicLink. The redirection
	* will enumerate the children of the remote connector
	* @param url 	
	* @param includeDeleted 	
	* @return the list of children under the given object ID
    */
	public ISFQuery<SFODataFeed<SFItem>> getChildren(URI url, Boolean includeDeleted)
	{
		SFApiQuery<SFODataFeed<SFItem>> sfApiQuery = new SFApiQuery<SFODataFeed<SFItem>>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("Children");
		sfApiQuery.addIds(url);
		sfApiQuery.addQueryString("includeDeleted", includeDeleted);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get Folder Access Info
	* Returns the effective Access Controls for the current authenticated user for the
	* selected folder - i.e., the resulting set of Access Controls for the Item/User context.This operation applies to Folders only, will return an error for other Item types.
	* @param url 	
	* @return The Folder Access Control Information
    */
	public ISFQuery<SFItemInfo> getInfo(URI url)
	{
		SFApiQuery<SFItemInfo> sfApiQuery = new SFApiQuery<SFItemInfo>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("Info");
		sfApiQuery.addIds(url);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Download Item Content
	* Initiate the download operation for an item. It will return 302 redirection to the
	* actual download link. For Folders, the download link will retrieve a ZIP archive
	* with the contents of the Folder.
	* @param url 	
	* @param redirect 	
	* @return the download link for the provided item content.
    */
	public ISFQuery<InputStream> download(URI url, Boolean redirect)
	{
		SFApiQuery<InputStream> sfApiQuery = new SFApiQuery<InputStream>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("Download");
		sfApiQuery.addIds(url);
		sfApiQuery.addQueryString("redirect", redirect);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Download Multiple Items
    * ["id1","id2",...]
	* Initiate the download operation for items. It will return 302 redirection to the
	* actual download link.
	* @param parentUrl 	
	* @param ids 	
	* @param redirect 	
	* @return the download link for the provided item content.
    */
	public ISFQuery<InputStream> bulkDownload(URI parentUrl, ArrayList<String> ids, Boolean redirect)
	{
		SFApiQuery<InputStream> sfApiQuery = new SFApiQuery<InputStream>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("BulkDownload");
		sfApiQuery.addIds(parentUrl);
		sfApiQuery.addQueryString("redirect", redirect);
		sfApiQuery.setBody(ids);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

    /**
	* Create Folder
    * {
    * "Name":"Folder Name",
    * "Description":"Description",
    * "Zone":{ "Id":"z014766e-8e96-4615-86aa-57132a69843c" }
    * }
	* Creates a new Folder.
	* The POST body must contain the serialized object.
	* For top-level folders, use Items/Folder.
	* The Zone object may only be provided for top-level folders. The Zone object must
	* contain a zone ID.
	* @param parentUrl 	
	* @param folder 	
	* @param overwrite 	
	* @param passthrough 	
	* @return the new Folder
    */
	public ISFQuery<SFFolder> createFolder(URI parentUrl, SFFolder folder, Boolean overwrite, Boolean passthrough)
	{
		SFApiQuery<SFFolder> sfApiQuery = new SFApiQuery<SFFolder>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("Folder");
		sfApiQuery.addIds(parentUrl);
		sfApiQuery.addQueryString("overwrite", overwrite);
		sfApiQuery.addQueryString("passthrough", passthrough);
		sfApiQuery.setBody(folder);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

    /**
	* Create Note
    * {
    * "Name":"Note Name",
    * "Description":"Description"
    * }
	* Creates a new Note.
	* @param parentUrl 	
	* @param note 	
	* @return the new Note
    */
	public ISFQuery<SFNote> createNote(URI parentUrl, SFNote note)
	{
		SFApiQuery<SFNote> sfApiQuery = new SFApiQuery<SFNote>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("Note");
		sfApiQuery.addIds(parentUrl);
		sfApiQuery.setBody(note);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

    /**
	* Create Link
    * {
    * "Name":"Link Name",
    * "Description":"Description",
    * "Uri":"https://server/path"
    * }
	* Creates a new Link
	* @param parentUrl 	
	* @param link 	
	* @return the new Link
    */
	public ISFQuery<SFLink> createLink(URI parentUrl, SFLink link)
	{
		SFApiQuery<SFLink> sfApiQuery = new SFApiQuery<SFLink>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("Link");
		sfApiQuery.addIds(parentUrl);
		sfApiQuery.setBody(link);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

    /**
	* Create SymbolicLink
    * {
    * "Name":"RemoteFileName",
    * "Description":"Description",
    * "Zone":{ "Id":"z014766e-8e96-4615-86aa-57132a69843c" },
    * "ConnectorGroup": { "Id":"1" }
    * }
	* Creates a Symbolic Link
	* The body must contain either a "Link" parameter with a fully qualified URI; or use
	* FileName + Zone to have sharefile.com attempt to convert the Connector path to an
	* URI using a call to the Zone - using ShareFile Hash authentication mode. For active
	* clients, it's recommended to make the convertion call to the Zone directly, using
	* Items/ByPath=name, retriving the resulting URL, and calling this method with the
	* Link parameter.SymbolicLinks must be created as top-level folders - i.e., this call requires
	* the parent to be the Item(accountid) element.Zone defines the location of the SymbolicLink target - for example, for
	* Network Shares connectors, the SymbolicLink will point to the StorageZone Controller
	* that will serve the file browsing requests.The ConnectorGroup parameter indicates the kind of symbolic link - e.g., Network
	* Share, or SharePoint.
	* @param parentUrl 	
	* @param symlink 	
	* @param overwrite 	
	* @return the new SymbolicLink
    */
	public ISFQuery<SFSymbolicLink> createSymbolicLink(URI parentUrl, SFSymbolicLink symlink, Boolean overwrite)
	{
		SFApiQuery<SFSymbolicLink> sfApiQuery = new SFApiQuery<SFSymbolicLink>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("SymbolicLink");
		sfApiQuery.addIds(parentUrl);
		sfApiQuery.addQueryString("overwrite", overwrite);
		sfApiQuery.setBody(symlink);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

    /**
	* Creates SymbolicLink
    * {
    * "Name":"RemoteFileName",
    * "Description":"Description",
    * "Link":"https://server/provider/version/Items(id)",
    * "Zone":{ "Id":"z014766e-8e96-4615-86aa-57132a69843c" },
    * "ConnectorGroup": { "Id":"1" }
    * }
	* @param url 	
	* @param symlink 	
	* @param overwrite 	
	* @return the new SymbolicLink
    */
	public ISFQuery<SFSymbolicLink> createChildrenByConnectorGroup(URI url, SFSymbolicLink symlink, Boolean overwrite)
	{
		SFApiQuery<SFSymbolicLink> sfApiQuery = new SFApiQuery<SFSymbolicLink>();
		sfApiQuery.setFrom("ConnectorGroups");
		sfApiQuery.setAction("Children");
		sfApiQuery.addIds(url);
		sfApiQuery.addQueryString("overwrite", overwrite);
		sfApiQuery.setBody(symlink);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

    /**
	* Update Item
    * {
    * "Name":"Name",
    * "FileName":"FileName",
    * "Description":"Description",
    * "ExpirationDate": "date",
    * "Parent": { "Id": "parentid" },
    * "Zone": { "Id": "zoneid" }
    * }
	* Updates an Item object. Please note that for a Folder, the Name and FileName properties must be consistent.
	* If a new Name is provided, the FileName will also be updated with the new name, and viceversa.
	* If both Name and FileName are provided, FileName is disregarded and Name will be used to update both properties.
	* @param url 	
	* @param item 	
	* @param forceSync 	
	* @return A modified Item object. If the item Zone or Parent Zone is modified, then this method will return an Asynchronous operation record instead. Note: the parameters listed in the body of the request are the only parameters that can be updated through this call.
    */
	public ISFQuery<SFItem> update(URI url, SFItem item, String batchid, Long batchSizeInBytes, Boolean forceSync, Boolean scheduleAsync, Boolean resolveFolderNameConflict)
	{
		SFApiQuery<SFItem> sfApiQuery = new SFApiQuery<SFItem>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.addIds(url);
		sfApiQuery.addQueryString("batchid", batchid);
		sfApiQuery.addQueryString("batchSizeInBytes", batchSizeInBytes);
		sfApiQuery.addQueryString("forceSync", forceSync);
		sfApiQuery.addQueryString("scheduleAsync", scheduleAsync);
		sfApiQuery.addQueryString("resolveFolderNameConflict", resolveFolderNameConflict);
		sfApiQuery.setBody(item);
		sfApiQuery.setHttpMethod("PATCH");
		return sfApiQuery;
	}

    /**
	* Update Link
    * {
    * "Name":"Name",
    * "Uri":"https://server/path",
    * "Description":"Description",
    * "Parent": { "Id": "parentid" },
    * }
	* Updates a Link object
	* @param id 	
	* @param link 	
	* @param notify 	
	* @return A modified Link object
    */
	public ISFQuery<SFLink> updateLink(String id, SFLink link, Boolean notify)
	{
		SFApiQuery<SFLink> sfApiQuery = new SFApiQuery<SFLink>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("Link");
		sfApiQuery.addActionIds(id);
		sfApiQuery.addQueryString("notify", notify);
		sfApiQuery.setBody(link);
		sfApiQuery.setHttpMethod("PATCH");
		return sfApiQuery;
	}

    /**
	* Update Note
    * {
    * "Name":"Name",
    * "Description":"Description",
    * "Parent": { "Id": "parentid" },
    * }
	* Updates a Note object
	* @param id 	
	* @param note 	
	* @param notify 	
	* @return The modified Note object
    */
	public ISFQuery<SFNote> updateNote(String id, SFNote note, Boolean notify)
	{
		SFApiQuery<SFNote> sfApiQuery = new SFApiQuery<SFNote>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("Note");
		sfApiQuery.addActionIds(id);
		sfApiQuery.addQueryString("notify", notify);
		sfApiQuery.setBody(note);
		sfApiQuery.setHttpMethod("PATCH");
		return sfApiQuery;
	}

    /**
	* Update SymbolicLink
    * {
    * "Name":"Name",
    * "Description":"Description",
    * "Link": "https://server/path"
    * }
	* Updates a Symbolic Link object
	* @param id 	
	* @param symlink 	
	* @return The modified SymbolicLink object
    */
	public ISFQuery<SFSymbolicLink> updateSymbolicLink(String id, SFSymbolicLink symlink)
	{
		SFApiQuery<SFSymbolicLink> sfApiQuery = new SFApiQuery<SFSymbolicLink>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("SymbolicLink");
		sfApiQuery.addActionIds(id);
		sfApiQuery.setBody(symlink);
		sfApiQuery.setHttpMethod("PATCH");
		return sfApiQuery;
	}

    /**
	* Delete Item
	* Removes an item
	* @param url 	
	* @param singleversion 	
	* @param forceSync 	
    */
	public ISFQuery delete(URI url, Boolean singleversion, Boolean forceSync)
	{
		SFApiQuery sfApiQuery = new SFApiQuery();
		sfApiQuery.setFrom("Items");
		sfApiQuery.addIds(url);
		sfApiQuery.addQueryString("singleversion", singleversion);
		sfApiQuery.addQueryString("forceSync", forceSync);
		sfApiQuery.setHttpMethod("DELETE");
		return sfApiQuery;
	}

    /**
	* Delete Multiple Items
    * ["id1","id2",...]
	* All items in bulk delete must be children of the same parent, identified in the URI
	* @param id 	
	* @param body 	
	* @param forceSync 	
	* @param deletePermanently 	
    */
	public ISFQuery bulkDelete(URI url, ArrayList<String> ids, Boolean forceSync, Boolean deletePermanently)
	{
		SFApiQuery sfApiQuery = new SFApiQuery();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("BulkDelete");
		sfApiQuery.addIds(url);
		sfApiQuery.addQueryString("forceSync", forceSync);
		sfApiQuery.addQueryString("deletePermanently", deletePermanently);
		sfApiQuery.setBody(ids);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

    /**
	* Get Thumbnail
	* Retrieve a thumbnail link from the specified Item.
	* @param url 	
	* @param size 	
	* @param redirect 	
	* @return A 302 redirection to the Thumbnail link
    */
	public ISFQuery<InputStream> getThumbnail(URI url, Integer size, Boolean redirect)
	{
		SFApiQuery<InputStream> sfApiQuery = new SFApiQuery<InputStream>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("Thumbnail");
		sfApiQuery.addIds(url);
		sfApiQuery.addQueryString("size", size);
		sfApiQuery.addQueryString("redirect", redirect);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get Breadcrumbs
	* Retrieves the path from an item from the root. The return list is a Feed of Items, with the top-level
	* folder at the first position. If this item is in a Connection path, the breadcrumbs may contain URL
	* reference back to the parent account - and the Item in the feed will contain just the URL reference.
	* @param url 	
	* @param path 	
	* @return A feed containing the path of folders from the specified root to the item, in order
    */
	public ISFQuery<SFODataFeed<SFItem>> getBreadcrumbs(URI url, String path)
	{
		SFApiQuery<SFODataFeed<SFItem>> sfApiQuery = new SFApiQuery<SFODataFeed<SFItem>>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("Breadcrumbs");
		sfApiQuery.addIds(url);
		sfApiQuery.addQueryString("path", path);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Copy Item
	* Copies an item to a new target Folder. If the target folder is in another zone, the operation will
	* return an AsyncOperation record instead. Clients may query the /AsyncOperation Entity to determine
	* operation progress and result.
	* @param url 	
	* @param targetid 	
	* @param overwrite 	
	* @return the modified source object
    */
	public ISFQuery<SFItem> copy(URI url, String targetid, Boolean overwrite)
	{
		SFApiQuery<SFItem> sfApiQuery = new SFApiQuery<SFItem>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("Copy");
		sfApiQuery.addIds(url);
		sfApiQuery.addQueryString("targetid", targetid);
		sfApiQuery.addQueryString("overwrite", overwrite);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

    /**
	* Upload File
    * POST https://account.sf-api.com/sf/v3/Items(id)/Upload2
    * {
    * "Method":"Method",
    * "Raw": false,
    * "FileName":"FileName"
    * "FileLength": length
    * }
	* Prepares the links for uploading files to the target Folder.
	* This method returns an Upload Specification object. The fields are
	* populated based on the upload method, provider, and resume parameters passed to the
	* upload call.
	* The Method determines how the URLs must be called.
	* 
	* There are two different URL's to upload: /sf/v3/Items(id)/Upload? accepts the upload parameters
	* through a query URL string, while /sf/v3/Items(id)/Upload2 does it through the HTTP POST message body.
	* If using 'Upload2', the parameters must be capitalized.
	* 
	* Standard uploads use a single HTTP POST message to the ChunkUri address provided in
	* the response. All other fields will be empty. Standard uploads do not support Resume.
	* 
	* Streamed uploads use multiple HTTP POST calls to the ChunkUri address. The client must
	* append the parameters index, offset and hash to the end of the ChunkUri address. Index
	* is a sequential number representing the data block (zero-based); Offset represents the
	* byte offset for the block; and hash contains the MD5 hash of the block. The last HTTP
	* POST must also contain finish=true parameter.
	* 
	* Threaded uploads use multiple HTTP POST calls to ChunkUri, and can have a number of
	* threads issuing blocks in parallel. Clients must append index, offset and hash to
	* the end of ChunkUri, as explained in Streamed. After all chunks were sent, the client
	* must call the FinishUri provided in this spec.
	* 
	* If using the Threaded Uploader, you can attach the argument fmt=json to each ChunkUri
	* to indicate you wish to retrieve the Item ID of the file after the upload is completed.
	* 
	* For all uploaders, the contents of the POST Body can either be "raw", if the "Raw" parameter
	* was provided to the Uploader, or use MIME multi-part form encoding otherwise. Raw uploads
	* simply put the block content in the POST body - Content-Length specifies the size. Multi-part
	* form encoding has to pass the File as a Form parameter named "File1".
	* 
	* For streamed and threaded, if Resume options were provided to the Upload call, then the
	* fields IsResume, ResumeIndex, ResumeOffset and ResumeFileHash MAY be populated. If they are,
	* it indicates that the server has identified a partial upload with that specification, and is
	* ready to resume on the provided parameters. The clients can then verify the ResumeFileHash to
	* ensure the file has not been modified; and continue issuing ChunkUri calls from the ResumeIndex
	* ResumeOffset parameters. If the client decides to restart, it should simply ignore the resume
	* parameters and send the blocks from Index 0.
	* 
	* For all uploaders: the result code for the HTTP POST calls to Chunk and Finish Uri can either
	* be a 401 - indicating authentication is required; 4xx/5xx indicating some kind of error; or
	* 200 with a Content Body of format 'ERROR:message'. Successful calls will return either a 200
	* response with no Body, or with Body of format 'OK'.
	* @param url 	
	* @param method 	
	* @param raw 	
	* @param fileName 	
	* @param fileSize 	
	* @param batchId 	
	* @param batchLast 	
	* @param canResume 	
	* @param startOver 	
	* @param unzip 	
	* @param tool 	
	* @param overwrite 	
	* @param title 	
	* @param details 	
	* @param isSend 	
	* @param sendGuid 	
	* @param opid 	
	* @param threadCount 	
	* @param responseFormat 	
	* @param notify 	
	* @param clientCreatedDateUTC 	
	* @param clientModifiedDateUTC 	
	* @return an Upload Specification element, containing the links for uploading, and the parameters for resume. The caller must know the protocol for sending the prepare, chunk and finish URLs returned in the spec; as well as negotiate the resume upload.
    */
	public ISFQuery<SFUploadSpecification> upload(URI url, SFSafeEnum<SFUploadMethod> method, Boolean raw, String fileName, Long fileSize, String batchId, Boolean batchLast, Boolean canResume, Boolean startOver, Boolean unzip, String tool, Boolean overwrite, String title, String details, Boolean isSend, String sendGuid, String opid, Integer threadCount, String responseFormat, Boolean notify, Date clientCreatedDateUTC, Date clientModifiedDateUTC, Integer expirationDays)
	{
		SFApiQuery<SFUploadSpecification> sfApiQuery = new SFApiQuery<SFUploadSpecification>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("Upload");
		sfApiQuery.addIds(url);
		sfApiQuery.addQueryString("method", method);
		sfApiQuery.addQueryString("raw", raw);
		sfApiQuery.addQueryString("fileName", fileName);
		sfApiQuery.addQueryString("fileSize", fileSize);
		sfApiQuery.addQueryString("batchId", batchId);
		sfApiQuery.addQueryString("batchLast", batchLast);
		sfApiQuery.addQueryString("canResume", canResume);
		sfApiQuery.addQueryString("startOver", startOver);
		sfApiQuery.addQueryString("unzip", unzip);
		sfApiQuery.addQueryString("tool", tool);
		sfApiQuery.addQueryString("overwrite", overwrite);
		sfApiQuery.addQueryString("title", title);
		sfApiQuery.addQueryString("details", details);
		sfApiQuery.addQueryString("isSend", isSend);
		sfApiQuery.addQueryString("sendGuid", sendGuid);
		sfApiQuery.addQueryString("opid", opid);
		sfApiQuery.addQueryString("threadCount", threadCount);
		sfApiQuery.addQueryString("responseFormat", responseFormat);
		sfApiQuery.addQueryString("notify", notify);
		sfApiQuery.addQueryString("clientCreatedDateUTC", clientCreatedDateUTC);
		sfApiQuery.addQueryString("clientModifiedDateUTC", clientModifiedDateUTC);
		sfApiQuery.addQueryString("expirationDays", expirationDays);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

	public ISFQuery<SFUploadSpecification> upload2(URI url, SFUploadRequestParams uploadParams, Integer expirationDays)
	{
		SFApiQuery<SFUploadSpecification> sfApiQuery = new SFApiQuery<SFUploadSpecification>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("Upload2");
		sfApiQuery.addIds(url);
		sfApiQuery.addQueryString("expirationDays", expirationDays);
		sfApiQuery.setBody(uploadParams);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

    /**
	* Unlock File
	* Unlock a locked file.
	* This operation is only implemented in Sharepoint providers (/sp)
	* @param url 	
	* @param message 	
    */
	public ISFQuery checkIn(URI url, String message)
	{
		SFApiQuery sfApiQuery = new SFApiQuery();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("CheckIn");
		sfApiQuery.addIds(url);
		sfApiQuery.addQueryString("message", message);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

	public ISFQuery checkOut(URI url)
	{
		SFApiQuery sfApiQuery = new SFApiQuery();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("CheckOut");
		sfApiQuery.addIds(url);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

	public ISFQuery discardCheckOut(URI url)
	{
		SFApiQuery sfApiQuery = new SFApiQuery();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("DiscardCheckOut");
		sfApiQuery.addIds(url);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

    /**
	* Search
	* Search for Items matching the criteria of the query parameter
	* @param query 	
	* @param maxResults 	
	* @param skip 	
	* @param homeFolderOnly 	
	* @return SearchResults
    */
	public ISFQuery<SFSearchResults> search(String query, Integer maxResults, Integer skip, Boolean homeFolderOnly)
	{
		SFApiQuery<SFSearchResults> sfApiQuery = new SFApiQuery<SFSearchResults>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("Search");
		sfApiQuery.addQueryString("query", query);
		sfApiQuery.addQueryString("maxResults", maxResults);
		sfApiQuery.addQueryString("skip", skip);
		sfApiQuery.addQueryString("homeFolderOnly", homeFolderOnly);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Advanced Simple Search
    * {
    * "Query":{
    * "ItemType":"",
    * "ParentID":"",
    * "CreatorID":"",
    * "SearchQuery":"",
    * "CreateStartDate":"",
    * "CreateEndDate":"",
    * "ItemNameOnly":false
    * },
    * "Paging":{
    * "PageNumber":1, (Deprecated)
    * "PageSize":10, (Deprecated)
    * "Count": 50
    * "Skip": 0
    * },
    * "Sort":{
    * "SortBy":"",
    * "Ascending":false,
    * },
    * "TimeoutInSeconds":10
    * }
	* Search for Items matching the criteria of the query parameter
	* @param simpleSearchQuery 	
	* @return AdvancedSearchResults
    */
	public ISFQuery<SFAdvancedSearchResults> advancedSimpleSearch(SFSimpleSearchQuery simpleSearchQuery)
	{
		SFApiQuery<SFAdvancedSearchResults> sfApiQuery = new SFApiQuery<SFAdvancedSearchResults>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("AdvancedSimpleSearch");
		sfApiQuery.setBody(simpleSearchQuery);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

    /**
	* Advanced Search
    * {
    * "Query":{
    * "ItemTypes":["type1", "type2", ...],
    * "ParentID":["id1", "id2", ...],
    * "CreatorID":["id1", "id2", ...],
    * "SearchQuery":"",
    * "CreateStartDate":"",
    * "CreateEndDate":"",
    * "ItemNameOnly":false
    * },
    * "Paging":{
    * "PageNumber":1, (deprecated)
    * "PageSize":10, (deprecated)
    * "Count":50, (default value)
    * "Skip":0, (default value)
    * },
    * "Sort":{
    * "SortBy":"",
    * "Ascending":false,
    * },
    * "TimeoutInSeconds":10
    * }
	* Search for Items matching the criteria of the query parameter
	* @param searchQuery 	
	* @return AdvancedSearchResults
    */
	public ISFQuery<SFAdvancedSearchResults> advancedSearch(SFSearchQuery searchQuery)
	{
		SFApiQuery<SFAdvancedSearchResults> sfApiQuery = new SFApiQuery<SFAdvancedSearchResults>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("AdvancedSearch");
		sfApiQuery.setBody(searchQuery);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

    /**
	* Get Web Preview Link
	* Redirects the caller to the Web Edit application for the selected item.
	* @param url 	
	* @return A redirection message to the Web Edit app for this item. It returns 404 (Not Found) if the Web Preview app doesn't support the file type.
    */
	public ISFQuery<SFRedirection> webView(URI url)
	{
		SFApiQuery<SFRedirection> sfApiQuery = new SFApiQuery<SFRedirection>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("WebView");
		sfApiQuery.addIds(url);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get List of Item Protocol Links
	* @param url 	
	* @param platform 	
	* @return A list of protocol links depending on the input parameter 'platform', 404 (Not Found) if not supported by the item
    */
	public ISFQuery<SFODataFeed<SFItemProtocolLink>> getProtocolLinks(URI url, SFSafeEnum<SFPreviewPlatform> platform)
	{
		SFApiQuery<SFODataFeed<SFItemProtocolLink>> sfApiQuery = new SFApiQuery<SFODataFeed<SFItemProtocolLink>>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("ProtocolLinks");
		sfApiQuery.addIds(url);
		sfApiQuery.addActionIds(platform);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

    /**
	* Get Redirection endpoint Information
	* Returns the redirection endpoint for this Item.This operation applies to Folders and SymbolicLinks only, will return an error for other Item types.
	* @param url 	
	* @return The Redirection endpoint Information
    */
	public ISFQuery<SFRedirection> getRedirection(URI url)
	{
		SFApiQuery<SFRedirection> sfApiQuery = new SFApiQuery<SFRedirection>();
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("Redirection");
		sfApiQuery.addIds(url);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

}

