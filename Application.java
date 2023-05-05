
import java.util.Scanner;
import java.util.List;
public class Application {

    public void printOpeningMenu(){
        System.out.println("7. - Add automaker.");
        System.out.println("6. - Generate report file.");
        System.out.println("5. - Delete vehicle.");
        System.out.println("4. - Replace vehicle.");
        System.out.println("3. - Add vehicle.");
        System.out.println("2. - Search by model.");
        System.out.println("1. - Search by automaker.");
        System.out.println("0. - Exit.");
    }
    public int readInteger(){
        Scanner scannerObject = new Scanner(System.in);
        int invalidInteger = 0;
        int inputUser=0;
        do {
            try {
                String inputString = scannerObject.nextLine();
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

    public void printApplicationEnded(){
        System.out.println("Program ended");
    }
    public void printModelRequest(){
        System.out.println("Enter the name of the model:");
    }
    public int requestTerminate() {
        Scanner scannerObject = new Scanner(System.in);
        int inputUser = 0;
        do {
            System.out.println("Do you want to continue?");
            System.out.println("1. - Yes");
            System.out.println("2. - No");
            try {
                String inputString = scannerObject.nextLine();
                inputUser = Integer.parseInt(inputString);
            } catch (NumberFormatException e) {
                 System.out.println("Invalid input, enter a number.");
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
    public void printVehicleTypeRequest(){
        System.out.println("Choose the vehicle type you want to add:");
        System.out.println("Car");
        System.out.println("Motorcycle");
        System.out.println("Van");
        System.out.println("Truck");
        System.out.println("Pickup");
        System.out.println("Other");
    }
    public void printTypeRequest(){
        System.out.println("Enter the name of the type:");
    }

}
