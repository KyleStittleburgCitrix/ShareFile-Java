
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

public class SFLink extends SFItem {

	@SerializedName("Uri")
	private URI Uri;

		/**
		* Universal Reference Identifier for this Link object
		*/
	public URI getUri() {
		return Uri;
	}

		/**
		* Universal Reference Identifier for this Link object
		*/
	public void setUri(URI uri) {
		Uri = uri;
	}
}