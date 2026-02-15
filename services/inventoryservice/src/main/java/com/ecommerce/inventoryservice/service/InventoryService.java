package com.ecommerce.inventoryservice.service;

import org.springframework.stereotype.Service;

import com.ecommerce.inventoryservice.entity.Inventory;
import com.ecommerce.inventoryservice.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository repository;

    public void reduceStock(Long productId, int quantity) {
        Inventory inventory = repository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));

        inventory.setQuantity(inventory.getQuantity() - quantity);
        repository.save(inventory);
    }
    
    public Inventory addInventory(Inventory inventory) {
        return repository.save(inventory);
    }
    
    public boolean reserveStock(Long productId, int quantity) {
		Inventory inventory = repository.findByProductId(productId)
				.orElseThrow(() -> new RuntimeException("Inventory not found"));

		if (inventory.getQuantity() >= quantity) {
			inventory.setQuantity(inventory.getQuantity() - quantity);
			repository.save(inventory);
			return true;
		}
		return false;
	}
    
    public void restoreStock(Long productId, int quantity) {
        Inventory inventory = repository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));
        inventory.setQuantity(inventory.getQuantity() + quantity);
        repository.save(inventory);
    }
    
}