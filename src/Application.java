import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.Scanner;

public class Application {

    public void printOpeningMenu(){
        System.out.println("5. - Delete vehicle.");
        System.out.println("4. - Update vehicle.");
        System.out.println("3. - Add vehicle.");
        System.out.println("2. - Search by model.");
        System.out.println("1. - Search by automaker.");
        System.out.println("0. - Exit.");
    }
    public int readInteger(){
        Scanner scannerObject = new Scanner(System.in);
        String inputString = scannerObject.nextLine();
        int invalidInteger = 0;
        int inputUser=0;

        do {
            try {
                inputUser = Integer.parseInt(inputString);
                invalidInteger = 0;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, enter a number.");
                invalidInteger = 1;
            }
        } while (invalidInteger != 0);
        return inputUser;
    }
    public void printAutomakerRequest(){
        System.out.println("Enter the name of the automaker:");
    }

    public String readString(){
        Scanner scannerObject = new Scanner(System.in);
        String inputString = scannerObject.nextLine();
        return inputString;
    }
    public void printArray(String[] array)
    {
        for (String modelIndex: array) {
            System.out.println(modelIndex);
        }
    }
    public void printApplicationEnded(){
        System.out.println("Program ended");
    }
    public void printModelRequest(){
        System.out.println("Enter the name of the model:");
    }
    public int requestTerminate() {
        Scanner scannerObject = new Scanner(System.in);
        int invalidInteger = 0;
        int inputUser = 0;

        do {
            System.out.println("Do you want to continue?");
            System.out.println("1. - Yes");
            System.out.println("2. - No");
            String inputString = scannerObject.nextLine();

            try {
                inputUser = Integer.parseInt(inputString);
            } catch (NumberFormatException e) {
                // System.out.println("Invalid input, enter a number.");
                }
            if (inputUser == 1) {
                return inputUser = 10;
            }    else if (inputUser == 2) {
                    return inputUser = 0;
                }
                    else {
                        System.out.println("Invalid input.");
                    }
        } while (inputUser!= 1 || inputUser!= 2);
        return inputUser;
    }
}
