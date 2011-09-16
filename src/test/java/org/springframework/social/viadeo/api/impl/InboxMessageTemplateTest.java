package org.springframework.social.viadeo.api.impl;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import org.junit.Test;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.viadeo.api.InboxMessage;

public class InboxMessageTemplateTest extends AbstractViadeoApiTest {

	@Test
	public void getInboxMessageWithId() {
		mockServer
				.expect(
						requestTo("https://api.viadeo.com/pvtweOoAcdjciVejhoDylwEjpmdavkvfatuVlqbmpvpucdbhhcAf?access_token=ACCESS_TOKEN&user_detail=full"))
				.andExpect(method(GET))
				.andRespond(withResponse(jsonResource("testdata/detailled-inbox-message"), responseHeaders));

		InboxMessage inboxMessage = viadeo.inboxMessageOperations().getInboxMessage(
				"pvtweOoAcdjciVejhoDylwEjpmdavkvfatuVlqbmpvpucdbhhcAf");

		assertEquals("pvtweOoAcdjciVejhoDylwEjpmdavkvfatuVlqbmpvpucdbhhcAf", inboxMessage.getId());
		assertEquals("http://www.viadeo.com/messages/detailsmessagerecu/?msgReceivedId=0021ahcgz6lyadff",
				inboxMessage.getLink());
		assertEquals(Boolean.TRUE, inboxMessage.getRead());
		assertEquals("RE : Message de test", inboxMessage.getSubject());
		assertEquals("Bonjour Stéfanie\n\nMerci pour ton message, voici ma réponse.\nVincent",
				inboxMessage.getMessage());
		assertEquals("EjtftevbyiugaIfDfVizDgymxg", inboxMessage.getSender().getId());
		assertEquals("Ile-de-France", inboxMessage.getSender().getLocation().getArea());
		assertEquals(1, inboxMessage.getReceivers().size());
		assertEquals("kqebrOcVsfsfhnmxsgxnOAyxyw", inboxMessage.getReceivers().get(0).getId());
		assertEquals("Ile-de-France", inboxMessage.getReceivers().get(0).getLocation().getArea());
		mockServer.verify();
	}

	@Test(expected = NotAuthorizedException.class)
	public void getInboxMessageWithId_unauthorized() {
		unauthorizedViadeo.inboxMessageOperations().getInboxMessage("pvtweOoAcdjciVejhoDylwEjpmdavkvfatuVlqbmpvpucdbhhcAf");
	}

}
