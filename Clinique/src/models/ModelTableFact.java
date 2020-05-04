package models;

public class ModelTableFact 
{
    int numFact, id_patient;
    double montant;

    public ModelTableFact(int numFact, int id_patient, double montant) {
        this.numFact = numFact;
        this.id_patient = id_patient;
        this.montant = montant;
    }

    public int getNumFact() {
        return numFact;
    }

    public int getId_patient() {
        return id_patient;
    }

    public double getMontant() {
        return montant;
    }
    
    
}
