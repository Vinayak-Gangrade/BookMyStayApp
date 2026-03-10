public class BookMyStayApp {

    // Abstract Room Class
    static abstract class Room {
        private int beds;
        private int size;
        private double price;

        public Room(int beds, int size, double price) {
            this.beds = beds;
            this.size = size;
            this.price = price;
        }

        public int getBeds() {
            return beds;
        }

        public int getSize() {
            return size;
        }

        public double getPrice() {
            return price;
        }

        public abstract String getRoomType();

        public void displayRoomDetails() {
            System.out.println("Room Type: " + getRoomType());
            System.out.println("Beds: " + beds);
            System.out.println("Size: " + size + " sq.ft");
            System.out.println("Price per night: ₹" + price);
        }
    }

    // Single Room Class
    static class SingleRoom extends Room {
        public SingleRoom() {
            super(1, 200, 1500);
        }

        public String getRoomType() {
            return "Single Room";
        }
    }

    // Double Room Class
    static class DoubleRoom extends Room {
        public DoubleRoom() {
            super(2, 350, 2500);
        }

        public String getRoomType() {
            return "Double Room";
        }
    }

    // Suite Room Class
    static class SuiteRoom extends Room {
        public SuiteRoom() {
            super(3, 600, 5000);
        }

        public String getRoomType() {
            return "Suite Room";
        }
    }

    // Main Method
    public static void main(String[] args) {

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("===== Welcome to BookMyStay =====\n");

        single.displayRoomDetails();
        System.out.println("Available Rooms: " + singleAvailable);
        System.out.println("---------------------------");

        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + doubleAvailable);
        System.out.println("---------------------------");

        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + suiteAvailable);

        System.out.println("\nThank you for using BookMyStay!");
    }
}