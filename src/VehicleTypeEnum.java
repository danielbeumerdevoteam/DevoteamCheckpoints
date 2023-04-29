public enum VehicleTypeEnum {
    CAR {
        public Vehicle buildNewVehicle(Automaker name, String model) {
            return new Car(name, model, CAR);
        }
    },
    MOTORCYCLE {
        public Vehicle buildNewVehicle(Automaker name, String model) {
            return new Motorcycle(name, model, MOTORCYCLE);
        }
    },
    VAN {
        public Vehicle buildNewVehicle(Automaker name, String model) {
            return new Van(name, model, VAN);
        }
    },
    TRUCK {
        public Vehicle buildNewVehicle(Automaker name, String model) {
            return new Truck(name, model, TRUCK);
        }
    },
    PICKUP {
        public Vehicle buildNewVehicle(Automaker name, String model) {
            return new Pickup(name, model, PICKUP);
        }
    },
    OTHERS {
        public Vehicle buildNewVehicle(Automaker name, String model) {
            return new Other(name, model, OTHERS);
        }
    }
}



