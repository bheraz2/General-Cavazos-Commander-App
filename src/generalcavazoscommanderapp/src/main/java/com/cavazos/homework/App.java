package com.cavazos.homework;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import org.json.simple.JSONArray;

public class App {

    private static JSONArray commandArray;

    // Displays the Menu
    public static void printMenu() {
        System.out.println("----------------------------------------------------------");
        System.out.println("General Cavazos Commander App");
        System.out.println("----------------------------------------------------------");
        printMenuCommand('i', "Issue a command");
        printMenuCommand('l', "List all of the commands");
        printMenuCommand('u', "Undo the last Command");
        printMenuCommand('r', "Redo the last command");
        printMenuCommand('q', "QUIT");
        System.out.println("----------------------------------------------------------");
    }

    public static void printMenuCommand(Character command, String desc) {
        System.out.printf("%s\t%s\n", command, desc);
    }

    public static char menuGetCommand(Scanner scanner) {
        String input = scanner.nextLine().toLowerCase();
        if (!input.isEmpty()) {
            return input.charAt(0);
        }
        return '_';
    }

    //issue a random command
    public static void issueCommand(Stack<String> commandStack) {
        if (commandArray != null && commandArray.size() > 0) {
            System.out.println("Number of commands available: " + commandArray.size());
            Random rand = new Random();
            int randIndex = rand.nextInt(commandArray.size());
            String randomCommand = commandArray.get(randIndex).toString();
            commandStack.push(randomCommand);
            System.out.println();
            System.out.println("[Command ISSUED]: General Cavazos orders the troops to do: " + randomCommand);
            System.out.println();
        } else {
            System.out.println("No commands available.");
        }
    }
    
    //display list of all commands
    public static void listAllCommands() {
        if (commandArray != null && commandArray.size() > 0) {
            System.out.println("----- List of all commands -----");
            for (int i = 0; i < commandArray.size(); i++) {
                System.out.println((i + 1) + ". " + commandArray.get(i));
            }
        } else {
            System.out.println("No commands available.");
        }
    }

    //Undo a command
    public static void undoCommand(Stack<String> commandStack, Stack<String> redoStack) {
        if (!commandStack.isEmpty()) {
            String undoneCommand = commandStack.pop();
            redoStack.push(undoneCommand);
            System.out.println();
            System.out.println("[UNDO COMMAND ISSUED]: General Cavazos orders the troops to undo: " + undoneCommand);
            System.out.println();
        } else {
            System.out.println("[ERROR] No command to undo. Please issue a comand.");
        }
    }

    //redo a command
    public static void redoCommand(Stack<String> commandStack, Stack<String> redoStack) {
        if (!redoStack.isEmpty()) {
            String redoCommand = redoStack.pop();
            commandStack.push(redoCommand);
            System.out.println();
            System.out.println("[REDO COMMAND ISSUED]: General Cavazos orders the troops to redo: " + redoCommand);
            System.out.println();
        } else {
            System.out.println("[ERROR]No commands to redo. Please Issue a Comand.");
        }
    }

    public static void main(String[] args) {

        //Json file
        String fileName = "/Users/bryanheraz/Documents/GitHub/General-Cavazos-Commander-App/src/generalcavazoscommanderapp/src/main/java/com/cavazos/homework/commands.json";
        
        commandArray = JSONFile.readArray(fileName);
        

        Stack<String> commandStack = new Stack<String>();
        Stack<String> redoStack = new Stack<String>();
        Scanner scanner = new Scanner(System.in);

        Character command = '_';


        while (command != 'q') {
            printMenu();
            System.out.print("Enter a command: ");
            command = menuGetCommand(scanner);

            //shows the options of commands we have t=for this app
            switch (command) {
                case 'i':
                    issueCommand(commandStack);
                    break;
                case 'l':
                    listAllCommands();
                    break;
                case 'u':
                    undoCommand(commandStack, redoStack);
                    break;
                case 'r':
                    redoCommand(commandStack, redoStack);
                    break;
                case 'q':
                    System.out.println("Goodbye:)");
                    break;
                default:
                    System.out.println("[ERROR] Invalid Input, Unknown Command.");
            }
        }
        scanner.close();
    }
}

