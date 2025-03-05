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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
public class Batsman extends Player
{
    private int centuries;
    private int halfcenturies;
    private int matachplayed;
    private static File fileB = new File("Batsman.txt");
    private static ArrayList<Batsman> batsmanList= new ArrayList<>();
    
    Batsman()
    {
    }
    Batsman(int halfcenturies , int centuries , int matchplayed)
    {
        this.halfcenturies=halfcenturies;
        this.centuries=centuries;
        this.matachplayed=matchplayed;
    }

    Batsman(String name, int age, LocalDate birthdate, double strikeRate, double economyRate,
            int halfcenturies , int centuries , int matchplayed)
    {
        super(name,age,birthdate,strikeRate,economyRate);
        this.centuries=centuries;
        this.halfcenturies=halfcenturies;
        this.matachplayed=matchplayed;
    }
    public static void addBatsman()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Batsman Name: ");
        String name = input.nextLine();
        System.out.print("Enter Batsman Age: ");
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
        System.out.print("Enter Total Half Centuries: ");
        int half= input.nextInt();
        System.out.print("Enter Total Centuries: ");
        int cen = input.nextInt();
        System.out.print("Enter Match Played: ");
        int match = input.nextInt();
        input.nextLine();
        
        Batsman b = new Batsman(name, age, birthdate, strikeRate, economyRate,
                                  half ,cen ,match);

        batsmanList.add(b);
        Batsman.addBatsmanTOFile();
    }
    public static void addBatsmanTOFile()
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileB))) {
            for (Batsman b : batsmanList) {
                writer.println(b.getName() + "," + b.getAge() + "," +
                        b.getBirthdate() + "," + b.getCenturies() + "," + b.halfcenturies+
                        "," +b.getMatachplayed()+","+b.getStrikeRate()+","+b.getEconomyRate());
            }
        } catch (IOException ex) {
            System.out.println("An error occurred while saving batsman data: " + ex.getMessage());
        }
    }
    public static void removeBatsman(String name)
    {
         boolean found = false;
        for (int i = 0; i < batsmanList.size(); i++) {
            if (batsmanList.get(i).getName().equalsIgnoreCase(name)) {
                batsmanList.remove(i);
                System.out.println("Batsman removed successfully...");
                System.out.println("");
                found = true;
                Batsman.addBatsmanTOFile();
                break;
            }
        }
        if (!found) {
            System.out.println("No match found");
        }

    }
    public static void displayBatsmanDetail(String name)
    {
        boolean found = false;
        for (Batsman b : batsmanList) {
            if (b.getName().equalsIgnoreCase(name)) {
                System.out.println(b);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Batsman not found.");
        }
    }
    public static void displayAllBatsmanDetails()
    {
         try (BufferedReader reader = new BufferedReader(new FileReader(fileB))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                LocalDate birthDate = LocalDate.parse(data[2]);
                int centuries = Integer.parseInt(data[3]);
                int halfcenturies = Integer.parseInt(data[4]);
                int matchplayed = Integer.parseInt(data[5]);
                double strikeRate = Double.parseDouble(data[6]);
                double economyRate = Double.parseDouble(data[7]);
                System.out.println("Batsman Name: " + name);
                System.out.println("Batsman Age: " + age);
                System.out.println("Birth Date: " + birthDate);
                System.out.println("Centuries: " + centuries);
                System.out.println("Half Centuries: " + halfcenturies);
                System.out.println("Total match Played: "+matchplayed);
                System.out.println("Strik Rate: "+strikeRate);
                System.out.println("Ecomony: "+economyRate);
                System.out.println();
            }
        } catch (IOException ex) {
            System.out.println("Error loading file: " + ex.getMessage());
        }
    }
     public static void loadBatsmanFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileB))) {
            String line;
            batsmanList.clear();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                LocalDate birthDate = LocalDate.parse(data[2]);
                int centuries = Integer.parseInt(data[3]);
                int halfcenturies = Integer.parseInt(data[4]);
                int matchplayed = Integer.parseInt(data[5]);
                double strikeRate = Double.parseDouble(data[6]);
                double economyRate = Double.parseDouble(data[7]);
                batsmanList.add(new Batsman(name, age, birthDate, strikeRate, economyRate, centuries, halfcenturies, matchplayed));
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading coach data: " + e.getMessage());
        }
     }
    public int getCenturies()
    {
        return centuries;
    }

    public void setCenturies(int centuries)
    {
        if(centuries<0)
        {
            throw new IllegalArgumentException("Wrong Input.");
        }
        this.centuries = centuries;
    }

    public int getHalfcenturies() 
    {
        return halfcenturies;
    }

    public void setHalfcenturies(int halfcenturies) 
    {
        if(halfcenturies<0)
        {
            throw new IllegalArgumentException("Wrong Input.");
        }
        this.halfcenturies = halfcenturies;
    }

    public int getMatachplayed()
    {
        return matachplayed;
    }

    public void setMatachplayed(int matchplayed)
    {
        if(matchplayed<0)
        {
            throw new IllegalArgumentException("Wrong Input.");
        }
        this.matachplayed = matachplayed;
    }
    
    
}
