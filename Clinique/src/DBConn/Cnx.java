package DBConn;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cnx {
    
    public Connection DBcnx()
    {
        try 
        {
            String url="jdbc:mysql://localhost/gestionclinique";
            String username="root";
            String password=""; 
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection(url, username, password);
            //System.out.println("Connexion avec Succès !");
            return (Connection) conn;
        } 
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connexion échouée !");
            Logger.getLogger(Cnx.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    //static Statement statement = null;
    //PreparedStatement pst;
    //DbConnection cnx = DbConnection.getInstance();
    //java.sql.Connection connection = cnx.getConnection();
    
}
