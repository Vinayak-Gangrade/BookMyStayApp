import java.util.*;

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Inventory
        Map<String, Integer> rooms = new HashMap<>();
        rooms.put("Standard", 2);
        rooms.put("Deluxe", 2);
        rooms.put("Suite", 1);

        // Booking storage (reservationId -> roomType)
        Map<String, String> bookings = new HashMap<>();

        // Stack for rollback (released room IDs)
        Stack<String> rollbackStack = new Stack<>();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Book Room");
            System.out.println("2. Cancel Booking");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter Reservation ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Room Type (Standard/Deluxe/Suite): ");
                    String type = sc.nextLine();

                    // Validation
                    if (!rooms.containsKey(type)) {
                        System.out.println("Invalid room type.");
                        break;
                    }

                    if (rooms.get(type) <= 0) {
                        System.out.println("No rooms available.");
                        break;
                    }

                    // Allocate room
                    bookings.put(id, type);
                    rooms.put(type, rooms.get(type) - 1);

                    System.out.println("Booking Confirmed.");
                    break;

                case 2:
                    System.out.print("Enter Reservation ID to cancel: ");
                    String cancelId = sc.nextLine();

                    // Validate existence
                    if (!bookings.containsKey(cancelId)) {
                        System.out.println("Invalid or already cancelled booking.");
                        break;
                    }

                    // Get room type
                    String bookedType = bookings.get(cancelId);

                    // Push to rollback stack (simulate room release)
                    rollbackStack.push(cancelId);

                    // Restore inventory
                    rooms.put(bookedType, rooms.get(bookedType) + 1);

                    // Remove booking
                    bookings.remove(cancelId);

                    System.out.println("Booking cancelled successfully.");
                    break;

                case 3:
                    System.out.println("\nCurrent Bookings: " + bookings);
                    System.out.println("Available Rooms: " + rooms);
                    System.out.println("Rollback Stack: " + rollbackStack);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}