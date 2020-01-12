package com.mindtree.channelmanagementsystemapplication.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ChannelDto implements Comparable<ChannelDto>{
	private int channelId;

	private String channelName;

	private int price;

	@JsonIgnoreProperties("channeldto")

	private List<ShowDto> showdto;

	@JsonIgnoreProperties("channeldto")
	private ChannelGroupDto channelgroupdto;

	public ChannelDto() {
		super();
	}

	public ChannelDto(int channelId, String channelName, int price, List<ShowDto> showdto,
			ChannelGroupDto channelgroupdto) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.price = price;
		this.showdto = showdto;
		this.channelgroupdto = channelgroupdto;
	}
	
	public ChannelDto(int channelId, String channelName, int price,List<ShowDto> showdto) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.price = price;
		this.showdto = showdto;	
	}

	public ChannelDto(int channelId, String channelName, int price) {
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

	public List<ShowDto> getShowdto() {
		return showdto;
	}

	public void setShowdto(List<ShowDto> showdto) {
		this.showdto = showdto;
	}

	public ChannelGroupDto getChannelgroupdto() {
		return channelgroupdto;
	}

	public void setChannelgroupdto(ChannelGroupDto channelgroupdto) {
		this.channelgroupdto = channelgroupdto;
	}

	

	@Override
	public int compareTo(ChannelDto ch) {

		int result = ch.getPrice() - this.price;
		if (result != 0) {
			return result;
		}
		if (result == 0) {
			result = ch.getChannelName().compareTo(this.channelName);
			
		}
		return result;

	}

}
