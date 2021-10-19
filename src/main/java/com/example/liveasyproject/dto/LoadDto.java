package com.example.liveasyproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoadDto {
    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private int noOfTrucks;
    private int weight;
    private String comment;
    private Long shipperId;
}
