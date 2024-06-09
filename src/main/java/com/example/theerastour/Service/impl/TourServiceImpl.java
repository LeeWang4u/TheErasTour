package com.example.theerastour.Service.impl;
import com.example.theerastour.Entities.Tour;
import com.example.theerastour.Repository.TourRepository;
import com.example.theerastour.Service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {
    @Autowired
    private TourRepository tourRepository;
    @Override
    public List<Tour> findAll(){
        return tourRepository.findAll();
    }

    @Override
    public List<Tour> findAllByUpComing(){
        List<Tour> tours = tourRepository.findUpcomingTours();
        if (tours == null) {
            return List.of();
        }
        return tours;
    }

    @Override
    public List<Tour> findAllByType(String type){
        List<Tour> tours = tourRepository.findAllByType(type);

        if (tours == null) {
            // Trả về một danh sách rỗng hoặc xử lý theo yêu cầu
            return List.of();
        }
        return tours;
    }

    @Override
    public Tour findTourById(int id){
        return tourRepository.findTourById(id);
    }

}
