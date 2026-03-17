import java.io.*;
import java.util.*;

public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // File name
        String fileName = "data.txt";

        // Inventory
        Map<String, Integer> rooms = new HashMap<>();
        rooms.put("Standard", 2);
        rooms.put("Deluxe", 2);
        rooms.put("Suite", 1);

        // Booking history
        List<String> bookings = new ArrayList<>();

        // 🔵 LOAD DATA (Recovery)
        try {
            File file = new File(fileName);

            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));

                // Load rooms
                rooms.clear();
                int roomCount = Integer.parseInt(br.readLine());

                for (int i = 0; i < roomCount; i++) {
                    String[] parts = br.readLine().split(",");
                    rooms.put(parts[0], Integer.parseInt(parts[1]));
                }

                // Load bookings
                int bookingCount = Integer.parseInt(br.readLine());

                for (int i = 0; i < bookingCount; i++) {
                    bookings.add(br.readLine());
                }

                br.close();
                System.out.println("Data loaded successfully (Recovery done).");
            }

        } catch (Exception e) {
            System.out.println("Error loading data. Starting fresh.");
        }

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Book Room");
            System.out.println("2. View Bookings");
            System.out.println("3. Exit (Save Data)");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Reservation ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Room Type (Standard/Deluxe/Suite): ");
                    String type = sc.nextLine();

                    if (!rooms.containsKey(type)) {
                        System.out.println("Invalid room type.");
                        break;
                    }

                    if (rooms.get(type) <= 0) {
                        System.out.println("No rooms available.");
                        break;
                    }

                    // Book
                    rooms.put(type, rooms.get(type) - 1);
                    bookings.add(id + " - " + type);

                    System.out.println("Booking successful.");
                    break;

                case 2:
                    System.out.println("\nBookings:");
                    for (String b : bookings) {
                        System.out.println(b);
                    }
                    break;

                case 3:
                    // 🔵 SAVE DATA (Persistence)
                    try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

                        // Save rooms
                        bw.write(rooms.size() + "\n");
                        for (String key : rooms.keySet()) {
                            bw.write(key + "," + rooms.get(key) + "\n");
                        }

                        // Save bookings
                        bw.write(bookings.size() + "\n");
                        for (String b : bookings) {
                            bw.write(b + "\n");
                        }

                        bw.close();
                        System.out.println("Data saved successfully.");

                    } catch (Exception e) {
                        System.out.println("Error saving data.");
                    }

                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}