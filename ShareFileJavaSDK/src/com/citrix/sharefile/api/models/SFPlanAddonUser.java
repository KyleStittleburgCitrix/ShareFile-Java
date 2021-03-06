
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
import com.citrix.sharefile.api.enumerations.SFSafeEnum;
import com.citrix.sharefile.api.models.*;

public class SFPlanAddonUser extends SFODataObject {

	@SerializedName("User")
	private SFUser User;
	@SerializedName("SpecialUserRole")
	private ArrayList<SFSafeEnum<SFMobileUserRole>> SpecialUserRole;

	public SFUser getUser() {
		return this.User;
	}

	public void setUser(SFUser user) {
		this.User = user;
	}
	public ArrayList<SFSafeEnum<SFMobileUserRole>> getSpecialUserRole() {
		return this.SpecialUserRole;
	}

	public void setSpecialUserRole(ArrayList<SFSafeEnum<SFMobileUserRole>> specialuserrole) {
		this.SpecialUserRole = specialuserrole;
	}

}