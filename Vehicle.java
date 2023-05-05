import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Random;

public abstract class Vehicle extends Automaker implements VehicleType {
    private final String id;
    private String color;
    private int year;
    private String model;
    private VehicleTypeEnum type;
    private final LocalDateTime createdAt;

    public Vehicle(Automaker automaker, String model, VehicleTypeEnum type) {
        super(automaker.getName());
        this.model = model;
        this.type = type;
        this.createdAt = generateRandomCreatedAt();
        this.id = generateRandomId();
    }

    public Vehicle(Automaker automaker, VehicleTypeEnum type) {
        super(automaker.getName());
        this.type = type;
        this.createdAt = generateRandomCreatedAt();
        this.id = generateRandomId();
    }

    public LocalDateTime generateRandomCreatedAt() {
        LocalDateTime now = LocalDateTime.now();
        Random random = new Random();
        int days = random.nextInt(365);
        int hours = random.nextInt(24);
        int minutes = random.nextInt(60);
        int seconds = random.nextInt(60);
        return now.minus(days, ChronoUnit.DAYS)
                .minus(hours, ChronoUnit.HOURS)
                .minus(minutes, ChronoUnit.MINUTES)
                .minus(seconds, ChronoUnit.SECONDS);
    }

    public String generateRandomId() {
        String randomStringID =  Integer.toHexString(new Random().nextInt());
        return randomStringID;
    }

    public boolean equals(Object comparedObject) {
        if (this == comparedObject) return true;
        if (!(comparedObject instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) comparedObject;
        return Objects.equals(id, vehicle.id);
    }

    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
        return "ID is: " + id + ".\n" +
                "Color is: " + color + ".\n" +
                "Year is: " + year + ".\n" +
                "Automaker is: " + name + ".\n" +
                "Model is: " + model + ".\n" +
                "Vehicle type is: " + getVehicleType() + ".\n" +
                "Created at: " + createdAt + ".";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAutomaker() {
        return name;
    }

    public Enum getType() {
        return type;
    }

    public VehicleTypeEnum getVehicleType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}