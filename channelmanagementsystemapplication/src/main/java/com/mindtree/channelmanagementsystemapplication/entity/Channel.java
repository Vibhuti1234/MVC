package com.mindtree.channelmanagementsystemapplication.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Channel {
	@Id
	private int channelId;

	private String channelName;

	private int price;

	@OneToMany(mappedBy = "channel", cascade = CascadeType.ALL) 
	private List<Show> show;

	@ManyToOne(fetch = FetchType.LAZY) 
	private ChannelGroup channelgroup;

	public Channel() {
		super();
		
	}

	
	
	public Channel(int channelId, String channelName, int price,List<Show> show) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.price = price;
		this.show = show;	
	}
	
	public Channel(int channelId, String channelName, int price) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.price = price;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Show> getShow() {
		return show;
	}

	public void setShow(List<Show> show) {
		this.show = show;
	}

	public ChannelGroup getChannelgroup() {
		return channelgroup;
	}

	public void setChannelgroup(ChannelGroup channelgroup) {
		this.channelgroup = channelgroup;
	}

	

}
