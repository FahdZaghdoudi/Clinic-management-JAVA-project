package models;

public class ModelTablePat 
{
    int id_pat,age,tel;
    String nom, prenom, adresse, assurance,etatCiv;

    public ModelTablePat(int id_pat, String nom, String prenom, int age, int tel, String adresse, String assurance, String etatCiv) 
    {
        this.id_pat = id_pat;
        this.age = age;
        this.tel = tel;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.assurance = assurance;
        this.etatCiv = etatCiv;
    }

    

    public int getId_pat() {
        return id_pat;
    }

    public int getAge() {
        return age;
    }

    public int getTel() {
        return tel;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getAssurance() {
        return assurance;
    }

    public String getEtatCiv() {
        return etatCiv;
    }
    
    
    
}
