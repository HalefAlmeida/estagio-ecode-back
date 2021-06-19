package com.api.estagioecode.repository;

import com.api.estagioecode.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {

}
