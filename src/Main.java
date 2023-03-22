public class Main {
    public static void main(String[] args) {
        Application application = new Application();
        VehicleRepository repository = new VehicleRepository();
        Vehicle[] repositoryArray = repository.getArrayVehicles();
        VehicleService vehicleService = new VehicleService(repositoryArray);

        int inputUser;
        String model;
        String automaker;
        do {
            application.printOpeningMenu();
            inputUser = application.readInteger();
             if (inputUser == 1) {
                application.printAutomakerRequest();
                String[] arrayModels = vehicleService.searchByAutomaker(application.readString());
                application.printArray(arrayModels);
                inputUser = application.requestTerminate();
            } else if (inputUser == 2) {
                application.printModelRequest();
                Vehicle searchModel = vehicleService.searchByModel(application.readString());
                if(searchModel != null) {
                    System.out.println(searchModel.getAutomaker());
                }
                    else {
                        System.out.println("Model not found in database.");
                        inputUser = application.requestTerminate();
                    }
            } else if (inputUser == 3) {
                application.printAutomakerRequest();
                automaker = application.readString();
                application.printModelRequest();
                model = application.readString();
                Vehicle newVehicle = new Vehicle(automaker, model);
                repositoryArray = vehicleService.addVehicle(newVehicle);
                inputUser = application.requestTerminate();
                }
            else if (inputUser == 4 ){
                application.printModelRequest();
                Vehicle oldVehicle = vehicleService.searchByModel(application.readString());
                application.printModelRequest();
                String newModel = application.readString();
                application.printAutomakerRequest();
                String newAutomaker = application.readString();
                Vehicle newVehicle = new Vehicle(newAutomaker, newModel);
                repositoryArray = vehicleService.updateVehicle(oldVehicle, newVehicle);
                inputUser = application.requestTerminate();
                }
            else if(inputUser == 5){
                application.printModelRequest();
                Vehicle deleteModel = vehicleService.searchByModel(application.readString());
                repositoryArray = vehicleService.deleteVehicle(deleteModel);
                inputUser = application.requestTerminate();
            }
        } while (inputUser != 0);
        application.printApplicationEnded();
    }
}