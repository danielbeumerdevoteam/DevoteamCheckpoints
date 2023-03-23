
import java.util.Collection;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public void printOpeningMenu(){
        System.out.println("7. - Generate report file.");
        System.out.println("6. - Search by type.");
        System.out.println("5. - Delete vehicle.");
        System.out.println("4. - Update vehicle.");
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
    public void printArrayModels(List <Vehicle> array)
    {
        array.stream()
                .filter(a->!a.equals(null))
                .forEach(a-> System.out.println(a.getModel()));
        array.stream()
                .filter(a->a.equals(null))
                .peek(a-> System.out.println("No models found"));
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
        System.out.println("1. - "+VehicleTypeEnum.CAR);
        System.out.println("2. - "+VehicleTypeEnum.MOTORCYCLE);
        System.out.println("3. - "+VehicleTypeEnum.VAN);
        System.out.println("4. - "+VehicleTypeEnum.TRUCK);
        System.out.println("5. - "+VehicleTypeEnum.PICKUP);
        System.out.println("6. - "+VehicleTypeEnum.OTHERS);
    }
    public void printTypeRequest(){
        System.out.println("Enter the name of the type:");
    }

}
