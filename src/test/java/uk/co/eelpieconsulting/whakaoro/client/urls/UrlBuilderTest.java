package uk.co.eelpieconsulting.whakaoro.client.urls;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uk.co.eelpieconsulting.whakaoro.urls.UrlBuilder;

public class UrlBuilderTest {

	private static final String API_HOST = "http://whakaoko.apis.eelpieconsulting.co.uk";
	
	private UrlBuilder urlBuilder;
	
	@Before
	public void setup() {
		urlBuilder = new UrlBuilder(API_HOST);
	}
	
	@Test
	public void canConstructUrlForChannels() {				
		assertEquals("http://whakaoko.apis.eelpieconsulting.co.uk/tonytw1/channels", urlBuilder.getChannels("tonytw1"));
	}
	
	@Test
	public void canConstructUrlForChannel() {				
		assertEquals("http://whakaoko.apis.eelpieconsulting.co.uk/tonytw1/channels/my-channel", urlBuilder.getChannel("tonytw1", "my-channel"));
	}
	
	@Test
	public void canConstructUrlForChannelItems() {				
		assertEquals("http://whakaoko.apis.eelpieconsulting.co.uk/tonytw1/channels/my-channel/items", urlBuilder.getChannelItems("tonytw1", "my-channel"));
	}
	
}
