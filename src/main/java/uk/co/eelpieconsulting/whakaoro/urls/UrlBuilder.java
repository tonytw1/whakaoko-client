package uk.co.eelpieconsulting.whakaoro.urls;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

public class UrlBuilder {
	
	private final String apiUrl;

	public UrlBuilder(String apiUrl) {
		this.apiUrl = apiUrl;
	}
	
	public String getChannels(String username) {
		return apiUrl + "/" + username + "/channels";
	}
	
	public String getChannel(String username, String channelId) {
		return getChannels(username) + "/" + channelId;
	}
			
	public String getChannelItems(String username, String channelId) {
		return getChannel(username, channelId) + "/items";
	}
	
	public String getChannelItems(String username, String channelId, int page) {
		return getChannel(username, channelId) + "/items" + "?page=" + page;
	}
	
	public String getChannelSubscriptions(String username, String channelId) {
		String string = getChannel(username, channelId) + "/subscriptions";
		System.out.println(string);
		return string;
	}
	
	public String createFeedSubscription(String username) {
		return apiUrl + "/" + username + "/subscriptions/feeds";
	}
	
	public String getSubscriptionItems(String username, String subscriptionId) {
		return apiUrl + "/" + username + "/subscriptions/" + subscriptionId + "/items";
	}
	
	public String createTwitterTagSubscription(String username, String tag) {
		return apiUrl + "/" + username + "/" + "subscriptions/twitter/tags";
	}
	
	public String createInstagramTagSubscription(String username, String tag) {
		return apiUrl + "/" + username + "/" + "subscriptions/instagram/tags";
	}
	
	private String urlEncode(String q) {
		try {
			return URLEncoder.encode(q, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	
}
