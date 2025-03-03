package com.devsuperior.bds04.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository repository;
	
	public Page<CityDTO> findAllPaged(Pageable pageable){
		Page<City> list = repository.findAll(pageable);
		return list.map(x -> new CityDTO(x));
	}
	
	public CityDTO insert(CityDTO dto) {
		City entity = new City();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new CityDTO(entity);
	}
}
