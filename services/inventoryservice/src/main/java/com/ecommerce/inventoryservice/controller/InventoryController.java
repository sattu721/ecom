package com.ecommerce.inventoryservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.inventoryservice.entity.Inventory;
import com.ecommerce.inventoryservice.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

	private final InventoryService service;

	@GetMapping("/reserve/{productId}/{qty}")
	public boolean reserveInventory(@PathVariable Long productId, @PathVariable int qty) {
		return service.reserveStock(productId, qty);
	}

	@PostMapping
	public Inventory addInventory(@RequestBody Inventory inventory) {
		return service.addInventory(inventory);
	}

	@PostMapping("/restore/{productId}/{qty}")
	public void restoreStock(@PathVariable Long productId, @PathVariable int qty) {
		service.restoreStock(productId, qty);
	}
}