
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

public class SFShareFileRepresentative extends SFPrincipal {

	@SerializedName("User")
	private SFUser User;
	@SerializedName("UserType")
	private SFSafeEnum<SFRepresentativeType> UserType;
	@SerializedName("CanViewStats")
	private Boolean CanViewStats;
	@SerializedName("CanPostNews")
	private Boolean CanPostNews;
	@SerializedName("CanPostFeatures")
	private Boolean CanPostFeatures;
	@SerializedName("CanPostBugs")
	private Boolean CanPostBugs;
	@SerializedName("RepresentativeName")
	private String RepresentativeName;
	@SerializedName("FirstName")
	private String FirstName;
	@SerializedName("LastName")
	private String LastName;
	@SerializedName("Extension")
	private Integer Extension;
	@SerializedName("CanBeTechnicalContact")
	private Boolean CanBeTechnicalContact;
	@SerializedName("IsPresent")
	private Boolean IsPresent;
	@SerializedName("IsSourceOption")
	private Boolean IsSourceOption;
	@SerializedName("MobilePhone")
	private String MobilePhone;
	@SerializedName("OfficePhone")
	private String OfficePhone;
	@SerializedName("EmailSignature")
	private String EmailSignature;
	@SerializedName("ShareFileRepresentativeImageFile")
	private String ShareFileRepresentativeImageFile;

	public SFUser getUser() {
		return this.User;
	}

	public void setUser(SFUser user) {
		this.User = user;
	}
	public SFSafeEnum<SFRepresentativeType> getUserType() {
		return this.UserType;
	}

	public void setUserType(SFSafeEnum<SFRepresentativeType> usertype) {
		this.UserType = usertype;
	}
	public Boolean getCanViewStats() {
		return this.CanViewStats;
	}

	public void setCanViewStats(Boolean canviewstats) {
		this.CanViewStats = canviewstats;
	}
	public Boolean getCanPostNews() {
		return this.CanPostNews;
	}

	public void setCanPostNews(Boolean canpostnews) {
		this.CanPostNews = canpostnews;
	}
	public Boolean getCanPostFeatures() {
		return this.CanPostFeatures;
	}

	public void setCanPostFeatures(Boolean canpostfeatures) {
		this.CanPostFeatures = canpostfeatures;
	}
	public Boolean getCanPostBugs() {
		return this.CanPostBugs;
	}

	public void setCanPostBugs(Boolean canpostbugs) {
		this.CanPostBugs = canpostbugs;
	}
	public String getRepresentativeName() {
		return this.RepresentativeName;
	}

	public void setRepresentativeName(String representativename) {
		this.RepresentativeName = representativename;
	}
	public String getFirstName() {
		return this.FirstName;
	}

	public void setFirstName(String firstname) {
		this.FirstName = firstname;
	}
	public String getLastName() {
		return this.LastName;
	}

	public void setLastName(String lastname) {
		this.LastName = lastname;
	}
	public Integer getExtension() {
		return this.Extension;
	}

	public void setExtension(Integer extension) {
		this.Extension = extension;
	}
	public Boolean getCanBeTechnicalContact() {
		return this.CanBeTechnicalContact;
	}

	public void setCanBeTechnicalContact(Boolean canbetechnicalcontact) {
		this.CanBeTechnicalContact = canbetechnicalcontact;
	}
	public Boolean getIsPresent() {
		return this.IsPresent;
	}

	public void setIsPresent(Boolean ispresent) {
		this.IsPresent = ispresent;
	}
	public Boolean getIsSourceOption() {
		return this.IsSourceOption;
	}

	public void setIsSourceOption(Boolean issourceoption) {
		this.IsSourceOption = issourceoption;
	}
	public String getMobilePhone() {
		return this.MobilePhone;
	}

	public void setMobilePhone(String mobilephone) {
		this.MobilePhone = mobilephone;
	}
	public String getOfficePhone() {
		return this.OfficePhone;
	}

	public void setOfficePhone(String officephone) {
		this.OfficePhone = officephone;
	}
	public String getEmailSignature() {
		return this.EmailSignature;
	}

	public void setEmailSignature(String emailsignature) {
		this.EmailSignature = emailsignature;
	}
	public String getShareFileRepresentativeImageFile() {
		return this.ShareFileRepresentativeImageFile;
	}

	public void setShareFileRepresentativeImageFile(String sharefilerepresentativeimagefile) {
		this.ShareFileRepresentativeImageFile = sharefilerepresentativeimagefile;
	}

}