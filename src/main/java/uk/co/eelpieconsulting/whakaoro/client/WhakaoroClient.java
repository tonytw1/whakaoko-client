package uk.co.eelpieconsulting.whakaoro.client;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import com.google.common.collect.Lists;

import uk.co.eelpieconsulting.common.http.HttpBadRequestException;
import uk.co.eelpieconsulting.common.http.HttpFetchException;
import uk.co.eelpieconsulting.common.http.HttpFetcher;
import uk.co.eelpieconsulting.common.http.HttpForbiddenException;
import uk.co.eelpieconsulting.common.http.HttpNotFoundException;
import uk.co.eelpieconsulting.whakaoro.client.exceptions.ParsingException;
import uk.co.eelpieconsulting.whakaoro.client.model.Channel;
import uk.co.eelpieconsulting.whakaoro.client.model.FeedItem;
import uk.co.eelpieconsulting.whakaoro.client.model.Subscription;
import uk.co.eelpieconsulting.whakaoro.client.parsers.ChannelsParser;
import uk.co.eelpieconsulting.whakaoro.urls.UrlBuilder;

public class WhakaoroClient {
	
	private final UrlBuilder urlBuilder;
	private final HttpFetcher httpFetcher;
	private final ChannelsParser channelsParser;
	
	public WhakaoroClient(String apiUrl) {
		this.urlBuilder = new UrlBuilder(apiUrl);
		this.httpFetcher = new HttpFetcher();
		this.channelsParser = new ChannelsParser();
	}
	
	public List<Channel> getChannels(String username) throws HttpFetchException, ParsingException {
		return channelsParser.parseChannels(httpFetcher.get(urlBuilder.getChannels(username)));
	}
	
	public Channel getChannel(String username, String channelId) throws HttpFetchException, ParsingException {
		return channelsParser.parseChannel(httpFetcher.get(urlBuilder.getChannel(username, channelId)));
	}
	
	public List<Subscription> getChannelSubscriptions(String username, String channelId) throws HttpNotFoundException, HttpBadRequestException, HttpForbiddenException, ParsingException, HttpFetchException {
		return channelsParser.parseSubscriptions(httpFetcher.get(urlBuilder.getChannelSubscriptions(username, channelId)));
	}
	
	public List<FeedItem> getChannelFeedItems(String username, String channelId) throws HttpNotFoundException, HttpBadRequestException, HttpForbiddenException, ParsingException, HttpFetchException {
		return channelsParser.parseFeedItems(httpFetcher.get(urlBuilder.getChannelItems(username, channelId)));
	}
	
	public List<FeedItem> getChannelFeedItems(String username, String channelId, int page) throws HttpNotFoundException, HttpBadRequestException, HttpForbiddenException, ParsingException, HttpFetchException {
		return channelsParser.parseFeedItems(httpFetcher.get(urlBuilder.getChannelItems(username, channelId, page)));
	}
	
	public List<FeedItem> getSubscriptionFeedItems(String username, String subscriptionId) throws HttpNotFoundException, HttpBadRequestException, HttpForbiddenException, ParsingException, HttpFetchException {
		return channelsParser.parseFeedItems(httpFetcher.get(urlBuilder.getSubscriptionItems(username, subscriptionId)));
	}
	
	public void createUser(String username) throws HttpNotFoundException, HttpBadRequestException, HttpForbiddenException, HttpFetchException {
		final HttpPost post = new HttpPost(urlBuilder.getUsers());
		
		final List<NameValuePair> nameValuePairs = Lists.newArrayList();		
		nameValuePairs.add(new BasicNameValuePair("username", username));
		
		httpFetcher.post(post);
		return;
	}
		
	public Channel createChannel(String username, String channelId) throws UnsupportedEncodingException, HttpNotFoundException, HttpBadRequestException, HttpForbiddenException, ParsingException, HttpFetchException {
		HttpPost post = new HttpPost(urlBuilder.getChannels(username));
				
		final List<NameValuePair> nameValuePairs = Lists.newArrayList();		
		nameValuePairs.add(new BasicNameValuePair("name", channelId));
		
		HttpEntity entity = new UrlEncodedFormEntity(nameValuePairs);
		post.setEntity(entity);
		
		return channelsParser.parseChannel(httpFetcher.post(post));
	}
	
	public Subscription createFeedSubscription(String username, String channelId, String url) throws UnsupportedEncodingException, HttpNotFoundException, HttpBadRequestException, HttpForbiddenException, HttpFetchException, ParsingException {
		HttpPost post = new HttpPost(urlBuilder.createFeedSubscription(username));
				
		final List<NameValuePair> nameValuePairs = Lists.newArrayList();		
		nameValuePairs.add(new BasicNameValuePair("channel", channelId));
		nameValuePairs.add(new BasicNameValuePair("url", url));
		
		HttpEntity entity = new UrlEncodedFormEntity(nameValuePairs);
		post.setEntity(entity);
			
		return channelsParser.parseSubscription(httpFetcher.post(post));
	}
	
	public Subscription createTwitterTagSubscription(String username, String tag, String channelId) throws HttpNotFoundException, HttpBadRequestException, HttpForbiddenException, ParsingException, HttpFetchException, UnsupportedEncodingException {
		HttpPost post = new HttpPost(urlBuilder.createTwitterTagSubscription(username, tag));
		final List<NameValuePair> nameValuePairs = Lists.newArrayList();		
		nameValuePairs.add(new BasicNameValuePair("tag", tag));		
		nameValuePairs.add(new BasicNameValuePair("channel", channelId));		

		HttpEntity entity = new UrlEncodedFormEntity(nameValuePairs);
		post.setEntity(entity);
			
		return channelsParser.parseSubscription(httpFetcher.post(post));
	}
	
	public Subscription createInstagramTagSubscription(String username, String tag, String channelId) throws HttpNotFoundException, HttpBadRequestException, HttpForbiddenException, ParsingException, HttpFetchException, UnsupportedEncodingException {
		String createInstagramTagSubscription = urlBuilder.createInstagramTagSubscription(username, tag);
		System.out.println(createInstagramTagSubscription);
		HttpPost post = new HttpPost(createInstagramTagSubscription);
		final List<NameValuePair> nameValuePairs = Lists.newArrayList();		
		nameValuePairs.add(new BasicNameValuePair("tag", tag));		
		nameValuePairs.add(new BasicNameValuePair("channel", channelId));		

		HttpEntity entity = new UrlEncodedFormEntity(nameValuePairs);
		post.setEntity(entity);
			
		return channelsParser.parseSubscription(httpFetcher.post(post));
	}
	
}
