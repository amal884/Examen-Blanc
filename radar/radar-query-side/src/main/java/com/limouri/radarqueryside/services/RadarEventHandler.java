package com.limouri.radarqueryside.services;

import com.limouri.commonapi.events.RadarCreatedEvent;
import com.limouri.radarqueryside.entities.Radar;
import com.limouri.radarqueryside.repositories.RadarRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RadarEventHandler {
    RadarRepository radarRepository;

    @EventHandler
    public void on(RadarCreatedEvent event){
        log.info("------------------------------");
        log.info("RadarCreatedEvent occurred");
        Radar radar = new Radar();
        radar.setId(event.getId());
        radar.setVitesseMax(event.getVitesseMax());
        radar.setLongitude(event.getLongtitude());
        radar.setLatitude(event.getLatitude());
        radarRepository.save(radar);
    }
}
