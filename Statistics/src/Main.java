/*
Written by Dexter Jones

Pseudocode:
A program that provides important statistics for grades in a class.

for-loop:
    Read 10 floating-point grades from user input

input: float grades
output: float average, maximum, minimum

user validation: while loop try-catch
    try: parse input for float
    catch: number formatting exception - ask for user input again
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        float ave, max = 0, min = 101, grade = 0, total = 0;
        String s;
        boolean isNumber = false;
        float grades[] = new float[10]; // float array to hold all grades

        System.out.print("Academic Performance Analyzer\n--------------------------------------\n ");

        for (int i = 0; i < 10; i++) {
            isNumber = false; // needed to reset while entry variable
            System.out.print("Please enter grade " + (i+1) + ":");
            s = scnr.nextLine();

            while (!isNumber) {
                try { // try to parse user input s to float
                    grade = Float.parseFloat(s);

                    while (grade < 0 || grade > 100) {
                        System.out.print("Number is out of bounds. Please enter a grade between 0-100: ");
                        s = scnr.nextLine();
                        try {
                            grade = Float.parseFloat(s);
                        }
                        catch (NumberFormatException e) {
                            System.out.print("Invalid entry. Please enter a number for the grade: ");
                        }
                    }
                    if (grade < min) {
                        min = grade;
                    }
                    else if (grade > max) {
                        max = grade;
                    }
                    total += grade;
                    isNumber = true;
                }
                catch (NumberFormatException e){ // if unable to parse String s to float, ask for user input again
                        System.out.print("Invalid entry. Please enter a number for the grade: ");
                        s = scnr.nextLine();
                }
            }
            grades[i] = grade;

        }
        System.out.println(total);

        for (int i = 0; i < 10; i++) { // debugging for loop - delete
            System.out.println(grades[i]);
        }
    }
}