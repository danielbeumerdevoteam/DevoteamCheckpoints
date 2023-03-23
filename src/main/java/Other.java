public class Other extends Vehicle {

    public Other(Automaker automaker, String model, VehicleTypeEnum type) {
        super(automaker, model, type);
    }

    public Other (Automaker automaker, VehicleTypeEnum type){
        super(automaker, type);
    }

    @Override
    public VehicleTypeEnum getVehicleType() {
        return super.getVehicleType();
    }
}
