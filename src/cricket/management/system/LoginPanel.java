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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginPanel
{

    private String username;
    private String password;
    private String role;
    private static List<LoginPanel> users= LoginPanel.loadUsersFromFile("Users.txt");
       



    // CONSTRUCTOR
    public LoginPanel(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // GETTER FOR USERNAME
    public String getUsername() {
        return username;
    }

    // GETTER FOR PASSWORD
    public String getPassword() {
        return password;
    }

    // GETTER FOR ROLE
    public String getRole() {
        return role;
    }
     

     public static boolean login(Scanner input, String role) 
    {
        input.nextLine();
        System.out.print("Enter Username: ");
        String enteredUsername = input.nextLine();
        System.out.print("Enter Password: ");
        String enteredPassword = input.nextLine();

        for (LoginPanel user : users) {
            if (user.getRole().equals(role) && user.getUsername().equals(enteredUsername) && user.getPassword().equals(enteredPassword)) {
                return true;
            }
        }
        return false;
    }

    // METHOD TO LOAD USERS FROM FILE
    public static List<LoginPanel> loadUsersFromFile(String filename) 
    {
        List<LoginPanel> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 3) {
                    String username = details[0].trim();
                    String password = details[1].trim();
                    String role = details[2].trim();
                    users.add(new LoginPanel(username, password, role));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user file: " + e.getMessage());
        }
        return users;
    }

}
