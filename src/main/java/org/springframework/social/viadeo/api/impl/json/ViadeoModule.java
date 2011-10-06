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
package org.springframework.social.viadeo.api.impl.json;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;
import org.springframework.social.viadeo.api.Career;
import org.springframework.social.viadeo.api.Comment;
import org.springframework.social.viadeo.api.Company;
import org.springframework.social.viadeo.api.ContactCards;
import org.springframework.social.viadeo.api.Experience;
import org.springframework.social.viadeo.api.Group;
import org.springframework.social.viadeo.api.InboxMessage;
import org.springframework.social.viadeo.api.Job;
import org.springframework.social.viadeo.api.Like;
import org.springframework.social.viadeo.api.Location;
import org.springframework.social.viadeo.api.News;
import org.springframework.social.viadeo.api.Phone;
import org.springframework.social.viadeo.api.ViadeoProfile;
import org.springframework.social.viadeo.api.impl.Comments;
import org.springframework.social.viadeo.api.impl.Contacts;
import org.springframework.social.viadeo.api.impl.Feed;
import org.springframework.social.viadeo.api.impl.GroupsResult;
import org.springframework.social.viadeo.api.impl.InboxMessagesResult;
import org.springframework.social.viadeo.api.impl.JobsResult;
import org.springframework.social.viadeo.api.impl.Likes;
import org.springframework.social.viadeo.api.impl.VisitCards;

/**
 * Jackson module for setting up mixin annotations on Viadeo model types. This
 * enables the use of Jackson annotations without directly annotating the model
 * classes themselves.
 * 
 * @author Vincent Devillers
 */
public class ViadeoModule extends SimpleModule {

	public ViadeoModule() {
		super("ViadeoModule", new Version(1, 0, 0, null));
	}

	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(ViadeoProfile.class,
				ViadeoProfileMixin.class);
		context.setMixInAnnotations(Contacts.class, ContactsMixin.class);
		context.setMixInAnnotations(Feed.class, FeedMixin.class);
		context.setMixInAnnotations(News.class, NewsMixin.class);
		context.setMixInAnnotations(Experience.class, ExperienceMixin.class);
		context.setMixInAnnotations(Career.class, CareerMixin.class);
		context.setMixInAnnotations(Comment.class, CommentMixin.class);
		context.setMixInAnnotations(Comments.class, CommentsMixin.class);
		context.setMixInAnnotations(Like.class, LikeMixin.class);
		context.setMixInAnnotations(Likes.class, LikesMixin.class);
		context.setMixInAnnotations(Job.class, JobMixin.class);
		context.setMixInAnnotations(Company.class, CompanyMixin.class);
		context.setMixInAnnotations(JobsResult.class, JobsResultMixin.class);
		context.setMixInAnnotations(Phone.class, PhoneMixin.class);
		context.setMixInAnnotations(ContactCards.class, ContactCardsMixin.class);
		context.setMixInAnnotations(VisitCards.class, VisitCardsMixin.class);
		context.setMixInAnnotations(Location.class, LocationMixin.class);
		context.setMixInAnnotations(Group.class, GroupMixin.class);
		context.setMixInAnnotations(GroupsResult.class, GroupsResultMixin.class);
		context.setMixInAnnotations(InboxMessage.class, InboxMessageMixin.class);
		context.setMixInAnnotations(InboxMessagesResult.class, InboxMessagesResultMixin.class);
	}
}
