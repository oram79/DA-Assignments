//Simulate a movie theater that helps users to book and reserve seats.
//1. Reserve seats (if seat is taken, let them know it is taken and suggest an available seat)
//2. Cancel seats
//3. Retrieve initial seating charting

package Arrays;

public class MovieTheatre {
    private char[][] seats; // 2D Array//

    public MovieTheatre(int rows, int cols) {
        seats = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seats[i][j] = 'A';
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
            if (seats[row][col] == 'A') {
                seats[row][col] = 'R';
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
            if (seats[row][col] == 'R') {
                seats[row][col] = 'A';
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
                if (seats[i][j] == 'A') {
                    System.out.println("Row: " + i + ", Seat: " + j);
                    return;
                }
            }
        }
    }
}
