package Controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class InterfaceAdm 
{
    @FXML
    private Button homeBtn;
    @FXML
    private Button rdvs;
    @FXML
    private Button infs;
    @FXML
    private Button meds;
    @FXML
    private Button pats;
    @FXML
    private Button fctrs;
    @FXML
    private Button chms;

    
    
    
    @FXML
    private void affTabPat(ActionEvent e) throws IOException
    {
        Stage gpat = new Stage();
        pats.getScene().getWindow().hide();
        Parent root1;
        root1 = FXMLLoader.load(getClass().getResource("/FXML/GererPat.fxml"));
        Scene scene = new Scene(root1);
        gpat.setScene(scene);
        gpat.show();
        gpat.setResizable(false);
    }
    
    @FXML
    private void affTabMed(ActionEvent e) throws IOException
    {
        Stage gmed = new Stage();
        meds.getScene().getWindow().hide();
        Parent root2;
        root2 = FXMLLoader.load(getClass().getResource("/FXML/GererMed.fxml"));
        Scene scene = new Scene(root2);
        gmed.setScene(scene);
        gmed.show();
        gmed.setResizable(false);
    }
    
    @FXML
    private void affTabInf(ActionEvent e) throws IOException
    {
        Stage gpat = new Stage();
        infs.getScene().getWindow().hide();
        Parent root3;
        root3 = FXMLLoader.load(getClass().getResource("/FXML/GererInf.fxml"));
        Scene scene = new Scene(root3);
        gpat.setScene(scene);
        gpat.show();
        gpat.setResizable(false);
    }
    
    @FXML
    private void affTabRdv(ActionEvent e) throws IOException
    {
        Stage gpat = new Stage();
        rdvs.getScene().getWindow().hide();
        Parent root4;
        root4 = FXMLLoader.load(getClass().getResource("/FXML/GererRdv.fxml"));
        Scene scene = new Scene(root4);
        gpat.setScene(scene);
        gpat.show();
        gpat.setResizable(false);
    }
    
    @FXML
    private void affTabChm(ActionEvent e) throws IOException
    {
        Stage gpat = new Stage();
        chms.getScene().getWindow().hide();
        Parent root5;
        root5 = FXMLLoader.load(getClass().getResource("/FXML/GererChm.fxml"));
        Scene scene = new Scene(root5);
        gpat.setScene(scene);
        gpat.show();
        gpat.setResizable(false);
    }
    
    @FXML
    private void affTabFact(ActionEvent e) throws IOException
    {
        Stage gpat = new Stage();
        fctrs.getScene().getWindow().hide();
        Parent root6;
        root6 = FXMLLoader.load(getClass().getResource("/FXML/GererFact.fxml"));
        Scene scene = new Scene(root6);
        gpat.setScene(scene);
        gpat.show();
        gpat.setResizable(false);
    }
    
    
    @FXML
    public void homee(ActionEvent e) throws IOException
    {
        Stage hm = new Stage();
        homeBtn.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/FXML/home.fxml"));
        Scene scene = new Scene(root);
        hm.setScene(scene);
        hm.show();
        hm.setResizable(false);
    }
}
