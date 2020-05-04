package models;

public class ModelTableChm 
{
    int numCh;
    String dispo;

    public ModelTableChm(int numCh, String dispo) {
        this.numCh = numCh;
        this.dispo = dispo;
    }

    public int getNumCh() {
        return numCh;
    }

    public String getDispo() {
        return dispo;
    }
  
}
