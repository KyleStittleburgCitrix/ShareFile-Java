
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

public class SFConnectorGroupAccessControl extends SFODataObject {

	@SerializedName("Principal")
	private SFPrincipal Principal;
	@SerializedName("CanManage")
	private Boolean CanManage;
	@SerializedName("CanCreate")
	private Boolean CanCreate;

	public SFPrincipal getPrincipal() {
		return this.Principal;
	}

	public void setPrincipal(SFPrincipal principal) {
		this.Principal = principal;
	}
	public Boolean getCanManage() {
		return this.CanManage;
	}

	public void setCanManage(Boolean canmanage) {
		this.CanManage = canmanage;
	}
	public Boolean getCanCreate() {
		return this.CanCreate;
	}

	public void setCanCreate(Boolean cancreate) {
		this.CanCreate = cancreate;
	}

}