import java.util.*;

public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Map: reservationId -> List of services (each service = name + cost)
        Map<String, List<String>> serviceMap = new HashMap<>();

        System.out.print("Enter Reservation ID: ");
        String reservationId = sc.nextLine();

        while (true) {
            System.out.println("\nSelect Add-On Service:");
            System.out.println("1. WiFi (₹200)");
            System.out.println("2. Breakfast (₹300)");
            System.out.println("3. Airport Pickup (₹500)");
            System.out.println("4. Done");

            int choice = sc.nextInt();

            String serviceName = "";
            int cost = 0;

            switch (choice) {
                case 1:
                    serviceName = "WiFi";
                    cost = 200;
                    break;

                case 2:
                    serviceName = "Breakfast";
                    cost = 300;
                    break;

                case 3:
                    serviceName = "Airport Pickup";
                    cost = 500;
                    break;

                case 4:
                    // Display services
                    System.out.println("\nAdd-On Services for Reservation ID: " + reservationId);

                    List<String> services = serviceMap.getOrDefault(reservationId, new ArrayList<>());

                    if (services.isEmpty()) {
                        System.out.println("No services selected.");
                    } else {
                        int total = 0;

                        for (String s : services) {
                            System.out.println("- " + s);

                            // Extract cost from string
                            int price = Integer.parseInt(s.split("₹")[1]);
                            total += price;
                        }

                        System.out.println("Total Add-On Cost: ₹" + total);
                    }
                    return;

                default:
                    System.out.println("Invalid choice");
                    continue;
            }

            // Add service to map
            serviceMap.putIfAbsent(reservationId, new ArrayList<>());
            serviceMap.get(reservationId).add(serviceName + " ₹" + cost);

            System.out.println(serviceName + " added.");
        }
    }
}
]