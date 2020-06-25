package com.onlinebusreservation.dao;

import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onlinebusreservation.model.ScheduledBus;

@Repository
public interface ScheduledBusDao extends JpaRepository<ScheduledBus, BigInteger>{

}
