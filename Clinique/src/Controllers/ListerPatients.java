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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Properties;
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
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import models.ModelTablePat;

public class ListerPatients implements Initializable{
    @FXML
    private Button homeBtn;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button ret;
    
    private Cnx conn;

    @FXML
    private TableView<models.ModelTablePat> tablePat;
    @FXML
    private TableColumn<models.ModelTablePat, Integer> col_id;
    @FXML
    private TableColumn<models.ModelTablePat, String> col_nom;
    @FXML
    private TableColumn<models.ModelTablePat, String> col_prenom;
    @FXML
    private TableColumn<models.ModelTablePat, Integer> col_age;
    @FXML
    private TableColumn<models.ModelTablePat, Integer> col_tel;
    @FXML
    private TableColumn<models.ModelTablePat, String> col_adr;
    @FXML
    private TableColumn<models.ModelTablePat, String> col_ass;
    @FXML
    private TableColumn<models.ModelTablePat, String> col_etat;
    
    ObservableList<models.ModelTablePat> oblistPat = FXCollections.observableArrayList();
    @FXML
    private ImageView homeImg;
    @FXML
    private TextField tel;
    @FXML
    private TextField adr;
    @FXML
    private TextField mdp;
    @FXML
    private TextField ass;
    @FXML
    private TextField age;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField etatC;
    @FXML
    private TextField id;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        
        try {
            conn = new Cnx();
            ResultSet rs = conn.DBcnx().createStatement().executeQuery
            ("SELECT id_pat, nom, prenom, age, tel, adresse, mdp, assurance, etatCiv  FROM patient");
            
            while(rs.next())
            {
                oblistPat.add(new ModelTablePat(rs.getInt("id_pat"), rs.getString("nom"), rs.getString("prenom"), rs.getInt("age"), 
                                        rs.getInt("tel"), rs.getString("adresse"), rs.getString("assurance"), rs.getString("etatCiv")));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ListerPatients.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            col_id.setCellValueFactory(new PropertyValueFactory<>("id_pat"));
            col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
            col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
            col_adr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            col_ass.setCellValueFactory(new PropertyValueFactory<>("assurance"));
            col_etat.setCellValueFactory(new PropertyValueFactory<>("etatCiv"));

            tablePat.setItems(oblistPat);
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
    private void ajouterPat(ActionEvent event) 
    {
        /*tel.getText();
        nom.getText();
        age.getText();
        prenom.getText();
        adr.getText();
        ass.getText();
        etatC.getText();
        id.getText();*/
        
        PreparedStatement pst;
        String requete="INSERT INTO patient (id_pat , nom , prenom , age , tel , adresse, mdp, assurance, etatCiv)"
                + " VALUES ('"+id.getText()+"','"+nom.getText()+"','"+prenom.getText()+"','"+age.getText()+"','"+tel.getText()+"',"
                + "'"+adr.getText()+"', '"+mdp.getText()+"' , '"+ass.getText()+"' , '"+etatC.getText()+"');";                              
        
        try
        {
           pst = conn.DBcnx().prepareStatement(requete);
            pst.executeUpdate(requete);
            System.out.println("Patient ajouté avec succés !");
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Clinique Joker");
                alert.setContentText("Patient ajouté avec succés !");
                alert.showAndWait();
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout !");
        }
        
        
        tablePat.getItems().clear();
        
        try {
            conn = new Cnx();
            ResultSet rs = conn.DBcnx().createStatement().executeQuery
            ("SELECT id_pat, nom, prenom, age, tel, adresse, mdp, assurance, etatCiv  FROM patient");
            
            while(rs.next())
            {
                oblistPat.add(new ModelTablePat(rs.getInt("id_pat"), rs.getString("nom"), rs.getString("prenom"), rs.getInt("age"), 
                                        rs.getInt("tel"), rs.getString("adresse"), rs.getString("assurance"), rs.getString("etatCiv")));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ListerPatients.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            col_id.setCellValueFactory(new PropertyValueFactory<>("id_pat"));
            col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
            col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
            col_adr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            col_ass.setCellValueFactory(new PropertyValueFactory<>("assurance"));
            col_etat.setCellValueFactory(new PropertyValueFactory<>("etatCiv"));

            tablePat.setItems(oblistPat);
        
        
        sendmail();

    }

    @FXML
    private void fichePat(ActionEvent event) {
        String snom = tablePat.getSelectionModel().getSelectedItem().getNom();
        String sprenom = tablePat.getSelectionModel().getSelectedItem().getPrenom();
        int sid = tablePat.getSelectionModel().getSelectedItem().getId_pat();
        int sage = tablePat.getSelectionModel().getSelectedItem().getAge();
        int stel = tablePat.getSelectionModel().getSelectedItem().getTel();
        String sadresse = tablePat.getSelectionModel().getSelectedItem().getAdresse();
        String sass = tablePat.getSelectionModel().getSelectedItem().getAssurance();
        String setat = tablePat.getSelectionModel().getSelectedItem().getEtatCiv();
//        System.out.println(x);
//        nom.setText(x );

        Document document = new Document();
        try{
            PdfWriter.getInstance(document, new FileOutputStream(snom+".pdf"));
            document.open();

            Font f=new Font(FontFactory.getFont(FontFactory.TIMES_BOLD,24,Font.UNDERLINE));
            f.setColor(0,153,255);
            
            Font f2=new Font(FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD));
            f2.setColor(0,0,0);
            Paragraph p1 = new Paragraph("PATIENT numéro :  "+ sid ,f);
            p1.setAlignment(Paragraph.ALIGN_CENTER);
            Paragraph p0 = new Paragraph("     ");
            Paragraph pe = new Paragraph("____________________________________________________________________________");     
            Paragraph p2 = new Paragraph("\n\n    -   Nom : ");
            p2.add("             "+snom);            
            Paragraph p3 = new Paragraph("   -   Prénom : ");
            p3.add("        "+sprenom);
            Paragraph p4 = new Paragraph("   -   Age :   " +"            "+sage);
            //p4.add(sage);
            Paragraph p5 = new Paragraph("   -   Télephone :  "+"  "+stel);
            //p5.add(stel);
            Paragraph p6 = new Paragraph("   -   Adresse :  ");
            p6.add("      "+sadresse);
            Paragraph p7 = new Paragraph("   -   Assurance :  ");
            p7.add("   "+sass);
            Paragraph p8 = new Paragraph("   -   Etat civil :  ");
            p8.add("      "+setat);
            Paragraph p9 = new Paragraph("Bienvenue au clinique JOKER INFO <3 ");
            p9.setAlignment(Paragraph.ALIGN_RIGHT);
            
	    document.add(p0);
            document.add(p1);
            document.add(pe);
            document.add(p0);
            document.add(p2);
            document.add(p3);
            document.add(p4);
            document.add(p5);
            document.add(p6);
            document.add(p7);
            document.add(p8);
            document.add(p0);
            document.add(pe);
            document.add(p0);
            document.add(p9);
            
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Clinique Joker");
                alert.setContentText("Fiche du PATIENT  -  " + snom + "  -  génerée avec succés !");
                alert.showAndWait();
        }
        catch(DocumentException | FileNotFoundException e){
            System.out.println(e);
        }
        document.close();
    }

    
    @FXML
    private void suprPat(ActionEvent event) {
                 PreparedStatement pst;

                int x = tablePat.getSelectionModel().getSelectedItem().getId_pat();
                tablePat.getItems().removeAll(tablePat.getSelectionModel().getSelectedItem());
                String requete3="DELETE FROM patient WHERE id_pat =?";
                     
                     
    
     try {
            pst = conn.DBcnx().prepareStatement(requete3);
            pst.setInt(1,x);
            
            pst.executeUpdate();
            
            System.out.println("Patient supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    
      public void sendmail()
    {
         try{
            String host ="smtp.gmail.com" ;
            String user = "mail.fortests404@gmail.com";
            String pass = "testMail123";
            String to = "zaghdoudi.f28@gmail.com";
            String from = "mail.fortests404@gmail.com";
            String subject = "Nouveau patient au Clinique Joker Info. ";
            String messageText = "Binevenue au Clinique Joker Info. \n Votre inscription a été efféctuée avec succés !";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new java.util.Date());
            msg.setText(messageText);

             try (Transport transport = mailSession.getTransport("smtp")) {
                 transport.connect(host, user, pass);
                 transport.sendMessage(msg, msg.getAllRecipients());
             }
           System.out.println("message send successfully");
        }catch(MessagingException ex)
        {
            System.out.println(ex);
        }
    }
      
    public LocalDate aujourdhui() 
    {
        return LocalDate.now();
    } 
    
}
