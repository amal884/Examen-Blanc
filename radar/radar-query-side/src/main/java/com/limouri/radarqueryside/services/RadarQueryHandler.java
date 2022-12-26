package com.limouri.radarqueryside.services;

import com.limouri.commonapi.queries.GetAllRadarsQuery;
import com.limouri.commonapi.queries.GetRadarByIdQuery;
import com.limouri.radarqueryside.entities.Radar;
import com.limouri.radarqueryside.repositories.RadarRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RadarQueryHandler {
    private RadarRepository radarRepository;

    @QueryHandler
    public List<Radar> customerList(GetAllRadarsQuery query){
        return radarRepository.findAll();
    }

    @QueryHandler
    public Radar radar(GetRadarByIdQuery query){
        return radarRepository.findById(query.getId()).orElseThrow(()-> new RuntimeException("Radar not found!"));
    }
}
