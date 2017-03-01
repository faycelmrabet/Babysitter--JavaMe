/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Date;

/**
 *
 * @author sassouki
 */
public class OffreMission {
    public int numOffre;
    public String date;
    public String description;
    public String adresse;
    public String horaire;

    public OffreMission(int numOffre, String date, String description, String adresse, String horaire) {
        this.numOffre = numOffre;
        this.date = date;
        this.description = description;
        this.adresse = adresse;
        this.horaire = horaire;
    }

    
    
    public OffreMission(){
        
    }
    public int getNumOffre() {
        return numOffre;
    }

    public String toString() {
        return "OffreMission{" + "numOffre=" + numOffre + ", date=" + date + ", description=" + description + ", adresse=" + adresse + ", horaire=" + horaire + '}';
    }

    public void setNumOffre(int numOffre) {
        this.numOffre = numOffre;
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
    public void setNumOffre(String numOffre) {
        this.numOffre = Integer.parseInt(numOffre);
    }
    public OffreMission getOffreMission()
    {return null;}
}
