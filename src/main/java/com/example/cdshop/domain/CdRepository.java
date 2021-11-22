package com.example.cdshop.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CdRepository extends CrudRepository<Cd, Long> {
	
	List<Cd> findByAlbum(String album);

}
