
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

package com.sharefile.api.models;

import java.io.InputStream;
import java.util.ArrayList;
import java.net.URI;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import com.google.gson.annotations.SerializedName;
import com.sharefile.api.*;
import com.sharefile.api.enumerations.*;
import com.sharefile.api.models.*;

public class SFConnectorGroupZone extends SFODataObject {

	@SerializedName("Zone")
	private SFZone Zone;
	@SerializedName("StorageCenters")
	private ArrayList<SFStorageCenter> StorageCenters;
	@SerializedName("ApiVersionMin")
	private String ApiVersionMin;
	@SerializedName("ApiVersionMax")
	private String ApiVersionMax;
	@SerializedName("IconUrl")
	private String IconUrl;
	@SerializedName("FormUrl")
	private String FormUrl;

		/**
		* Zone that contains this connector class
		*/
	public SFZone getZone() {
		return this.Zone;
	}

		/**
		* Zone that contains this connector class
		*/
	public void setZone(SFZone zone) {
		this.Zone = zone;
	}
		/**
		* List of Storage Centers in this Zone that contain this Connector
		*/
	public ArrayList<SFStorageCenter> getStorageCenters() {
		return this.StorageCenters;
	}

		/**
		* List of Storage Centers in this Zone that contain this Connector
		*/
	public void setStorageCenters(ArrayList<SFStorageCenter> storagecenters) {
		this.StorageCenters = storagecenters;
	}
		/**
		* Minimum API version supported by this connector group
		*/
	public String getApiVersionMin() {
		return this.ApiVersionMin;
	}

		/**
		* Minimum API version supported by this connector group
		*/
	public void setApiVersionMin(String apiversionmin) {
		this.ApiVersionMin = apiversionmin;
	}
		/**
		* Maximum API version supported by this connector group
		*/
	public String getApiVersionMax() {
		return this.ApiVersionMax;
	}

		/**
		* Maximum API version supported by this connector group
		*/
	public void setApiVersionMax(String apiversionmax) {
		this.ApiVersionMax = apiversionmax;
	}
		/**
		* URL for the Connector Group Icon.
		*/
	public String getIconUrl() {
		return this.IconUrl;
	}

		/**
		* URL for the Connector Group Icon.
		*/
	public void setIconUrl(String iconurl) {
		this.IconUrl = iconurl;
	}
		/**
		* URL for the Form that creates or updates connectors
		*/
	public String getFormUrl() {
		return this.FormUrl;
	}

		/**
		* URL for the Form that creates or updates connectors
		*/
	public void setFormUrl(String formurl) {
		this.FormUrl = formurl;
	}

}