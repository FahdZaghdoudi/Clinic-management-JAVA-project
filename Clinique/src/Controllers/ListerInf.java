package Controllers;

import DBConn.Cnx;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.ModelTableInf;
import models.ModelTablePat;

public class ListerInf implements Initializable{
    @FXML
    private Button homeBtn;
    @FXML
    private Button ret;
    
    private Cnx conn;

    @FXML
    private TableView<models.ModelTableInf> tableInf;
    @FXML
    private TableColumn<models.ModelTableInf, Integer> col_id;
    @FXML
    private TableColumn<models.ModelTableInf, String> col_nom;
    @FXML
    private TableColumn<models.ModelTableInf, String> col_prenom;
    @FXML
    private TableColumn<models.ModelTableInf, Integer> col_age;
    @FXML
    private TableColumn<models.ModelTableInf, Integer> col_tel;
    @FXML
    private TableColumn<models.ModelTableInf, String> col_adr;
    @FXML
    private TableColumn<models.ModelTableInf, String> col_ser;
    
    ObservableList<models.ModelTableInf> oblistInf = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        
        try {
            conn = new Cnx();
            ResultSet rs = conn.DBcnx().createStatement().executeQuery
            ("SELECT id_inf, nom, prenom, age, tel, adresse, mdp, service FROM infirmier");
            
            while(rs.next())
            {
                oblistInf.add(new ModelTableInf(rs.getInt("id_inf"), rs.getString("nom"), rs.getString("prenom"), rs.getInt("age"), 
                                        rs.getInt("tel"), rs.getString("adresse"), rs.getString("service")));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ListerInf.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            col_id.setCellValueFactory(new PropertyValueFactory<>("id_inf"));
            col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
            col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
            col_adr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            col_ser.setCellValueFactory(new PropertyValueFactory<>("service"));

            tableInf.setItems(oblistInf);
            
    }
  
    @FXML
    private void interAdm(ActionEvent e) throws IOException
    {
        Stage gpat = new Stage();
        ret.getScene().getWindow().hide();
        Parent root2;
        root2 = FXMLLoader.load(getClass().getResource("/FXML/InterfAdm.fxml"));
        Scene scene = new Scene(root2);
        gpat.setScene(scene);
        gpat.show();
        gpat.setResizable(false);
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
