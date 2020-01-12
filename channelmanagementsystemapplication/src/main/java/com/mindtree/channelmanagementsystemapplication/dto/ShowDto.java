package com.mindtree.channelmanagementsystemapplication.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ShowDto {

	private int showId;

	private String showName;

	@JsonIgnoreProperties("showdto")
	private ChannelDto channeldto;

	public ShowDto() {
		super();
	}

	
	public ShowDto(int showId, String showName) {
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

	public ChannelDto getChanneldto() {
		return channeldto;
	}

	public void setChanneldto(ChannelDto channeldto) {
		this.channeldto = channeldto;
	}

	

}
