package uk.co.eelpieconsulting.whakaoro.client.model;

import java.util.Date;

import uk.co.eelpieconsulting.common.geo.model.Place;

public class FeedItem {
	
	private String id, title, body, subscriptionId, url, imageUrl;
	private Date date;
	private boolean geoTagged;
	private Place place;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isGeoTagged() {
		return geoTagged;
	}
	public void setGeoTagged(boolean geoTagged) {
		this.geoTagged = geoTagged;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	
	@Override
	public String toString() {
		return "FeedItem [body=" + body + ", date=" + date + ", id=" + id
				+ ", imageUrl=" + imageUrl + ", subscriptionId="
				+ subscriptionId + ", title=" + title + ", url=" + url + "]";
	}
	
}
