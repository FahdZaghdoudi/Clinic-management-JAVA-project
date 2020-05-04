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
import models.ModelTableMed;

public class ListerMed implements Initializable{
    @FXML
    private Button homeBtn;
    @FXML
    private Button ret;
    
    private Cnx conn;

    @FXML
    private TableView<models.ModelTableMed> tableMed;
    @FXML
    private TableColumn<models.ModelTableMed, Integer> col_id;
    @FXML
    private TableColumn<models.ModelTableMed, String> col_nom;
    @FXML
    private TableColumn<models.ModelTableMed, String> col_prenom;
    @FXML
    private TableColumn<models.ModelTableMed, Integer> col_age;
    @FXML
    private TableColumn<models.ModelTableMed, Integer> col_tel;
    @FXML
    private TableColumn<models.ModelTableMed, String> col_adr;
    @FXML
    private TableColumn<models.ModelTableMed, String> col_spec;
    
    ObservableList<models.ModelTableMed> oblistMed = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        
        try {
            conn = new Cnx();
            ResultSet rs = conn.DBcnx().createStatement().executeQuery
            ("SELECT id_med, nom, prenom, age, tel, adresse, specialite FROM medecin");
            
            while(rs.next())
            {
                oblistMed.add(new ModelTableMed(rs.getInt("id_med"), rs.getString("nom"), rs.getString("prenom"), rs.getInt("age"), 
                                        rs.getInt("tel"), rs.getString("adresse"), rs.getString("specialite")));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ListerMed.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            col_id.setCellValueFactory(new PropertyValueFactory<>("id_med"));
            col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
            col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
            col_adr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            col_spec.setCellValueFactory(new PropertyValueFactory<>("specialite"));

            tableMed.setItems(oblistMed);
            
    }
  
    @FXML
    private void interAdm(ActionEvent e) throws IOException
    {
        Stage gadm = new Stage();
        ret.getScene().getWindow().hide();
        Parent root2;
        root2 = FXMLLoader.load(getClass().getResource("/FXML/InterfAdm.fxml"));
        Scene scene = new Scene(root2);
        gadm.setScene(scene);
        gadm.show();
        gadm.setResizable(false);
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
