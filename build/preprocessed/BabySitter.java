/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Fhima
 */
public class BabySitter extends User{
    
    private String dateNaissance;
    private String adresse;
    private int codePostale;
    private int telephone;
    private int etat;

  

    public BabySitter() 
    {
          this.dateNaissance = "";
        this.adresse = "";
        this.codePostale = 0;
        this.telephone = 0;
        this.etat=0;
    }

    public BabySitter(String dateNaissance, String adresse, int codePostale, int telephone, int cin, String nom, String prenom, String email, String login, String password) 
    {
        super(cin, nom, prenom, email, login, password);
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.codePostale = codePostale;
        this.telephone = telephone;
    }
    

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(int codePostale) {
        this.codePostale = codePostale;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

  
    public String toString() {
        return "BabySitter{"+super.toString() + "dateNaissance=" + dateNaissance + ", adresse=" + adresse + ", codePostale=" + codePostale + ", telephone=" + telephone +", Etat="+etat+ '}'+"\n";
    }
     
    
    
}
