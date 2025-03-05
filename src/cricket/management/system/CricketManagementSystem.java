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

import java.util.ArrayList;
import java.util.Scanner;

public class CricketManagementSystem 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        Player.loadPlayersFromFile();
        Coach.loadCoachFile();
        Batsman.loadBatsmanFile();
        Bowler.loadBowlerFile();
        Menu menu= new Menu();

        
        System.out.println("********************************************");
        System.out.println("*                                          *");
        System.out.println("*   WELCOME TO CRICKET MANAGEMENT SYSTEM   *");
        System.out.println("*                                          *");
        System.out.println("********************************************");

        boolean b = true;
        while (b) {
            
            System.out.println("");
            System.out.println("");
            System.out.println(" _______________");
            System.out.println("|---------------|");
            System.out.println("|  1. Player    |");
            System.out.println("|---------------|");
            System.out.println("|  2. Coach     |");
            System.out.println("|---------------|");
            System.out.println("|  3. Admin     |");
            System.out.println("|---------------|");
            System.out.println("Enter 0 to Exit System.");
            System.out.print("Enter Your Role: ");
            int role = input.nextInt();

            switch (role) 
            {
                case 0:
                    b=false;
                    System.out.println("\n\tExiting System...");
                    break;
                case 1:
                    menu.playerMenu(input);
                    break;
                case 2:
                    if (LoginPanel.login(input, "coach")) {
                        menu.coachMenu(input);
                    } else {
                        System.out.println("Invalid credentials for Coach. Access denied.");
                    }
                    break;
                case 3:
                    if (LoginPanel.login(input, "admin")) {
                        menu.adminMenu(input);
                    } else {
                        System.out.println("Invalid credentials for Admin. Access denied.");
                    }
                    break;
                default:
                    System.out.println("Invalid Role. Please enter a valid option.");
            }
        }
        input.close();
    }
}
