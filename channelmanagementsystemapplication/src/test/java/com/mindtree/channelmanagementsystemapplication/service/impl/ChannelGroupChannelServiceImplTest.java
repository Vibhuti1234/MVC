package com.mindtree.channelmanagementsystemapplication.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.mindtree.channelmanagementsystemapplication.entity.ChannelGroup;
import com.mindtree.channelmanagementsystemapplication.entity.Show;
import com.mindtree.channelmanagementsystemapplication.exception.ChannelGroupChannelShowServiceException;
import com.mindtree.channelmanagementsystemapplication.repository.ChannelGroupRepository;
import com.mindtree.channelmanagementsystemapplication.repository.ChannelRepository;
import com.mindtree.channelmanagementsystemapplication.repository.ShowRepository;
@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
@WebMvcTest(ChannelGroupChannelServiceImpl.class)
public class ChannelGroupChannelServiceImplTest {

	@Autowired
	MockMvc mockMvc;

	@InjectMocks
	ChannelGroupChannelServiceImpl channelGroupChannelServiceImpl;

	@Mock
	ChannelGroupRepository channelgrouprepository;

	@Mock
	ChannelRepository channelrepository;

	@Mock
	ShowRepository showrepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(channelGroupChannelServiceImpl).build();
	}

	@Test
	
	public void testInsertChannelGroupIntoDB() {
		ChannelGroupDto channelgroupdto = new ChannelGroupDto();
		ChannelGroupDto channelgroupdto1 = new ChannelGroupDto();
		channelgroupdto1.setChannelgoupId(2);
		channelgroupdto1.setChannelgroupName("bc");
		
		ChannelGroup channelgroup = new ChannelGroup();
		channelgroup.setChannelgoupId(1);
		channelgroup.setChannelgroupName("ab");
		channelgroupdto.setChannelgoupId(1);
		channelgroupdto.setChannelgroupName("ab");
		
		
		assertEquals(channelGroupChannelServiceImpl.insertChannelGroupIntoDB(channelgroupdto),channelgroupdto);
		assertNotEquals(channelGroupChannelServiceImpl.insertChannelGroupIntoDB(channelgroupdto),channelgroupdto1);
		assertNotNull(channelgroupdto);
		assertNull(null);
		
	}

	@Test
	public void testInsertchannelIntoDB() throws ChannelGroupChannelShowServiceException {
		List<Show> shows = new ArrayList<>();
		List<ShowDto> showsdto = new ArrayList<>();
		Channel channel = new Channel();
		ChannelDto channeldto = new ChannelDto();
		ChannelDto channeldto1 = new ChannelDto();
		
		shows.add(new Show(1, "ab"));
		shows.add(new Show(2, "cd"));
		channel = new Channel(1, "pp", 200, shows);
		ChannelGroup channelGroup = new ChannelGroup(1, "ab", null);
		showsdto.add(new ShowDto(1, "ab"));
		showsdto.add(new ShowDto(2, "cd"));
		channeldto = new ChannelDto(1, "pp", 200, showsdto);
		channeldto1=new ChannelDto(1,"qq",300,showsdto);
		Mockito.when(channelgrouprepository.findById(1)).thenReturn(Optional.of(channelGroup));
		assertEquals(channelGroupChannelServiceImpl.insertchannelIntoDB(channeldto, 1), channeldto);
		assertNotEquals(channelGroupChannelServiceImpl.insertchannelIntoDB(channeldto, 1),channeldto1);
		assertNotNull(channeldto);
		assertNull(null);
	}

	@Test
	public void testInsertshowIntoDB() throws ChannelGroupChannelShowServiceException {
		Channel channel = new Channel();
		Show show = new Show();
		show = new Show(1, "jj");
		ShowDto showdto = new ShowDto();
		ShowDto showdto1 = new ShowDto();
		showdto = new ShowDto(1, "jj");
		showdto1 = new ShowDto(2, "kk");
		channel = new Channel(1, "pp", 200);
		Mockito.when(channelrepository.findById(1)).thenReturn(Optional.of(channel));
		assertEquals(channelGroupChannelServiceImpl.insertshowIntoDB(showdto, 1), showdto);
		assertNotEquals(channelGroupChannelServiceImpl.insertshowIntoDB(showdto, 1), showdto1 );
		assertNotNull(showdto);
		assertNull(null);
	}

	@Test
	public void testGetAllChannels() {
		List<ChannelDto> channelsdto = new ArrayList<>();
		List<Channel> channels = new ArrayList<>();
		Channel channel = new Channel();
		channel.setChannelId(1);
		channel.setChannelName("aa");
		channel.setPrice(200);
		channel.setChannelId(2);
		channel.setChannelName("bb");
		channel.setPrice(300);
		channels.add(channel);
		ChannelGroup channelGroup = new ChannelGroup(1, "ab", channels);

		ChannelDto channeldto = new ChannelDto();
		channeldto.setChannelId(1);
		channeldto.setChannelName("aadfgh");
		channeldto.setPrice(200);
		channelsdto.add(channeldto);
		Mockito.when(channelgrouprepository.findById(1)).thenReturn(Optional.of(channelGroup));
		assertEquals(channelGroupChannelServiceImpl.getAllChannels(1).size(), 1);
		assertNotEquals(channelGroupChannelServiceImpl.getAllChannels(1).size(), 2);
		assertNotNull(1);
		assertNull(null);
	}

	@Test
	public void testupdateChannel() {
		Channel channel = new Channel();
		Mockito.when(channelrepository.findById(1)).thenReturn(Optional.of(channel));
		assertEquals(channelGroupChannelServiceImpl.updateChannel(channel, 1, "gh"), channel);
		assertNotEquals(channelGroupChannelServiceImpl.updateChannel(channel, 1, "ij"),null);
		assertNotNull(channel);
		assertNull(null);
	}

	@Test
	public void testdeleteChannelInDB() {
		Channel channel = new Channel();
		Mockito.when(channelrepository.findById(1)).thenReturn(Optional.of(channel));
		assertEquals(channelGroupChannelServiceImpl.deleteChannelInDB(1), channel);
		assertNotEquals(channelGroupChannelServiceImpl.deleteChannelInDB(1), null);
		assertNotNull(channel);
		assertNull(null);
	}
}
