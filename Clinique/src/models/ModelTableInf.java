package models;

public class ModelTableInf 
{
    int id_inf,age,tel;
    String nom, prenom, adresse, service;

    public ModelTableInf(int id_inf, String nom, String prenom, int age, int tel, String adresse, String service) 
    {
        this.id_inf = id_inf;
        this.age = age;
        this.tel = tel;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.service = service;
    }

    public int getId_inf() {
        return id_inf;
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

    public String getService() {
        return service;
    }

    

    
    
    
}
