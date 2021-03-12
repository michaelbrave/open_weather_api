package com.tts.WeatherApp.repository;

import com.tts.WeatherApp.model.ZipCode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZipCodeRepository extends CrudRepository<ZipCode, Long>{
    ZipCode findByZipCode(String zip);

    @Query(value = "SELECT ZIP_CODE,FROM ZIP_CODE ORDER BY CREATED_AT DESC LIMIT 10",
            nativeQuery = true)
    List<String> findMostRecent();
}