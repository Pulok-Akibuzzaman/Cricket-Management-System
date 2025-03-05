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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Team {

    private static final String homeTeam = "Bangladesh";
    private static String teamName;
    private static ArrayList<Player> teamPlayer = new ArrayList<>();
    private static ArrayList<Coach> teamCoach = new ArrayList<>();
    //  private Player player;

    // DEFAULT CONSTRUCTOR
    Team() {
        this.teamName = homeTeam;
    }

    // GETTER FOR TEAM NAME
    public static String getTeam() {
        return homeTeam;
    }
    public String getTeamName()
    {
        return teamName;
    }

    // METHOD TO ADD A PLAYER TO TEAM
    public static void addPlayerToTeam(Player player) {
        teamPlayer.add(player);
        System.out.println(player.getName() + " added to team " + getTeam());
    }

    // METHOD TO ADD A PLAYER BY NAME
    public static void addPlayer(String playerName) {
        Player player = null;
        for (Player p : Player.getPlayersList()) {
            if (p.getName().equalsIgnoreCase(playerName)) {
                player = p;
                break;
            }
        }
        if (player != null) {
            addPlayerToTeam(player);
        } else {
            System.out.println("Player not found in the player list.");
        }
    }

    // METHOD TO REMOVE A PLAYER BY NAME
    public static void removePlayerFromTeam(String name) {
        boolean found = false;
        for (int i = 0; i < teamPlayer.size(); i++) {
            if (teamPlayer.get(i).getName().equalsIgnoreCase(name)) {
                teamPlayer.remove(i);
                System.out.println("Player removed successfully...");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No match found");
        }
    }

    // METHOD TO DISPLAY ALL TEAM PLAYERS
    public static void displayTeamPlayers() {
        System.out.println("Team: " + teamName);
        for (Player player : teamPlayer) {
            System.out.println(player);
        }
    }

    public void AssignCoach(String name, String type) {
        Coach coach = null;
        for (Coach c : Coach.getCoachList()) {
            if (c.getName().equalsIgnoreCase(name) && c.getCoachType().equalsIgnoreCase(type)) {
                coach = c;
                break;
            }
        }
        if (coach != null) {
            teamCoach.add(coach);
            System.out.println(" Successfully assigned " + coach.getType() + " coach for team " + getTeam());
        } else {
            System.out.println("Coach not found in the coach list. ");
        }
    }

    public void removeTeamCoach(String name) {
        boolean found = false;
        for (int i = 0; i < teamCoach.size(); i++) {
            if (teamCoach.get(i).getName().equalsIgnoreCase(name)) {
                teamCoach.remove(i);
                System.out.println("Coach removed successfully...");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No match found");
        }
    }

}
