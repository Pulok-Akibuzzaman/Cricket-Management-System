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


public class Bowler extends Player
{
    private int totalwickets;
    private int fifer;
    private int matchplayed;
    private static File fileBo = new File("Bowler.txt");
    private static ArrayList<Bowler> bowlerList = new ArrayList<>();
    
    Bowler()
    {
    }
    Bowler(int totalwicket , int fifer , int matchplayed)
    {
        this.totalwickets=totalwicket;
        this.fifer=fifer;
        this.matchplayed=matchplayed;
    }
    Bowler(String name, int age, LocalDate birthdate, double strikeRate, double economyRate,
            int totalwicket,int fifer,int matchplayed)
    {
        super(name,age,birthdate,strikeRate,economyRate);
        this.totalwickets=totalwicket;
        this.fifer=fifer;
        this.matchplayed=matchplayed;
    }
    public static void addBowler()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Bowler Name: ");
        String name = input.nextLine();
        System.out.print("Enter Bowler Age: ");
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
        System.out.print("Enter Bowler Strike Rate: ");
        double strikeRate = input.nextDouble();
        System.out.print("Enter Bowler Economy Rate: ");
        double economyRate = input.nextDouble();
        input.nextLine();
        System.out.print("Enter Total Wicket: ");
        int half= input.nextInt();
        System.out.print("Enter Total Fifer: ");
        int cen = input.nextInt();
        System.out.print("Enter Match Played: ");
        int match = input.nextInt();
        input.nextLine();
        
        Bowler bo = new Bowler(name, age, birthdate, strikeRate, economyRate,
                                  half ,cen ,match);

        bowlerList.add(bo);
        Bowler.addBowlerToFile();
    }
    public static void addBowlerToFile()
    {
        try (PrintWriter writer1 = new PrintWriter(new FileWriter(fileBo)))
        {
            for (Bowler bo : bowlerList) {
                writer1.println(bo.getName() + "," + bo.getAge() + "," +
                        bo.getBirthdate() + "," + bo.getTotalwickets() + "," + bo.getFifer()+
                        "," +bo.getMatchplayed()+","+bo.getStrikeRate()+","+bo.getEconomyRate());
            }
        } catch (IOException ex) {
            System.out.println("An error occurred while saving batsman data: " + ex.getMessage());
        }
    }
    public static void removeBowler(String name)
    {
        boolean found=false;
        for(int i=0;i<bowlerList.size();i++)
        {
            if(bowlerList.get(i).getName().equalsIgnoreCase(name))
            {
                bowlerList.remove(i);
                System.out.println("Bowler removed successfully...");
                System.out.println("");
                found = true;
                Bowler.addBowlerToFile();
                break;
            }
            if(!found)
            {
                System.out.println("No match found");
            }
        }
    }
    public static void displayBowlerDetail(String name)
    {
        boolean found= false;
        for(Bowler bo : bowlerList)
        {
            if(bo.getName().equalsIgnoreCase(name))
            {
                System.out.println(bo);
                found = true;
                break;
            }
        }
             if(!found)
            {
                System.out.println("Bowler not found");
            }
    }
    public static void displayAllBowlerDetails()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileBo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                LocalDate birthDate = LocalDate.parse(data[2]);
                int wicket = Integer.parseInt(data[3]);
                int fifer = Integer.parseInt(data[4]);
                int matchplayed = Integer.parseInt(data[5]);
                double strikeRate = Double.parseDouble(data[6]);
                double economyRate = Double.parseDouble(data[7]);
                System.out.println("Bowler Name: " + name);
                System.out.println("Bowler Age: " + age);
                System.out.println("Birth Date: " + birthDate);
                System.out.println("Total Wicket: " + wicket);
                System.out.println("Fifer: " + fifer);
                System.out.println("Total match Played: "+matchplayed);
                System.out.println("Strik Rate: "+strikeRate);
                System.out.println("Ecomony: "+economyRate);
                System.out.println();
            }
        } catch (IOException ex) {
            System.out.println("Error loading file: " + ex.getMessage());
        }
    }
    public static void loadBowlerFile()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileBo))) {
            String line;
            bowlerList.clear();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                LocalDate birthDate = LocalDate.parse(data[2]);
                int wicket = Integer.parseInt(data[3]);
                int fifer = Integer.parseInt(data[4]);
                int matchplayed = Integer.parseInt(data[5]);
                double strikeRate = Double.parseDouble(data[6]);
                double economyRate = Double.parseDouble(data[7]);
                bowlerList.add(new Bowler(name, age, birthDate, strikeRate, economyRate, wicket, fifer, matchplayed));
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading Bowler data: " + e.getMessage());
        }
    }
    public int getTotalwickets()
    {
        return totalwickets;
    }

    public void setTotalwickets(int totalwickets)
    {
        if(totalwickets<0)
        {
            throw new IllegalArgumentException("Wronng input.");
        }
        this.totalwickets = totalwickets;
    }

    public int getFifer() 
    {
        return fifer;
    }

    public void setFifer(int fifer)
    {
        if(fifer<0)
        {
            throw new IllegalArgumentException("Wronng input.");
        }
        this.fifer = fifer;
    }

    public int getMatchplayed() {
        return matchplayed;
    }

    public void setMatchplayed(int matchplayed) 
    {
        if(matchplayed<0)
        {
            throw new IllegalArgumentException("Wronng input.");
        }
        this.matchplayed = matchplayed;
    }

}
