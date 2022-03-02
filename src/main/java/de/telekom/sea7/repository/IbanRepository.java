package de.telekom.sea7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.telekom.sea7.model.implementation.IbanImpl;

public interface IbanRepository extends JpaRepository<IbanImpl, Integer> {
	
}