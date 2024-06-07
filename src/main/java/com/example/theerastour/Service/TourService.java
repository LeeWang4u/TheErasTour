package com.example.theerastour.Service;

import com.example.theerastour.Entities.Tour;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TourService {
    List<Tour> findAll();
    List<Tour> findAllByUpComing();
    List<Tour> findAllByType(String type);


}
