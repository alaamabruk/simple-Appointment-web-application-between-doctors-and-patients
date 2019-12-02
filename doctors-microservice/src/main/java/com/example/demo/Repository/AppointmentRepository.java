package com.example.demo.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long>{

	List<Appointment> findByAvailable(boolean available);
	Optional<Appointment> findByIdAndAvailable(long appointementId, boolean available);
	
	Optional<Appointment> findByFromHourAndDate(String fromhour,Date date); 
	


}
