package com.limouri.radarqueryside.repositories;


import com.limouri.radarqueryside.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepository extends JpaRepository<Radar, String> {
}
