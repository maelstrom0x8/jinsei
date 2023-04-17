package com.antares.jinsei.caveat.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antares.jinsei.caveat.dto.ItemRequest;
import com.antares.jinsei.caveat.dto.ItemResponse;
import com.antares.jinsei.caveat.service.CaveatService;

@RestController
@RequestMapping("/items")
public class ItemController {

	private final Logger logger = LoggerFactory.getLogger(ItemController.class.getName());

	@Autowired
	private CaveatService caveatService;

	@GetMapping
	public List<ItemResponse> items() {
		logger.info("GET: All items");
		return caveatService.getAllItems();
	}

	@PostMapping
	public ItemResponse addItem(@RequestBody ItemRequest item) {
		return caveatService.addItem(item.name(), item.price());
	}

	@PostMapping("/{id}/images")
	public void addImage(@PathVariable Long itemID, @RequestBody String url) {
		caveatService.addImageUrl(itemID, url);
	}

	@GetMapping("/info")
	public String info() {
		return "Caveate Emptor. Since 2008";
	}

}
