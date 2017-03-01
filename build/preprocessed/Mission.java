/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author rahmouch
 */
public class Mission {
    
    private int idMission;
    private String date;
    private String description;
     private String adresse;
      private String horaire;

    public Mission() {
    }

    public Mission(int idMission, String date, String description, String adresse, String horaire) {
        this.idMission = idMission;
        this.date = date;
        this.description = description;
        this.adresse = adresse;
        this.horaire = horaire;
    }

    public int getIdMission() {
        return idMission;
    }

    public void setIdMission(int idMission) {
        this.idMission = idMission;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }
    


}
