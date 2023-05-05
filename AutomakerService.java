import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.ConnectionFactory;
public class AutomakerService {
    private AutomakerRepository automakerRepository;

    public AutomakerService(AutomakerRepository automakerRepository){
        this.automakerRepository = automakerRepository;
    }

    public void searchByName(String name){
        String modelName = null;
        int autoID = automakerRepository.findAutomakerIDIfExistentElseReturnZero(name);
        if(autoID ==0){
            System.out.println("Automaker name not found in database");
            return;
        }
        try(Connection conn = ConnectionFactory.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT model FROM car_database.vehicles WHERE Automakers_ID = ? "))
        {
            stmt.setInt(1,autoID);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                modelName = rs.getString(1);
                System.out.println(modelName);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    public void addAutomaker(String name){
        automakerRepository.saveAutomaker(name);
    }
}


