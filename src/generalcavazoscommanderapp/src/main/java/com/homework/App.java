package com.homework;

import java.util.Scanner;

public class App 
{
  public static void main(String[] args){

      Scanner scan = new Scanner(System.in);
    Character command = '_';
    
    

    // loop until user quits
    while (command != 'q') {
      printMenu();
      System.out.print("Enter a command: ");
      command = menuGetCommand(scan);

      executeCommand(scan, command);
    }

    scan.close();      
        
    }

    private static void printMenuline() {
        System.out.println(
      "----------------------------------------------------------"
    );
    }

    private static void printMenuCommand(Character command, String desc ) {
        System.out.printf("%s\t%s\n", command, desc);
      }
    

    //Print the menu 
    public static void printMenu(){
        printMenuline();
        System.out.println("General Cavazos COmmander App");
        printMenuline();
        printMenuCommand('i', 'Issue a command');
        printMenuCommand('l', 'List all of th ecommans');
        printMenuCommand('u', "Undo the last command that was issued");
        printMenuCommand('r', 'Redo the last command that was issued');
        printMenuCommand('q', 'Quit');
        printMenuline();

    }

    public static char menuGetCommand(Scanner scanner){
        String input = scanner .nextLine().toLowerCase();
        if (input.length() > 0){
            return input.charAt(0);
        }  
        return '_';
    } 

    public static void 
}
