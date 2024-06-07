package com.example.theerastour.Repository;

import com.example.theerastour.Entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {

    List<Tour> findAll();

//    @Query(
//            value =" select t from Tour as t where t.type = ?1 "
//            ,nativeQuery = true
//    )
@Query(value = "SELECT t FROM Tour t WHERE t.type = ?1")
    List<Tour> findAllByType(String TYPE);

    @Query("SELECT t FROM Tour t WHERE t.tourDate > CURRENT_DATE")
    List<Tour> findUpcomingTours();
    Tour findTourById(int id);


}