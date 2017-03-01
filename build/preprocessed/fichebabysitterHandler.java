

import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class fichebabysitterHandler extends DefaultHandler{
    
    private Vector fiches;
    String idficheTag = "close";
    String typebTag = "close";
    String nbmissionsTag = "close";
    String nbenfantsTag = "close";
     String tarifTag = "close";
     String distanceTag = "close";
     String experienceTag = "close";
     String sexeTag = "close";
     String telephoneTag = "close";
     String villeTag = "close";
     String codepostalTag = "close";
     String paysTag = "close";
    

  
 
 
    public fichebabysitterHandler () {
      fiches = new Vector();
    }

    public fichebabysitter[] getFichebabysitter() {
        fichebabysitter[] fichebabysitterss = new   fichebabysitter[fiches.size()];
       fiches.copyInto(fichebabysitterss);
        return fichebabysitterss;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private fichebabysitter currentfichebabysitter;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("fiches")) {
            currentfichebabysitter = new fichebabysitter();
            //2ème methode pour parser les attributs
           currentfichebabysitter.setIdfiche(Integer.parseInt(attributes.getValue("idFiche")));
           currentfichebabysitter.setTypeb(attributes.getValue("typeb"));
           currentfichebabysitter.setNbmissions(Integer.parseInt(attributes.getValue("nbmissions")));
           currentfichebabysitter.setNbenfants(Integer.parseInt(attributes.getValue("nbenfants")));
           currentfichebabysitter.setTarif(Integer.parseInt(attributes.getValue("tarif")));
           currentfichebabysitter.setDistance(Integer.parseInt(attributes.getValue("distance")));
           currentfichebabysitter.setExperience(attributes.getValue("experience"));
           currentfichebabysitter.setSexe(attributes.getValue("sexe"));
            currentfichebabysitter.setPays(attributes.getValue("pays"));
           currentfichebabysitter.setTelephone(Integer.parseInt(attributes.getValue("telephone")));
           currentfichebabysitter.setVille(attributes.getValue("ville"));
           currentfichebabysitter.setCodepostal(Integer.parseInt(attributes.getValue("codepostal")));
         
            
            
            
            /****/
            
        } else if (qName.equals("idFiche")) {
            idficheTag = "open";
        } else if (qName.equals("typeb")) {
            typebTag = "open";
        } else if (qName.equals("nbmissions")) {
            nbmissionsTag = "open";
            
        } else if (qName.equals("nbenfants")) {
            nbenfantsTag = "open";
        }
          else if (qName.equals("tarif")) {
            tarifTag = "open";
        }
          else if (qName.equals("distance")) {
            distanceTag = "open";
        }
         else if (qName.equals("experience")) {
            experienceTag = "open";
        }
         else if (qName.equals("sexe")) {
          sexeTag = "open";
        }
         else if (qName.equals("telephone")) {
         telephoneTag = "open";
        }
         else if (qName.equals("ville")) {
            villeTag = "open";
        }
         else if (qName.equals("codepostal")) {
         codepostalTag = "open";
        }
         else if (qName.equals("pays")) {
            paysTag = "open";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("fiches")) {
            // we are no longer processing a <reg.../> tag
            fiches.addElement(currentfichebabysitter);
            currentfichebabysitter = null;
        } else if (qName.equals("idFiche")) {
            idficheTag = "close";
        } else if (qName.equals("typeb")) {
            typebTag = "close";
        } else if (qName.equals("nbmissions")) {
            nbmissionsTag = "close";
            
        } else if (qName.equals("nbenfants")) {
            nbenfantsTag = "close";
        }
          else if (qName.equals("tarif")) {
            tarifTag = "close";
        }
          else if (qName.equals("distance")) {
            distanceTag = "close";
        }
         else if (qName.equals("experience")) {
            experienceTag = "close";
        }
         else if (qName.equals("sexe")) {
          sexeTag = "close";
        }
         else if (qName.equals("telephone")) {
         telephoneTag = "close";
        }
         else if (qName.equals("ville")) {
            villeTag = "close";
        }
         else if (qName.equals("codepostal")) {
         codepostalTag = "close";
        }
         else if (qName.equals("pays")) {
            paysTag = "close";
        }
    }
    // "characters" are the text between tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentfichebabysitter!= null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idficheTag.equals("open")) {
                String idfiche = new String(ch, start, length).trim();
                currentfichebabysitter.setIdfiche(Integer.parseInt(idfiche));
            } else
                if (typebTag.equals("open")) {
                String typeb = new String(ch, start, length).trim();
                currentfichebabysitter.setTypeb(typeb);
            } else
                    if (nbmissionsTag.equals("open")) {
                String nbmissions = new String(ch, start, length).trim();
                currentfichebabysitter.setNbmissions(Integer.parseInt(nbmissions));
                
            }
             else
                    if (nbenfantsTag.equals("open")) {
                String nbenfants = new String(ch, start, length).trim();
                currentfichebabysitter.setNbenfants(Integer.parseInt(nbenfants));
                
            }
             else
                    if (tarifTag.equals("open")) {
                String tarif = new String(ch, start, length).trim();
                currentfichebabysitter.setTarif(Integer.parseInt(tarif));
                
            }
             else
                    if (distanceTag.equals("open")) {
                String distance = new String(ch, start, length).trim();
                currentfichebabysitter.setDistance(Integer.parseInt(distance));
                
            }
             else
                    if (experienceTag.equals("open")) {
                String experience = new String(ch, start, length).trim();
                currentfichebabysitter.setExperience(experience);
                
            }
             else
                    if (sexeTag.equals("open")) {
                String sexe = new String(ch, start, length).trim();
                currentfichebabysitter.setSexe(sexe);
                
            }
             else
                    if (telephoneTag.equals("open")) {
                String telephone = new String(ch, start, length).trim();
                currentfichebabysitter.setTelephone(Integer.parseInt(telephone));
                
            }
             else
                    if (villeTag.equals("open")) {
                String ville = new String(ch, start, length).trim();
                currentfichebabysitter.setVille(ville);
                
            }
             else
                    if (codepostalTag.equals("open")) {
                String codepostal = new String(ch, start, length).trim();
                currentfichebabysitter.setCodepostal(Integer.parseInt(codepostal));
                
            }
             else
                    if (paysTag.equals("open")) {
                String pays = new String(ch, start, length).trim();
                currentfichebabysitter.setPays(pays);
                
            }
        }
    }
    
}
