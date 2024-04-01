package myclass.testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnector {
    
    protected Connection con01 = null;
    private String URL = "jdbc:mysql://localhost:3306/project_database";
    protected Statement ST = null;
    private ResultSet RST = null; 
    
    
    public void connn() throws SQLException{
        
        try {
            
            con01 = DriverManager.getConnection(URL,"root","");
            System.out.println("con complete");
        
            }
        catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
     
    }
    
    public boolean Execute(String a) throws SQLException{
        
        try {
            
            connn();
            Statement ST = con01.createStatement();
            ST.execute(a);
            System.out.println("Execute complete");
            return true;
          
            
            }
            catch(SQLException ex)
                {
        
                ex.printStackTrace();
                return false;
        
                }finally{
            dis123();
        }
       
    }
        
    public void dis123() throws SQLException{        
        
        try{
            
            con01.close();
            System.out.println("dis complete");
            
            }
            catch(SQLException ex) 
                {
            
            
                }
        
    }
    
    public ResultSet Getresultset(String B) throws SQLException{

        try{
            
            connn();
            ST = con01.createStatement();
            RST = ST.executeQuery(B);
            System.out.println("Getresultset complete");
            
            
            }
            catch(SQLException ex)
                {
            
            RST = null;
            
                }
                return RST;

    
      
    }
}

