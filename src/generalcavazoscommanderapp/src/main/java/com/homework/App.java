package com.homework;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import org.json.simple.JSONArray;

import com.cavazos.JSONFile;

public class App {

   private static JSONArray commandJSONArray;

   public static void printMenu(){
    System.out.println("----------------------------------------------------------");
    System.out.println("General Cavazos COmmander App");
    System.out.println("----------------------------------------------------------");
    printMenuCommand('i', "Issue a command");
    printMenuCommand('l', "List all of the commands");
    printMenuCommand('u', "Undeo the last Command");
    printMenuCommand('r', "Redo the last command");
    printMenuCommand('q',"QUIT");
    System.out.println("----------------------------------------------------------");
   }

   public static void printMenuCommand(Character command, String desc) {
        System.out.printf("%s\t%s\n", command, desc);
    }

    public static char menuGetCommand(Scanner scamner){
        String input = scanner.nextLine().toLowerCase();
        if(!input.isEmpty()){
            return input.charAt(0);
        }
        return '_';
    }

    public static void issuseCommad(Stack<String> commandStack){
        Random rand = new Random();
        int randIndex = rand.nextInt(commandJSONArray.size());
        String randomCommand = commandJSONArray.get(randIndex).toString();
        commandStack.push(randomCommand);
        System.out.println("Issued command: " + randomCommand);
    }
  public static void main(String[] args){
    
    String fileName = "/Users/jerom/Documents/GitHub/class-java/general-cavazos/undoredo/src/main/java/com/cavazos/commands.json";
    commandJSONArray = JSONFile.readArray(fileName);
    
    Stack<String> commandStack = new Stack<String>();
    Stack<String> redoStack = new Stack<String>();
    Scanner scanner = new Scanner(System.in);

    Character command = '_';

    while (command != 'q'){
        printMenu();
        System.out.print("Enter a command");
        command = menuGetCommand(scanner);

        switch (command){
            case 'i':
                //
                break;
            case 'l':
                //
                break;
            case 'u':
                //
                break;
            case 'r':
                //
                break;
            case 'q':
            
                break;
            default:
                System.out.println("Invalid Command. Please Try again");

            
        }
    }
        scanner.close();
  }


}
