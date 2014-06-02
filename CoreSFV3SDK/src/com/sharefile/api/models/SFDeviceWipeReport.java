
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

package com.sharefile.api.models;

import java.io.InputStream;
import java.util.ArrayList;
import java.net.URI;
import java.util.Date;
 
import com.google.gson.annotations.SerializedName;
import com.sharefile.api.enumerations.SFSafeEnum;

public class SFDeviceWipeReport extends SFODataObject {

	@SerializedName("Logs")
	private ArrayList<SFDeviceLogEntry> Logs;
	@SerializedName("WipeResults")
	private ArrayList<SFDeviceUserWipe> WipeResults;

		/**
		* Logs
		*/
	public ArrayList<SFDeviceLogEntry> getLogs() {
		return Logs;
	}

		/**
		* Logs
		*/
	public void setLogs(ArrayList<SFDeviceLogEntry> logs) {
		Logs = logs;
	}
		/**
		* Wipe results
		*/
	public ArrayList<SFDeviceUserWipe> getWipeResults() {
		return WipeResults;
	}

		/**
		* Wipe results
		*/
	public void setWipeResults(ArrayList<SFDeviceUserWipe> wiperesults) {
		WipeResults = wiperesults;
	}
}