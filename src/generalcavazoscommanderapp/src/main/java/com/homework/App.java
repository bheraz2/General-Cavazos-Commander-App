package com.homework;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import org.json.simple.JSONArray;

import com.cavazos.JSONFile;

public class App {

   private static JSONArray commandArray;

   

   //Displays the Menu
   public static void printMenu(){
    System.out.println("----------------------------------------------------------");
    System.out.println("General Cavazos Commander App");
    System.out.println("----------------------------------------------------------");
    printMenuCommand('i', "Issue a command");
    printMenuCommand('l', "List all of the commands");
    printMenuCommand('u', "Undo the last Command");
    printMenuCommand('r', "Redo the last command");
    printMenuCommand('q',"QUIT");
    System.out.println("----------------------------------------------------------");

   }

   public static void printMenuCommand(Character command, String desc) {
        System.out.printf("%s\t%s\n", command, desc);
    }

    public static char menuGetCommand(Scanner scanner){
        String input = scanner.nextLine().toLowerCase();
        if(!input.isEmpty()){
            return input.charAt(0);
        }
        return '_';
    }

    public static void issueCommad(Stack<String> commandStack){
        Random rand = new Random();
        int randIndex = rand.nextInt(commandArray.size());
        String randomCommand = commandArray.get(randIndex).toString();
        commandStack.push(randomCommand);
        System.out.println("Issued command: " + randomCommand);
    }

    public static void listALLCommands(String[] commandArray, int numCommand){
        System.out.println("----- List of all commands -----");
        System.out.println();
        Random rand = new Random();
    System.out.printf("Number\tCommand\n");
    System.out.printf("------\t---------------\n");
    for (int i = 0; i < numCommand; i++) {
      int randIndex = rand.nextInt(commandArray.length);
      System.out.printf("%04d\t%s\n", i, commandArray[randIndex]);
    }
    }

    public static void undoCommand(Stack<String> commandStack, Stack<String> redoStack){
        if (!commandStack.isEmpty()){
            String undoneCommand = commandStack.pop();
            redoStack.push(undoneCommand);
            System.out.println("Undone Command: " + undoneCommand);
            }else {
                System.out.println("No command to undo.");
            }
        }

    public static void redoCommand(Stack<String> commandStack, Stack<String> redoStack){
        if (!redoStack.isEmpty()){
            String redoneCommand = redoStack.pop();
            commandStack.push(redoneCommand);
            System.out.println("Redone Command: " + redoneCommand);
        } else {
            System.out.println("No commands to redo."); 
        }
    }
    
     public static void main(String[] args){
    
        String fileName = "/Users/jerom/Documents/GitHub/class-java/general-cavazos/undoredo/src/main/java/com/cavazos/commands.json";
        commandArray = JSONFile.readArray(fileName);
    
        Stack<String> commandStack = new Stack<String>();
        Stack<String> redoStack = new Stack<String>();
        Scanner scanner = new Scanner(System.in);

        Character command = '_';

        while (command != 'q'){
         printMenu();
            System.out.print("Enter a command: ");
            System.out.println();
            command = menuGetCommand(scanner);

            switch (command){
                case 'i':
                    issueCommad(commandStack);
                    break;
                case 'l':
                     listALLCommands(args, 0);
                    break;
                case 'u':
                    undoCommand(commandStack, redoStack);
                    break;
                case 'r':
                    redoCommand(commandStack, redoStack);
                    break;
                case 'q':
                    if (command == 'q'){
                    System.out.println("Goodbye:)");
                 }
                break;
            default:
                System.out.println("Invalid Command. Please Try again");
                
            
        }
    }
        scanner.close();
  }


}
