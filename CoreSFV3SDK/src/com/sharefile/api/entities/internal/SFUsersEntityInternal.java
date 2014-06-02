
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

package com.sharefile.api.entities.private;
package com.sharefile.api.entities;


import java.io.InputStream;
import java.util.ArrayList;
import java.net.URI;
import java.util.Date;
 
import com.google.gson.annotations.SerializedName;
import com.sharefile.api.enumerations.SFSafeEnum;

public class SFUsersEntityInternal extends SFUsersEntity
{
    /**
	* Get User Security
	* Retrieve the user security record - current state of the user regarding
	* security and password settings.
	* @param url 	
	* @return the user security status
    */
	public ISFQuery<SFUserSecurity> getSecurity(URI url)
	{
		SFQuery<SFUserSecurity> sfApiQuery = new SFQuery<SFUserSecurity>();
		sfApiQuery.setFrom("Users");
		sfApiQuery.setAction("Security");
		sfApiQuery.addIds(url);
		sfApiQuery.setHttpMethod("GET");
		return sfApiQuery;
	}

}

