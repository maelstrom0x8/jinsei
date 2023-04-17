package com.antares.jinsei.caveat.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antares.jinsei.caveat.dto.ItemResponse;
import com.antares.jinsei.caveat.model.Item;
import com.antares.jinsei.caveat.repository.ItemRepository;

@Service
public class CaveatService {

	@Autowired
	private ItemRepository itemRepository;

	public List<ItemResponse> getAllItems() {
		return itemRepository.findAll().stream()
				.map(this::toResponse)
				.collect(Collectors.toList());
	}

	public ItemResponse addItem(String name, Double price) {
		Item item = itemRepository.save(new Item(name, price));
		return toResponse(item);
	}

	public void addImageUrl(Long itemID, String url) {
		Optional<Item> item = itemRepository.findById(itemID);
		if (item.isPresent()) {
			item.get().getImages().add(url);
		}
	}

	private ItemResponse toResponse(Item item) {
		return new ItemResponse(item.getId(), item.getName(), item.getPrice());
	}
}
