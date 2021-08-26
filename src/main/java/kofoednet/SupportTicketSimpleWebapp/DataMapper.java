package kofoednet.SupportTicketSimpleWebapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;


public class DataMapper {

    public static Queue<String> waitinglistQueue() throws DatabaseException {
        Queue<String> waitinglistQueue = new LinkedList<>();
        try {
            Connection con = MYSQLConnector.connection();
            String SQL = "SELECT * FROM ticket";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                waitinglistQueue.add(name);
            }

        } catch (SQLException ex) {
            throw new DatabaseException(ex.getMessage());
        } catch (ClassNotFoundException e) {
        }
        return waitinglistQueue;
    }

}
