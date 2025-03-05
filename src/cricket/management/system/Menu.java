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
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;



public class Menu
{ 
    private MatchSchedule schedule = new MatchSchedule();
    
    public void playerMenu(Scanner input) {
        boolean player = true;
        do {
            System.out.println("\n\nWelcome to Player Menu");
            System.out.println("\nMain Menu:");
            System.out.println("1. Display Player Details.");
            System.out.println("2. Display All Player Details.");
            System.out.println("3. Display Batsman Details.");
            System.out.println("4. Display All Batsman Details.");
            System.out.println("5. Display Bowler Details.");
            System.out.println("6. Display All Bowler Details.");
            System.out.println("7. Display Coach details");
            System.out.println("8. Display Match Schedule");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    input.nextLine();
                    System.out.print("Enter player name: ");
                    String name = input.nextLine();
                    Player.displayPlayerDetails(name);
                    break;
                case 2:
                    Player.displayAllPlayerInfo();
                    break;
                case 3:
                    input.nextLine();
                    System.out.print("Enter Batsman name: ");
                    String bat = input.nextLine();
                    Batsman.displayBatsmanDetail(bat);
                    break;
                case 4:
                    Batsman.displayAllBatsmanDetails();
                    break;
                case 5:
                    input.nextLine();
                    System.out.print("Enter Bowler name: ");
                    String bowl = input.nextLine();
                    Bowler.displayBowlerDetail(bowl);
                    break;
                case 6:
                    Bowler.displayAllBowlerDetails();
                    break;
                case 7:
                    Coach.displayAllCoachDetails();
                    break;
                case 8:
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
                    schedule.displayMatchDetails(matchDate);
                    break;
                case 9:
                    player = false;
                    System.out.println("\n\tExiting Player Menu...");
                    break;
                default:
                    System.out.println("Invalid Choice. Please enter a valid option.");
            }
        } while (player);
    }

    public void coachMenu(Scanner input) {
        boolean coach = true;
        do {
            System.out.println("\n\nWelcome to Coach Menu.");
            System.out.println("\nMain Menu:");
            System.out.println("1. Add Player.");
            System.out.println("2. Remove Player.");
            System.out.println("3. Add Batsman.");
            System.out.println("4. Remove Batsman.");
            System.out.println("5. Add Bowler.");
            System.out.println("6. Remove Bowler.");
            System.out.println("7. Display Coach details");
            System.out.println("8. Display Match Schedule");
            System.out.println("9. Display Full Team.");
            System.out.println("10. Add Player To Team.");
            System.out.println("11. Remove Player From Team.");
            System.out.println("12. Exit");

            System.out.print("Enter choice: ");
            int opt = input.nextInt();

            switch (opt) {
                case 1:
                    Player.addPlayer();
                    break;
                case 2:
                    input.nextLine();
                    System.out.print("Enter Player name: ");
                    String n = input.nextLine();
                    Player.removePlayer(n);
                    break;
                case 3:
                    Batsman.addBatsman();
                    break;
                case 4:
                    input.nextLine();
                    System.out.print("Enter Batsman Name: ");
                    String bat = input.nextLine();
                    Batsman.removeBatsman(bat);
                    break;
                case 5:
                    Bowler.addBowler();
                    break;
                case 6:
                    input.nextLine();
                    System.out.print("Enter Bowler Name: ");
                    String bow = input.nextLine();
                    Bowler.removeBowler(bow);
                    break;
                case 7:
                    Coach.displayAllCoachDetails();
                    break;
                case 8:
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
                    schedule.displayMatchDetails(matchDate);
                   
                    break;
                case 9:
                    Team.displayTeamPlayers();
                    break;
                case 10:
                    input.nextLine();
                    System.out.print("Enter Player Name to Add: ");
                    String name = input.nextLine();
                    Team.addPlayer(name);
                    break;
                case 11:
                    input.nextLine();
                    System.out.print("Enter Player Name to Remove: ");
                    String name1 = input.nextLine();
                    Team.removePlayerFromTeam(name1);
                    break;
                case 12:
                    coach = false;
                    System.out.println("\n\tExiting Coach Menu...");
                    break;
                default:
                    System.out.println("Invalid Choice. Please enter a valid option.");
            }
        } while (coach);
    }

    public void adminMenu(Scanner input) {
        boolean admin = true;
        do {
            System.out.println("\n\nWelcome to Admin Menu");
            System.out.println("\nMain Menu:");
            System.out.println("1. Add Player.");
            System.out.println("2. Remove Player.");
            System.out.println("3. Display Player Details.");
            System.out.println("4. Display All Player Details.");
            System.out.println("5. Add Coach.");
            System.out.println("6. Remove Coach.");
            System.out.println("7. Display Coach details");
            System.out.println("8. Assign Coach To Team.");
            System.out.println("9. Remove Assigned Coach.");
            System.out.println("10.Add New Match Schedule.");
            System.out.println("11.Display Full Team.");
            System.out.println("12.Exit.");

            System.out.print("Enter choice: ");
            int value = input.nextInt();
            Team t = new Team();
            switch (value) {
                case 1:
                    Player.addPlayer();
                    break;
                case 2:
                    input.nextLine();
                    System.out.print("Enter Player name: ");
                    String n = input.nextLine();
                    Player.removePlayer(n);
                    break;
                case 3:
                    input.nextLine();
                    System.out.print("Enter player name: ");
                    String name = input.nextLine();
                    Player.displayPlayerDetails(name);
                    break;
                case 4:
                    Player.displayAllPlayerInfo();
                    break;
                case 5:
                    Coach.addCoach();
                    break;
                case 6:
                    input.nextLine();
                    System.out.print("Enter Coach name: ");
                    String c = input.nextLine();
                    Coach.removeCoach(c);
                    break;
                case 7:
                    Coach.displayAllCoachDetails();
                    break;
                case 8:
                    input.nextLine();
                    System.out.print("Enter Coach Name: ");
                    String coachName=input.nextLine();
                    System.out.print("Enter Coach Type: ");
                    String type= input.nextLine();
                    t.AssignCoach(coachName,type);
                    break;
                case 9:
                    input.nextLine();
                    System.out.print("Enter Coach Name: ");
                    String coachName1=input.nextLine();
                    t.removeTeamCoach(coachName1);
                    break;
                case 10:
                    schedule.addMatchSchedule();
                    break;
                case 11:
                    Team.displayTeamPlayers();
                    break;
                case 12:
                    admin = false;
                    System.out.println("\n\tExiting Admin Menu...");
                    break;
                default:
                    System.out.println("Invalid Choice. Please enter a valid option.");
            }
        } while (admin);
    }
}
