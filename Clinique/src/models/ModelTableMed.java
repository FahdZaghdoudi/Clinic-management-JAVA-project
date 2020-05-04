package models;

public class ModelTableMed 
{
    int id_med,age,tel;
    String nom, prenom, adresse, specialite;

    public ModelTableMed(int id_med, String nom, String prenom, int age, int tel, String adresse, String specialite) 
    {
        this.id_med = id_med;
        this.age = age;
        this.tel = tel;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.specialite = specialite;
    }

    public int getId_med() {
        return id_med;
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

    public String getSpecialite() {
        return specialite;
    }

  
    
}
