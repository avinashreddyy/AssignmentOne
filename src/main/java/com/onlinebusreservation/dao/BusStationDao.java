package com.onlinebusreservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onlinebusreservation.model.BusStation;

@Repository
public interface BusStationDao extends JpaRepository<BusStation, String> {

}
