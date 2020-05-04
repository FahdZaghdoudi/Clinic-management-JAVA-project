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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.ModelTableChm;
import models.ModelTablePat;

public class ListerChm implements Initializable{
    @FXML
    private Button homeBtn;
    @FXML
    private Button ret;
    
    private Cnx conn;

    @FXML
    private TableView<models.ModelTableChm> tableChm;
    @FXML
    private TableColumn<models.ModelTableChm, Integer> col_chm;
    @FXML
    private TableColumn<models.ModelTableChm, String> col_disp;

    
    ObservableList<models.ModelTableChm> oblistChm = FXCollections.observableArrayList();
    @FXML
    private ImageView homeImg;
    @FXML
    private TextField disp;
    @FXML
    private TextField chm;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        
        try {
            conn = new Cnx();
            ResultSet rs = conn.DBcnx().createStatement().executeQuery
            ("SELECT * FROM chambre");
            
            while(rs.next())
            {
                oblistChm.add(new ModelTableChm(rs.getInt("numCh"), rs.getString("dispo")));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ListerChm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            col_chm.setCellValueFactory(new PropertyValueFactory<>("numCh"));
            col_disp.setCellValueFactory(new PropertyValueFactory<>("dispo"));

            tableChm.setItems(oblistChm);
            
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
