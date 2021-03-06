package ucf.assignment1.ex17;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 first_name last_name
 *
Exercise 17 - Blood Alcohol Calculator
Sometimes you have to perform a more complex calculation based on some provided inputs and
then use that result to make a determination.
Create a program that prompts for your weight, gender, total alcohol consumed (in ounces), and the amount of time
since your last drink. Calculate your blood alcohol content (BAC) using this formula

BAC = (A × 5.14 / W × r) − .015 × H

where
    A is total alcohol consumed, in ounces (oz).
    W is body weight in pounds.
    r is the alcohol distribution ratio:
        0.73 for men
        0.66 for women
    H is number of hours since the last drink.

Display whether or not it’s legal to drive by comparing the blood alcohol content to 0.08.

Example Output
Your BAC is 0.08
It is not legal for you to drive.

Constraint
Prevent the user from entering non-numeric values.

Challenges
Handle metric units.
Look up the legal BAC limit by state and prompt for the state. Display a message that states whether or
not it’s legal to drive based on the computed BAC.
Develop this as a mobile application that makes it easy to record each drink, updating the BAC each time a drink is entered.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex17 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double W = 0; // body weight
        double A = 0; // alcohol consumed
        double r = 0; // distribution ratio. Varies for men and women
        double H = 0; // hours since last drink
        String gender;

        // Preventing user from entering non-numeric values
        while (true){
            System.out.print("Enter Weight (in pounds): ");
            try{
                W = input.nextDouble();
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Try again!");
                input.next();
                continue;
            }
            break;
        }

        while (true){
            System.out.print("Enter Total of alcohol consumed (in ounces): ");
            try{
                A = input.nextDouble();
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Try again!");
                input.next();
                continue;
            }
            break;
        }

        while (true){
            System.out.print("Enter Amount of time since your last drink (hours): ");
            try{
                H = input.nextDouble();
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Try again!");
                input.next();
                continue;
            }
            break;
        }

        while(true){
            System.out.print("Enter gender (men / women): ");
            gender = input.next();
            if(!gender.equalsIgnoreCase("men") && !gender.equalsIgnoreCase("women")){
                System.out.println("Invalid input. Try again!");
/*                input.next();*/
                continue;
            }
            break;
        }

        // Calculation
        if(gender.equalsIgnoreCase("men"))
            r = 0.73;
        else // women
            r = 0.66;

        double BAC = (A * 5.14 / W * r) - (0.015 * H);
        System.out.printf("Your BCA is %.2f\n", BAC);

        String output;
        output = (BAC >= 0.08) ? "It is not legal for you to drive."
                               : "You can drive.";
        System.out.println(output);

    }
}
