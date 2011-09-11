package org.springframework.social.viadeo.connect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.easymock.EasyMock;
import org.junit.Test;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.viadeo.api.UserOperations;
import org.springframework.social.viadeo.api.Viadeo;
import org.springframework.social.viadeo.api.ViadeoProfile;
import org.springframework.social.viadeo.connect.ViadeoAdapter;
import org.unitils.UnitilsJUnit4;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.RegularMock;


public class TestViadeoApiAdapter extends UnitilsJUnit4{

		private ViadeoAdapter apiAdapter = new ViadeoAdapter();

		@RegularMock
		private Viadeo viadeoApi;
		
		@RegularMock
		private UserOperations profileOperations;

		@Test
		public void fetchProfile() {		
			EasyMock.expect(viadeoApi.userOperations()).andReturn(profileOperations);
			EasyMock.expect(profileOperations.getUserProfile()).andReturn(new ViadeoProfile("12345678", "M", "Vincent", "DEVILLERS", null, "profileUrl", "imageUrl"));
			EasyMockUnitils.replay();
			
			UserProfile profile = apiAdapter.fetchUserProfile(viadeoApi);
			assertEquals("Vincent DEVILLERS", profile.getName());
			assertEquals("DEVILLERS", profile.getLastName());
			assertEquals("Vincent", profile.getFirstName());
			assertNull(profile.getEmail());
			assertNull(profile.getUsername());
		}

		@Test
		public void setConnectionValues() {		
			EasyMock.expect(viadeoApi.userOperations()).andReturn(profileOperations);
			EasyMock.expect(profileOperations.getUserProfile()).andReturn(new ViadeoProfile("12345678", "M", "Vincent", "DEVILLERS", null, "profileUrl", "imageUrl"));
			EasyMockUnitils.replay();
			
			TestConnectionValues connectionValues = new TestConnectionValues();
			apiAdapter.setConnectionValues(viadeoApi, connectionValues);
			assertEquals("Vincent DEVILLERS", connectionValues.getDisplayName());
			assertEquals("imageUrl", connectionValues.getImageUrl());
			assertEquals("profileUrl", connectionValues.getProfileUrl());
			assertEquals("12345678", connectionValues.getProviderUserId());
		}

		private static class TestConnectionValues implements ConnectionValues {

			private String displayName;
			private String imageUrl;
			private String profileUrl;
			private String providerUserId;

			public String getDisplayName() {
				return displayName;
			}

			public void setDisplayName(String displayName) {
				this.displayName = displayName;
			}

			public String getImageUrl() {
				return imageUrl;
			}

			public void setImageUrl(String imageUrl) {
				this.imageUrl = imageUrl;
			}

			public String getProfileUrl() {
				return profileUrl;
			}

			public void setProfileUrl(String profileUrl) {
				this.profileUrl = profileUrl;
			}

			public String getProviderUserId() {
				return providerUserId;
			}

			public void setProviderUserId(String providerUserId) {
				this.providerUserId = providerUserId;
			}

		}
}
