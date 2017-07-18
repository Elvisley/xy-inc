package com.xyinc.poi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyinc.poi.model.Poi;

@Repository
public interface PoiRepository extends JpaRepository<Poi,Long> {

}
