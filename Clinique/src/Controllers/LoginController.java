package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import DBConn.Cnx;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

public class LoginController implements Initializable{
    
    @FXML
    private TextField login;

    @FXML
    private PasswordField pswd;

    @FXML
    private Button homeBtn;
    
    @FXML
    private Button pat;
    
    @FXML
    private Button med;
    
    @FXML
    private Button adm;
    
    @FXML
    private Button inf;
    
    @FXML
    private Button admBtn;
    
    @FXML
    private Button infBtn;
    
    @FXML
    private Button medBtn;
    
    @FXML
    private Button patBtn;
    
    @FXML
    private ImageView logo;
    
    private Cnx conn;
    private PreparedStatement pst;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       conn = new Cnx();
    }
    
    
    @FXML
    public void loginActionAdm(ActionEvent e) throws IOException
    {
        //System.out.println("Connexion...");
        String q1 = "SELECT * FROM admin WHERE id_admin=? AND mdp=?";
        try {
            pst = conn.DBcnx().prepareStatement(q1);
            pst.setString(1, login.getText());
            pst.setString(2, pswd.getText());
            
            ResultSet rs = pst.executeQuery();
            int count = 0;
            while(rs.next())
            {
                count++;
            }
            
            if (count==1)
            {
                System.out.println("Connexion Admin avec succés");
                
                Stage logp = new Stage();
                admBtn.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/FXML/InterfAdm.fxml"));
                Scene scene = new Scene(rootA);
                logp.setScene(scene);
                logp.show();
                logp.setResizable(false);
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Veuillez vérifier votre Identifiant et votre Mot de passe !");
                alert.showAndWait();
            }
            
        } catch (SQLException ex) {
        }
        
        finally
        {
            try {
                conn.DBcnx().close();
            } catch (SQLException ex) {
            }
        }
    }
    
    @FXML
    public void loginActionInf(ActionEvent e) throws IOException
    {
        //System.out.println("Connexion...");
        String q1 = "SELECT * FROM infirmier WHERE id_inf=? AND mdp=?";
        try {
            pst = conn.DBcnx().prepareStatement(q1);
            pst.setString(1, login.getText());
            pst.setString(2, pswd.getText());
            
            ResultSet rs = pst.executeQuery();
            int count = 0;
            while(rs.next())
            {
                count++;
            }
            
            if (count==1)
            {
                System.out.println("Connexion Infirmier avec succés");
                
                Stage logp = new Stage();
                infBtn.getScene().getWindow().hide();
                Parent rootI;
                rootI = FXMLLoader.load(getClass().getResource("/FXML/InterfInf.fxml"));
                Scene scene = new Scene(rootI);
                logp.setScene(scene);
                logp.show();
                logp.setResizable(false);
            }    
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Veuillez vérifier votre Identifiant et votre Mot de passe !");
                alert.showAndWait();
            }
            
        } catch (SQLException ex) {
        }
        
        finally
        {
            try {
                conn.DBcnx().close();
            } catch (SQLException ex) {
            }
        }
    }
    
    @FXML
    public void loginActionMed(ActionEvent e) throws IOException
    {
        //System.out.println("Connexion...");
        String q1 = "SELECT * FROM medecin WHERE id_med=? AND mdp=?";
        try {
            pst = conn.DBcnx().prepareStatement(q1);
            pst.setString(1, login.getText());
            pst.setString(2, pswd.getText());
            
            ResultSet rs = pst.executeQuery();
            int count = 0;
            while(rs.next())
            {
                count++;
            }
            
            if (count==1)
            {
                System.out.println("Connexion Medecin avec succés");
                
                Stage logp = new Stage();
                medBtn.getScene().getWindow().hide();
                Parent rootM;
                rootM = FXMLLoader.load(getClass().getResource("/FXML/InterfMed.fxml"));
                Scene scene = new Scene(rootM);
                logp.setScene(scene);
                logp.show();
                logp.setResizable(false);
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Veuillez vérifier votre Identifiant et votre Mot de passe !");
                alert.showAndWait();
            }
            
        } catch (SQLException ex) {
        }
        
        finally
        {
            try {
                conn.DBcnx().close();
            } catch (SQLException ex) {
            }
        }
    }
    
    @FXML
    public void loginActionPat(ActionEvent e) throws IOException
    {
        //System.out.println("Connexion...");
        String q1 = "SELECT * FROM patient WHERE id_pat=? AND mdp=?";
        try {
            pst = conn.DBcnx().prepareStatement(q1);
            pst.setString(1, login.getText());
            pst.setString(2, pswd.getText());
            
            ResultSet rs = pst.executeQuery();
            int count = 0;
            while(rs.next())
            {
                count++;
            }
            
            if (count==1)
            {
                System.out.println("Connexion Patient avec succés");
                
                Stage logp = new Stage();
                patBtn.getScene().getWindow().hide();
                Parent rootP;
                rootP = FXMLLoader.load(getClass().getResource("/FXML/InterfPat.fxml"));
                Scene scene = new Scene(rootP);
                logp.setScene(scene);
                logp.show();
                logp.setResizable(false);
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Veuillez vérifier votre Identifiant et votre Mot de passe !");
                alert.showAndWait();
            }
            
        } catch (SQLException ex) {
        }
        
        finally
        {
            try {
                conn.DBcnx().close();
            } catch (SQLException ex) {
            }
        }
    }
    
    
     @FXML
    public void loginpat(ActionEvent e) throws IOException
    {
        Stage logp = new Stage();
        pat.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/LoginPat.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }
    
    @FXML
    public void loginAdm(ActionEvent e) throws IOException
    {
        Stage logp = new Stage();
        adm.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/LoginAdm.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }
    
    @FXML
    public void loginMed(ActionEvent e) throws IOException
    {
        Stage logp = new Stage();
        med.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/LoginMed.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }
    
    @FXML
    public void loginInf(ActionEvent e) throws IOException
    {
        Stage logp = new Stage();
        inf.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/LoginInf.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }
    
    
    @FXML
    public void homee(ActionEvent e) throws IOException
    {
        Stage hm = new Stage();
        homeBtn.getScene().getWindow().hide();
        Parent root1;
        root1 = FXMLLoader.load(getClass().getResource("/FXML/home.fxml"));
        Scene scene = new Scene(root1);
        hm.setScene(scene);
        hm.show();
        hm.setResizable(false);
    }
}
