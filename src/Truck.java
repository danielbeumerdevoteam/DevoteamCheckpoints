public class Truck extends Vehicle {

    public Truck(Automaker automaker, String model, VehicleTypeEnum type) {
        super(automaker, model, type);
    }

    public Truck (Automaker automaker, VehicleTypeEnum type){
        super(automaker, type);
    }

    @Override
    public VehicleTypeEnum getVehicleType() {
        return super.getVehicleType();
    }
}
