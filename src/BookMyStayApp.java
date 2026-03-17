import java.util.Queue;
import java.util.LinkedList;

public class BookMyStayApp {

    // Reservation class representing booking request
    static class Reservation {

        String guestName;
        String roomType;

        Reservation(String guestName, String roomType) {
            this.guestName = guestName;
            this.roomType = roomType;
        }

        void displayRequest() {
            System.out.println("Guest: " + guestName + " requested " + roomType);
        }
    }

    // Booking Request Queue
    static class BookingRequestQueue {

        private Queue<Reservation> queue;

        BookingRequestQueue() {
            queue = new LinkedList<>();
        }

        // Add booking request
        public void addRequest(Reservation reservation) {
            queue.add(reservation);
            System.out.println("Booking request added for " + reservation.guestName);
        }

        // Display queued requests
        public void showRequests() {
            System.out.println("\n===== Booking Request Queue =====");

            for (Reservation r : queue) {
                r.displayRequest();
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Guests submitting booking requests
        Reservation r1 = new Reservation("Vinayak", "Single Room");
        Reservation r2 = new Reservation("Rahul", "Double Room");
        Reservation r3 = new Reservation("Anita", "Suite Room");

        // Add requests to queue
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Show queued booking requests
        bookingQueue.showRequests();
    }
}