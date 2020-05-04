package Controllers;

import DBConn.Cnx;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import models.ModelTablePat;
import models.ModelTableRdv;

public class ListerRdv implements Initializable
{
    private Cnx conn;
    
    @FXML
    private ImageView homeImg;
    @FXML
    private Button homeBtn;
    @FXML
    private Button ret;
    @FXML
    private Button infs;
    @FXML
    private Button meds;
    @FXML
    private Button fctrs;
    @FXML
    private Button chms;
    @FXML
    private TableView<models.ModelTableRdv> tableRdv;
    @FXML
    private TableColumn<models.ModelTableRdv, Integer> col_num;
    @FXML
    private TableColumn<models.ModelTableRdv, Date> col_date;
    @FXML
    private TableColumn<models.ModelTableRdv, String> col_rq;
    @FXML
    private TableColumn<models.ModelTableRdv, Integer> col_pat;
    @FXML
    private TableColumn<models.ModelTableRdv, Integer> col_med;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;

    ObservableList<models.ModelTableRdv> oblistRdv = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        try {
            conn = new Cnx();
            ResultSet rs = conn.DBcnx().createStatement().executeQuery
            ("SELECT * FROM rdv");
            
            while(rs.next())
            {
                oblistRdv.add(new ModelTableRdv(rs.getInt("num_rdv"), rs.getDate("date_rdv"), rs.getString("remarque"), rs.getInt("id_pat"), rs.getInt("id_med")));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ListerPatients.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            col_num.setCellValueFactory(new PropertyValueFactory<>("num_rdv"));
            col_date.setCellValueFactory(new PropertyValueFactory<>("date_rdv"));
            col_rq.setCellValueFactory(new PropertyValueFactory<>("remarque"));
            col_pat.setCellValueFactory(new PropertyValueFactory<>("id_pat"));
            col_med.setCellValueFactory(new PropertyValueFactory<>("id_med"));

            tableRdv.setItems(oblistRdv);
            
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
