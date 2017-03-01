
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fhima
 */
public class UserHandler  extends DefaultHandler {

      private Vector users;
    String idTag = "close";
    String nomTag = "close";
    String prenTag = "close";
    String passTag = "close";
    String cinTag = "close";
    String logTag = "close";
    String emailTag = "close";
    String typeTag = "close";
    String etatTag = "close";
    String cpTag = "close";
    String dnTag = "close";
    String telTag = "close";
    String addTag = "close";
    String NoteTag = "close";
    
   

    public UserHandler() {
        users = new Vector();
    }

    public User[] getUser() {
        User[] personness = new User[users.size()];
        users.copyInto(personness);
        return personness;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private User currentUser;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("user")) {
            currentUser = new User();
            //2ème methode pour parser les attributs
            currentUser.setId(Integer.parseInt(attributes.getValue("id").trim()));
            currentUser.setNom(attributes.getValue("nom"));
            currentUser.setPrenom(attributes.getValue("prenom"));
            currentUser.setLogin(attributes.getValue("username"));
            currentUser.setPassword(attributes.getValue("password"));
            currentUser.setEmail(attributes.getValue("email"));
            currentUser.setCin(Integer.parseInt(attributes.getValue("cin").trim()));
            currentUser.setType(attributes.getValue("typeUser"));
            currentUser.setAdresse(attributes.getValue("adresse"));
            currentUser.setCodePostale(Integer.parseInt(attributes.getValue("codePostale")));
            currentUser.setDateNaissance(attributes.getValue("dateNaissance"));
            currentUser.setTelephone(Integer.parseInt(attributes.getValue("telephone")));
            currentUser.setEtat(Integer.parseInt(attributes.getValue("etat")));
             currentUser.setNote(Integer.parseInt(attributes.getValue("note")));
            /****/
            
        } else if (qName.equals("id")) {
            idTag = "open";
        } else if (qName.equals("nom")) {
            nomTag = "open";
        } else if (qName.equals("prenom")) {
            prenTag = "open";
        }
        else if (qName.equals("username")) {
            logTag = "open";
        }else if (qName.equals("password")) {
            passTag = "open";
        }else if (qName.equals("email")) {
            emailTag = "open";
        }else if (qName.equals("cin")) {
            cinTag = "open";
        }else if (qName.equals("typeUser")) {
            typeTag = "open";
        }else if (qName.equals("etat")){
               etatTag="open";
        }else if (qName.equals("adresse")){
               addTag="open";
        }else if (qName.equals("codePostale")){
               cpTag="open";
        }else if (qName.equals("dateNaissance")){
               dnTag="open";
        }else if (qName.equals("telephone")){
               telTag="open";
        }else if (qName.equals("note")){
               NoteTag="open";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("user")) {
            // we are no longer processing a <reg.../> tag
            users.addElement(currentUser);
            currentUser = null;
        } else if (qName.equals("id")) {
            idTag = "close";
        } else if (qName.equals("nom")) {
            nomTag = "close";
        } else if (qName.equals("prenom")) {
            prenTag = "close";
        }else if (qName.equals("username")) {
            logTag = "close";
        }else if (qName.equals("password")) {
            passTag = "close";
        }else if (qName.equals("email")) {
            emailTag = "close";
        }else if (qName.equals("cin")) {
            cinTag = "close";
        }else if (qName.equals("typeUser")) {
            typeTag = "close";
        }else if (qName.equals("etat")){
               etatTag="close";
        }else if (qName.equals("adresse")){
               addTag="close";
        }else if (qName.equals("codePostale")){
               cpTag="close";
        }else if (qName.equals("dateNaissance")){
               dnTag="close";
        }else if (qName.equals("telephone")){
               telTag="close";
        }else if (qName.equals("note")){
               NoteTag="close";
        }
    }
    // "characters" are the text between tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentUser != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                currentUser.setId(Integer.parseInt(id));
            } else
                if (nomTag.equals("open")) {
                String nom = new String(ch, start, length).trim();
                currentUser.setNom(nom);
            } else
                    if (prenTag.equals("open")) {
                String pren = new String(ch, start, length).trim();
                currentUser.setPrenom(pren);
            }else
                    if (logTag.equals("open")) {
                String log = new String(ch, start, length).trim();
                currentUser.setLogin(log);
            }else
                    if (passTag.equals("open")) {
                String pass = new String(ch, start, length).trim();
                currentUser.setPassword(pass);
            }else
                    if (emailTag.equals("open")) {
                String mail = new String(ch, start, length).trim();
                currentUser.setEmail(mail);
            }else
                    if (cinTag.equals("open")) {
                String cin = new String(ch, start, length).trim();
                currentUser.setCin(Integer.parseInt(cin));
            }
            else
                    if (typeTag.equals("open")) {
                String type = new String(ch, start, length).trim();
                currentUser.setType(type);
            }else
                    if (addTag.equals("open")) {
                String add = new String(ch, start, length).trim();
                currentUser.setAdresse(add);
            }else
                    if (cpTag.equals("open")) {
                String cp = new String(ch, start, length).trim();
                currentUser.setCodePostale(Integer.parseInt(cp));
            }else
                    if (dnTag.equals("open")) {
                String dn = new String(ch, start, length).trim();
                currentUser.setDateNaissance(dn);
            }else
                    if (etatTag.equals("open")) {
                String etat = new String(ch, start, length).trim();
                currentUser.setEtat(Integer.parseInt(etat));
            }else
                    if (telTag.equals("open")) {
                String tel = new String(ch, start, length).trim();
                currentUser.setTelephone(Integer.parseInt(tel));
            }
            else
                    if (NoteTag.equals("open")) {
                String note = new String(ch, start, length).trim();
                currentUser.setNote(Integer.parseInt(note));
            }
        }
    }
    

}
