package com.mindtree.channelmanagementsystemapplication.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ChannelGroupDto {
	private int channelgoupId;

	private String channelgroupName;
	

	@JsonIgnoreProperties("channelgroupdto")
	private List<ChannelDto> channeldto;

	public ChannelGroupDto() {
		super();
	}

	public ChannelGroupDto(int channelgoupId, String channelgroupName, List<ChannelDto> channeldto) {
		super();
		this.channelgoupId = channelgoupId;
		this.channelgroupName = channelgroupName;
		this.channeldto = channeldto;
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

	public List<ChannelDto> getChanneldto() {
		return channeldto;
	}

	public void setChanneldto(List<ChannelDto> channeldto) {
		this.channeldto = channeldto;
	}

	

}
