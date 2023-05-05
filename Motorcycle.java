public class Motorcycle extends Vehicle {

    public Motorcycle(Automaker automaker, String model, VehicleTypeEnum type) {
        super(automaker, model, type);
    }

    public Motorcycle (Automaker automaker, VehicleTypeEnum type){
        super(automaker, type);
    }

    @Override
    public VehicleTypeEnum getVehicleType() {
        return super.getVehicleType();
    }
}
