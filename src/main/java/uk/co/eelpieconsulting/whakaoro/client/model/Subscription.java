package uk.co.eelpieconsulting.whakaoro.client.model;

import java.util.Date;

public class Subscription {
	
	private String id, name, channelId;
	private Date lastRead, latestItemDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public Date getLastRead() {
		return lastRead;
	}
	public void setLastRead(Date lastRead) {
		this.lastRead = lastRead;
	}
	public Date getLatestItemDate() {
		return latestItemDate;
	}
	public void setLatestItemDate(Date latestItemDate) {
		this.latestItemDate = latestItemDate;
	}
	
	@Override
	public String toString() {
		return "Subscription [channelId=" + channelId + ", id=" + id
				+ ", lastRead=" + lastRead + ", latestItemDate="
				+ latestItemDate + ", name=" + name + "]";
	}
	
}
