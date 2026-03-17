import java.util.*;

// Custom Exception
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Room inventory
        Map<String, Integer> rooms = new HashMap<>();
        rooms.put("Standard", 2);
        rooms.put("Deluxe", 2);
        rooms.put("Suite", 1);

        while (true) {
            try {
                System.out.println("\n===== BOOKING MENU =====");
                System.out.println("Available Rooms: " + rooms);

                System.out.print("Enter Guest Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Room Type (Standard/Deluxe/Suite): ");
                String roomType = sc.nextLine();

                // 🔴 VALIDATION 1: Empty input
                if (name.isEmpty()) {
                    throw new InvalidBookingException("Guest name cannot be empty.");
                }

                // 🔴 VALIDATION 2: Invalid room type
                if (!rooms.containsKey(roomType)) {
                    throw new InvalidBookingException("Invalid room type selected.");
                }

                // 🔴 VALIDATION 3: Availability check
                if (rooms.get(roomType) <= 0) {
                    throw new InvalidBookingException("No rooms available for " + roomType);
                }

                // ✅ If all validations pass → confirm booking
                rooms.put(roomType, rooms.get(roomType) - 1);

                System.out.println("Booking successful for " + name + " in " + roomType);

            } catch (InvalidBookingException e) {
                // Graceful error handling
                System.out.println("Booking Failed: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected Error occurred.");
            }

            System.out.print("\nDo you want to continue? (yes/no): ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("no")) {
                System.out.println("Exiting system...");
                break;
            }
        }
    }
}