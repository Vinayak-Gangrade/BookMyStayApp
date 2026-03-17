import java.util.HashMap;

public class BookMyStayApp {

    // Abstract Room class
    static abstract class Room {
        int beds;
        int size;
        double price;

        Room(int beds, int size, double price) {
            this.beds = beds;
            this.size = size;
            this.price = price;
        }

        abstract String getRoomType();

        void displayDetails() {
            System.out.println("Room Type: " + getRoomType());
            System.out.println("Beds: " + beds);
            System.out.println("Size: " + size + " sq.ft");
            System.out.println("Price: ₹" + price);
        }
    }

    // Room Types
    static class SingleRoom extends Room {
        SingleRoom() {
            super(1, 200, 1500);
        }

        String getRoomType() {
            return "Single Room";
        }
    }

    static class DoubleRoom extends Room {
        DoubleRoom() {
            super(2, 350, 2500);
        }

        String getRoomType() {
            return "Double Room";
        }
    }

    static class SuiteRoom extends Room {
        SuiteRoom() {
            super(3, 600, 5000);
        }

        String getRoomType() {
            return "Suite Room";
        }
    }

    // Inventory (UC3 concept reused)
    static class RoomInventory {

        private HashMap<String, Integer> inventory;

        RoomInventory() {
            inventory = new HashMap<>();
            inventory.put("Single Room", 5);
            inventory.put("Double Room", 3);
            inventory.put("Suite Room", 0); // Example unavailable room
        }

        public int getAvailability(String roomType) {
            return inventory.getOrDefault(roomType, 0);
        }
    }

    // Search Service (Read-only access)
    static class SearchService {

        public void searchRooms(RoomInventory inventory, Room[] rooms) {

            System.out.println("===== Available Rooms =====");

            for (Room room : rooms) {

                int available = inventory.getAvailability(room.getRoomType());

                // Show only available rooms
                if (available > 0) {
                    room.displayDetails();
                    System.out.println("Available Rooms: " + available);
                    System.out.println("------------------------");
                }
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        // Create inventory
        RoomInventory inventory = new RoomInventory();

        // Create room objects
        Room[] rooms = {
                new SingleRoom(),
                new DoubleRoom(),
                new SuiteRoom()
        };

        // Search service
        SearchService search = new SearchService();

        // Guest searches for rooms
        search.searchRooms(inventory, rooms);
    }
}