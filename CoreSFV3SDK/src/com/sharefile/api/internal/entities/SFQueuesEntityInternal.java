
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

import com.sharefile.api.*;
import com.sharefile.api.entities.*;
import com.sharefile.api.models.*;
import com.sharefile.api.internal.models.*;
import com.sharefile.api.SFApiQuery;
import com.sharefile.api.interfaces.ISFQuery;


import java.io.InputStream;
import java.util.ArrayList;
import java.net.URI;
import java.util.Date;
 
import com.google.gson.annotations.SerializedName;
import com.sharefile.api.enumerations.SFSafeEnum;
import com.sharefile.api.enumerations.SFSafeEnumFlags;

public class SFQueuesEntityInternal extends SFODataEntityBase
{
	public SFQueuesEntityInternal(ISFApiClient client) {
		super(client);
	}

	/**
	* Get List of Queues
	* Retrieve list of system Queues associated with the authenticated Zone.
	* @return the list of system Queues for the authenticated Zone
	*/
	public ISFQuery<SFODataFeed<SFQueue>> get()	{

		SFApiQuery<SFODataFeed<SFQueue>> sfApiQuery = new SFApiQuery<SFODataFeed<SFQueue>>(this.client);
		sfApiQuery.setFrom("Queues");
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

	/**
	* Get single Queue
	* @param url 	 	
	* @return A single Queue represented by the ID
	*/
	public ISFQuery<SFQueue> get(URI url) throws InvalidOrMissingParameterException 	{
		if (url == null) {
			throw new InvalidOrMissingParameterException("url");
		}

		SFApiQuery<SFQueue> sfApiQuery = new SFApiQuery<SFQueue>(this.client);
		sfApiQuery.setFrom("Queues");
		sfApiQuery.addIds(url);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

	/**
	* Get Queue Entry
	* @param qUrl 	 	
	* @return A single queue entry element
	*/
	public ISFQuery<SFQueueEntry> getEntries(URI qUrl, String eid) throws InvalidOrMissingParameterException 	{
		if (qUrl == null) {
			throw new InvalidOrMissingParameterException("qUrl");
		}
		if (eid == null) {
			throw new InvalidOrMissingParameterException("eid");
		}

		SFApiQuery<SFQueueEntry> sfApiQuery = new SFApiQuery<SFQueueEntry>(this.client);
		sfApiQuery.setFrom("Queues");
		sfApiQuery.setAction("Entries");
		sfApiQuery.addIds(qUrl);
		sfApiQuery.addActionIds(eid);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

	/**
	* Add Queue Entry
	* Adds a new queue entry, referencing an existing Work Item.
	* The return (void) is not standard, this method should not be used directly.
	* @param url 	 	
	* @param entry 	 	
	*/
	public ISFQuery createEntries(URI url, SFQueueEntry entry) throws InvalidOrMissingParameterException 	{
		if (url == null) {
			throw new InvalidOrMissingParameterException("url");
		}
		if (entry == null) {
			throw new InvalidOrMissingParameterException("entry");
		}

		SFApiQuery sfApiQuery = new SFApiQuery(this.client);
		sfApiQuery.setFrom("Queues");
		sfApiQuery.setAction("Entries");
		sfApiQuery.addIds(url);
		sfApiQuery.setBody(entry);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

	/**
	* Receive Queue Entries
	* Retrieve the $top elements of the queue - default is 1. Elements returned
	* are locked; therefore the caller must process the element.
	* @param url 	 	
	* @return List of queue entries, in creation order (FIFO). Elements are automatically locekd and won't be retrieved by other workers.
	*/
	public ISFQuery<SFODataFeed<SFQueueEntry>> receive(URI url) throws InvalidOrMissingParameterException 	{
		if (url == null) {
			throw new InvalidOrMissingParameterException("url");
		}

		SFApiQuery<SFODataFeed<SFQueueEntry>> sfApiQuery = new SFApiQuery<SFODataFeed<SFQueueEntry>>(this.client);
		sfApiQuery.setFrom("Queues");
		sfApiQuery.setAction("Receive");
		sfApiQuery.addIds(url);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

	/**
	* Complete Queue Operation
    * { "key": "value" }
	* Indicate the worker has completed the work item. The queue entry is removed. Workers
	* may pass additional completion parameters that trigger other metadata changes. For eSignature
	* queue, the completion parameter SignedItemId indicates the new item containing the signed
	* document.
	* @param grandparentid 	 	
	* @param url 	 	
	* @param result 	 	
	*/
	public ISFQuery complete(URI url, SFODataObject result, String grandparentid) throws InvalidOrMissingParameterException 	{
		if (url == null) {
			throw new InvalidOrMissingParameterException("url");
		}
		if (result == null) {
			throw new InvalidOrMissingParameterException("result");
		}
		if (grandparentid == null) {
			throw new InvalidOrMissingParameterException("grandparentid");
		}

		SFApiQuery sfApiQuery = new SFApiQuery(this.client);
		sfApiQuery.setFrom("Queues");
		sfApiQuery.setAction("Complete");
		sfApiQuery.addIds(url);
		sfApiQuery.addQueryString("grandparentid", grandparentid);
		sfApiQuery.setBody(result);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

	/**
	* Modifies a Queue Entry
	* Limited patching for queue entry metadata. Currently supports the SignedItem
	* attribute for esignature queue
	* @param qUrl 	 	
	* @param entry 	 	
	*/
	public ISFQuery update(URI qUrl, String eid, SFQueueEntry entry) throws InvalidOrMissingParameterException 	{
		if (qUrl == null) {
			throw new InvalidOrMissingParameterException("qUrl");
		}
		if (eid == null) {
			throw new InvalidOrMissingParameterException("eid");
		}
		if (entry == null) {
			throw new InvalidOrMissingParameterException("entry");
		}

		SFApiQuery sfApiQuery = new SFApiQuery(this.client);
		sfApiQuery.setFrom("Queues");
		sfApiQuery.setAction("Entries");
		sfApiQuery.addIds(qUrl);
		sfApiQuery.addActionIds(eid);
		sfApiQuery.setBody(entry);
		sfApiQuery.setHttpMethod("PATCH");
		return sfApiQuery;
	}

	/**
	* Delete Queue Entry
	* Removes the queue entry
	* @param qUrl 	 	
	*/
	public ISFQuery delete(URI qUrl, String eid) throws InvalidOrMissingParameterException 	{
		if (qUrl == null) {
			throw new InvalidOrMissingParameterException("qUrl");
		}
		if (eid == null) {
			throw new InvalidOrMissingParameterException("eid");
		}

		SFApiQuery sfApiQuery = new SFApiQuery(this.client);
		sfApiQuery.setFrom("Queues");
		sfApiQuery.setAction("Entries");
		sfApiQuery.addIds(qUrl);
		sfApiQuery.addActionIds(eid);
		sfApiQuery.setHttpMethod("DELETE");
		return sfApiQuery;
	}

	/**
	* Fail the Queue Entry
	* Indicates that the worker has failed to process the queue entry
	* @param qUrl 	 	
	*/
	public ISFQuery error(URI qUrl, String eid) throws InvalidOrMissingParameterException 	{
		if (qUrl == null) {
			throw new InvalidOrMissingParameterException("qUrl");
		}
		if (eid == null) {
			throw new InvalidOrMissingParameterException("eid");
		}

		SFApiQuery sfApiQuery = new SFApiQuery(this.client);
		sfApiQuery.setFrom("Queues");
		sfApiQuery.setAction("Error");
		sfApiQuery.addIds(qUrl);
		sfApiQuery.addActionIds(eid);
		sfApiQuery.setHttpMethod("POST");
		return sfApiQuery;
	}

}

