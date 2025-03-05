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

import java.util.Scanner;
import java.time.LocalDate;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MatchSchedule extends Team 
{
    private String awayTeam;
    private LocalDate matchDate; 
    private String location; 
    private File fileT = new File("Schedule.txt"); 
    
    
    // DEFAULT CONSTRUCTOR
    MatchSchedule() {
    }

    // PARAMETERIZED CONSTRUCTOR
    MatchSchedule(String awayTeam, LocalDate matchdate, String location)
    {
        this.awayTeam=awayTeam;
        this.matchDate = matchdate; 
        this.location = location; 
         
    }

    // METHOD TO ADD A MATCH SCHEDULE
    public void addMatchSchedule()
    {
        Scanner input= new Scanner(System.in);
        System.out.print("Enter Away Team: ");
        String away= input.nextLine();
        System.out.print("Enter Location: ");
        String location=input.nextLine();
        input.nextLine();
        
        LocalDate matchDate = null;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        boolean validDate = false;

        while (!validDate) {
            System.out.print("Enter Match Date (yyyy-MM-dd): ");
            String dateString = input.nextLine();

            try {
                matchDate = LocalDate.parse(dateString, dateFormatter);
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }
        MatchSchedule schedule = new MatchSchedule(away,matchDate,location);
        schedule.saveMatchScheduleToFile();
        System.out.println("New Match Schedule Added For Team "+super.getTeamName());
    }
    public void saveMatchScheduleToFile()
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileT, true)))
        {
            writer.println(matchDate + "," + super.getTeamName() + " vs " + awayTeam + "," + location);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the match schedule: " + e.getMessage());
        }
    }

    // METHOD TO DISPLAY MATCH DETAILS FOR A SPECIFIC TEAM
    public void displayMatchDetails(LocalDate matchDate)
    {
       try (BufferedReader reader = new BufferedReader(new FileReader(fileT))) 
       {
            String line;
            boolean dateFound = false;
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split(",");
                if (parts.length > 1) 
                {
                    try 
                    {
                        LocalDate date = LocalDate.parse(parts[0], dateFormatter);
                        if (date.equals(matchDate)) 
                        {
                            dateFound = true;
                            System.out.println(line); 
                        }
                    } 
                    catch (DateTimeParseException e)
                    {
                        System.out.println("Invalid date format in schedule: " + parts[0]);
                    }
                }
            }
            if (!dateFound)
            {
                System.out.println("No match schedule found for the date: " + matchDate); 
            }
        }
       catch (IOException e) 
        {
            System.out.println("An error occurred while reading the schedule file: " + e.getMessage()); 
        }
    }
        
    // GETTER FOR MATCH DATE
    public LocalDate getMatchDate() {
        return matchDate;
    }

    // SETTER FOR MATCH DATE
    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    // GETTER FOR LOCATION
    public String getLocation() {
        return location;
    }

    // SETTER FOR LOCATION
    public void setLocation(String location) {
        this.location = location;
    }
}
