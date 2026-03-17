import java.util.*;

public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // List to store booking history (in insertion order)
        List<String> bookingHistory = new ArrayList<>();

        while (true) {
            System.out.println("\n===== BOOKING SYSTEM =====");
            System.out.println("1. Confirm Booking");
            System.out.println("2. View Booking History");
            System.out.println("3. Generate Report");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    // Simulate booking confirmation
                    System.out.print("Enter Reservation ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Guest Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Room Type: ");
                    String room = sc.nextLine();

                    String booking = "ID: " + id + ", Name: " + name + ", Room: " + room;

                    // Add to history
                    bookingHistory.add(booking);

                    System.out.println("Booking Confirmed and Stored.");
                    break;

                case 2:
                    // View history
                    System.out.println("\n===== BOOKING HISTORY =====");

                    if (bookingHistory.isEmpty()) {
                        System.out.println("No bookings found.");
                    } else {
                        for (String b : bookingHistory) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 3:
                    // Generate simple report
                    System.out.println("\n===== BOOKING REPORT =====");

                    int totalBookings = bookingHistory.size();

                    System.out.println("Total Bookings: " + totalBookings);

                    // Count room types
                    Map<String, Integer> roomCount = new HashMap<>();

                    for (String b : bookingHistory) {
                        String roomType = b.split("Room: ")[1];

                        roomCount.put(roomType, roomCount.getOrDefault(roomType, 0) + 1);
                    }

                    System.out.println("Room Type Distribution:");
                    for (String key : roomCount.keySet()) {
                        System.out.println(key + ": " + roomCount.get(key));
                    }

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