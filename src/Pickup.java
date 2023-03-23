public class Pickup extends Vehicle {

    public Pickup(Automaker automaker, String model, VehicleTypeEnum type) {
        super(automaker, model, type);
    }

    public Pickup (Automaker automaker, VehicleTypeEnum type){
        super(automaker, type);
    }

    @Override
    public VehicleTypeEnum getVehicleType() {
        return super.getVehicleType();
    }
}
