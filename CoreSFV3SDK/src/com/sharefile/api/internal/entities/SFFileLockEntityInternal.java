
// ------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//  
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
//     
//	   Copyright (c) 2015 Citrix ShareFile. All rights reserved.
// </auto-generated>
// ------------------------------------------------------------------------------

package com.sharefile.api.internal.entities;

import com.sharefile.api.entities.*;
import com.sharefile.api.exceptions.InvalidOrMissingParameterException;
import com.sharefile.api.interfaces.ISFApiClient;
import com.sharefile.api.models.*;
import com.sharefile.api.SFApiQuery;
import com.sharefile.api.interfaces.ISFQuery;


import java.net.URI;

public class SFFileLockEntityInternal extends SFODataEntityBase
{
	public SFFileLockEntityInternal(ISFApiClient client) {
		super(client);
	}

	/**
	* Get Item Lock info
	* Retrieves the lock info for a given Item.
	* @param url 	 	
	* @return Lock info
	*/
	public ISFQuery<SFFileLock> getByItem(URI url) throws InvalidOrMissingParameterException {
		if (url == null) {
			throw new InvalidOrMissingParameterException("url");
		}

		SFApiQuery<SFFileLock> sfApiQuery = new SFApiQuery<SFFileLock>(this.apiClient);
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("FileLock");
		sfApiQuery.addIds(url);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

	/**
	* Create Lock
	* @param url 	 	
	* @param fileLock 	 	
	* @return The created item Lock object
	*/
	public ISFQuery<SFFileLock> createByItem(URI url, SFFileLock fileLock) throws InvalidOrMissingParameterException 	{
		if (url == null) {
			throw new InvalidOrMissingParameterException("url");
		}
		if (fileLock == null) {
			throw new InvalidOrMissingParameterException("fileLock");
		}

		SFApiQuery<SFFileLock> sfApiQuery = new SFApiQuery<SFFileLock>(this.apiClient);
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("FileLock");
		sfApiQuery.addIds(url);
		sfApiQuery.setBody(fileLock);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

	/**
	* Update FileLock
    * {
    * LockId:"lockid",
    * Owner:{Id:"ownerid"},
    * ExpirationTimeInMinutes:30
    * }
	* @param url 	 	
	* @param fileLock 	 	
	* @return The updated lock object
	*/
	public ISFQuery<SFFileLock> updateByItem(URI url, SFFileLock fileLock) throws InvalidOrMissingParameterException 	{
		if (url == null) {
			throw new InvalidOrMissingParameterException("url");
		}
		if (fileLock == null) {
			throw new InvalidOrMissingParameterException("fileLock");
		}

		SFApiQuery<SFFileLock> sfApiQuery = new SFApiQuery<SFFileLock>(this.apiClient);
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("FileLock");
		sfApiQuery.addIds(url);
		sfApiQuery.setBody(fileLock);
		sfApiQuery.setHttpMethod("PATCH");
		return sfApiQuery;
	}

	/**
	* Unlock File
	* Unlock a locked file.
	* @param url 	 	
	*/
	public ISFQuery deleteByItem(URI url, String lockid) throws InvalidOrMissingParameterException 	{
		if (url == null) {
			throw new InvalidOrMissingParameterException("url");
		}
		if (lockid == null) {
			throw new InvalidOrMissingParameterException("lockid");
		}

		SFApiQuery sfApiQuery = new SFApiQuery(this.apiClient);
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("FileLock");
		sfApiQuery.addIds(url);
		sfApiQuery.addActionIds(lockid);
		sfApiQuery.setHttpMethod("DELETE");
		return sfApiQuery;
	}

	/**
	* Discard checkout on a File
	* Discard a checkout on a file
	* @param url 	 	
	*/
	public ISFQuery discard(URI url, String lockid) throws InvalidOrMissingParameterException 	{
		if (url == null) {
			throw new InvalidOrMissingParameterException("url");
		}
		if (lockid == null) {
			throw new InvalidOrMissingParameterException("lockid");
		}

		SFApiQuery sfApiQuery = new SFApiQuery(this.apiClient);
		sfApiQuery.setFrom("Items");
		sfApiQuery.setAction("FileLock");
		sfApiQuery.addIds(url);
		sfApiQuery.addActionIds(lockid);
		sfApiQuery.addSubAction("Discard");
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

}

