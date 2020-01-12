package com.mindtree.channelmanagementsystemapplication.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mindtree.channelmanagementsystemapplication.dto.ChannelDto;
import com.mindtree.channelmanagementsystemapplication.dto.ChannelGroupDto;
import com.mindtree.channelmanagementsystemapplication.dto.ShowDto;
import com.mindtree.channelmanagementsystemapplication.entity.Channel;
import com.mindtree.channelmanagementsystemapplication.exception.ChannelGroupChannelShowServiceException;
import com.mindtree.channelmanagementsystemapplication.service.ChannelGroupChannelService;
@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
@WebMvcTest(ChannelController.class)
public class ChannelControllerTest {
	@Autowired
	MockMvc mockMvc;

	@InjectMocks
	ChannelController appcontroller;

	@Mock
	ChannelGroupChannelService channelGroupChannelService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(appcontroller).build();
	}

	@Test
	public void testInsertChannelGroup() {
		ChannelGroupDto channelgroupdto = new ChannelGroupDto();
		channelgroupdto.setChannelgoupId(1);
		channelgroupdto.setChannelgroupName("aa");
		ChannelGroupDto channelgroupdto1 = new ChannelGroupDto();
		Mockito.when(channelGroupChannelService.insertChannelGroupIntoDB(channelgroupdto)).thenReturn(channelgroupdto);
		assertEquals(appcontroller.insertChannelGroup(channelgroupdto), "inserted successfully");
		assertNotEquals(appcontroller.insertChannelGroup(channelgroupdto), "not inserted successfully");
		assertNotNull(channelgroupdto);
		assertNull(null);
	}

	@Test
	public void testInsertChannel() throws ChannelGroupChannelShowServiceException {
		ChannelDto channeldto = new ChannelDto();
		channeldto.setChannelId(1);
		channeldto.setChannelName("xx");
		channeldto.setPrice(100);
		Mockito.when(channelGroupChannelService.insertchannelIntoDB(channeldto, 1)).thenReturn(channeldto);
		assertEquals(appcontroller.insertChannel(channeldto, 1).getStatusCodeValue(), 200);
		assertNotEquals(appcontroller.insertChannel(channeldto, 2).getStatusCodeValue(), 404);
		assertNotNull(channeldto);
		assertNull(null);
	}

	@Test
	public void testInsertShow() throws ChannelGroupChannelShowServiceException {
		ShowDto showdto = new ShowDto();
		showdto.setShowId(1);
		showdto.setShowName("xy");
		Mockito.when(channelGroupChannelService.insertshowIntoDB(showdto, 1)).thenReturn(showdto);
		assertEquals(appcontroller.insertShow(showdto, 1).getStatusCodeValue(), 200);
		assertNotEquals(appcontroller.insertShow(showdto, 2).getStatusCodeValue(), 404);
		assertNotNull(showdto);
		assertNull(null);
	}

	@Test
	public void testGetAllChannels() {
		ChannelDto channeldto = new ChannelDto();
		List<ChannelDto> channelsdto = new ArrayList<>();
		channeldto.setChannelId(1);
		channeldto.setChannelName("mm");
		channeldto.setPrice(300);
		channeldto.setChannelId(2);
		channeldto.setChannelName("nn");
		channeldto.setPrice(400);
		channeldto.setChannelId(3);
		channeldto.setChannelName("oo");
		channeldto.setPrice(500);
		channelsdto.add(channeldto);
		Mockito.when(channelGroupChannelService.getAllChannels(1)).thenReturn(channelsdto);
		assertEquals(appcontroller.getAllChannels(1), channelsdto);
		assertNotEquals(appcontroller.getAllChannels(4), channelsdto);
		assertNotNull(channelsdto);
		assertNull(null);
	}

	@Test
	public void testUpdateChannel() {
		Channel channel = new Channel();
		channel.setChannelName("gh");
		Mockito.when(channelGroupChannelService.updateChannel(channel, 1, "gh")).thenReturn(channel);
		assertEquals(appcontroller.updateChannel(channel, 1, "gh"), channel);
		assertNotEquals(appcontroller.updateChannel(channel, 1, "ef"), channel);
		assertNotNull(channel);
		assertNull(null);
	}

	@Test
	public void testDeleteChannel() {
		Channel channel = new Channel();
		Mockito.when(channelGroupChannelService.deleteChannelInDB(1)).thenReturn(channel);
		assertEquals(appcontroller.deleteChannel(1), channel);
		assertNotEquals(appcontroller.deleteChannel(2), channel);
		assertNotNull(channel);
		assertNull(null);
	}

}
