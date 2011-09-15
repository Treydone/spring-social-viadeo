/*
* Copyright 2011 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.springframework.social.viadeo.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.viadeo.api.Viadeo;
import org.springframework.social.viadeo.api.ViadeoProfile;

/**
 * Viadeo ApiAdapter implementation.
 * 
 * @author Vincent Devillers
 */
public class ViadeoAdapter implements ApiAdapter<Viadeo> {

	public boolean test(Viadeo viadeo) {
		try {
			viadeo.userOperations().getUserProfile();
			return true;
		} catch (ApiException e) {
			return false;
		}
	}

	public void setConnectionValues(Viadeo viadeo, ConnectionValues values) {
		ViadeoProfile profile = viadeo.userOperations().getUserProfile();
		values.setProviderUserId(profile.getId());
		values.setDisplayName(profile.getFirstName() + " "
				+ profile.getLastName());
		values.setImageUrl(profile.getLargeImageUrl());
		values.setProfileUrl(profile.getProfileUrl());
	}

	public UserProfile fetchUserProfile(Viadeo viadeo) {
		ViadeoProfile profile = viadeo.userOperations().getUserProfile();
		return new UserProfileBuilder()
				.setName(profile.getFirstName() + " " + profile.getLastName())
				.setFirstName(profile.getFirstName())
				.setLastName(profile.getLastName())
				.setUsername(profile.getNickName()).build();
	}

	public void updateStatus(Viadeo viadeo, String message) {
		// not supported yet
	}
}
