/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import java.util.Vector;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author sassouki
 */
public class OffreMissionHandler extends DefaultHandler {
     private Vector offremission;
          
     
           String numOffreTag = "close";
           String dateTag = "close";
           String descriptionTag = "close";
           String adresseTag = "close";
           String horaireTag = "close";

    public OffreMissionHandler() {
        offremission = new Vector();
    }

    public OffreMission[] getOffreMission() {
       OffreMission[] OffreMissions = new OffreMission[offremission.size()];
        offremission.copyInto(OffreMissions);
        return OffreMissions;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private OffreMission currentOffreMission;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("offre")) {
            currentOffreMission = new OffreMission();
            //2ème methode pour parser les attributs
            currentOffreMission.setNumOffre(Integer.parseInt(attributes.getValue("numOffre")));
            currentOffreMission.setDate(attributes.getValue("date"));
            currentOffreMission.setDescription(attributes.getValue("description"));
            currentOffreMission.setAdresse(attributes.getValue("adresse"));
            currentOffreMission.setHoraire(attributes.getValue("horaire"));
            /****/
            
        } else if (qName.equals("numOffre")) {
            numOffreTag = "open";
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

        if (qName.equals("offre")) {
            // we are no longer processing a <reg.../> tag
            offremission.addElement(currentOffreMission);
            currentOffreMission = null;
        }  else if (qName.equals("numOffre")) {
            numOffreTag = "close";
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
        if (currentOffreMission != null) {
            // don't forget to trim excess spaces from the ends of the string
            if ( numOffreTag.equals("open")) {
                String numOffre = new String(ch, start, length).trim();
                currentOffreMission.setNumOffre(Integer.parseInt(numOffre));
            } else
                if (dateTag.equals("open")) {
                String date = new String(ch, start, length).trim();
                currentOffreMission.setDate(date);
            } else
                    if (descriptionTag.equals("open")) {
                String desc = new String(ch, start, length).trim();
                currentOffreMission.setDescription(desc);
            }else
                    if (adresseTag.equals("open")) {
                String adresse = new String(ch, start, length).trim();
                currentOffreMission.setDescription(adresse);
            }else
                    if (horaireTag.equals("open")) {
                String horaire = new String(ch, start, length).trim();
                currentOffreMission.setDescription(horaire);
            }
        }
    }
    
}


