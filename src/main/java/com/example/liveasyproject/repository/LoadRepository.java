package com.example.liveasyproject.repository;

import com.example.liveasyproject.model.Load;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoadRepository extends JpaRepository<Load, Long> {
    List<Load> findAllByShipperId(long shipperId);
}
