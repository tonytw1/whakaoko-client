package uk.co.eelpieconsulting.whakaoro.client.parsers;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uk.co.eelpieconsulting.whakaoro.client.model.Channel;
import uk.co.eelpieconsulting.whakaoro.client.parsers.ChannelsParser;

public class ChannelsParserTest {

	private ChannelsParser parser;

	@Before
	public void setup() {
		parser = new ChannelsParser();
	}
	
	@Test
	public void canParseChannel() throws Exception {
		final Channel channel = parser.parseChannel(ContentLoader.loadContent("channel.json"));
		
		assertEquals("my-channel", channel.getId());
		assertEquals("My channel", channel.getName());
	}
	
	@Test
	public void canParseChannesl() throws Exception {
		final List<Channel> channels = parser.parseChannels(ContentLoader.loadContent("channels.json"));
		
		assertEquals(2, channels.size());
		
		final Channel anotherChannel = channels.get(1);
		assertEquals("another-channel", anotherChannel.getId());
		assertEquals("Another channel", anotherChannel.getName());
	}
	
}
