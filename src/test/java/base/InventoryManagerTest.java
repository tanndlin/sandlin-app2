package base;

import inventory.Inventory;
import inventory.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {

    InventoryManager inventoryManager;

    @BeforeEach
    void init() {
        inventoryManager = new InventoryManager(new Inventory());
    }

    @Test
    void addItem() {
        assertEquals(0, inventoryManager.getInventory().getItems().size());
        inventoryManager.addItem(new Item("A-XB1-24A-XY3", "Xbox Series X", 1499.00));
        assertEquals(1, inventoryManager.getInventory().getItems().size());
    }

    @Test
    void addDuplicateSerialNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            inventoryManager.addItem(new Item("A-XB1-24A-XY3", "Xbox Series X", 1499.00));
            inventoryManager.addItem(new Item("A-XB1-24A-XY3", "Hello World", 420.69));
        });
    }

    @Test
    void clearItems() {
        inventoryManager.addItem(new Item("A-XB1-24A-XY3", "Xbox Series X", 1499.00));
        inventoryManager.clearItems();
        assertEquals(0, inventoryManager.getInventory().getItems().size());
    }
}