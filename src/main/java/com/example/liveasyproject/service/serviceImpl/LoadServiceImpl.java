package com.example.liveasyproject.service.serviceImpl;

import com.example.liveasyproject.dto.LoadDto;
import com.example.liveasyproject.model.Load;
import com.example.liveasyproject.repository.LoadRepository;
import com.example.liveasyproject.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
@Service
public class LoadServiceImpl implements LoadService {
    private final LoadRepository loadRepository;
    @Autowired
    public LoadServiceImpl(LoadRepository loadRepository) {
        this.loadRepository = loadRepository;
    }
    @Override
    public void addNewLoad(LoadDto loadDto) {
        Load load = new Load();
        load.setComment(loadDto.getComment());
        load.setDate(Date.valueOf(LocalDate.now()));
        load.setLoadingPoint(loadDto.getLoadingPoint());
        load.setProductType(loadDto.getProductType());
        load.setNoOfTrucks(loadDto.getNoOfTrucks());
        load.setShipperId(loadDto.getShipperId());
        load.setTruckType(loadDto.getTruckType());
        load.setWeight(loadDto.getWeight());
        load.setUnloadingPoint(loadDto.getUnloadingPoint());
        loadRepository.save(load);
    }

    @Override
    public List<Load> listOfLoadsWithShipperId(long shipperId) {
        return loadRepository.findAllByShipperId(shipperId);
    }

    @Override
    public Load findByLoadId(long loadId) {
        return loadRepository.getById(loadId);
    }

    @Override
    public Load updateLoad(long loadId, LoadDto loadDto) {
        Load load = loadRepository.getById(loadId);
        load.setComment(loadDto.getComment());
        load.setDate(Date.valueOf(LocalDate.now()));
        load.setLoadingPoint(loadDto.getLoadingPoint());
        load.setProductType(loadDto.getProductType());
        load.setNoOfTrucks(loadDto.getNoOfTrucks());
        load.setShipperId(loadDto.getShipperId());
        load.setTruckType(loadDto.getTruckType());
        load.setWeight(loadDto.getWeight());
        load.setUnloadingPoint(loadDto.getUnloadingPoint());
        loadRepository.save(load);
        return load;
    }

    @Override
    public void deleteLoad(long loadId) {
        loadRepository.deleteById(loadId);
    }
}
