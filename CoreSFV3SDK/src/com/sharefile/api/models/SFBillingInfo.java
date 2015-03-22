
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

public class SFBillingInfo extends SFODataObject {

	@SerializedName("BillingContact")
	private SFUser BillingContact;
	@SerializedName("Address1")
	private String Address1;
	@SerializedName("Address2")
	private String Address2;
	@SerializedName("City")
	private String City;
	@SerializedName("State")
	private String State;
	@SerializedName("Country")
	private String Country;
	@SerializedName("Zip")
	private String Zip;
	@SerializedName("CreditCardFirstName")
	private String CreditCardFirstName;
	@SerializedName("CreditCardLastName")
	private String CreditCardLastName;
	@SerializedName("CreditCardType")
	private String CreditCardType;
	@SerializedName("CreditCardToken")
	private String CreditCardToken;
	@SerializedName("CreditCardExpirationMonth")
	private String CreditCardExpirationMonth;
	@SerializedName("CreditCardExpirationYear")
	private String CreditCardExpirationYear;
	@SerializedName("CreditCardSecurityCode")
	private String CreditCardSecurityCode;

	public SFUser getBillingContact() {
		return this.BillingContact;
	}

	public void setBillingContact(SFUser billingcontact) {
		this.BillingContact = billingcontact;
	}
	public String getAddress1() {
		return this.Address1;
	}

	public void setAddress1(String address1) {
		this.Address1 = address1;
	}
	public String getAddress2() {
		return this.Address2;
	}

	public void setAddress2(String address2) {
		this.Address2 = address2;
	}
	public String getCity() {
		return this.City;
	}

	public void setCity(String city) {
		this.City = city;
	}
	public String getState() {
		return this.State;
	}

	public void setState(String state) {
		this.State = state;
	}
	public String getCountry() {
		return this.Country;
	}

	public void setCountry(String country) {
		this.Country = country;
	}
	public String getZip() {
		return this.Zip;
	}

	public void setZip(String zip) {
		this.Zip = zip;
	}
	public String getCreditCardFirstName() {
		return this.CreditCardFirstName;
	}

	public void setCreditCardFirstName(String creditcardfirstname) {
		this.CreditCardFirstName = creditcardfirstname;
	}
	public String getCreditCardLastName() {
		return this.CreditCardLastName;
	}

	public void setCreditCardLastName(String creditcardlastname) {
		this.CreditCardLastName = creditcardlastname;
	}
	public String getCreditCardType() {
		return this.CreditCardType;
	}

	public void setCreditCardType(String creditcardtype) {
		this.CreditCardType = creditcardtype;
	}
	public String getCreditCardToken() {
		return this.CreditCardToken;
	}

	public void setCreditCardToken(String creditcardtoken) {
		this.CreditCardToken = creditcardtoken;
	}
	public String getCreditCardExpirationMonth() {
		return this.CreditCardExpirationMonth;
	}

	public void setCreditCardExpirationMonth(String creditcardexpirationmonth) {
		this.CreditCardExpirationMonth = creditcardexpirationmonth;
	}
	public String getCreditCardExpirationYear() {
		return this.CreditCardExpirationYear;
	}

	public void setCreditCardExpirationYear(String creditcardexpirationyear) {
		this.CreditCardExpirationYear = creditcardexpirationyear;
	}
	public String getCreditCardSecurityCode() {
		return this.CreditCardSecurityCode;
	}

	public void setCreditCardSecurityCode(String creditcardsecuritycode) {
		this.CreditCardSecurityCode = creditcardsecuritycode;
	}

}