import java.util.ArrayList;
public class VehicleRepository {

    private ArrayList<Vehicle> vehicleList;
    private final VehicleService vehicleService;
    private Application application; 

    public VehicleRepository() {
        initializeVehicleList();
        this.vehicleService = new VehicleService(vehicleList, application);
    }

    private void initializeVehicleList() {
        int index = 0;
        vehicleList = new ArrayList<>(50);
        vehicleList.add(new Car(new Automaker("GM"), "Suburban", VehicleTypeEnum.CAR));
        vehicleList.add(new Car(new Automaker("GM"), "Malibu", VehicleTypeEnum.CAR));
        vehicleList.add(new Car(new Automaker("GM"), "Silverado", VehicleTypeEnum.CAR));
        vehicleList.add(new Car(new Automaker("Hyundai"), "Azera", VehicleTypeEnum.CAR));
        vehicleList.add(new Car(new Automaker("Hyundai"), "Sonata", VehicleTypeEnum.CAR));
        vehicleList.add(new Car(new Automaker("Hyundai"), "Veloster", VehicleTypeEnum.CAR));
        vehicleList.add(new Car(new Automaker("Volkswagen"), "Golf", VehicleTypeEnum.CAR));
        vehicleList.add(new Car(new Automaker("Volkswagen"), "Jetta", VehicleTypeEnum.CAR));
        vehicleList.add(new Car(new Automaker("Volkswagen"), "Polo", VehicleTypeEnum.CAR));
        vehicleList.add(new Car(new Automaker("Audi"), "A4", VehicleTypeEnum.CAR));
        vehicleList.add(new Car(new Automaker("Audi"), "Q7", VehicleTypeEnum.CAR));
        vehicleList.add(new Car(new Automaker("Audi"), "R8", VehicleTypeEnum.CAR));
        vehicleList.add(new Car(new Automaker("Mercedes"), "C 180", VehicleTypeEnum.CAR));
        vehicleList.add(new Car(new Automaker("Mercedes"), "C 200", VehicleTypeEnum.CAR));
        vehicleList.add(new Car(new Automaker("Mercedes"), "GLA 200", VehicleTypeEnum.CAR));
        vehicleList.add(new Car(new Automaker("Peugeot"), "206", VehicleTypeEnum.CAR));
        vehicleList.add(new Car(new Automaker("Peugeot"), "208", VehicleTypeEnum.CAR));
        vehicleList.add(new Car(new Automaker("Peugeot"), "2008", VehicleTypeEnum.CAR));
        vehicleList.add(new Motorcycle(new Automaker("BMW"), "Scrambler", VehicleTypeEnum.MOTORCYCLE));
        vehicleList.add(new Motorcycle(new Automaker("Yamaha"), "MT07", VehicleTypeEnum.MOTORCYCLE));
        vehicleList.add(new Motorcycle(new Automaker("Yamaha"), "XSR900", VehicleTypeEnum.MOTORCYCLE));
        vehicleList.add(new Van(new Automaker("Ford"), "Transit", VehicleTypeEnum.VAN));
        vehicleList.add(new Van(new Automaker("Mercedes"), "Sprinter", VehicleTypeEnum.VAN));
        vehicleList.add(new Pickup(new Automaker("RAM"), "1500", VehicleTypeEnum.PICKUP));
        vehicleList.add(new Other(new Automaker("Ford"), "3620 Tractor", VehicleTypeEnum.OTHERS));
    }

    public ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public ArrayList<Vehicle> createNewVehicle(int inputUser, Automaker automaker) {
        switch (inputUser) {
            case 1 -> vehicleService.addVehicle(new Car(automaker, VehicleTypeEnum.CAR));
            case 2 -> vehicleService.addVehicle(new Motorcycle(automaker, VehicleTypeEnum.MOTORCYCLE));
            case 3 -> vehicleService.addVehicle(new Van(automaker, VehicleTypeEnum.VAN));
            case 4 -> vehicleService.addVehicle(new Truck(automaker, VehicleTypeEnum.TRUCK));
            case 5 -> vehicleService.addVehicle(new Pickup(automaker, VehicleTypeEnum.PICKUP));
            case 6 -> vehicleService.addVehicle(new Other(automaker, VehicleTypeEnum.OTHERS));
            default -> throw new IllegalArgumentException("Invalid input");
        };
        return vehicleList;
    }


}