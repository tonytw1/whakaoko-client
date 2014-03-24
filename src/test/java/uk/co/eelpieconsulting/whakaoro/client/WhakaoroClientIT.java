package uk.co.eelpieconsulting.whakaoro.client;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uk.co.eelpieconsulting.whakaoro.client.model.Channel;
import uk.co.eelpieconsulting.whakaoro.client.model.FeedItem;
import uk.co.eelpieconsulting.whakaoro.client.model.Subscription;

public class WhakaoroClientIT {

	private WhakaoroClient client;
	
	@Before
	public void setup() {
		this.client = new WhakaoroClient("http://int.local:8080/whakaoko-0.0.1-SNAPSHOT");
	}
	
	@Test
	public void canCreateUser() throws Exception {
		client.createUser("tonytw1");
	}

	@Test
	public void canFetchListOfChannels() throws Exception {	
		List<Channel> channels = client.getChannels("tonytw1");
		assertFalse(channels.isEmpty());
		for (Channel channel : channels) {
			System.out.println(channel);
		}
	}
	
	@Test
	public void canFetchListOfChannelsSubscriptions() throws Exception {
		List<Subscription> channelSubscriptions = client.getChannelSubscriptions("tonytw1", client.getChannels("tonytw1").get(0).getId());
		
		assertFalse(channelSubscriptions.isEmpty());
		for (Subscription subscription : channelSubscriptions) {
			System.out.println(subscription);
		}
	}
	
	@Test
	public void canFetchChannelFeedItems() throws Exception {
		List<FeedItem> feedItems = client.getChannelFeedItems("tonytw1", client.getChannels("tonytw1").get(0).getId());
		
		assertFalse(feedItems.isEmpty());
		for (FeedItem feedItem : feedItems) {
			System.out.println(feedItem);
		}
	}
	
	@Test
	public void canFetchSubscriptionFeedItems() throws Exception {
		final String channelId = client.getChannels("tonytw1").get(0).getId();
		final Subscription subscription = client.getChannelSubscriptions("tonytw1", channelId).get(0);
		
		List<FeedItem> feedItems = client.getSubscriptionFeedItems("tonytw1", subscription.getId());

		assertFalse(feedItems.isEmpty());
		for (FeedItem feedItem : feedItems) {
			System.out.println(feedItem);
		}
	}
	
	@Test
	public void canObtainPlaceFromGeotaggedFeedItems() throws Exception {
		List<FeedItem> feedItems = client.getSubscriptionFeedItems("tonytw1", "feed-8ca5e582e1af699ed9ba8d55d16ac86f");
				
		final FeedItem geotaggedFeedItem = feedItems.get(3);
		
		assertTrue(geotaggedFeedItem.isGeoTagged());
		assertNotNull(geotaggedFeedItem.getPlace());
	}
	
	@Test
	public void canCreateChannel() throws Exception {
		Channel createdChannel = client.createChannel("tonytw1", "wellynews");
		System.out.println(createdChannel);
	}
	
	@Test
	public void canCreateFeedSubscription() throws Exception {
		Channel channel = client.getChannels("tonytw1").get(0);
		System.out.println(channel);
		
		Subscription createdSubscription = client.createFeedSubscription("tonytw1", channel.getId(), "http://wellington.gen.nz/rss2");
		System.out.println(createdSubscription);
	}
	
	@Test
	public void canCreateTwitterTagSubscription() throws Exception {
		Subscription createdSubscription = client.createTwitterTagSubscription("tonytw1", "tal13", "tal");
		System.out.println(createdSubscription);
	}
	
	@Test
	public void canCreateInstagramTagSubscription() throws Exception {
		Subscription createdSubscription = client.createInstagramTagSubscription("tonytw1", "tal13", "tal");
		System.out.println(createdSubscription);
	}
	
}
