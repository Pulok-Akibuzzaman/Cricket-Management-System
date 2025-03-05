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

public class Coach extends Person {

    private String type;
    private int experience;
    private static File file = new File("Coach.txt");
    public static ArrayList<Coach> coachList = new ArrayList<>();

    public Coach() {
    }

    public Coach(String name, int age, LocalDate birthDate, String type, int experience) {
        super(name, age, birthDate);
        this.type = type;
        this.experience = experience;
    }

    public String getCoachType() {
        return type;
    }

    public void setCoachType(String type) {
        this.type = type;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
    public static ArrayList<Coach> getCoachList()
    {
        return coachList;
    }

    public static void addCoach() 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Coach Name: ");
        String name = input.nextLine();
        System.out.print("Enter Coach Age: ");
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
        System.out.print("Enter Coach Type: ");
        String type = input.nextLine();
        System.out.print("Enter Coach Experience: ");
        int experience = input.nextInt();
        input.nextLine();

        Coach coach = new Coach(name, age,birthdate, type, experience);
        coachList.add(coach);
        addCoachToFile();
        System.out.println("Coach Added Successfully.");
    }

    public static void removeCoach(String name) {
        coachList.removeIf(coach -> coach.getName().equalsIgnoreCase(name));
        addCoachToFile();
        System.out.println("Coach Removed Successfully.");
    }

    public static void addCoachToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (Coach c : coachList) {
                writer.println(c.getName() + "," + c.getAge() + "," +
                        c.getBirthdate() + "," + c.getCoachType() + "," + c.getExperience());
            }
        } catch (IOException ex) {
            System.out.println("An error occurred while saving coach data: " + ex.getMessage());
        }
    }

    public static void displayCoachDetails(String name) {
        boolean found = false;
        for (Coach c : coachList) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println(c);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Coach not found.");
        }
    }

    public static void displayAllCoachDetails() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                LocalDate birthDate = LocalDate.parse(data[2]);
                String type = data[3];
                int experience = Integer.parseInt(data[4]);
                System.out.println("Coach Name: " + name);
                System.out.println("Coach Age: " + age);
                System.out.println("Birth Date: " + birthDate);
                System.out.println("Type: " + type);
                System.out.println("Experience: " + experience);
                System.out.println();
            }
        } catch (IOException ex) {
            System.out.println("Error loading file: " + ex.getMessage());
        }
    }

    public static void loadCoachFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            coachList.clear();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                LocalDate birthDate = LocalDate.parse(data[2]);
                String type = data[3];
                int experience = Integer.parseInt(data[4]);
                coachList.add(new Coach(name, age, birthDate, type, experience));
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading coach data: " + e.getMessage());
        }
    }
    public String getType()
    {
        return type;
    }

    @Override
    public String toString() {
        return "Name: " + super.getName() + "\n" +
                "Birth Date: " + super.getBirthdate() + "\n" +
                "Type: " + getCoachType() + "\n" +
                "Experience: " + getExperience();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public LocalDate getBirthdate() {
        return super.getBirthdate();
    }

    @Override
    public void setBirthdate(LocalDate birthdate) {
        super.setBirthdate(birthdate);
    }
}
