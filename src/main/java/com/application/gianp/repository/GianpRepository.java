package com.application.gianp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.application.gianp.model.Gianp;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface GianpRepository extends CrudRepository<Gianp, Integer> {
	
	@Query(value="SELECT message FROM gianp WHERE idgianp = ?1", nativeQuery=true)
	String findGianpByIdnativeQuery(Integer id);
	
	@Query(value="SELECT message,idgianp,message FROM gianp", nativeQuery=true)
	List<Object[]> findAllToGenericObject(); //Con List<Object[]> prendi qualsiesi cosa da qualsiesi query
	

}