package com.antares.jinsei.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antares.jinsei.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
}
