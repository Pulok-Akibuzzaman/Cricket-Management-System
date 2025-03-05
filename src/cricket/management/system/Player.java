/*
Group Members:
Muin Hossain
Id:2023-3-60-059
Fayaza Islam                 
Id:2023-3-60-314  
Pulok Akibuzzaman
ID: 2023-3-60-051
*/

package cricket.management.system;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Person {

    private double strikeRate;
    private double economyRate;
    private static ArrayList<Player> playersList = new ArrayList<>();

    // Default Constructor
    public Player() {
    }

    // Parameterized Constructor
    public Player(String name, int age, LocalDate birthdate, double strikeRate, double economyRate) {
        super(name, age, birthdate);
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        if (strikeRate < 0) {
            throw new IllegalArgumentException("Strike Rate cannot be negative.");
        }
        if (economyRate < 0) {
            throw new IllegalArgumentException("Economy Rate cannot be negative.");
        }
        this.strikeRate = strikeRate;
        this.economyRate = economyRate;
    }

    // Method to add a player
    public static void addPlayer() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Player Name: ");
        String name = input.nextLine();
        System.out.print("Enter Player Age: ");
        int age = input.nextInt();
        input.nextLine();
        
        LocalDate birthdate = null;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        boolean validDate = false;

        while (!validDate) {
            System.out.print("Enter Player Birth Date (yyyy-MM-dd): ");
            String dateString = input.nextLine();

            try {
                birthdate = LocalDate.parse(dateString, dateFormatter);
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }

        input.nextLine();
        System.out.print("Enter Player Strike Rate: ");
        double strikeRate = input.nextDouble();
        System.out.print("Enter Player Economy Rate: ");
        double economyRate = input.nextDouble();
        input.nextLine();

        Player player = new Player(name, age, birthdate, strikeRate, economyRate);
        playersList.add(player);
        savePlayersToFile();
        System.out.println("Player Added Successfully.");
    }

    // Method to remove a player
    public static void removePlayer(String name) {
        boolean found = false;
        for (int i = 0; i < playersList.size(); i++) {
            if (playersList.get(i).getName().equalsIgnoreCase(name)) {
                playersList.remove(i);
                System.out.println("Player removed successfully...");
                found = true;
                Player.savePlayersToFile();
                break;
            }
        }
        if (!found) {
            System.out.println("No match found");
        }
    }

    // Method to display details of a specific player
    public static void displayPlayerDetails(String name) {
        boolean found = false;
        for (Player player : playersList) {
            if (player.getName().equalsIgnoreCase(name)) {
                System.out.println(player);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Player Not Found.");
        }
    }

    // Method to display details of all players
    public static void displayAllPlayerInfo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("players.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                    String name = data[0];
                    int age = Integer.parseInt(data[1]);
                    LocalDate birthDate = LocalDate.parse(data[2]);
                    double strikeRate = Double.parseDouble(data[3]);
                    double economyRate = Double.parseDouble(data[4]);
                    System.out.println("Player Name: " + name);
                    System.out.println("Player Age: " + age);
                    System.out.println("Birth Date: " + birthDate);
                    System.out.println("Strike Rate: " + strikeRate);
                    System.out.println("Economy Rate: " + economyRate);
                    System.out.println();
                } else {
                    System.out.println("Invalid data format for player: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading player data: " + e.getMessage());
        }
    }

    // Method to save players to file
    public static void savePlayersToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Players.txt"))) {
            for (Player player : playersList) {
                writer.println(player.getName() + "," + player.getAge() + "," + player.getBirthdate() + "," +
                        player.getStrikeRate() + "," + player.getEconomyRate());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving player data: " + e.getMessage());
        }
    }

    // Method to load players from file
    public static void loadPlayersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("players.txt"))) {
            String line;
            playersList.clear();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                    String name = data[0];
                    int age = Integer.parseInt(data[1]);
                    LocalDate birthDate = LocalDate.parse(data[2]);
                    double strikeRate = Double.parseDouble(data[3]);
                    double economyRate = Double.parseDouble(data[4]);
                    playersList.add(new Player(name, age, birthDate, strikeRate, economyRate));
                } else {
                    System.out.println("Invalid data format for player: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading player data: " + e.getMessage());
        }
    }
    
    public static ArrayList<Player> getPlayersList()
    {
        return playersList;
        
    }

    // Getter for strike rate
    public double getStrikeRate() {
        return strikeRate;
    }

    // Setter for strike rate
    public void setStrikeRate(double strikeRate) {
        if (strikeRate < 0) {
            throw new IllegalArgumentException("Strike Rate cannot be negative.");
        }
        this.strikeRate = strikeRate;
    }

    // Getter for economy rate
    public double getEconomyRate() {
        return economyRate;
    }

    // Setter for economy rate
    public void setEconomyRate(double economyRate) {
        if (economyRate < 0) {
            throw new IllegalArgumentException("Economy Rate cannot be negative.");
        }
        this.economyRate = economyRate;
    }

    // Override toString method to print player details
    @Override
    public String toString() {
        return "Player Name: " + getName() + "\n" +
                "Player Age: " + getAge() + "\n" +
                "Birth Date: " + getBirthdate() + "\n" +
                "Strike Rate: " + getStrikeRate() + "\n" +
                "Economy Rate: " + getEconomyRate() + "\n";
    }
}
