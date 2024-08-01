package com.procedures.demo.appointment;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AppointmentRepository extends CrudRepository<Appointment, Long>{
    // @Query("SELECT ALL FROM Appointment WHERE appointment_date BETWEEN :initalDateTime AND :finalDateTime")
    // List<Appointment> findAllByAppointmentDate(@Param("initalDateTime") LocalDateTime initalDateTime, @Param("finalDateTime") LocalDateTime finalDateTime);
}
