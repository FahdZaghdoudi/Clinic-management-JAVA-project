package models;

import java.sql.Date;

public class ModelTableRdv 
{
    int num_rdv, id_pat, id_med;
    String remarque;
    Date date_rdv;

    public ModelTableRdv(int num_rdv, Date date_rdv, String remarque, int id_pat, int id_med) {
        this.num_rdv = num_rdv;
        this.id_pat = id_pat;
        this.id_med = id_med;
        this.remarque = remarque;
        this.date_rdv = date_rdv;
    }

    public int getNum_rdv() {
        return num_rdv;
    }

    public int getId_pat() {
        return id_pat;
    }

    public int getId_med() {
        return id_med;
    }

    public String getRemarque() {
        return remarque;
    }

    public Date getDate_rdv() {
        return date_rdv;
    }
    
    
    
}
