package com.tarmoun.radarcommandside.controllers;

import com.tarmoun.commonapi.commands.CreateRadarCommand;
import com.tarmoun.commonapi.dtos.RadarRequestDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/radars/commands")
public class RadarCommandController {

    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> newRadar(@RequestBody RadarRequestDTO request){
        CompletableFuture<String> response = commandGateway.send(new CreateRadarCommand(
                UUID.randomUUID().toString(),
                request.getVitesseMax(),
                request.getLongtitude(),
                request.getLatitude()
        ));
        return response;
    }

    @GetMapping("/eventStore/{radarId}")
    public Stream eventStore(@PathVariable String radarId){
        return eventStore.readEvents(radarId).asStream();
    }
}
