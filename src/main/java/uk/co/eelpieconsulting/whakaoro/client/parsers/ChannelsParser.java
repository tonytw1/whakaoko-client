package uk.co.eelpieconsulting.whakaoro.client.parsers;

import java.io.IOException;
import java.util.List;

import uk.co.eelpieconsulting.whakaoro.client.exceptions.ParsingException;
import uk.co.eelpieconsulting.whakaoro.client.model.Channel;
import uk.co.eelpieconsulting.whakaoro.client.model.FeedItem;
import uk.co.eelpieconsulting.whakaoro.client.model.Subscription;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ChannelsParser {
	
    private final ObjectMapper objectMapper;

    public ChannelsParser() {
    	this.objectMapper = new ObjectMapper();
    	objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
    
	public Channel parseChannel(String json) throws ParsingException {
		try {
			return objectMapper.readValue(json, Channel.class);
		} catch (JsonParseException e) {
			throw new ParsingException();
		} catch (JsonMappingException e) {
			throw new ParsingException();
		} catch (IOException e) {
			throw new ParsingException();
		}
	}
	
	public List<Channel> parseChannels(String json) throws ParsingException {
		try {
            return (List<Channel>) objectMapper.readValue(json, new TypeReference<List<Channel>>() {});
		} catch (JsonParseException e) {
			throw new ParsingException();
		} catch (JsonMappingException e) {
			throw new ParsingException();
		} catch (IOException e) {
			throw new ParsingException();
		}
	}

	public List<Subscription> parseSubscriptions(String json) throws ParsingException {
		try {
            return (List<Subscription>) objectMapper.readValue(json, new TypeReference<List<Subscription>>() {});            
		} catch (JsonParseException e) {
			throw new ParsingException();
		} catch (JsonMappingException e) {
			throw new ParsingException();
		} catch (IOException e) {
			throw new ParsingException();
		}
	}

	public List<FeedItem> parseFeedItems(String json) throws ParsingException {
		try {
            return (List<FeedItem>) objectMapper.readValue(json, new TypeReference<List<FeedItem>>() {});            
		} catch (JsonParseException e) {
			throw new ParsingException();
		} catch (JsonMappingException e) {
			throw new ParsingException();
		} catch (IOException e) {
			throw new ParsingException();
		}
	}

	public Subscription parseSubscription(String json) throws ParsingException {
		try {
			return objectMapper.readValue(json, Subscription.class);
		} catch (JsonParseException e) {
			throw new ParsingException();
		} catch (JsonMappingException e) {
			throw new ParsingException();
		} catch (IOException e) {
			throw new ParsingException();
		}
	}
	
}
