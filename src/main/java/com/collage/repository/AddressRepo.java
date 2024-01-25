package com.collage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.collage.entity.Address;

import jakarta.transaction.Transactional;

public interface AddressRepo extends JpaRepository<Address, Integer> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Address a WHERE a.city = :cityName", nativeQuery = true)
    int deleteCityByName(@Param("cityName") String cityName);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Address a SET a.pincode = :newpin WHERE a.pincode = :oldpin", nativeQuery = true)
    int updatePincode(@Param("oldpin") String oldpin, @Param("newpin") String newpin);
}
