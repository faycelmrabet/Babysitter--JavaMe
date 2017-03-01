/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Fhima
 */
public class User {
    protected int id;
    protected int cin;
    protected String nom;
    protected String prenom;
    protected String login;
    protected String password;
    protected String email;
    protected String dateNaissance;
    protected String adresse;
    protected int codePostale;
    protected int telephone;
    protected int etat;
    protected int Note;
   protected String type;

    public User(int id, int cin, String nom, String prenom, String login, String password, String email, String dateNaissance, String adresse, int codePostale, int telephone, int etat, int Note, String type) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.codePostale = codePostale;
        this.telephone = telephone;
        this.etat = etat;
        this.Note = Note;
        this.type = type;
    }

  

   

    public User() 
    {
        this.id = 0;
        this.cin = 0;
        this.nom = "";
        this.prenom = "";
        this.email = "";
        this.dateNaissance = "";
        this.adresse = "";
        this.codePostale = 0;
        this.telephone = 0;
        this.etat = 0;
        this.login = "";
        this.password = "";
        this.type = ""; 
        this.Note=0;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getNote() {
        return Note;
    }

    public void setNote(int Note) {
        this.Note = Note;
    }

    public String toString() {
        return "User{" + "id=" + id + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password=" + password + ", email=" + email + ", dateNaissance=" + dateNaissance + ", adresse=" + adresse + ", codePostale=" + codePostale + ", telephone=" + telephone + ", etat=" + etat + ", Note=" + Note + ", type=" + type + '}';
    }

   

  
    
   
    
    
    
}
