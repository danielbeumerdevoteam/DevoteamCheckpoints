public class Van extends Vehicle {

    public Van(Automaker automaker, String model, VehicleTypeEnum type) {
        super(automaker, model, type);
    }

    public Van (Automaker automaker, VehicleTypeEnum type){
        super(automaker, type);
    }

    @Override
    public VehicleTypeEnum getVehicleType() {
        return super.getVehicleType();
    }
}
