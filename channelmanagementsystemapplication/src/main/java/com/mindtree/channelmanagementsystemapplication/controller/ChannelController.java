package com.mindtree.channelmanagementsystemapplication.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.channelmanagementsystemapplication.dto.ChannelDto;
import com.mindtree.channelmanagementsystemapplication.dto.ChannelGroupDto;
import com.mindtree.channelmanagementsystemapplication.dto.ShowDto;
import com.mindtree.channelmanagementsystemapplication.entity.Channel;
import com.mindtree.channelmanagementsystemapplication.exception.ChannelGroupChannelShowServiceException;
import com.mindtree.channelmanagementsystemapplication.service.ChannelGroupChannelService;

@RestController
public class ChannelController {
	@Autowired
	ChannelGroupChannelService channelgroupchannelservice;// private

	@PostMapping("/channelgroup")
	public String insertChannelGroup(@RequestBody ChannelGroupDto channelgroupdto) {
		channelgroupchannelservice.insertChannelGroupIntoDB(channelgroupdto);
		String status = "inserted successfully";
		return status;

	}

	@PostMapping("/channel/{channelgroup_id}")
	public ResponseEntity<String> insertChannel(@RequestBody ChannelDto channeldto, @PathVariable int channelgroup_id)
			throws ChannelGroupChannelShowServiceException {
		channelgroupchannelservice.insertchannelIntoDB(channeldto, channelgroup_id);
		String status = "inserted successfully";
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	@PostMapping("/show/{channel_id}")
	public ResponseEntity<String> insertShow(@RequestBody ShowDto showdto, @PathVariable int channel_id)
			throws ChannelGroupChannelShowServiceException {
		channelgroupchannelservice.insertshowIntoDB(showdto, channel_id);
		String status = "inserted successfully";
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	@GetMapping("/channels/{channelgroup_id}")
	public List<ChannelDto> getAllChannels(@PathVariable int channelgroup_id) {
		List<ChannelDto> channelsdto = channelgroupchannelservice.getAllChannels(channelgroup_id);
		Collections.sort(channelsdto);
		return channelsdto;
	}
	
	@PutMapping("/channelName/{channelId}/{channelName}")
		public Channel updateChannel(@RequestBody Channel channel,@PathVariable int channelId,String channelName) {
		return channel=channelgroupchannelservice.updateChannel(channel, channelId,channelName);	
		}
	
	@GetMapping("/channelId")
	public Channel deleteChannel(int channelId) {
	Channel channel=channelgroupchannelservice.deleteChannelInDB(channelId);
	return channel;
	}

}
