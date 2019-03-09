package com.sprphnx.restws.repository.hr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprphnx.restws.entity.hr.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long>{

}
