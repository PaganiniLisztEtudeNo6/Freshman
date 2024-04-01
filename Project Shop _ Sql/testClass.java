package myclass.testdb;

import java.sql.ResultSet;
import java.sql.SQLException;

public class testClass {
    public static void main(String args[]) {
        try {
            DbConnector db = new DbConnector();
            ResultSet rs = db.Getresultset("select * from `employee`");
            while (rs.next()) {
                String text = rs.getString(2) + " " + rs.getString(10);
                System.out.println(text);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}