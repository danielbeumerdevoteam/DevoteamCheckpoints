public class Car extends Vehicle {

    public Car(Automaker automaker, String model, VehicleTypeEnum type) {

        super(automaker, model, type);
    }

    public Car (Automaker automaker, VehicleTypeEnum type){

        super(automaker, type);
    }

    @Override
    public VehicleTypeEnum getVehicleType() {
        return super.getVehicleType();
    }
}
