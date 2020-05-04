package Controllers;

import DBConn.Cnx;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.ModelTableFact;
import models.ModelTablePat;

public class ListerFact implements Initializable{
    @FXML
    private Button homeBtn;
    @FXML
    private Button ret;
    
    private Cnx conn;

    @FXML
    private TableView<models.ModelTableFact> tableFact;
    @FXML
    private TableColumn<models.ModelTableFact, Integer> col_fact;
    @FXML
    private TableColumn<models.ModelTableFact, Double> col_mnt;
    @FXML
    private TableColumn<models.ModelTableFact, Integer> col_pat;
    
    ObservableList<models.ModelTableFact> oblistFact = FXCollections.observableArrayList();
    @FXML
    private ImageView homeImg;
    @FXML
    private Button imp;
    @FXML
    private TextField mnt;
    @FXML
    private TextField id_pat;
    @FXML
    private TextField num;
    @FXML
    private Button ajouter;
    @FXML
    private Button supprimer;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        
        try {
            conn = new Cnx();
            ResultSet rs = conn.DBcnx().createStatement().executeQuery
            ("SELECT * FROM facture");
            
            while(rs.next())
            {
                oblistFact.add(new ModelTableFact(rs.getInt("numFact"), (int)rs.getDouble("montant"), rs.getInt("id_patient")));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ListerFact.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            col_fact.setCellValueFactory(new PropertyValueFactory<>("numFact"));
            col_mnt.setCellValueFactory(new PropertyValueFactory<>("montant"));
            col_pat.setCellValueFactory(new PropertyValueFactory<>("id_patient"));
            
            tableFact.setItems(oblistFact);
            
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
    
    
    @FXML
    private void imprimer(ActionEvent event) {
        int inumFact = tableFact.getSelectionModel().getSelectedItem().getNumFact();
        double imontant = tableFact.getSelectionModel().getSelectedItem().getMontant();
        int iid_patient = tableFact.getSelectionModel().getSelectedItem().getId_patient();
//        System.out.println(x);
//        nom.setText(x );

        Document document = new Document();
        try{
            PdfWriter.getInstance(document, new FileOutputStream("Facture N."+inumFact+".pdf"));
            document.open();

            Font f=new Font(FontFactory.getFont(FontFactory.TIMES_BOLD,24,Font.UNDERLINE));
            f.setColor(0,153,255);
            
            Font f2=new Font(FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD));
            f2.setColor(0,0,0);
            Paragraph p1 = new Paragraph("Facture numéro :  "+ inumFact ,f);
            p1.setAlignment(Paragraph.ALIGN_CENTER);
            Paragraph p0 = new Paragraph("     ");
                 
            Paragraph p2 = new Paragraph("____________________________________________________________________________");
            Paragraph p4 = new Paragraph("   -   Montant :   " +"                       "+imontant);
            //p4.add(sage);
            Paragraph p5 = new Paragraph("   -   Identifiant du patient :  "+"          "+iid_patient);
            //p5.add(stel);
            Paragraph p9 = new Paragraph("Bienvenue au clinique JOKER INFO <3 ");
            p9.setAlignment(Paragraph.ALIGN_RIGHT);
            
	    
            document.add(p0);
            document.add(p1);
            document.add(p0);
            document.add(p2);
            document.add(p0);
            document.add(p0);
            document.add(p4);
            document.add(p0);
            document.add(p5);
            document.add(p0);
            document.add(p2);
            document.add(p0);
            document.add(p0);
            document.add(p9);
            
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Clinique Joker");
                alert.setContentText("Facture ( "+ inumFact + " ) du PATIENT  ( " + iid_patient + " )   génerée avec succés !");
                alert.showAndWait();
        }
        catch(DocumentException | FileNotFoundException e){
            System.out.println(e);
        }
        document.close();
    }
}
