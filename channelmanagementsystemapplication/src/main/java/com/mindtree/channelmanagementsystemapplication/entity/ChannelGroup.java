package com.mindtree.channelmanagementsystemapplication.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ChannelGroup {
	@Id
	private int channelgoupId;

	private String channelgroupName;

	@OneToMany(mappedBy = "channelgroup", cascade = CascadeType.ALL)//PERSIST
	private List<Channel> channel;

	public ChannelGroup() {
		super();
	}

	public ChannelGroup(int channelgoupId, String channelgroupName, List<Channel> channel) {
		super();
		this.channelgoupId = channelgoupId;
		this.channelgroupName = channelgroupName;
		this.channel = channel;
		
	}
	

	
	public int getChannelgoupId() {
		return channelgoupId;
	}

	public void setChannelgoupId(int channelgoupId) {
		this.channelgoupId = channelgoupId;
	}

	public String getChannelgroupName() {
		return channelgroupName;
	}

	public void setChannelgroupName(String channelgroupName) {
		this.channelgroupName = channelgroupName;
	}

	public List<Channel> getChannel() {
		return channel;
	}

	public void setChannel(List<Channel> channel) {
		this.channel = channel;
	}


}
