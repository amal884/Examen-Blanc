package com.tarmoun.radarcommandside.aggregates;

import com.tarmoun.commonapi.commands.CreateRadarCommand;
import com.tarmoun.commonapi.events.RadarCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class RadarAggregate {
    @AggregateIdentifier
    private String radarId;
    private int vitesseMax;
    private Double longitude;
    private Double latitude;

    public RadarAggregate(){

    }

    @CommandHandler
    public RadarAggregate(CreateRadarCommand command) {
        log.info("CreateRadarCommand received");
        AggregateLifecycle.apply(new RadarCreatedEvent(
                command.getId(),
                command.getVitesseMax(),
                command.getLongtitude(),
                command.getLatitude()
        ));
    }
    @EventSourcingHandler
    public void on(RadarCreatedEvent event){
        log.info("RadarCreatedEvent occurred");
        this.radarId = event.getId();
        this.vitesseMax = event.getVitesseMax();
        this.longitude = event.getLongtitude();
        this.latitude = event.getLatitude();
    }
}

