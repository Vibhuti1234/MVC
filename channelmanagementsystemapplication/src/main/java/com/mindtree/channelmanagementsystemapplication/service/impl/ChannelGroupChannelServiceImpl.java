package com.mindtree.channelmanagementsystemapplication.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.channelmanagementsystemapplication.dto.ChannelDto;
import com.mindtree.channelmanagementsystemapplication.dto.ChannelGroupDto;
import com.mindtree.channelmanagementsystemapplication.dto.ShowDto;
import com.mindtree.channelmanagementsystemapplication.entity.Channel;
import com.mindtree.channelmanagementsystemapplication.entity.ChannelGroup;
import com.mindtree.channelmanagementsystemapplication.entity.Show;
import com.mindtree.channelmanagementsystemapplication.exception.ChannelGroupChannelShowServiceException;
import com.mindtree.channelmanagementsystemapplication.exception.NoSuchChannelFoundException;
import com.mindtree.channelmanagementsystemapplication.exception.NoSuchChannelGroupFoundException;
import com.mindtree.channelmanagementsystemapplication.repository.ChannelGroupRepository;
import com.mindtree.channelmanagementsystemapplication.repository.ChannelRepository;
import com.mindtree.channelmanagementsystemapplication.repository.ShowRepository;
import com.mindtree.channelmanagementsystemapplication.service.ChannelGroupChannelService;
@Service
public class ChannelGroupChannelServiceImpl implements ChannelGroupChannelService {
	@Autowired
	ChannelGroupRepository channelgrouprepository;

	@Autowired
	ChannelRepository channelrepository;

	@Autowired
	
	ShowRepository showrepository;

	@Override
	public ChannelGroupDto insertChannelGroupIntoDB(ChannelGroupDto channelgroupdto) {
		ChannelGroup channelgroup = new ChannelGroup();
		channelgroup.setChannelgoupId(channelgroupdto.getChannelgoupId());
		channelgroup.setChannelgroupName(channelgroupdto.getChannelgroupName());
		channelgrouprepository.save(channelgroup);
		return channelgroupdto;
	}

	@Override
	public ChannelDto insertchannelIntoDB(ChannelDto channeldto, int channelgroup_id)
			throws ChannelGroupChannelShowServiceException {

		ChannelGroup channelgroup = channelgrouprepository.findById(channelgroup_id)
				.orElseThrow(() -> new NoSuchChannelGroupFoundException("channel group is not present"));

		Channel channel = new Channel();
		channel.setChannelId(channeldto.getChannelId());
		channel.setChannelName(channeldto.getChannelName());
		channel.setPrice(channeldto.getPrice());
		channel.setChannelgroup(channelgroup);
		channelrepository.save(channel);
		return channeldto;
		
	}

	@Override
	public ShowDto insertshowIntoDB(ShowDto showdto, int channel_id) throws ChannelGroupChannelShowServiceException {
		
		Channel channel = channelrepository.findById(channel_id).orElseThrow(()->new NoSuchChannelFoundException("channel is not present"));
		Show show = new Show();
				show.setShowId(showdto.getShowId());
				show.setShowName(showdto.getShowName());
				show.setChannel(channel);
				showrepository.save(show);
				return showdto;
			}


	@Override
	public List<ChannelDto> getAllChannels(int channelgroup_id) {
		Optional<ChannelGroup> channels = channelgrouprepository.findById(channelgroup_id);
		ChannelGroup c=channels.get();
		List<ChannelDto> channelsdto = new ArrayList<>();
		for (Channel channel : c.getChannel()) {
			
			ChannelDto channeldto = new ChannelDto();
			channeldto.setChannelId(channel.getChannelId());
			channeldto.setChannelName(channel.getChannelName());
			channeldto.setPrice(channel.getPrice());
			channelsdto.add(channeldto);

		}
		
		return channelsdto;
	}
	
	@Override
	public Channel updateChannel(Channel channel,int channel_id,String channelName ) {
	Channel c=channelrepository.findById(channel_id).get();
	c.setChannelName(channelName);
	return c;
	}
	
	@Override
	public Channel deleteChannelInDB(int channelId) {
		Optional<Channel> channel = channelrepository.findById(channelId);
		Channel c = channel.get();
		channelrepository.delete(c);
		return c;
		
		}
}
