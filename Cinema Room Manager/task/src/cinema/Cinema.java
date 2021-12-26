package cinema;

import java.util.Objects;
import java.util.Scanner;

public class Cinema {

    static String[][] seats;
    static int purchasedTickets = 0;
    static int currentIncome = 0;
    static int allSeats = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int column = scanner.nextInt();
        allSeats = row * column;
        seats = initSeats(row, column);

        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1: {
                    printSeats(seats);
                    break;
                }
                case 2: {
                    buyTicket(scanner);
                    break;
                }
                case 3: {
                    statistics();
                    break;
                }
                case 0: {
                    return;
                }
            }
        }
    }

    private static void statistics() {
        int totalIncome = (allSeats <= 60)
                ? allSeats * 10
                : (seats.length / 2) * seats[0].length * 10 +
                (allSeats - (seats.length / 2) * seats[0].length) * 8;
        System.out.printf("Number of purchased tickets: %d", purchasedTickets);
        System.out.println();
        System.out.printf("Percentage: %s", getPercentage());
        System.out.println();
        System.out.printf("Current income: $%d", currentIncome);
        System.out.println();
        System.out.printf("Total income: $%d", totalIncome);
        System.out.println();
    }

    private static void buyTicket(Scanner scanner) {
        while (true) {
            System.out.println("Enter a row number:");
            int row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int column = scanner.nextInt();
            if (row > seats.length || column > seats[0].length) {
                System.out.println("Wrong input!");
                continue;
            }
            if (Objects.equals(seats[row - 1][column - 1], "S")) {
                markSeat(row, column);
                purchasedTickets++;
                break;
            } else {
                System.out.println("That ticket has already been purchased!");
            }
        }
    }

    private static String getPercentage() {
        double percentage = purchasedTickets * 100f / (allSeats);
        return String.format("%.2f", percentage) + "%";
    }

    public static String[][] initSeats(int row, int column) {
        String[][] seats = new String[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                seats[i][j] = "S";
            }
        }
        return seats;
    }

    public static void printSeats(String[][] seats) {
        System.out.println("Cinema:");
        for (int i = 0; i <= seats[0].length; i++) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < seats.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seats[0].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void markSeat(int row, int column) {
        if (allSeats > 60) {
            if (row <= seats.length / 2) {
                System.out.printf("Ticket price: $%d", 10);
                currentIncome += 10;
            } else {
                System.out.printf("Ticket price: $%d", 8);
                currentIncome += 8;
            }
        } else {
            System.out.printf("Ticket price: $%d", 10);
            currentIncome += 10;
        }
        System.out.println();
        seats[--row][--column] = "B";
    }
}