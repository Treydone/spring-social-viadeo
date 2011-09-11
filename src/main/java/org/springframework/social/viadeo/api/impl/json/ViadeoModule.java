package org.springframework.social.viadeo.api.impl.json;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;
import org.springframework.social.viadeo.api.Career;
import org.springframework.social.viadeo.api.Comment;
import org.springframework.social.viadeo.api.ContactCards;
import org.springframework.social.viadeo.api.Experience;
import org.springframework.social.viadeo.api.Job;
import org.springframework.social.viadeo.api.News;
import org.springframework.social.viadeo.api.Phone;
import org.springframework.social.viadeo.api.ViadeoProfile;
import org.springframework.social.viadeo.api.impl.Comments;
import org.springframework.social.viadeo.api.impl.Contacts;
import org.springframework.social.viadeo.api.impl.Feed;
import org.springframework.social.viadeo.api.impl.JobsResult;
import org.springframework.social.viadeo.api.impl.VisitCards;

/**
 * Jackson module for setting up mixin annotations on Viadeo model types. This
 * enables the use of Jackson annotations without directly annotating the model
 * classes themselves.
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
		context.setMixInAnnotations(Job.class, JobMixin.class);
		context.setMixInAnnotations(JobsResult.class, JobsResultMixin.class);
		context.setMixInAnnotations(Phone.class, PhoneMixin.class);
		context
				.setMixInAnnotations(ContactCards.class,
						ContactCardsMixin.class);
		context
		.setMixInAnnotations(VisitCards.class,
				VisitCardsMixin.class);
	}
}
