package com.limouri.radarqueryside.controllers;

import com.limouri.commonapi.queries.GetAllRadarsQuery;
import com.limouri.commonapi.queries.GetRadarByIdQuery;
import com.limouri.radarqueryside.entities.Radar;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/radars/query")
public class RadarQueryController {

    private QueryGateway queryGateway;

    @GetMapping("/all")
    public CompletableFuture<List<Radar>> radars(){
        return queryGateway.query(new GetAllRadarsQuery(), ResponseTypes.multipleInstancesOf(Radar.class));
    }

    @GetMapping("/byId/{id}")
    public CompletableFuture<Radar> getRadar(@PathVariable String id){
        return queryGateway.query(new GetRadarByIdQuery(id), ResponseTypes.instanceOf(Radar.class));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

}
