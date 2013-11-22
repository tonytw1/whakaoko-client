package uk.co.eelpieconsulting.whakaoro.client.model;

public class Channel {
	
	private String id, name;

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

	@Override
	public String toString() {
		return "Channel [id=" + id + ", name=" + name + "]";
	}
	
}
