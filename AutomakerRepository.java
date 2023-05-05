import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.ConnectionFactory;

public class AutomakerRepository {
    public int findAutomakerIDIfExistentElseReturnZero(String automakerName) {
        int autoID = 0;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement findAutomakerID = conn.prepareStatement("SELECT ID  FROM car_database.automakers WHERE automakers = ?"))
        {
            findAutomakerID.setString(1, automakerName);
            ResultSet rs = findAutomakerID.executeQuery();
            if (rs.next()) {
                autoID = rs.getInt("ID");
                return autoID;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autoID;
    }

    public int saveAutomaker(String automakerName) {
        int autoID = findAutomakerIDIfExistentElseReturnZero(automakerName);
        if (autoID == 0) {
            try (Connection conn = ConnectionFactory.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("INSERT INTO car_database.automakers (Automakers, ID) VALUES (?, ?)")) {
                ResultSet rs = stmt.executeQuery("SELECT MAX(ID) AS ID FROM car_database.automakers");
                if (rs.next()) {
                    autoID = rs.getInt("ID") + 1;
                }
                stmt.setString(1, automakerName);
                stmt.setInt(2, autoID);
                System.out.println("Automaker "+ automakerName + " added to database");
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
                }
            return autoID;
        }
        else {
            System.out.println("Automaker name already saved in database");
            return autoID;
        }
    }
}
