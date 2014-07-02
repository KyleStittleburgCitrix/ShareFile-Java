package com.sharefile.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sharefile.java.log.SLog;


public class SFDateFormat
{
	private static final String TAG = "SFDateFormat";
	
	
	//Add more ShareFile date formats if newer formats get added
	private static final  SimpleDateFormat v3SimpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSSSZ");
	private static final  SimpleDateFormat v3SimpleDateFormat2 = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss");
	
	private static final SFDateFormat[] mSFDateFormats = new SFDateFormat[]
	{
		new SFDateFormat(v3SimpleDateFormat, "+0000"),
		new SFDateFormat(v3SimpleDateFormat2, "")
	};	
	
	
	private final SimpleDateFormat mFormat;
	private final String mZoneReplace;
	
	public SFDateFormat(SimpleDateFormat sf,String zonereplace) 
	{
		mFormat = sf;
		mZoneReplace = zonereplace;
	}
	
	private static Date parse(SFDateFormat format, String str)
	{
		Date ret = null;
		
		try 
		{			
			ret = format.mFormat.parse(str.replace("Z", format.mZoneReplace));			
		} 
		catch (ParseException e) 
		{				
			//don't log this to reduce the noise
		}
		catch (Exception e) 
		{
			SLog.e(TAG,e);
		}
		
		return ret;
	}
			
	public static Date parse(String str)
	{
		Date ret = null;
		
		if(str == null)
		{
			return null;
		}
		
		for(SFDateFormat d:mSFDateFormats)
		{
			ret = SFDateFormat.parse(d,str);
			
			if(ret != null)
			{
				break;
			}
		}
		
		if(ret == null)
		{
			SLog.e(TAG, "cannot parse date: " + str);
		}
		
		return ret;
	}	
}