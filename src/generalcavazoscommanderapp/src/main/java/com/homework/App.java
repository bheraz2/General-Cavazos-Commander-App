package com.homework;

import java.util.Scanner;

public class App {

   private static JSONArray commandJSONArray;
  public static void main(String[] args){
    
    String fileName = "/Users/jerom/Documents/GitHub/class-java/general-cavazos/undoredo/src/main/java/com/cavazos/commands.json";
    commandJSONArray = JSONFile.readArray(fileName);
    
    Stack<String> commandStack = new Stack<String>();
    Stack<String> redoStack = new Stack<String>();
    Scanner scanner = new Scanner(System.in);

    Character command = '_';

    while ( commandd)

  }
}
