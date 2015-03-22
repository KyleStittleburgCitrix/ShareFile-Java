
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

package com.sharefile.api.internal.models;

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

public class SFEncryptedEmailReplyParams extends SFEncryptedEmailParams {

	@SerializedName("ToRecipients")
	private ArrayList<SFPrincipal> ToRecipients;
	@SerializedName("CcRecipients")
	private ArrayList<SFPrincipal> CcRecipients;
	@SerializedName("BccRecipients")
	private ArrayList<SFPrincipal> BccRecipients;

	public ArrayList<SFPrincipal> getToRecipients() {
		return this.ToRecipients;
	}

	public void setToRecipients(ArrayList<SFPrincipal> torecipients) {
		this.ToRecipients = torecipients;
	}
	public ArrayList<SFPrincipal> getCcRecipients() {
		return this.CcRecipients;
	}

	public void setCcRecipients(ArrayList<SFPrincipal> ccrecipients) {
		this.CcRecipients = ccrecipients;
	}
	public ArrayList<SFPrincipal> getBccRecipients() {
		return this.BccRecipients;
	}

	public void setBccRecipients(ArrayList<SFPrincipal> bccrecipients) {
		this.BccRecipients = bccrecipients;
	}

}