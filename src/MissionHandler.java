/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author rahmouch
 */
public class MissionHandler extends DefaultHandler{
    
    private Vector mission;
          
     
           String idMissionTag = "close";
           String dateTag = "close";
           String descriptionTag = "close";
           String adresseTag = "close";
           String horaireTag = "close";

    public MissionHandler() {
        mission = new Vector();
    }

    public Mission[] getMission(){
      Mission[] Missions = new Mission[mission.size()];
      mission.copyInto(Missions);
        return Missions;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private Mission currentMission;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("missions")) {
            currentMission = new Mission();
            //2ème methode pour parser les attributs
            currentMission.setIdMission(Integer.parseInt(attributes.getValue("idMission")));
            currentMission.setDate(attributes.getValue("date"));
            currentMission.setDescription(attributes.getValue("description"));
            currentMission.setAdresse(attributes.getValue("adresse"));
            currentMission.setHoraire(attributes.getValue("horaire"));
            /****/
            
        } else if (qName.equals("idMission")) {
            idMissionTag = "open";
        } else if (qName.equals("date")) {
            dateTag = "open";
        } else if (qName.equals("description")) {
            descriptionTag = "open";
        }else if (qName.equals("adresse")) {
            adresseTag = "open";
        }else if (qName.equals("horaire")) {
            horaireTag = "open";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("missions")) {
            // we are no longer processing a <reg.../> tag
            mission.addElement(currentMission);
            currentMission = null;
        }  else if (qName.equals("idMission")) {
            idMissionTag= "close";
        } else if (qName.equals("date")) {
            dateTag = "close";
        } else if (qName.equals("description")) {
            descriptionTag = "close";
        }else if (qName.equals("adresse")) {
            adresseTag = "close";
        }else if (qName.equals("horaire")) {
            horaireTag = "close";
        }
    }
    // "characters" are the text between tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentMission != null) {
            // don't forget to trim excess spaces from the ends of the string
            if ( idMissionTag.equals("open")) {
                String numOffre = new String(ch, start, length).trim();
                currentMission.setIdMission(Integer.parseInt(numOffre));
            } else
                if (dateTag.equals("open")) {
                String date = new String(ch, start, length).trim();
                currentMission.setDate(date);
            } else
                    if (descriptionTag.equals("open")) {
                String desc = new String(ch, start, length).trim();
                currentMission.setDescription(desc);
            }else
                    if (adresseTag.equals("open")) {
                String adresse = new String(ch, start, length).trim();
                currentMission.setDescription(adresse);
            }else
                    if (horaireTag.equals("open")) {
                String horaire = new String(ch, start, length).trim();
                currentMission.setDescription(horaire);
            }
        }
    }
    
    
}
