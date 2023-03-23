import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleService{
    private Automaker automaker;
    private List<Vehicle> vehicleList;
    private final Application application;

    public VehicleService(List<Vehicle> vehicleList, Application application) {
        this.vehicleList = vehicleList;
        this.application = new Application();
        this.automaker = automaker;
    }

    public List <Vehicle> searchByAutomaker(String automaker) {
        return vehicleList.stream()
                .filter(vehicleList -> vehicleList.getName().equals(automaker))
                .collect(Collectors.toList());
    }

    public Vehicle searchByModel(String model) {
        return vehicleList.stream()
                .filter(vehicleList -> vehicleList.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public List<Vehicle> addVehicle(Vehicle addVehicle) {
                vehicleList.add(addVehicle);
                System.out.println("Vehicle " + addVehicle.getName() + ", " + addVehicle.getType() + " added.");
                application.printModelRequest();
                addVehicle.setModel(application.readString());
                return vehicleList;
        }

    public List<Vehicle> updateVehicle(Vehicle oldVehicle, String newAutomaker, String newModel) {
        boolean isUpdated = vehicleList.stream()
                .filter(vehicle -> vehicle.getModel().equals(oldVehicle.getModel()))
                .findFirst()
                .map(vehicle -> { vehicle.setModel(newModel); vehicle.setName(newAutomaker); return true; })
                .orElse(false);

        System.out.println(isUpdated ? "Vehicle " + oldVehicle.getModel() + " updated." : "Vehicle not found, database not updated.");
        return vehicleList;
    }

    public List<Vehicle> deleteVehicle(Vehicle deleteVehicle) {

        boolean isDeleted = vehicleList.removeIf(vehicle -> vehicle.getModel().equals(deleteVehicle.getModel()));
        System.out.println(isDeleted ? "Vehicle " + deleteVehicle.getModel() + " deleted." : "Vehicle not found, no vehicle is deleted.");
        return vehicleList;
    }

    public void searchByType(String type) {
        vehicleList.stream()
                .filter(vehicle -> vehicle.getVehicleType().name().equals(type))
                .forEach(vehicle -> System.out.println(vehicle.getModel()));
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