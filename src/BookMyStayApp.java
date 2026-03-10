import java.util.HashMap;

public class BookMyStayApp {

    // Inner class for Inventory Management
    static class RoomInventory {

        private HashMap<String, Integer> inventory;

        // Constructor initializes room availability
        public RoomInventory() {
            inventory = new HashMap<>();

            inventory.put("Single Room", 5);
            inventory.put("Double Room", 3);
            inventory.put("Suite Room", 2);
        }

        // Get availability
        public int getAvailability(String roomType) {
            return inventory.getOrDefault(roomType, 0);
        }

        // Update availability
        public void updateAvailability(String roomType, int count) {
            inventory.put(roomType, count);
        }

        // Display inventory
        public void displayInventory() {
            System.out.println("===== Room Inventory =====");

            for (String roomType : inventory.keySet()) {
                System.out.println(roomType + " : " + inventory.get(roomType));
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display current inventory
        inventory.displayInventory();

        System.out.println();

        // Check availability
        System.out.println("Single Room Available: "
                + inventory.getAvailability("Single Room"));

        System.out.println();

        // Update inventory
        System.out.println("Updating Single Room availability...\n");
        inventory.updateAvailability("Single Room", 4);

        // Display updated inventory
        inventory.displayInventory();
    }
}