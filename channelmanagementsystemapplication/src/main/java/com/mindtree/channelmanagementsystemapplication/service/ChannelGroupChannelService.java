package com.mindtree.channelmanagementsystemapplication.service;

import java.util.List;

import com.mindtree.channelmanagementsystemapplication.dto.ChannelDto;
import com.mindtree.channelmanagementsystemapplication.dto.ChannelGroupDto;
import com.mindtree.channelmanagementsystemapplication.dto.ShowDto;
import com.mindtree.channelmanagementsystemapplication.entity.Channel;
import com.mindtree.channelmanagementsystemapplication.exception.ChannelGroupChannelShowServiceException;

public interface ChannelGroupChannelService {
	/**
	 * @param channelgroupdto
	 * @return
	 */
	public ChannelGroupDto insertChannelGroupIntoDB(ChannelGroupDto channelgroupdto);

	
	/**
	 * @param channeldto
	 * @param channelgroup_id
	 * @return
	 * @throws ChannelGroupChannelShowServiceException
	 */
	public ChannelDto insertchannelIntoDB(ChannelDto channeldto, int channelgroup_id)
			throws ChannelGroupChannelShowServiceException;

	
	/**
	 * @param showdto
	 * @param channel_id
	 * @return
	 * @throws ChannelGroupChannelShowServiceException
	 */
	public ShowDto insertshowIntoDB(ShowDto showdto, int channel_id) throws ChannelGroupChannelShowServiceException;

	/**
	 * @param channelgroup_id
	 * @return
	 */
	public List<ChannelDto> getAllChannels(int channelgroup_id);


	
	/**
	 * @param channel
	 * @param channel_id
	 * @param channelName
	 * @return
	 */
	public Channel updateChannel(Channel channel, int channel_id,String channelName);


	/**
	 * @param channelId
	 * @return
	 */
	public Channel deleteChannelInDB(int channelId);

}
