/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rahmouch
 */
public class fichebabysitter {
    
  int idfiche;
  String typeb;
  int nbmissions;
  int nbenfants;
  int tarif;
  int distance; 
  String experience;
  String sexe;
  int telephone;
  String ville;
  int codepostal;
  String pays;
  String photo;
  
  public fichebabysitter() {}

    public fichebabysitter(int idfiche, String typeb, int nbmissions, int nbenfants, int tarif, int distance, String experience, String sexe, int telephone, String ville, int codepostal, String pays, String photo) {
        this.idfiche = idfiche;
        this.typeb = typeb;
        this.nbmissions = nbmissions;
        this.nbenfants = nbenfants;
        this.tarif = tarif;
        this.distance = distance;
        this.experience = experience;
        this.sexe = sexe;
        this.telephone = telephone;
        this.ville = ville;
        this.codepostal = codepostal;
        this.pays = pays;
        this.photo = photo;
    }

    public int getIdfiche() {
        return idfiche;
    }
//    public String getIdficheBaby() {
//        return (String.valueOf(idfiche));
//    }

    public void setIdfiche(int idfiche) {
        this.idfiche = idfiche;
    }

    public String getTypeb() {
        return typeb;
    }

    public void setTypeb(String typeb) {
        this.typeb = typeb;
    }

    public int getNbmissions() {
        return nbmissions;
    }

    public void setNbmissions(int nbmissions) {
        this.nbmissions = nbmissions;
    }

    public int getNbenfants() {
        return nbenfants;
    }

    public void setNbenfants(int nbenfants) {
        this.nbenfants = nbenfants;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(int codepostal) {
        this.codepostal = codepostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String toString() {
        return "fichebabysitter{" + "idfiche=" + idfiche + ", typeb=" + typeb + ", nbmissions=" + nbmissions + ", nbenfants=" + nbenfants + ", tarif=" + tarif + ", distance=" + distance + ", experience=" + experience + ", sexe=" + sexe + ", telephone=" + telephone + ", ville=" + ville + ", codepostal=" + codepostal + ", pays=" + pays + ", photo=" + photo + '}';
    }

   
    
    
}
