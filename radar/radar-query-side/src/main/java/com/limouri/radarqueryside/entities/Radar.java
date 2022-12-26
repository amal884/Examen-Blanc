package com.limouri.radarqueryside.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Radar {
    @Id
    private  String id;
    private int vitesseMax;
    private Double longitude;
    private Double latitude;
}
