package com.cpe.backend.Carreturn.repository;

import com.cpe.backend.Carreturn.entity.ReturnsCar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface ReturnsCarRepository extends JpaRepository<ReturnsCar, Long> {
	ReturnsCar findById(long id);
}