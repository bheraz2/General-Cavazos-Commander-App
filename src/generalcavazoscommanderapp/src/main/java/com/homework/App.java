package com.homework;

import java.util.Scanner;
import java.util.Stack;

import com.google.gson.JsonArray;

public class App {

   private static JsonArray commandJSONArray;

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
