package com.example.liveasyproject.service;

import com.example.liveasyproject.dto.LoadDto;
import com.example.liveasyproject.model.Load;

import java.util.List;

public interface LoadService {
    void addNewLoad(LoadDto loadDto);
    List<Load> listOfLoadsWithShipperId (long shipperId);
    Load findByLoadId (long loadId);
    Load updateLoad (long loadId, LoadDto loadDto);
    void deleteLoad (long loadId);
}
