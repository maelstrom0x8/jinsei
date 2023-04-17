package com.antares.jinsei.caveat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antares.jinsei.caveat.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
}
