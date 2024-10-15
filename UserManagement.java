package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManagement {
    private static ArrayList<User> userList = new ArrayList<>();
    private static ArrayList<Incident> incidentList = new ArrayList<>();
    private static int incidentCounter = 1; // To track incident IDs


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean running = true;

        while(running) {
            System.out.println("Welcome to the Cybersecurity Incident Tracking System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int input = scan.nextInt();
            scan.nextLine();

            switch (input) {
                case 1:
                    registerUser(scan);
                    break;
                case 2:
                    loginUser(scan);
                    break;
                case 3:
                    running = false;
                    System.out.println("\n Exit Complete\n");
                    break;
                default:
                    System.out.println("Invalid Choice. Try Again.");
            }
        }

        scan.close();
    }

    public static void registerUser(Scanner scan) {
        System.out.println("Enter Username: ");
        String username = scan.nextLine();

        System.out.println("Enter Password: ");
        String password = scan.nextLine();

        System.out.println("Enter Role(Admin/Analyst): ");
        String role = scan.nextLine();

        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username taken. Try Again");
                return;
            }
        }
        User newUser = new User(username, password, role);
        userList.add(newUser);
        System.out.println("\n New User Added \n");
    }

    public static void loginUser(Scanner scan) {
        System.out.println("Enter Username: ");
        String username = scan.nextLine();

        System.out.println("Enter Password: ");
        String password = scan.nextLine();

        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                if (user.getRole().equalsIgnoreCase("Admin")) {
                    adminMenu(scan);
                } else if (user.getRole().equalsIgnoreCase("Analyst")) {
                    analystMenu(scan, user);
                }
                return;
            }
        }
        System.out.println("\nInvalid Username or Password\n");
    }

    public static void adminMenu(Scanner scan){
        boolean running = true;
        while(running){
            System.out.println("\nAdmin Menu");
            System.out.println("1. View All Incidents");
            System.out.println("2. Logout");

            int input = scan.nextInt();
            scan.nextLine();

            switch(input){
                case 1:
                    viewAllIncidents();
                    break;
                case 2:
                    System.out.println("Logout Successful");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }

    public static void analystMenu(Scanner scan, User user){
            boolean running = true;
            while(running){
                System.out.println("\nAnalyst Menu");
                System.out.println("1. Log Incidents");
                System.out.println("2. View My Incidents");
                System.out.println("3. Logout");

                int input = scan.nextInt();
                scan.nextLine();

                switch(input){
                    case 1:
                        logIncident(scan, user);
                        break;
                    case 2:
                        viewUserIncidents(user);
                        break;
                    case 3:
                        System.out.println("Logout Successful");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid Option");
                }
            }

    }

    public static void viewAllIncidents(){
        System.out.println("\nAll Incidents:");
        for(Incident incident : incidentList){
            System.out.println(incident.toString());
        }
    }

    public static void logIncident(Scanner scan, User user){
        System.out.println("Enter Incident Type (Phishing, DDoS, Malware, etc.): ");
        String incidentType = scan.nextLine();

        System.out.println("Enter Description: ");
        String description = scan.nextLine();

        System.out.println("Enter Status (Open, In Progress, Resolved): ");
        String status = scan.nextLine();

        System.out.println("Enter Time Reported: ");
        String date = scan.nextLine();
        Incident newIncident = new Incident(incidentCounter++, user.getUsername(), incidentType, description, status, date);
        incidentList.add(newIncident);

        System.out.println("\nIncident Logged Successfully\n");
    }

    public static void viewUserIncidents(User user){
        System.out.println("\nMy Incidents:");
        for(Incident incident : incidentList){
            if(incident.getReporterUsername().equals(user.getUsername())){
                System.out.println(incident.toString());
            }
        }
    }

};
