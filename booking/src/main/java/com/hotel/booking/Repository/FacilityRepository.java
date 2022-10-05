package com.hotel.booking.Repository;

import com.hotel.booking.Entity.Facility;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends CrudRepository<Facility,Integer> {
}
