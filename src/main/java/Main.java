import java.util.List;
public class Main {
    public static void main(String[] args) {
        Application application = new Application();
        VehicleRepository repository = new VehicleRepository();
        List <Vehicle> repositoryArray = repository.getVehicleList();
        VehicleService vehicleService = new VehicleService(repositoryArray, application);
        int inputUser;

        do {
            application.printOpeningMenu();
            inputUser = application.readInteger();
             if (inputUser == 1) {
                 application.printAutomakerRequest();
                 List<Vehicle> arrayModels = vehicleService.searchByAutomaker(application.readString());
                 application.printArrayModels(arrayModels);
                 inputUser = application.requestTerminate();
             }
                else if(inputUser == 2) {
                    application.printModelRequest();
                    Vehicle searchModel = vehicleService.searchByModel(application.readString());
                 if (searchModel != null) {
                     System.out.println(searchModel.getAutomaker());
                     inputUser = application.requestTerminate();
                 } else {
                     System.out.println("Model not found in database.");
                     inputUser = application.requestTerminate();
                 }
            } else if (inputUser == 3) {
                application.printAutomakerRequest();
                Automaker automaker = new Automaker(application.readString());
                application.printVehicleTypeRequest();
                inputUser = application.readInteger();
                repositoryArray = repository.createNewVehicle(inputUser, automaker);
                inputUser = application.requestTerminate();
                }
            else if (inputUser == 4 ){

                application.printModelRequest();
                Vehicle oldVehicle = vehicleService.searchByModel(application.readString());

                application.printModelRequest();
                String newModel = application.readString();

                application.printAutomakerRequest();
                String newAutomaker = application.readString();

                repositoryArray = vehicleService.updateVehicle(oldVehicle, newAutomaker, newModel);
                inputUser = application.requestTerminate();
                }
            else if(inputUser == 5) {
                 application.printModelRequest();
                 Vehicle deleteModel = vehicleService.searchByModel(application.readString());
                 repositoryArray = vehicleService.deleteVehicle(deleteModel);
                 inputUser = application.requestTerminate();
             }
                else if(inputUser == 6){
                     application.printTypeRequest();
                     vehicleService.searchByType(application.readString());
                     //application.printArrayModels(arrayModels);
                     inputUser = application.requestTerminate();
                 }
                else if (inputUser== 7){
                    vehicleService.generateReportFile();
                    inputUser = application.requestTerminate();
             }
        } while (inputUser != 0);
        application.printApplicationEnded();
    }
}