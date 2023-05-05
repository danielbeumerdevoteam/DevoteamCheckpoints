import java.util.ArrayList;
import Connection.ConnectionFactory;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class VehicleRepository {
    private ArrayList<Vehicle> vehicleList;
    private final VehicleService vehicleService;
    private Application application;
    private AutomakerService automakerService;
    private AutomakerRepository automakerRepository;
    public VehicleRepository() {
        this.vehicleService = new VehicleService(vehicleList, application, automakerService, automakerRepository);
    }
    public void findByAutomaker (String automaker){
        String name;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT model FROM car_database.vehicles WHERE automaker = ?"))
        {
             stmt.setString(1, automaker);
             ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                name = rs.getString("model");
                System.out.println(name);
            }
    } catch (SQLException e){
        e.printStackTrace();
        }
    }

    public void saveVehicle(Vehicle newVehicle, int autoID){
        int maxVehiclesId = 0;
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO car_database.vehicles SET model =?, automakers_ID =?, type =?, vehicles_ID = ?"))
        {   ResultSet rs = stmt.executeQuery("SELECT MAX(Vehicles_ID) FROM car_database.vehicles");
            if(rs.next()) {
                maxVehiclesId = rs.getInt(1);
            }
            stmt.setString(1, newVehicle.getModel());
            stmt.setInt(2, autoID);
            stmt.setString(3, newVehicle.getType().toString());
            stmt.setInt(4, maxVehiclesId +1);
            stmt.executeUpdate();
            System.out.println(newVehicle.getModel() + " " + newVehicle.getAutomaker()  + " added to the database");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Vehicle> findAll() {
        String model;
        String automaker;
        String type;
        List<Vehicle> vehicleList = new ArrayList<>(100);
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement
                     ("SELECT * FROM car_database.vehicles JOIN car_database.automakers ON vehicles.automakers_ID = automakers.ID")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model = rs.getString("vehicles.model");
                automaker = rs.getString("automakers.automakers");
                type = rs.getString("vehicles.type");
                vehicleList.add(createNewVehicleFromDatabase(type, automaker, model));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicleList;
    }

    public void replaceVehicle(Vehicle oldVehicle, String newAutomaker, String newModel) {
        if (oldVehicle == null) {
            System.out.println("Model not found in database");
            return;
        }
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement selectStmt = conn.prepareStatement(
                     "SELECT automakers_ID FROM car_database.vehicles WHERE model = ?");
             PreparedStatement updateAutomakerStmt = conn.prepareStatement(
                     "UPDATE car_database.automakers SET automakers = ? WHERE ID = ?");
             PreparedStatement updateVehicleStmt = conn.prepareStatement(
                     "UPDATE car_database.vehicles SET model = ? WHERE automakers_ID = ?")) {

            selectStmt.setString(1, oldVehicle.getModel());
            ResultSet rs = selectStmt.executeQuery();
            if (!rs.next()) {
                System.out.println("Model not found in database");
                return;
            }
            int automakerID = rs.getInt(1);
            updateAutomakerStmt.setString(1, newAutomaker);
            updateAutomakerStmt.setInt(2, automakerID);
            updateAutomakerStmt.executeUpdate();

            updateVehicleStmt.setString(1, newModel);
            updateVehicleStmt.setInt(2, automakerID);
            updateVehicleStmt.executeUpdate();

            System.out.println(newModel + " replaced for " + oldVehicle.getModel());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeVehicleByModel(String userInput) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM car_database.vehicles WHERE model = ?")) {
            stmt.setString(1, userInput);
            stmt.executeUpdate();
            System.out.println("Vehicle " + userInput + " in database is deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Vehicle findByModel(String model) {
        String type;
        String automakerName;
        Vehicle vehicle = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement
                     ("SELECT type, model, automakers FROM car_database.vehicles JOIN car_database.automakers " +
                             "ON vehicles.automakers_ID = automakers.ID WHERE model = ?"))
        {
            stmt.setString(1, model);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                type = rs.getString("type");
                automakerName = rs.getString("Automakers");
                vehicle = createNewVehicleFromDatabase(type, automakerName, model);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return vehicle;
    }

    public ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public Vehicle createNewVehicleFromDatabase(String type, String automaker, String model) {
        switch (type) {
            case "Car" : return (new Car(new Automaker(automaker), model, VehicleTypeEnum.CAR));
            case "Motorcycle" : return (new Motorcycle(new Automaker(automaker), model, VehicleTypeEnum.MOTORCYCLE));
            case "Van" : return (new Van(new Automaker(automaker), model, VehicleTypeEnum.VAN));
            case "Truck" : return (new Truck(new Automaker(automaker), model, VehicleTypeEnum.TRUCK));
            case "Pickup" : return (new Pickup(new Automaker(automaker), model, VehicleTypeEnum.PICKUP));
            case "Others" : return (new Other(new Automaker(automaker), model, VehicleTypeEnum.OTHERS));
            default : System.out.println("Invalid input"); return null;
        }
    }
}