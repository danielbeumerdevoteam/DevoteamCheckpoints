import java.util.Scanner;
public class VehicleRepository {

    private Vehicle[] arrayVehicles;
    private Automaker automaker;

    public VehicleRepository() {
        initializeVehicleArray();
    }

    private Vehicle[] initializeVehicleArray() {

        Automaker gm = new Automaker("GM");
        Automaker hyundai = new Automaker("Hyundai");
        Automaker volkswagen = new Automaker("Volkswagen");
        Automaker audi = new Automaker("Audi");
        Automaker mercedes = new Automaker("Mercedes");
        Automaker peugeot = new Automaker("Peugeot");
        Automaker empty = new Automaker("Empty");

            arrayVehicles = new Vehicle[100];
            arrayVehicles[0] = new Vehicle(gm.getName(), "Suburban");
            arrayVehicles[1]= new Vehicle(gm.getName(), "Malibu");
            arrayVehicles[2] = new Vehicle(gm.getName(), "Silverado");
            arrayVehicles[3] = new Vehicle(hyundai.getName(), "Azera");
            arrayVehicles[4] = new Vehicle(hyundai.getName(), "Sonata");
            arrayVehicles[5] = new Vehicle(hyundai.getName(), "Veloster");
            arrayVehicles[6] = new Vehicle(volkswagen.getName(), "Golf");
            arrayVehicles[7] = new Vehicle(volkswagen.getName(), "Jetta");
            arrayVehicles[8] = new Vehicle(volkswagen.getName(), "Polo");
            arrayVehicles[9] = new Vehicle(audi.getName(), "A4");
            arrayVehicles[10] = new Vehicle(audi.getName(), "Q7");
            arrayVehicles[11] = new Vehicle(audi.getName(), "R8");
            arrayVehicles[12] = new Vehicle(mercedes.getName(), "C 180");
            arrayVehicles[13] = new Vehicle(mercedes.getName(), "C 200");
            arrayVehicles[14] = new Vehicle(mercedes.getName(), "GLA 200");
            arrayVehicles[15] = new Vehicle(peugeot.getName(), "206");
            arrayVehicles[16] = new Vehicle(peugeot.getName(), "208");
            arrayVehicles[17] = new Vehicle(peugeot.getName(), "2008");
            for (int index = 18; index <100; index++){
                arrayVehicles[index] = new Vehicle(empty.getName(), "Empty");
            }
        return arrayVehicles;
    }
    public void setArrayVehicles(Vehicle[] arrayVehicles) {
        this.arrayVehicles = arrayVehicles;
    }
    public Vehicle[] getArrayVehicles() {
       return arrayVehicles;
    }

}

