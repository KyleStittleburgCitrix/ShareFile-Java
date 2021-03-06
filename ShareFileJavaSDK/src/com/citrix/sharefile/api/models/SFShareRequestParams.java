
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

package com.citrix.sharefile.api.models;

import java.io.InputStream;
import java.util.ArrayList;
import java.net.URI;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import com.google.gson.annotations.SerializedName;
import com.citrix.sharefile.api.*;
import com.citrix.sharefile.api.enumerations.*;
import com.citrix.sharefile.api.models.*;

public class SFShareRequestParams extends SFODataObject {

	@SerializedName("FolderId")
	private String FolderId;
	@SerializedName("FolderPath")
	private String FolderPath;
	@SerializedName("Emails")
	private ArrayList<String> Emails;
	@SerializedName("Subject")
	private String Subject;
	@SerializedName("Body")
	private String Body;
	@SerializedName("CcSender")
	private Boolean CcSender;
	@SerializedName("RequireLogin")
	private Boolean RequireLogin;
	@SerializedName("ExpirationDays")
	private Integer ExpirationDays;
	@SerializedName("NotifyOnUpload")
	private Boolean NotifyOnUpload;
	@SerializedName("IsViewOnly")
	private Boolean IsViewOnly;

	public String getFolderId() {
		return this.FolderId;
	}

	public void setFolderId(String folderid) {
		this.FolderId = folderid;
	}
	public String getFolderPath() {
		return this.FolderPath;
	}

	public void setFolderPath(String folderpath) {
		this.FolderPath = folderpath;
	}
	public ArrayList<String> getEmails() {
		return this.Emails;
	}

	public void setEmails(ArrayList<String> emails) {
		this.Emails = emails;
	}
	public String getSubject() {
		return this.Subject;
	}

	public void setSubject(String subject) {
		this.Subject = subject;
	}
	public String getBody() {
		return this.Body;
	}

	public void setBody(String body) {
		this.Body = body;
	}
	public Boolean getCcSender() {
		return this.CcSender;
	}

	public void setCcSender(Boolean ccsender) {
		this.CcSender = ccsender;
	}
	public Boolean getRequireLogin() {
		return this.RequireLogin;
	}

	public void setRequireLogin(Boolean requirelogin) {
		this.RequireLogin = requirelogin;
	}
	public Integer getExpirationDays() {
		return this.ExpirationDays;
	}

	public void setExpirationDays(Integer expirationdays) {
		this.ExpirationDays = expirationdays;
	}
	public Boolean getNotifyOnUpload() {
		return this.NotifyOnUpload;
	}

	public void setNotifyOnUpload(Boolean notifyonupload) {
		this.NotifyOnUpload = notifyonupload;
	}
	public Boolean getIsViewOnly() {
		return this.IsViewOnly;
	}

	public void setIsViewOnly(Boolean isviewonly) {
		this.IsViewOnly = isviewonly;
	}

}