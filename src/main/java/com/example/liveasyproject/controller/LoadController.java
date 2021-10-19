package com.example.liveasyproject.controller;

import com.example.liveasyproject.dto.LoadDto;
import com.example.liveasyproject.model.Load;
import com.example.liveasyproject.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/load")
public class LoadController {
    private final LoadService loadService;

    @Autowired
    public LoadController(LoadService loadService) {
        this.loadService = loadService;
    }

    @PostMapping("/addNewLoad")
    public ResponseEntity<String> addNewLoad (@RequestBody LoadDto loadDto) {
        loadService.addNewLoad(loadDto);
        return new ResponseEntity<>("loads details added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/loadsByShipper")
    public ResponseEntity<List<Load>> loadsByShipper(@RequestParam long shipperId) {
        List<Load> loadList = loadService.listOfLoadsWithShipperId(shipperId);
        return ResponseEntity.ok(loadList);
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<Load> findByLoadId(@PathVariable long loadId) {
        return ResponseEntity.ok(loadService.findByLoadId(loadId));
    }

    @PutMapping("/updateLoad/{loadId}")
    public ResponseEntity<Load> updateLoad(@PathVariable long loadId, @RequestBody LoadDto loadDto) {
        return new ResponseEntity<>(loadService.updateLoad(loadId, loadDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteLoad/{loadId}")
    public ResponseEntity<String> deleteLoad(@PathVariable long loadId){
        loadService.deleteLoad(loadId);
        return ResponseEntity.ok("Load successfully deleted");
    }
}
