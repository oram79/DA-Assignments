//Simulate a movie theater that helps users to book and reserve seats.
//1. Reserve seats (if seat is taken, let them know it is taken and suggest an available seat)
//2. Cancel seats
//3. Retrieve initial seating charting

package Arrays;
import java.util.Scanner;

public class MovieTheatre {
    private char[][] seats; // 2D Array//

    public MovieTheatre(int rows, int cols) {
        seats = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seats[i][j] = 'O';
            }
        }
    }

    // Display The Seating Chart //
    public void displaySeatingChart() {
        System.out.println("Seating Chart:");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Buying A Seat //
    public boolean reserveSeat(int row, int col) {
        if (isValidSeat(row, col)) {
            if (seats[row][col] == 'O') {
                seats[row][col] = 'X';
                System.out.println("Ticket Purchase Successful!");
                return true;
            } else {
                System.out.println("Seat Is Already Taken");
                suggestAvailableSeat();
                return false;
            }
        }
        System.out.println("Invaild Seat Selection");
        return false;
    }

    // Cancel A Reserved Seat //
    public boolean cancelReservation(int row, int col) {
        if (isValidSeat(row, col)) {
            if (seats[row][col] == 'X') {
                seats[row][col] = 'O';
                System.out.println("Reservation Canceled!");
                return true;
            } else {
                System.out.println("Seat Is Not Reserved");
                return false;
            }
        }
        System.out.println("Invalid Seat Selection, Try Again!");
        return false;
    }

    // Suggest Next Available Seat //
    private void suggestAvailableSeat() {
        System.out.println("Available Seat:");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 'O') {
                    System.out.println("Row: " + i + ", Seat: " + j);
                    return;
                }
            }
        }
        System.out.println("No Seats Available");
    }

    // Validating Seat Indices //
    private boolean isValidSeat(int row, int col) {
        return row >= 0 && row < seats.length && col >= 0 && col < seats[0].length;
    }

    // Main Method For Testing //
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieTheatre theatre = new MovieTheatre(5, 5);

        while (true) {
            System.out.println("\n1. Display Seating Chart");
            System.out.println("2. Reserve a Seat");
            System.out.println("3. Cancel a Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    theatre.displaySeatingChart();
                    break;
                case 2:
                    System.out.print("Enter row: ");
                    int reserveRow = scanner.nextInt();
                    System.out.print("Enter column: ");
                    int reserveCol = scanner.nextInt();
                    theatre.reserveSeat(reserveRow, reserveCol);
                    break;
                case 3:
                    System.out.print("Enter row: ");
                    int cancelRow = scanner.nextInt();
                    System.out.print("Enter column: ");
                    int cancelCol = scanner.nextInt();
                    theatre.cancelReservation(cancelRow, cancelCol);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
