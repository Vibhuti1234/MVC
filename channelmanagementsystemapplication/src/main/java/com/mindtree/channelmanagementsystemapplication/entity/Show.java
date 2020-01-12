package com.mindtree.channelmanagementsystemapplication.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "show_details")
public class Show {

	@Id
	private int showId;

	private String showName;

	@ManyToOne(fetch = FetchType.LAZY)
	private Channel channel;

	public Show(){
		super();
	}

	
	public Show(int showId, String showName) {
		super();
		this.showId = showId;
		this.showName = showName;	
	}
	
	

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	
}
