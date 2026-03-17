import java.util.*;

public class UseCase11ConcurrentBookingSimulation {

    // Shared inventory
    static Map<String, Integer> rooms = new HashMap<>();

    // Lock object for synchronization
    static Object lock = new Object();

    public static void main(String[] args) {

        // Initialize inventory
        rooms.put("Standard", 1);
        rooms.put("Deluxe", 1);
        rooms.put("Suite", 1);

        // Simulate multiple guest booking requests (threads)
        Thread t1 = new Thread(() -> bookRoom("Guest1", "Standard"));
        Thread t2 = new Thread(() -> bookRoom("Guest2", "Standard"));
        Thread t3 = new Thread(() -> bookRoom("Guest3", "Deluxe"));

        // Start threads simultaneously
        t1.start();
        t2.start();
        t3.start();
    }

    // Booking method (shared resource access)
    public static void bookRoom(String guestName, String roomType) {

        System.out.println(guestName + " trying to book " + roomType);

        // 🔴 Critical Section (only one thread at a time)
        synchronized (lock) {

            if (!rooms.containsKey(roomType)) {
                System.out.println("Invalid room type for " + guestName);
                return;
            }

            if (rooms.get(roomType) > 0) {
                System.out.println(guestName + " booking confirmed for " + roomType);

                // Update inventory safely
                rooms.put(roomType, rooms.get(roomType) - 1);

            } else {
                System.out.println("No rooms available for " + guestName);
            }
        }
    }
}