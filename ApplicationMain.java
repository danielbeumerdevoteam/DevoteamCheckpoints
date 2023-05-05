import java.util.List;
public class ApplicationMain {
    public static void main(String[] args) {
        Application application = new Application();
        VehicleRepository repository = new VehicleRepository();
        List <Vehicle> repositoryArray = repository.getVehicleList();
        AutomakerRepository automakerRepository = new AutomakerRepository();
        AutomakerService automakerService = new AutomakerService(automakerRepository);
        VehicleService vehicleService = new VehicleService(repositoryArray, application, automakerService, automakerRepository);
        int inputUser;
        //check

        do {
            application.printOpeningMenu();
            inputUser = application.readInteger();
             if (inputUser == 1) {
                 application.printAutomakerRequest();
                 automakerService.searchByName(application.readString());
                 inputUser = application.requestTerminate();
             }
             else if(inputUser == 2) {
                    application.printModelRequest();
                    Vehicle searchModel = repository.findByModel(application.readString());
                 if (searchModel != null) {
                     System.out.println(searchModel.getAutomaker());
                     inputUser = application.requestTerminate();
                 } else {
                     System.out.println("Model not found in database.");
                     inputUser = application.requestTerminate();
                 }
            } else if (inputUser == 3) {
                 Vehicle newVehicle = null;
                 do {
                     application.printAutomakerRequest();
                     String automaker = application.readString();
                     application.printVehicleTypeRequest();
                     String type = application.readString();
                     application.printModelRequest();
                     String model = application.readString();
                     newVehicle = repository.createNewVehicleFromDatabase(type, automaker, model);
                 } while(newVehicle == null);
                int autoID = automakerRepository.saveAutomaker(newVehicle.getAutomaker());
                repository.saveVehicle(newVehicle, autoID);
                 inputUser = application.requestTerminate();
                }
            else if (inputUser == 4 ){
                 System.out.println("Enter the model you want to replace");
                Vehicle oldVehicle = vehicleService.searchByModel(application.readString(),repository);

                 System.out.println("Enter the new model name");
                String newModel = application.readString();

                 System.out.println("Enter the new automaker name:");
                String newAutomaker = application.readString();

                repository.replaceVehicle(oldVehicle, newAutomaker, newModel);
                inputUser = application.requestTerminate();
                }
            else if(inputUser == 5) {
                 application.printModelRequest();
                 Vehicle deleteModel = vehicleService.searchByModel(application.readString(),repository);
                 vehicleService.deleteVehicle(deleteModel,repository);
                 inputUser = application.requestTerminate();
             }

            else if (inputUser == 6){
                 List<Vehicle> databaseListVehicles = repository.findAll();
                 vehicleService.generateReportFile(databaseListVehicles);
                 inputUser = application.requestTerminate();
             }
            else if (inputUser == 7){
                 System.out.println("Enter the new automaker name:");
                 automakerService.addAutomaker(application.readString());
                 inputUser = application.requestTerminate();
             }
        } while (inputUser != 0);
        application.printApplicationEnded();
    }
}