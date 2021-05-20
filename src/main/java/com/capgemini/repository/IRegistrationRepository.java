package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.Registration;
@Repository
public interface IRegistrationRepository extends JpaRepository<Registration, String> {

}
