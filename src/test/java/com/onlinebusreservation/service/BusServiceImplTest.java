package com.onlinebusreservation.service;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.onlinebusreservation.dao.BusDao;
import com.onlinebusreservation.model.Bus;

@RunWith(SpringRunner.class)
class BusServiceImplTest {

	@Autowired
	private BusServiceImpl busServiceImplTest;
	@MockBean
	private BusDao busDao;
	
	
	
	@Test
	void testAddBus() {
		Bus bus=new Bus();
		bus.setBusModel("super luxury");
		bus.setBusName("APSRTC");
		bus.setBusNo(new BigInteger("1234"));
		bus.setSeatCapacity(54);
		ResponseEntity<Bus> responseEntity=	busServiceImplTest.addBus(bus);
				
	}

	
}
