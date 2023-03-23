
public class VehicleService {
    private VehicleRepository vehicleRepository;
    private String automaker;
    private Vehicle model;
    private final Vehicle[] arrayVehicles;

    public VehicleService(Vehicle[] arrayVehicles) {
        this.arrayVehicles = arrayVehicles;
    }

    public String[] searchByAutomaker(String automaker) {
        int strLenght = 0;
        String empty = "Empty";
        for (Vehicle autoMakers : arrayVehicles) {
            if (automaker.equals(autoMakers.getAutomaker()) && (!empty.equals(autoMakers.getModel()))) {
                strLenght++;
            }
        }
        String[] arrayModel = new String[strLenght];
        int counter = 0;
        int foundModel = 0;
        for (Vehicle index : arrayVehicles) {
            if (automaker.equals(index.getAutomaker()) && (!empty.equals(index.getModel())) ) {
                arrayModel[foundModel] = arrayVehicles[counter].getModel();
                foundModel++;
            }
            counter++;
        }
        return arrayModel;
    }

    public Vehicle searchByModel(String model) {
        for (Vehicle modelCount : arrayVehicles) {
            if (model.equals(modelCount.getModel())) {
                return modelCount;
            }
        }
        return null;
    }

    public Vehicle[] addVehicle(Vehicle addVehicle) {
        for (int index = 0; index < 100; index++) {
            if (arrayVehicles[index].getAutomaker().equals("Empty")) {
                arrayVehicles[index] = addVehicle;
                System.out.println("Vehicle " + arrayVehicles[index].getModel() + " added.");
                return arrayVehicles;
            }
        }
        System.out.println("Database is full. Delete a vehicle first.");
        return arrayVehicles;
    }

    public Vehicle[] updateVehicle(Vehicle oldVehicle, Vehicle newVehicle) {
        for (int index = 0; index < 100; index++) {
            if (arrayVehicles[index].getModel().equals(oldVehicle.getModel())) {
                arrayVehicles[index] = newVehicle;
                return arrayVehicles;
            }
        }
        System.out.println("Vehicle not found, database not updated.");
        return arrayVehicles;
    }

    public Vehicle[] deleteVehicle(Vehicle deleteVehicle) {
        for (int index = 0; index < 100; index++) {
            if (arrayVehicles[index].getModel().equals(deleteVehicle.getModel())) {
                System.out.println("Vehicle " + deleteVehicle.getModel() + " deleted.");
                arrayVehicles[index].setModel("Empty");
                arrayVehicles[index].setName("Empty");
                return arrayVehicles;
            }
        }
        System.out.println("Vehicle not found, no vehicle is deleted.");
        return arrayVehicles;
    }
}