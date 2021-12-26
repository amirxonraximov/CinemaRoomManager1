package cinema;

import java.util.Objects;
import java.util.Scanner;

public class CinemaRoom {
    private final String[][] seats;
    private int purchasedTickets;
    private int currentIncome;
    private final int allSeats;
    private final Scanner sc;
    private final int row;
    private final int column;

    public CinemaRoom() {
        sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        row = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        column = sc.nextInt();
        seats = initSeats(row, column);
        purchasedTickets = 0;
        currentIncome = 0;
        allSeats = row * column;
    }


    public void showMenu() {
        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1: {
                    printSeats(seats);
                    break;
                }
                case 2: {
                    buyTicket();
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

    private void printSeats(String[][] seats) {
        System.out.println("Cinema:");
        for (int i = 0; i <= column; i++) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < row; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < column; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void buyTicket() {
        while (true) {
            System.out.println("Enter a row number:");
            int rowBuy = sc.nextInt();
            System.out.println("Enter a seat number in that row:");
            int columnBuy = sc.nextInt();
            if (rowBuy > row || columnBuy > column) {
                System.out.println("Wrong input!");
                continue;
            }
            if (Objects.equals(seats[rowBuy - 1][columnBuy - 1], "S")) {
                markSeat(rowBuy, columnBuy);
                purchasedTickets++;
                break;
            } else {
                System.out.println("That ticket has already been purchased!");
            }
        }
    }

    private void statistics() {
        int totalIncome = (allSeats <= 60)
                ? allSeats * 10
                : (row / 2) * column * 10 +
                (allSeats - (row / 2) * column) * 8;
        System.out.printf("Number of purchased tickets: %d", purchasedTickets);
        System.out.println();
        System.out.printf("Percentage: %s", getPercentage());
        System.out.println();
        System.out.printf("Current income: $%d", currentIncome);
        System.out.println();
        System.out.printf("Total income: $%d", totalIncome);
        System.out.println();
    }

    private void markSeat(int row, int column) {
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

    private String[][] initSeats(int row, int column) {
        String[][] seats = new String[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                seats[i][j] = "S";
            }
        }
        return seats;
    }

    private String getPercentage() {
        double percentage = purchasedTickets * 100f / (allSeats);
        return String.format("%.2f", percentage) + "%";
    }
}
