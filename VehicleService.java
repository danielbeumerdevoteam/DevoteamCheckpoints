import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleService{
    private Automaker automaker;
    private List<Vehicle> vehicleList;
    private final Application application;
    private AutomakerService automakerService;

    public VehicleService(List<Vehicle> vehicleList, Application application, AutomakerService automakerService, AutomakerRepository automakerRepository) {
        this.vehicleList = vehicleList;
        this.application = new Application();
        this.automaker = automaker;
        this.automakerService = new AutomakerService(automakerRepository);
    }

     public void searchByAutomaker(String automaker, VehicleRepository vehicleRepository) {
        vehicleRepository.findByAutomaker(automaker);
    }


    public Vehicle searchByModel(String model, VehicleRepository vehicleRepository) {
        return vehicleRepository.findByModel(model);
    }


    public void deleteVehicle(Vehicle deleteVehicle, VehicleRepository vehicleRepository) {
        if (deleteVehicle != null) {
            vehicleRepository.removeVehicleByModel(deleteVehicle.getModel());
        } else {
            System.out.println("Model not found in database");
        }
    }

    public void generateReportFile(List <Vehicle> vehicleList) {
        try {
            FileWriter writer = new FileWriter("report.txt");
            for (Vehicle vehicle : vehicleList) {
                    writer.write("#-------------------------------------------------------------------#\n");
                    writer.write("Registration Date: " + vehicle.generateRandomCreatedAt().format(DateTimeFormatter.ofPattern("MMM d, yyyy, h:mm:ss a")) + "\n");
                    writer.write("Automaker: " + vehicle.getName() + "\n");
                    writer.write("Model: " + vehicle.getModel() + "\n");
                    writer.write("Type: " + vehicle.getType().toString() + "\n");
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