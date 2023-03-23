import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class VehicleService{
    private VehicleRepository vehicleRepository;
    private Automaker automaker;
    private Vehicle model;
    private ArrayList<Vehicle> vehicleList;
    private final Application application;

    public VehicleService(ArrayList<Vehicle> vehicleList, Application application) {
        this.vehicleList = vehicleList;
        this.application = new Application();
        this.automaker = automaker;
    }

    public String[] searchByAutomaker(String automaker) {
        return vehicleList.stream()
                .filter(vehicle -> vehicle.getName().equals(automaker))
                .map(Vehicle::getModel)
                .toArray(String[]::new);
    }

    public Vehicle searchByModel(String model) {
        return vehicleList.stream()
                .filter(vehicle -> vehicle.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public ArrayList<Vehicle> addVehicle(Vehicle addVehicle) {
                vehicleList.add(addVehicle);
                System.out.println("Vehicle " + addVehicle.getName() + ", " + addVehicle.getType() + " added.");
                application.printModelRequest();
                String setModel = application.readString();
                addVehicle.setModel(setModel);
                return vehicleList;
        }

    public ArrayList<Vehicle> updateVehicle(Vehicle oldVehicle, String newAutomaker, String newModel) {
        for (int index = 0; index < vehicleList.size(); index++) {
            if(vehicleList.get(index).getModel().equals(oldVehicle.getModel())) {
                oldVehicle.setModel(newModel);
                oldVehicle.setName(newAutomaker);
                vehicleList.set(index, oldVehicle);
                return vehicleList;
            }
        }
        System.out.println("Vehicle not found, database not updated.");
        return vehicleList;
    }

    public ArrayList<Vehicle> deleteVehicle(Vehicle deleteVehicle) {
        for (int index = 0; index < vehicleList.size(); index++) {
            if (vehicleList.get(index).getModel().equals(deleteVehicle.getModel())) {
                System.out.println("Vehicle " + deleteVehicle.getModel() + " deleted.");
                vehicleList.remove(index);
                //vehicleList.get(index).setModel("Empty");
                //vehicleList.get(index).setName("Empty");
                return vehicleList;
            }
        }
        System.out.println("Vehicle not found, no vehicle is deleted.");
        return vehicleList;
    }

    public void searchByType(String type) {
        for (Vehicle typeVehicles : vehicleList) {
            if (typeVehicles.getType() == VehicleTypeEnum.valueOf(type)) {
                System.out.println(typeVehicles.getModel());
            }
        }
    }
    public void generateReportFile() {
        try {
            FileWriter writer = new FileWriter("report.txt");
            for (Vehicle vehicle : vehicleList) {
                    writer.write("#-------------------------------------------------------------------#\n");
                    writer.write("Registration Date: " + vehicle.generateRandomCreatedAt().format(DateTimeFormatter.ofPattern("MMM d, yyyy, h:mm:ss a")) + "\n");
                    writer.write("Automaker: " + vehicle.getName() + "\n");
                    writer.write("Model: " + vehicle.getModel() + "\n");
                    writer.write("Type: " + vehicle.getType() + "\n");
                    writer.write("Color: " + vehicle.getColor() + "\n");
                    writer.write("Year: " + vehicle.getYear() + "\n");
            }
            System.out.println("File report is successfully generated.");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }

}