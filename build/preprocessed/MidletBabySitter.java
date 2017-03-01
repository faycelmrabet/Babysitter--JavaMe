/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.Spacer;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;
import javax.microedition.midlet.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author Fhima
 */




public class MidletBabySitter extends MIDlet implements CommandListener, Runnable{
Display disp=Display.getDisplay(this);
  //Ilyes
    String[] tabE = {"Mon Espace", "Mon Compte"};
    List l2 = new List("Espace BabySitter", List.IMPLICIT, tabE, null);
    Form form1 = new Form("Authentification");
    //Form form2 = new Form("Espace BabySitter");
    Form form3 = new Form("Inscription BabySitter");
    Form form4 = new Form("Mes Information");
    Form form5=new Form("Espace Parent");
    Form form6=new Form("Espace Responsable");
    Form form7=new Form("Espace Admin");
    Form form8=new Form("Modifier mes Informations");
    Alert al = new Alert("verifier vos donnees");
     Alert alm=new Alert("Modifier","Compte modifier avec succee", null, AlertType.CONFIRMATION);
      Alert alin=new Alert("Inscription","Inscription avec succee", null, AlertType.INFO);
    Command cmdExit=new Command("Exit",Command.BACK,0);
     Command cmdLog=new Command("Login",Command.OK,1);
      Command cmdBack=new Command("Back",Command.BACK,1);
      Command cmdInsc=new Command("Inscription",Command.OK,0);
      Command cmdInscri=new Command("s'inscrire",Command.OK,0);
       Command cmdModif=new Command("Modifier Compte",Command.OK,0);
        Command cmdval=new Command("valider",Command.OK,0);
     Command cmdSupp=new Command("Supprimer Compte",Command.OK,0);
    TextField tf_log_auth = new TextField("Login", null, 30, TextField.ANY);
    TextField tf_passw = new TextField("Password", null, 30, TextField.PASSWORD);
    TextField tf_nom = new TextField("Nom", null, 30, TextField.ANY);
    TextField tf_prenom = new TextField("Prenom", null, 30, TextField.ANY);
    TextField tf_log = new TextField("Login", null, 30, TextField.ANY);
    TextField tf_pass = new TextField("Password", null, 30, TextField.PASSWORD);
    TextField tf_cin = new TextField("Cin", null, 30, TextField.NUMERIC);
    TextField tf_cp = new TextField("Code Postale", null, 30, TextField.NUMERIC);
    DateField tf_dn = new DateField("Date Naissance", DateField.DATE);
    
    TextField tf_email = new TextField("Email", null, 30, TextField.EMAILADDR);
    TextField tf_add = new TextField("Addresse", null, 30, TextField.ANY);
    TextField tf_tel = new TextField("Telephone", null, 30, TextField.NUMERIC);

    TextField tf_nom1 = new TextField("Nom", null, 30, TextField.ANY);
    TextField tf_prenom1 = new TextField("Prenom", null, 30, TextField.ANY);
    TextField tf_cp1 = new TextField("Code Postale", null, 30, TextField.NUMERIC);
    DateField tf_dn1 = new DateField("Date Naissance", DateField.DATE);
    TextField tf_email1 = new TextField("Email", null, 30, TextField.EMAILADDR);
    TextField tf_add1 = new TextField("Addresse", null, 30, TextField.ANY);
    TextField tf_tel1 = new TextField("Telephone", null, 30, TextField.NUMERIC);
    Image img_auth; 
    ImageItem imgt_auth;  
         User[] users;
         User user;
          
     //Asma
         
    String[] tabA={"Offre Mission"};
    String[] tabB={"AjouterOffre","AfficherOffre"};
     List lA;
    List lB;
  //  Command cmdBack=new Command("Retour", Command.BACK, 0);
    Ticker t2=new Ticker("Offre Mission");
    Image[] img=new Image[2];
    
    String[] tabC={"Parent","Baby Sitter","Responsable Garderie"};
    
    Ticker t4=new Ticker("Espace Administrateur");
     Image[] img1=new Image[3];
     List lC;
    
     Form ajouterOffre=new Form("Ajouter Offre Mission");
    Form afficherOffre=new Form("Afficher Offre Mission");
    Form modifierOffre=new Form("Modifier Offre Mission");
    
    
     DateField tfDate=new DateField("Date", DateField.DATE);
    TextField tfDesc = new TextField("Description", null, 100, TextField.ANY);
    TextField tfAdresse = new TextField("Adresse", null, 100, TextField.ANY);
    TextField tfHoraire = new TextField("Horaire", null, 100, TextField.ANY);
    
     DateField tfDate1=new DateField("Date", DateField.DATE);
    TextField tfDesc1 = new TextField("Description", null, 100, TextField.ANY);
    TextField tfAdresse1 = new TextField("Adresse", null, 100, TextField.ANY);
    TextField tfHoraire1 = new TextField("Horaire", null, 100, TextField.ANY);
     
    Command cmdValider = new Command("Ajouter", Command.SCREEN, 0);
    Command cmdValider2 = new Command("Valider", Command.SCREEN, 0);
    Command cmdBack1 = new Command("Retour", Command.BACK, 0);
    Command cmdSupprimer=new Command("Supprimer", Command.OK, 1);
    Command cmdModifier=new Command("Modifier", Command.OK, 1);
    Form welcome = new Form("Ajout avec succés");
    Form erreur = new Form("Erreur d'ajout");
    Alert alerte = new Alert("Error", "Sorry", null, AlertType.ERROR);
    Alert alertD = new Alert("Succes", "Votre Offre Mission a été ajouté", null, AlertType.CONFIRMATION);
    Alert alerta = new Alert("Error", "Erreur lors de l'ajout", null, AlertType.ERROR);
    
    Alert alertD1 = new Alert("Succes", "Votre Offre Mission a été modifié", null, AlertType.CONFIRMATION);
    Alert alerta1 = new Alert("Error", "Erreur lors de la modification", null, AlertType.ERROR);
    
     Alert alertD2 = new Alert("Succes", "Votre Offre Mission a été supprimé", null, AlertType.CONFIRMATION);
    Alert alerta2 = new Alert("Error", "Erreur lors de la suppression", null, AlertType.ERROR);

    Form f2 = new Form("Welcome");
    Form f3 = new Form("Erreur");
     Command cmdParse = new Command("Offres Missions", Command.SCREEN, 0);
     
    OffreMission []   offremission;
    List lst = new List("offres", List.IMPLICIT);
    
    Form f4 = new Form("Infos sur les Offres");
    Form loadingDialog = new Form("Please Wait");
    StringBuffer sb4 = new StringBuffer();
    
    Command cmdModifier1=new Command("Modifier", Command.OK, 1);
     
    //Form
    Form listParent = new Form("Afficher les parents");
    
    User []   parent;
    List lst1 = new List("Parents", List.IMPLICIT);
    int id;
    TextField etat = new TextField("etat", null, 30, TextField.ANY);
    
    Alert alertD3 = new Alert("Succes", "Votre utilisateur a été modifié", null, AlertType.CONFIRMATION);
    Alert alerta3 = new Alert("Error", "Erreur lors de la modification", null, AlertType.ERROR);
    
    Form form = new Form("Infos sur les Parents");
    Form loadingDialog1 = new Form("Please Wait");
    StringBuffer sb1 = new StringBuffer();
    
    Form listBabySitter = new Form("Afficher les Baby Sitters");
    
    
    User []   babysitter;
    List lst2 = new List("Baby Sitters", List.IMPLICIT);
    
    Form form2 = new Form("Infos sur les Baby Sitters");
    Form loadingDialog2 = new Form("Please Wait");
    StringBuffer sb2 = new StringBuffer();
    
    Form listeResponsableGarderie = new Form("Afficher les Responsables Garderie");
    
    
    User []   responsablegarderie;
    List lst3 = new List("Responsables Garderie", List.IMPLICIT);
    
    Form for3 = new Form("Infos sur les Responsables Garderie");
    Form loadingDialog3 = new Form("Please Wait");
    StringBuffer sb3 = new StringBuffer();
    
    //Rahma
    
     
    String[] tabB1 = {"Ma fiche", "Offres Missions", "Mes Missions"};
    String[] tabF = {"Ajouter une fiche", "Afficher fiche"};
    String[] tabO = {"Afficher Offre mission"};
    String[] tabM = {"Afficher Mission"};
    Image[] imgR = new Image[3];
    Image image;
    List liste1;
    List liste2;
    List liste3;
    List liste4;
    String adress;
     

    Form ficheajout = new Form("Fiche Baby sitter");

    Form offreaffiche = new Form("Offre Missions");
    Form missionsaffiche = new Form("Mes Missions");
    Form modifierform = new Form("Modifier ma fiche");
    Form SupprimerMissionform = new Form("Supprimer ma mission");
    List lstfiche = new List("Ma fiche", List.IMPLICIT);
    List lstoffre = new List("offres de missions ", List.IMPLICIT);
    List lstmission = new List("Mes missions", List.IMPLICIT);
    Form forminfo = new Form("Infos fiche");
    Form missioninfo = new Form("Infos mission");
    TextField searchbox = new TextField("addresse", "Entrer votre addresse", 100, TextField.ANY);
    Form menumap = new Form("Search Menu");

    Command search = new Command("Search", Command.OK, 0);
    Command cmdNext = new Command("Next", Command.OK, 0);
    Command cmdHome = new Command("Home", Command.OK, 0);
    Command cmdUpdate = new Command("Modifier", Command.SCREEN, 0);
    Command cmdDelete = new Command("Supprimer", Command.SCREEN, 0);
    Command cmdchoix = new Command("Choisir", Command.OK, 0);
    Command cmdmap = new Command("localisation", Command.OK, 0);
    Command cmdConfDelete = new Command("Oui", Command.SCREEN, 0);
    

    //ajoutfiche
    String[] el_sexe = {"Homme", "Femme"};
    String[] el_typeb = {"debutant(e)", "experimente(e)", "Confirme(e)"};
    String[] el_pays = {"Ariana", "Beja", "Benarous", "Bizerte", "Gabes", "Gafsa", "Jendouba", "Kairouan", "Kasserine", "Kebeli", "Mahdia", "Manouba", "Mednine", "Monastir", "Nabeul", "Sfax", "SidiBouzid", "Siliena", "Sousse", "Tataouine", "Tozeur", "Tunis", "Zaghouan"};

    ChoiceGroup cgsexe = new ChoiceGroup("Je suis un(e)", ChoiceGroup.EXCLUSIVE, el_sexe, null);
    ChoiceGroup cgtypeb = new ChoiceGroup("Je suis un(e) babysitter", ChoiceGroup.POPUP, el_typeb, null);
    ChoiceGroup cgpays = new ChoiceGroup("J'habite à ", ChoiceGroup.POPUP, el_pays, null);
    TextField tfmission = new TextField("Nombre de Missions que j'ai réalisé", null, 100, TextField.NUMERIC);
    TextField tfenfants = new TextField("Nombre d'enfants que j'ai gardé", null, 100, TextField.NUMERIC);
    Gauge gtarif = new Gauge("Tarif en DNT", true, 18, 7);
    Gauge gdistance = new Gauge("Distance en KM", true, 50, 5);
    TextField tftelephone = new TextField("Telephone", null, 100, TextField.NUMERIC);
    TextField tfville = new TextField("Ville", null, 100, TextField.ANY);
    TextField tfcodepostal = new TextField("Code postal", null, 100, TextField.NUMERIC);
    TextField tfexperience = new TextField("Décrivez votre experience", null, 500, TextField.ANY);

    //modifier fiche
    ChoiceGroup cgsexe1 = new ChoiceGroup("Je suis un(e)", ChoiceGroup.EXCLUSIVE, el_sexe, null);
    ChoiceGroup cgtypeb1 = new ChoiceGroup("Je suis un(e) babysitter", ChoiceGroup.POPUP, el_typeb, null);
    ChoiceGroup cgpays1 = new ChoiceGroup("J'habite à ", ChoiceGroup.POPUP, el_pays, null);
    TextField tfmission1 = new TextField("Nombre de Missions que j'ai réalisé", null, 100, TextField.NUMERIC);
    TextField tfenfants1 = new TextField("Nombre d'enfants que j'ai gardé", null, 100, TextField.NUMERIC);
    Gauge gtarif1 = new Gauge("Tarif en DNT", true, 18, 7);
    Gauge gdistance1 = new Gauge("Distance en KM", true, 50, 5);
    TextField tftelephone1 = new TextField("Telephone", null, 100, TextField.NUMERIC);
    TextField tfville1 = new TextField("Ville", null, 100, TextField.ANY);
    TextField tfcodepostal1 = new TextField("Code postal", null, 100, TextField.NUMERIC);
    TextField tfexperience1 = new TextField("Décrivez votre experience", null, 500, TextField.ANY);

    Ticker tk = new Ticker("Bienvenue à NOUNOU KIDS");

    Form fo2 = new Form("fiche ajoutée avec succés");
    Form fo3 = new Form("Erreur");
    Form loadingDialog4 = new Form("Please Wait");

    Alert alerta4 = new Alert("Error", "Sorry", null, AlertType.ERROR);
    Alert alertD4 = new Alert("Succes", "Votre fiche a ete modifier", null, AlertType.CONFIRMATION);
    Alert alertD5 = new Alert("Error", "Erreur l'ors de la modification", null, AlertType.ERROR);
    Alert alertA = new Alert("Succes", "Votre fiche a ete ajoutee", null, AlertType.CONFIRMATION);
    Alert alertA1 = new Alert("Error", "Erreur l'ors de l'ajout", null, AlertType.ERROR);
    Alert alertM = new Alert("Succes", "offre ajouté a vos missions de babysitting", null, AlertType.CONFIRMATION);
    Command cmdValider1 = new Command("Valider", Command.SCREEN, 0);
    
    int Index;
    
         
         
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/BabySitterJavaME/ajout.php";
    String url2 = "http://localhost/BabySitterJavaME/login.php";
     String url3 = "http://localhost/BabySitterJavaME/modifier.php";
     String url4 = "http://localhost/BabySitterJavaME/supprimer.php";
     String url5 = "http://localhost/BabySitterJavaME/modifierOffre.php";
     String url6 = "http://localhost/BabySitterJavaME/modifierUser.php";
     String url7 = "http://localhost/BabySitterJavaME/supprimerOffre.php";
     String url8="http://localhost/BabySitterJavaME/ajoutOffre.php";
     String url9="http://localhost/BabySitterJavaME/modifierUser.php";
     
     String urlajout = "http://localhost/BabySitterJavaME/ajoutFiche.php";
    String urlsupp = "http://localhost/BabySitterJavaME/suppression.php";
    String urlmodif = "http://localhost/BabySitterJavaME/modificationfiche.php";
    String urlsupprime = "http://localhost/BabySitterJavaME/supprimermission.php";

   
    int idfiche;
    int idmodif;

    Mission[] missions;
    OffreMission[] offres;
    fichebabysitter[] fiches;
    int i;
     
    StringBuffer sb = new StringBuffer();
    int ch;
    public void startApp() {
        //auth
        form1.addCommand(cmdExit);
        form1.addCommand(cmdLog);
        form1.addCommand(cmdInscri);
        form1.setCommandListener(this);
        
        try {
         img_auth =Image.createImage("/auth.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        imgt_auth = new ImageItem("", img_auth, ImageItem.LAYOUT_CENTER, null);
        form1.append(img_auth);
        form1.append(tf_log_auth);
        form1.append(tf_passw);
        //espace babySitter
        l2.addCommand(cmdBack);
        l2.addCommand(cmdExit);
        l2.setCommandListener(this);
        //Inscri BabySitter
        form3.append(tf_nom);
        form3.append(tf_prenom);
        form3.append(tf_log);
        form3.append(tf_pass);
        form3.append(tf_email);
        form3.append(tf_cin);
        tf_dn.setDate(new Date());
        form3.append(tf_dn);
        form3.append(tf_cp);
        form3.append(tf_add);
        form3.append(tf_tel);
        form3.addCommand(cmdInsc);
        form3.addCommand(cmdExit);
        form3.addCommand(cmdBack);
        form3.setCommandListener(this);
        form4.addCommand(cmdBack);
        form4.addCommand(cmdModif);
        form4.addCommand(cmdSupp);
        form4.setCommandListener(this);
        form5.addCommand(cmdBack);
        form5.setCommandListener(this);
        form6.addCommand(cmdBack);
        form6.setCommandListener(this);
        form7.addCommand(cmdBack);
        form7.setCommandListener(this);
         form8.addCommand(cmdBack);
         form8.addCommand(cmdval);
         form8.append(tf_nom1);
         form8.append(tf_prenom1);
         form8.append(tf_add1);
         form8.append(tf_email1);
         form8.append(tf_cp1);
         form8.append(tf_dn1);
         form8.append(tf_tel1);
         
        form8.setCommandListener(this);
        
        //Asma 
        
         try {
            img[0]=Image.createImage("/ajout.png"); //si on a un nom de package /nompackage/im.jpg
            img[1]=Image.createImage("/afficher.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         
         
        lA=new List("Application Offre Mission",List.IMPLICIT, tabA,null );
        lA.setCommandListener(this);
        lA.setTicker(t2);
        lB=new List("Application Offre Mission",List.IMPLICIT, tabB, img);
        lB.setCommandListener(this);
        lB.addCommand(cmdBack);
       // disp.setCurrent(lA);
         //form ajouterOffre
        ajouterOffre.append(tfDate);
        ajouterOffre.append(tfDesc);
        ajouterOffre.append(tfAdresse);
        ajouterOffre.append(tfHoraire);
        ajouterOffre.addCommand(cmdValider);
        ajouterOffre.setCommandListener(this);
        ajouterOffre.addCommand(cmdBack);
        f2.addCommand(cmdBack);
        f2.setCommandListener(this);
         //afficher Offre
        afficherOffre.append("Cliquer sur Afficher pour afficher la liste des offres");
        afficherOffre.addCommand(cmdParse);
        afficherOffre.setCommandListener(this);
        lst.setCommandListener(this);
        lst.addCommand(cmdBack);
       
        lst.addCommand(cmdSupprimer);
        
        lst.setCommandListener(this);
       
        f4.addCommand(cmdBack);
        f4.addCommand(cmdModifier);
        f4.setCommandListener(this);
        f4.append("Informations offres: \n");
        
        modifierOffre.append(tfDate1);
        modifierOffre.append(tfDesc1);
        modifierOffre.append(tfAdresse1);
        modifierOffre.append(tfHoraire1);
        
        modifierOffre.addCommand(cmdBack);
        modifierOffre.addCommand(cmdValider2);
        modifierOffre.setCommandListener(this);
        
        try {
            img1[0]=Image.createImage("/afficher.png");
             img1[1]=Image.createImage("/afficher.png");
              img1[2]=Image.createImage("/afficher.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         //Menu Administrateur  
     lC=new List("Application Administrateur",List.IMPLICIT, tabC,img1 );
     lC.setCommandListener(this);
     lC.setTicker(t4);
     lC.addCommand(cmdBack);
        listParent.append("Cliquer sur Parents pour afficher");
        listParent.setCommandListener(this);
        lst1.setCommandListener(this);
       
        lst1.addCommand(cmdBack);
        form.addCommand(cmdBack);
        form.addCommand(cmdModifier1);
        form.setCommandListener(this);
        
        
        listBabySitter.append("Cliquer sur Baby Sitters pour afficher");
        
        listBabySitter.setCommandListener(this);
        lst2.setCommandListener(this);
        lst2.addCommand(cmdBack);
        form2.addCommand(cmdBack);
        form2.addCommand(cmdModifier1);
        form2.setCommandListener(this);
       
        listeResponsableGarderie.append("Cliquer sur Responsables Garderie pour afficher");
        
        listeResponsableGarderie.setCommandListener(this);
        lst3.setCommandListener(this);
        lst3.addCommand(cmdBack);
        for3.addCommand(cmdBack);
        for3.addCommand(cmdModifier1);
        for3.setCommandListener(this);
        //Rahma
         try {
            //creation des images

            imgR[0] = Image.createImage("/fiche.png");
            imgR[1] = Image.createImage("/offre.png");
            imgR[2] = Image.createImage("/mission.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //Menu babysitter 
        liste1 = new List("Application Baby sitter", List.IMPLICIT, tabB1, imgR);
        liste1.setCommandListener(this);
        liste1.setTicker(tk);
        liste1.addCommand(cmdHome);
        //Menu fiche
        liste2 = new List("Application Baby sitter", List.IMPLICIT, tabF, null);
        liste2.setCommandListener(this);
        liste2.addCommand(cmdBack);
        //Menu offres missions
        liste3 = new List("Application Baby sitter", List.IMPLICIT, tabO, null);
        liste3.setCommandListener(this);
        liste3.addCommand(cmdBack);
        //Menu missions
        liste4 = new List("Application Baby sitter", List.IMPLICIT, tabM, null);
        liste4.setCommandListener(this);
        liste4.addCommand(cmdBack);
        
        
         
        ficheajout.setTicker(tk);
        ficheajout.append(new Spacer(20, 20));
        ficheajout.append(cgsexe);
        ficheajout.append(cgtypeb);
        ficheajout.append(tfmission);
        ficheajout.append(tfenfants);
        ficheajout.append(gtarif);
        ficheajout.append(gdistance);
        ficheajout.append(tftelephone);
        ficheajout.append(cgpays);
        ficheajout.append(tfville);
        ficheajout.append(tfcodepostal);
        ficheajout.append(tfexperience);
      

        ficheajout.addCommand(cmdValider1);
        ficheajout.addCommand(cmdBack);
        ficheajout.setCommandListener(this);
        fo2.addCommand(cmdBack);
        fo2.setCommandListener(this);

        lstfiche.setCommandListener(this);
        lstfiche.addCommand(cmdBack);
        forminfo.addCommand(cmdBack);
        forminfo.addCommand(cmdDelete);
        forminfo.addCommand(cmdUpdate);

        forminfo.setCommandListener(this);

        //afficher offre mission
        offreaffiche.append("Cliquer sur Afficher pour afficher la liste des offres");
        offreaffiche.addCommand(cmdParse);
        offreaffiche.setCommandListener(this);

        lstoffre.addCommand(cmdBack);
        lstoffre.addCommand(cmdchoix);
        lstoffre.setCommandListener(this);

        modifierform.append(new Spacer(20, 20));
        modifierform.append(cgsexe1);
        modifierform.append(cgtypeb1);
        modifierform.append(tfmission1);
        modifierform.append(tfenfants1);
        modifierform.append(gtarif1);
        modifierform.append(gdistance1);
        modifierform.append(tftelephone1);
        modifierform.append(cgpays1);
        modifierform.append(tfville1);
        modifierform.append(tfcodepostal1);
        modifierform.append(tfexperience1);
        modifierform.addCommand(cmdUpdate);
        modifierform.addCommand(cmdBack);
        modifierform.setCommandListener(this);
        //missions

        missionsaffiche.append("Cliquer sur Afficher pour afficher la liste des missions");
        missionsaffiche.addCommand(cmdParse);
        missionsaffiche.setCommandListener(this);

        lstmission.setCommandListener(this);
        lstmission.addCommand(cmdBack);
        missioninfo.addCommand(cmdBack);
        missioninfo.addCommand(cmdmap);
        missioninfo.addCommand(cmdDelete);

        missioninfo.setCommandListener(this);
        SupprimerMissionform.append("Voulez vous varaiment supprimer cette mission");
        SupprimerMissionform.addCommand(cmdConfDelete);
        SupprimerMissionform.addCommand(cmdBack);
        SupprimerMissionform.setCommandListener(this);

        menumap.addCommand(search);
        menumap.append(searchbox);
        menumap.setCommandListener(this);

      //  disp.setCurrent(liste1);
        
        
        
        
        disp.setCurrent(new SplashScreen(this));
        
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {

         if(c==cmdExit)
        {
           
            notifyDestroyed();
        }
        if(c==cmdLog)
        {
         Thread t =new Thread(new Runnable() {

                public void run() {
                    auth();             }
            });
         t.start();
        } 
         if(c==cmdInscri)
        {
        disp.setCurrent(form3);
        } 
          if(c==cmdModif && d==form4)
        {
            tf_nom1.setString(user.getNom());
            tf_prenom1.setString(user.getPrenom());
            tf_add1.setString(user.getAdresse());
            tf_cp1.setString(String.valueOf(user.getCodePostale()) );
            tf_email1.setString(user.getEmail());
            tf_tel1.setString(String.valueOf(user.getTelephone()));
            tf_dn1.setDate(tf_dn.getDate());
        disp.setCurrent(form8);
        } 
        
          if(c==cmdBack && d==form8)
        {
            disp.setCurrent(form4);
        } 
        if(c==cmdBack && d==form4)
        {
           form4.deleteAll();
        disp.setCurrent(l2);
        }
        if(c==cmdInsc){
          Thread t =new Thread(new Runnable() {

                public void run() {
                    ajoutB();             }
            });
         t.start();
        }
        if(d==l2){
         if(c==List.SELECT_COMMAND){
             if("Mon Compte".equals(l2.getString(l2.getSelectedIndex()))){
                 form4.append(showInfoBaby());
                 disp.setCurrent(form4);}
         if("Mon Espace".equals(l2.getString(l2.getSelectedIndex()))){
               
                 disp.setCurrent(liste1);}
         
         
                                      }
         if(c==cmdBack){
             tf_log_auth.setString("");
             tf_passw.setString("");
             disp.setCurrent(form1);
                       }
                 }
          if(c==cmdval)
        {
        Thread t =new Thread(new Runnable() {

                public void run() {
           modif();             }
            });
         t.start();
         
        }
           if(c==cmdSupp)
        {
               Thread t =new Thread(new Runnable() {

                public void run() {
                    supp();
                }});
                    t.start();
         
        }
           if(c==cmdBack && d==form3){
               
               disp.setCurrent(form1);
           }
           
           //Asma
           
                if(c==List.SELECT_COMMAND & d==lA){
             if("Offre Mission".equals(lA.getString(lA.getSelectedIndex())))
             {disp.setCurrent(lB);}
          }
             if(c==List.SELECT_COMMAND & d==lB){
             if("AjouterOffre".equals(lB.getString(lB.getSelectedIndex())))
             {disp.setCurrent(ajouterOffre);}
             
              
             
            
             if("AfficherOffre".equals(lB.getString(lB.getSelectedIndex())))
             {            disp.setCurrent(loadingDialog);
            Thread th = new Thread(new Runnable() {

                public void run() {
                    try{
            
            OffreMissionHandler offreMissionHandler = new OffreMissionHandler();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
             HttpConnection hc = (HttpConnection) Connector.open("http://localhost/BabySitterJavaME/getXmlOffre_Attributes.php"+"?id="+user.getId());
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, offreMissionHandler);
            
           offremission=offreMissionHandler.getOffreMission();
            if(offremission.length>0){
                for (int i = 0; i < offremission.length; i++) {
                    lst.append(offremission[i].getNumOffre()+""
                      + offremission[i].getDate()+""
                       +offremission[i].getDescription()+""
                       +offremission[i].getAdresse()+""
                        +offremission[i].getHoraire(),null);
                }
            }
            
        }
       catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(lst); 
         
                }
                
            });
            th.start();
             lst.deleteAll();}
             }
         
            if(c==cmdBack &d==lst)
             {
             disp.setCurrent(lB);
             } 
             if(c==cmdBack &d==lB)
             {
             disp.setCurrent(lA);
             }
        if (c == cmdValider) {
            Thread th = new Thread(new Runnable() {

                public void run() {
  try {
            Calendar cal= Calendar.getInstance();
            cal.setTime(tfDate.getDate());
            String date = cal.get(Calendar.YEAR) + "-" + ( cal.get(Calendar.MONTH) + 1 ) + "-" + cal.get(Calendar.DAY_OF_MONTH);
                hc = (HttpConnection) Connector.open(url8+"?date="+date+"&description="+tfDesc.getString().trim()+"&adresse="+tfAdresse.getString().trim()+"&horaire="+tfHoraire.getString().trim()+"&id="+user.getId());
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char)ch);
                }
                if ("OK".equals(sb.toString().trim())) {
                    disp.setCurrent(alertD);
                }else{
                    disp.setCurrent(alerta);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
                }
            });
            th.start();
        }
        
        if (c == cmdBack & d==ajouterOffre) {
            
            disp.setCurrent(lB);
        }
       
        if (c == cmdBack & d==f2) {
            
            disp.setCurrent(ajouterOffre);
        }
        if (c == cmdBack & d==f4) {
            
            disp.setCurrent(lst);
            f4.deleteAll();
            f4.append("Informations offres: \n");
        }
        
    

        if (c == List.SELECT_COMMAND & d==lst) {
            
            f4.append(showOffre(lst.getSelectedIndex()));
            disp.setCurrent(f4);
            
        }
if (c==cmdSupprimer)
{    
    supprimerOffreMission(lst.getSelectedIndex());
    //disp.setCurrent(lst);
}
if (c==cmdBack & d==modifierOffre)
{
       
           disp.setCurrent(f4);
           
}
if(c==cmdModifier & d==f4){
     tfDesc1.setString(offremission[lst.getSelectedIndex()].getDescription());
     tfAdresse1.setString(offremission[lst.getSelectedIndex()].getAdresse()); 
     tfHoraire1.setString(offremission[lst.getSelectedIndex()].getHoraire());
     tfDate1.setDate(tfDate.getDate());
     Index=lst.getSelectedIndex();
     disp.setCurrent(modifierOffre);
}
if(c==cmdValider2 & d==modifierOffre)
{
       try {
               Calendar cal= Calendar.getInstance();
               cal.setTime(tfDate1.getDate());
               String date = cal.get(Calendar.YEAR) + "-" + ( cal.get(Calendar.MONTH) + 1 ) + "-" + cal.get(Calendar.DAY_OF_MONTH);
                hc = (HttpConnection) Connector.open(url5+"?date="+date+"&description="+tfDesc1.getString().trim()
                +"&adresse="+tfAdresse1.getString().trim()+"&horaire="+tfHoraire1.getString().trim()+"&numOffre="+offremission[Index].getNumOffre());
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char)ch);
                }
                if ("OK".equals(sb.toString().trim())) {
                    disp.setCurrent(alertD1);
                }else{
                    disp.setCurrent(alerta1);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
}

 if (c == List.SELECT_COMMAND & d==lst1) {
            form.append("Informations Parents: \n");
            form.append(showParent(lst1.getSelectedIndex()));
             form.append(etat);
            disp.setCurrent(form);
        }

        if (c==cmdBack & d==form) {
            form.deleteAll();
            disp.setCurrent(lst1);
        }
        
        

        if (c == List.SELECT_COMMAND & d==lst2) {
            form2.append("Informations Baby Sitters: \n");
            form2.append(showBabySitter(lst2.getSelectedIndex()));
            form2.append(etat);
            disp.setCurrent(form2);
        }

        if (c == cmdBack & d==form2) {
            form2.deleteAll();
            disp.setCurrent(lst2);
        }
        

        if (c == List.SELECT_COMMAND & d==lst3) {
            for3.append("Informations Responsables Garderie: \n");
            for3.append(showResponsableGarderie(lst3.getSelectedIndex()));
            for3.append(etat);
            disp.setCurrent(for3);
        }

        if (c == cmdBack & d==for3) {
            for3.deleteAll();
            disp.setCurrent(lst3);
        }
        if (c == cmdBack & (d==lst1 ||d==lst2 ||d==lst3 ) ) {
            lst1.deleteAll();
            lst2.deleteAll();
            lst3.deleteAll();
            disp.setCurrent(lC);
        }
        if(c==cmdModifier1 & d==form)
        {
            new Thread(new Runnable() {

                public void run() {
                try {
                    System.out.println("id :"+parent[id].getId());
                    System.out.println("etat :"+etat.getString().trim());
                    
                        hc = (HttpConnection) Connector.open("http://localhost/BabySitterJavaME/modifierUser.php"+ "?etat=" + etat.getString().trim()+"&id=" + parent[id].getId() );
                        dis = new DataInputStream(hc.openDataInputStream());
                        while ((ch = dis.read()) != -1) {
                            sb.append((char) ch);
                        }
                        if ("OK".equals(sb.toString().trim())) {
                            disp.setCurrent(alertD3);
                        } else {
                            disp.setCurrent(alerta3);
                        }
                        sb = new StringBuffer();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();
            
        }
        if(c==cmdModifier1 & d==form2)
        {
           new Thread(new Runnable() {

               public void run() {

              try {
                    System.out.println("id :"+babysitter[id].getId());
                    System.out.println("etat :"+etat.getString().trim());
                    
                        hc = (HttpConnection) Connector.open("http://localhost/BabySitterJavaME/modifierUser.php"+ "?etat=" + etat.getString().trim()+"&id=" + babysitter[id].getId() );
                        dis = new DataInputStream(hc.openDataInputStream());
                        while ((ch = dis.read()) != -1) {
                            sb.append((char) ch);
                        }
                        if ("OK".equals(sb.toString().trim())) {
                            disp.setCurrent(alertD3);
                        } else {
                            disp.setCurrent(alerta3);
                        }
                        sb = new StringBuffer();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();
            
        }
        if(c==cmdModifier1 & d==for3)
        {
           new Thread(new Runnable() {

               public void run() {
                   
              try {
                    System.out.println("id :"+responsablegarderie[id].getId());
                    System.out.println("etat :"+etat.getString().trim());
                    
                        hc = (HttpConnection) Connector.open("http://localhost/BabySitterJavaME/modifierUser.php"+ "?etat=" + etat.getString().trim()+"&id=" + responsablegarderie[id].getId() );
                        dis = new DataInputStream(hc.openDataInputStream());
                        while ((ch = dis.read()) != -1) {
                            sb.append((char) ch);
                        }
                        if ("OK".equals(sb.toString().trim())) {
                            disp.setCurrent(alertD3);
                        } else {
                            disp.setCurrent(alerta3);
                        }
                        sb = new StringBuffer();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();
            
        }
        if(c==List.SELECT_COMMAND & d==lC){
             if("Parent".equals(lC.getString(lC.getSelectedIndex())))
             { disp.setCurrent(loadingDialog1);
            Thread th = new Thread(new Runnable() {

                public void run() {
                      try{
            
            UserHandler parentHandler = new UserHandler();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
             HttpConnection hc = (HttpConnection) Connector.open("http://localhost/BabySitterJavaME/getXmlParent_Attributes.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, parentHandler);
            
           parent=parentHandler.getUser();
            if(parent.length>0){
                for (int i = 0; i < parent.length; i++) {
                    lst1.append(parent[i].getId()+""
                      + parent[i].getNom()+""
                       +parent[i].getPrenom()+""
                       +parent[i].getDateNaissance()+""
                       +parent[i].getCin()+""
                       +parent[i].getAdresse()+""
                       +parent[i].getCodePostale()+""
                       +parent[i].getTelephone()+""
                      // +parent[i].getNbreEnfant()+""
                       +parent[i].getType()+""
                       +parent[i].getEtat()+"",null);
                       //+parent[i].getNote(),null);
                }
            }
            
        }
       catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(lst1);
                }
            });
            th.start();
        }
             if("Baby Sitter".equals(lC.getString(lC.getSelectedIndex())))
             {            
                 disp.setCurrent(loadingDialog2);
            Thread th = new Thread(new Runnable() {

                public void run() {
try{
            
            UserHandler babySitterHandler = new UserHandler();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
             HttpConnection hc = (HttpConnection) Connector.open("http://localhost/BabySitterJavaME/getXmlBs_Attributes.php");
             DataInputStream dis = new DataInputStream(hc.openDataInputStream());
             parser.parse(dis, babySitterHandler);
            
           babysitter=babySitterHandler.getUser();
            if(babysitter.length>0){
                for (int i = 0; i < babysitter.length; i++) {
                    lst2.append(babysitter[i].getId()+""
                      + babysitter[i].getNom()+""
                       +babysitter[i].getPrenom()+""
                       +babysitter[i].getDateNaissance()+""
                       +babysitter[i].getCin()+""
                       +babysitter[i].getAdresse()+""
                       +babysitter[i].getCodePostale()+""
                       +babysitter[i].getTelephone()+""
                       +babysitter[i].getType()+""
                       +babysitter[i].getEtat(),null);
                }
            }
            
        }
       catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
                 disp.setCurrent(lst2);                 }
            });
            th.start();}
             if("Responsable Garderie".equals(lC.getString(lC.getSelectedIndex())))
             {            disp.setCurrent(loadingDialog3);
            Thread th = new Thread(new Runnable() {

                public void run() {
                    try{
            
            UserHandler responsableGarderieHandler = new UserHandler();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
             HttpConnection hc = (HttpConnection) Connector.open("http://localhost/BabySitterJavaME/getXmlRG_Attributes%20.php");
             DataInputStream dis = new DataInputStream(hc.openDataInputStream());
             parser.parse(dis, responsableGarderieHandler);
            
           responsablegarderie=responsableGarderieHandler.getUser();
            if(responsablegarderie.length>0){
                for (int i = 0; i < responsablegarderie.length; i++) {
                    lst3.append(responsablegarderie[i].getId()+""
                      + responsablegarderie[i].getNom()+""
                       +responsablegarderie[i].getPrenom()+""
                       +responsablegarderie[i].getDateNaissance()+""
                       +responsablegarderie[i].getCin()+""
                       +responsablegarderie[i].getAdresse()+""
                       +responsablegarderie[i].getCodePostale()+""
                       +responsablegarderie[i].getTelephone()+""
                       +responsablegarderie[i].getType()+""
                       +responsablegarderie[i].getEtat(),null);
                }
            }
            
        }
       catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
                   disp.setCurrent(lst3); 
                }
            });
            th.start();}
           }
        //Rahma
        
         if (c == List.SELECT_COMMAND & d == liste1) {
            if ("Ma fiche".equals(liste1.getString(liste1.getSelectedIndex()))) {
                disp.setCurrent(liste2);
            }
            if ("Offres Missions".equals(liste1.getString(liste1.getSelectedIndex()))) {
                disp.setCurrent(liste3);
            }
            if ("Mes Missions".equals(liste1.getString(liste1.getSelectedIndex()))) {
                disp.setCurrent(liste4);
            }
        }
        if (c == List.SELECT_COMMAND & d == liste2) {
            if ("Ajouter une fiche".equals(liste2.getString(liste2.getSelectedIndex()))) {
                disp.setCurrent(ficheajout);
            }

            if ("Afficher fiche".equals(liste2.getString(liste2.getSelectedIndex()))) {
                disp.setCurrent(lstfiche);
                Thread t = new Thread(new Runnable() {
                    public void run() {
                        afficherfiche();
                    }
                });
                t.start();
                lstfiche.deleteAll();
                forminfo.deleteAll();

            }
        }
        if (c == cmdBack & d == lstfiche) {
            disp.setCurrent(liste2);
        }
        if (c == List.SELECT_COMMAND & d == liste3) {
            if ("Afficher Offre mission".equals(liste3.getString(liste3.getSelectedIndex()))) {
                disp.setCurrent(offreaffiche);
            }
        }
        if (c == List.SELECT_COMMAND & d == liste4) {
            if ("Afficher Mission".equals(liste4.getString(liste4.getSelectedIndex()))) {
                disp.setCurrent(missionsaffiche);
            }
        }
        if (c == cmdHome && d == liste1) {
            disp.setCurrent(form1);
        }

        if (c == cmdBack & d == liste2) {
            disp.setCurrent(liste1);
        }
        if (c == cmdBack & d == liste3) {
            disp.setCurrent(liste1);
        }
        if (c == cmdBack & d == liste4) {
            disp.setCurrent(liste1);
        }
        if (c == cmdBack & d == ficheajout) {
            disp.setCurrent(liste2);
        }
        if (c == cmdBack & d == forminfo) {
            disp.setCurrent(liste2);
            forminfo.deleteAll();
            lstfiche.deleteAll();
        }

        if (c == cmdValider1 & d==ficheajout) {
            Thread th = new Thread(this);
            th.start();
        }

        if (c == cmdDelete && d == forminfo) {

            Thread t = new Thread(new Runnable() {

                public void run() {
                    supprimerFiche(i);
                }
            });
            t.start();
            forminfo.deleteAll();
            lstfiche.deleteAll();
            disp.setCurrent(lstfiche);
        }

        if (c == cmdBack && d == fo2) {

            disp.setCurrent(liste2);

        }
        if (c == cmdBack && d == lstfiche) {

            disp.setCurrent(liste2);

        }

        if (c == List.SELECT_COMMAND && d == lstfiche) {
            forminfo.append("Détails de ma fiche: \n");
            forminfo.append(showfiche(lstfiche.getSelectedIndex()));
            idmodif = lstfiche.getSelectedIndex();
            disp.setCurrent(forminfo);
        }

        if (c == cmdUpdate && d == forminfo) {

            disp.setCurrent(modifierform);
            modifierform.append(modiffiche(idmodif));

        }
        if (c == cmdBack & d == modifierform) {
            disp.setCurrent(forminfo);
        }
        if (c == cmdUpdate & d == modifierform) {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    modifierfiche();
                }
            });
            t.start();
        }
        if (c == cmdBack && d == lstfiche) {
            disp.setCurrent(liste2);
            lstfiche.deleteAll();
        }
        if (c == cmdParse && d == offreaffiche) {
            disp.setCurrent(loadingDialog4);
            Thread t = new Thread(new Runnable() {
                public void run() {
                    afficheroffre();
                }
            });
            t.start();
        }
        if (c == cmdParse && d == missionsaffiche) {
            disp.setCurrent(loadingDialog4);
            Thread t = new Thread(new Runnable() {
                public void run() {
                    affichermission();
                }
            });
            t.start();
        }
        if (c == List.SELECT_COMMAND && d == lstmission) {
            missioninfo.append("Détails de ma mission: \n");
            missioninfo.append(showmission(lstmission.getSelectedIndex()));

            disp.setCurrent(missioninfo);
        }

        if (c == cmdBack && d == lstoffre) {
            disp.setCurrent(liste3);
            lstoffre.deleteAll();
        }
        if (c == cmdchoix && d == lstoffre) {

            Thread t = new Thread(new Runnable() {
                public void run() {
                    System.out.println(lstoffre.getSelectedIndex());
                    choisiroffre(lstoffre.getSelectedIndex());
                }
            });
            t.start();
            disp.setCurrent(alertM);

        }
        if (c == cmdBack & d == lstmission) {
            disp.setCurrent(liste4);
            lstmission.deleteAll();
        }
        if (c == cmdBack & d == missioninfo) {
            disp.setCurrent(lstmission);
            missioninfo.deleteAll();
        }
        if (c == cmdmap) {
            // disp.setCurrent(new GoogleMapsSimpleCanvas(this, d));
            disp.setCurrent(menumap);
        }
        if (c == search & d == menumap) {
            //disp.setCurrent(new GoogleMapsMarkerCanvas(this, d));

        }

        if (c == cmdDelete && d == missioninfo) {

            disp.setCurrent(SupprimerMissionform);
        }
        if (c == cmdConfDelete && d == SupprimerMissionform) {
            Thread t = new Thread(new Runnable() {

                public void run() {
                    supprimerMission(i);

                }
            });
            t.start();
            missioninfo.deleteAll();
            lstmission.deleteAll();
            disp.setCurrent(lstmission);
        }
        if (c == cmdBack & d == SupprimerMissionform) {
            disp.setCurrent(lstmission);
            missioninfo.deleteAll();
        }
           
    }
public void ajoutB() {
        try {
            Calendar cal= Calendar.getInstance();
             cal.setTime(tf_dn.getDate());
                 String date = cal.get(Calendar.YEAR) + "-" + ( cal.get(Calendar.MONTH) + 1 ) + "-" + cal.get(Calendar.DAY_OF_MONTH);
                hc = (HttpConnection) Connector.open(url+"?nom="+tf_nom.getString().trim()+"&prenom="+tf_prenom.getString().trim()+"&log="+tf_log.getString().trim()+"&pass="+tf_pass.getString().trim()+"&email="+tf_email.getString().trim()+"&cin="+tf_cin.getString().trim()+"&add="+tf_add.getString().trim()+"&cp="+tf_cp.getString().trim()+"&dn="+date+"&tel="+tf_tel.getString().trim());
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char)ch);
                }
                if ("OK".equals(sb.toString().trim())) {
                   
                    disp.setCurrent(alin,form1);
                }else{
                    disp.setCurrent(al,form3);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
                  
            }
    }
public void modif() {
        try {
            Calendar cal= Calendar.getInstance();
            cal.setTime(tf_dn1.getDate());
            String date = cal.get(Calendar.YEAR) + "-" + ( cal.get(Calendar.MONTH) + 1 ) + "-" + cal.get(Calendar.DAY_OF_MONTH);
                hc = (HttpConnection) Connector.open(url3+"?nom="+tf_nom1.getString().trim()+"&prenom="+tf_prenom1.getString().trim()+"&email="+tf_email1.getString().trim()+"&add="+tf_add1.getString().trim()+"&cp="+tf_cp1.getString().trim()+"&dn="+date+"&tel="+tf_tel1.getString().trim()+"&id="+user.getId());
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char)ch);
                }
                if ("OK".equals(sb.toString().trim())) {
                    disp.setCurrent(alm,l2);
                }else{
                    disp.setCurrent(al);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
                  
            }
    }
public void supp() {
        try {
           
                hc = (HttpConnection) Connector.open(url4+"?id="+user.getId());
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char)ch);
                }
                if ("OK".equals(sb.toString().trim())) {
                    
                    disp.setCurrent(form1);
                }else{
                    disp.setCurrent(al);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
                  
            }
    }

public void auth(){
 try {
                        UserHandler clientHand = new UserHandler();
                        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
                         hc = (HttpConnection) Connector.open(url2+"?login="+tf_log_auth.getString().trim()+"&password="+tf_passw.getString().trim());
                        dis = new DataInputStream(hc.openDataInputStream());
                        parser.parse(dis, clientHand);
                        users = clientHand.getUser();
                        if (users.length != 0) {
                            user = users[0];
                           if("BabySitter".equals(users[0].getType())){
                            Ticker tk=new Ticker("bienvenu"+" "+user.getPrenom()); 
                            l2.setTicker(tk);
                            disp.setCurrent(l2);
                           }else if("Parent".equals(users[0].getType())){
                            Ticker tk=new Ticker("bienvenu"+" "+user.getPrenom()); 
                            form5.setTicker(tk);
                            disp.setCurrent(lA);
                           }else if("ResponsableGarderie".equals(users[0].getType())){
                            Ticker tk=new Ticker("bienvenu"+" "+user.getPrenom()); 
                            form6.setTicker(tk);
                            disp.setCurrent(form6);
                           }else if("Admin".equals(users[0].getType())){
                            Ticker tk=new Ticker("bienvenu"+" "+user.getPrenom()); 
                            form7.setTicker(tk);
                            disp.setCurrent(lC);
                           }
                            

                        } else {
                            Alert al = new Alert("ERROR", "verifiez vos données", null, AlertType.INFO);
                            disp.setCurrent(al);
                        }

                    } catch (Exception e) {
                        disp.setCurrent(new Alert("Error", "Impossible d'etablir la connection", null, AlertType.ERROR));
                    }

    }
 private String showInfoBaby() {
        
     String res = "";
       

            sb.append("*Prenom: ");
            sb.append(users[0].getPrenom());
            sb.append("\n");
            sb.append("*Nom: ");
            sb.append(users[0].getNom());
            sb.append("\n");
            sb.append("*Login: ");
            sb.append(users[0].getLogin());
            sb.append("\n");
            sb.append("*Email: ");
            sb.append(users[0].getEmail());
            sb.append("\n");
             sb.append("*Cin: ");
            sb.append(users[0].getCin());
            sb.append("\n");
            sb.append("*Date Naissance: ");
            sb.append(users[0].getDateNaissance());
            sb.append("\n");
            sb.append("*Adresse: ");
            sb.append(users[0].getAdresse());
            sb.append("\n");
            sb.append("*Code Postale: ");
            sb.append(users[0].getCodePostale());
            sb.append("\n");
            sb.append("*Note: ");
            sb.append(users[0].getNote());
            sb.append("\n");
           
            
        
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }

public class SplashScreen extends Canvas implements Runnable {
    private Image mImage;
    private MidletBabySitter midletBaby;
  
    public SplashScreen(MidletBabySitter midletBaby){
        this.midletBaby = midletBaby;
        try{
        mImage = Image.createImage("/babysitter.jpg");
        Thread t = new Thread(this);
        t.start();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Paints the image centered on the screen.
     */
    public void paint(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        //set background color to overdraw what ever was previously displayed
        g.setColor(0x000000);
        g.fillRect(0,0, width, height);
        g.drawImage(mImage, width / 2, height / 2,
                Graphics.HCENTER | Graphics.VCENTER);
    }
    /**
     * Dismisses the splash screen with a key press or a pointer press
     */
    public void dismiss() {
        if (isShown())
            Display.getDisplay(midletBaby).setCurrent(form1);

    }
    /**
     * Default timeout with thread
     */
    public void run() {
        try {
            Thread.sleep(6000);//set for 3 seconds
        }
        catch (InterruptedException e) {
            System.out.println("InterruptedException");
            e.printStackTrace();
        }
        dismiss();
    }

}
  //Asma

private String showOffre(int i){
        String res = "";
        if (offremission.length>0) {
            sb4.append("*");
            sb4.append(offremission[i].getNumOffre());
            sb4.append("\n");
            
            sb4.append("*");
            sb4.append(offremission[i].getDate());
            sb4.append("\n");
            
            sb4.append("* ");
            sb4.append(offremission[i].getDescription());
            sb4.append("\n");
            
            sb4.append("*");
            sb4.append(offremission[i].getAdresse());
            sb4.append("\n");
            
            sb4.append("*");
            sb4.append(offremission[i].getHoraire());
            sb4.append("\n");
        }
        
         res = sb4.toString();
         sb4 = new StringBuffer("");
         return res;
    }
     
     
     
     
     private void supprimerOffreMission(int i) {
        try {
                 
                
                hc = (HttpConnection) Connector.open(url7+"?numOffre="+offremission[i].getNumOffre());
                dis = new DataInputStream(hc.openDataInputStream());    
                  while ((ch = dis.read()) != -1) {
                    sb.append((char)ch);
                }
                if ("OK".equals(sb.toString().trim())) {
                    lst.delete(i);
                    disp.setCurrent(lst);
                     disp.setCurrent(alertD2);
                   
                }else{
                    
                    disp.setCurrent(lst);
                     disp.setCurrent(alertD2);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            } 
     
     private String showParent(int i){
        String res = "";
        if (parent.length>0) {
            
             id = i;
            
            sb1.append("Nom:");
            sb1.append(parent[i].getNom());
            sb1.append("\n");
            
            sb1.append("Prenom:");
            sb1.append(parent[i].getPrenom());
            sb1.append("\n");
            
            sb1.append("Date de naissance:");
            sb1.append(parent[i].getDateNaissance());
            sb1.append("\n");
            
            sb1.append("CIN:");
            sb1.append(parent[i].getCin());
            sb1.append("\n");
            
            sb1.append("Adresse:");
            sb1.append(parent[i].getAdresse());
            sb1.append("\n");
            
            sb1.append("Code postale:");
            sb1.append(parent[i].getCodePostale());
            sb1.append("\n");
            
            sb1.append("Telephone:");
            sb1.append(parent[i].getTelephone());
            sb1.append("\n");
            
            sb1.append("Nombre d'enfant:");
            //sb1.append(parent[i].getNbreEnfant());
            sb1.append("\n");
            
            sb1.append("Type d'utilisateur:");
            sb1.append(parent[i].getType());
            sb1.append("\n");
            
            
            
            etat.setString("" + parent[i].getEtat());
            
            sb1.append("Note de Baby Sitter:");
            //sb1.append(parent[i].getNote());
            sb1.append("\n");
            
        }
        
         res = sb1.toString();
         sb1 = new StringBuffer("");
         return res;
    }

private String showBabySitter(int i){
        String res = "";
        if (babysitter.length>0) {
            
           id = i;
            
            sb2.append("Nom: ");
            sb2.append(babysitter[i].getNom());
            sb2.append("\n");
            
            sb2.append("Prenom: ");
            sb2.append(babysitter[i].getPrenom());
            sb2.append("\n");
            
            sb2.append("Date de naissance: ");
            sb2.append(babysitter[i].getDateNaissance());
            sb2.append("\n");
            
            sb2.append("CIN: ");
            sb2.append(babysitter[i].getCin());
            sb2.append("\n");
            
            sb2.append("Adresse: ");
            sb2.append(babysitter[i].getAdresse());
            sb2.append("\n");
            
            sb2.append("Code postale: ");
            sb2.append(babysitter[i].getCodePostale());
            sb2.append("\n");
            
            sb2.append("Telephone: ");
            sb2.append(babysitter[i].getTelephone());
            sb2.append("\n");
            
            
            
            sb2.append("Type d'utilisateur: ");
            sb2.append(babysitter[i].getType());
            sb2.append("\n");
             
            sb2.append("Note: ");
            sb2.append(babysitter[i].getNote());
            sb2.append("\n");
            
            etat.setString("" + babysitter[i].getEtat());
            
            
            
        }
        
         res = sb2.toString();
         sb2 = new StringBuffer("");
         return res;
    }

private String showResponsableGarderie(int i){
        String res = "";
        if (responsablegarderie.length>0) {
            
            id = i;
            
            sb3.append("Nom: ");
            sb3.append(responsablegarderie[i].getNom());
            sb3.append("\n");
            
            sb3.append("Prenom: ");
            sb3.append(responsablegarderie[i].getPrenom());
            sb3.append("\n");
            
            sb3.append("Date de naissance: ");
            sb3.append(responsablegarderie[i].getDateNaissance());
            sb3.append("\n");
            
            sb3.append("CIN: ");
            sb3.append(responsablegarderie[i].getCin());
            sb3.append("\n");
            
            sb3.append("Adresse: ");
            sb3.append(responsablegarderie[i].getAdresse());
            sb3.append("\n");
            
            sb3.append("Code postale: ");
            sb3.append(responsablegarderie[i].getCodePostale());
            sb3.append("\n");
            
            sb3.append("Telephone: ");
            sb3.append(responsablegarderie[i].getTelephone());
            sb3.append("\n");
            
            
            
            sb3.append("Type d'utilisateur: ");
            sb3.append(responsablegarderie[i].getType());
            sb3.append("\n");
            
            etat.setString("" + responsablegarderie[i].getEtat());
            
            
            
        }
        
         res = sb3.toString();
         sb3 = new StringBuffer("");
         return res;
    }
               //Rahma
public void run() {
        try {
            hc = (HttpConnection) Connector.open(urlajout+"?typeb="+cgtypeb.getString(cgtypeb.getSelectedIndex()).trim()+ "&sexe=" + cgsexe.getString(cgsexe.getSelectedIndex())+ "&nbmissions=" + tfmission.getString().trim()+ "&nbenfants=" + tfenfants.getString().trim() + "&tarif=" + gtarif.getValue()+ "&distance=" + gdistance.getValue() + "".trim() + "&experience=" + tfexperience.getString().trim()+ "&pays=" + cgpays.getString(cgpays.getSelectedIndex()).trim()+ "&telephone=" + tftelephone.getString().trim() + "&ville=" + tfville.getString().trim()+ "&codepostal=" + tfcodepostal.getString().trim());
           dis = new DataInputStream(hc.openDataInputStream());//recupere flux entrant 
            while ((ch = dis.read()) != -1) {// ta9ra un caratére 
                sb.append((char) ch); //convrtir char 
            }
            if ("OK".equals(sb.toString().trim())) { //trim pour supprimer les espaces 
                disp.setCurrent(alertA);
            } else {
                disp.setCurrent(alertA1);
            }
            sb = new StringBuffer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void afficherfiche() {
        try {
            // this will handle our XML
            fichebabysitterHandler fichesHandler = new fichebabysitterHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
             hc = (HttpConnection) Connector.open("http://localhost/BabySitterJavaME/getXmlFiche_Attributes.php");
             dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, fichesHandler);
            // display the result
            fiches = fichesHandler.getFichebabysitter();

            if (fiches.length > 0) {
                for (int i = 0; i < fiches.length; i++) {
                    lstfiche.append(
                            fiches[i].getTypeb() + "  "
                            + fiches[i].getSexe() + "  "
                            + fiches[i].getNbmissions() + "   "
                            + fiches[i].getNbenfants() + "   "
                            + fiches[i].getTarif() + "   "
                            + fiches[i].getDistance() + "   "
                            + fiches[i].getTelephone() + "  "
                            + fiches[i].getPays() + "  "
                            + fiches[i].getVille() + "  "
                            + fiches[i].getCodepostal() + "  "
                            + fiches[i].getExperience(), null);

                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(lstfiche);
    }

    private String showfiche(int i) {
        String res = "";
        if (fiches.length > 0) {
            sb.append("* ");
            sb.append("je suis un(e) babysitter : " + fiches[i].getTypeb());
            sb.append("\n");
            sb.append("* ");
            sb.append("je suis un(e)  : " + fiches[i].getSexe());
            sb.append("\n");
            sb.append("* ");
            sb.append("nombre missions que j'ai réalisé  : " + fiches[i].getNbmissions());
            sb.append("\n");
            sb.append("* ");
            sb.append("nombre enfants que j'ai gardé  : " + fiches[i].getNbenfants());
            sb.append("\n");
            sb.append("* ");
            sb.append("Distance que j'accepte parcourir  : " + fiches[i].getDistance() + "KM");
            sb.append("\n");
            sb.append("* ");
            sb.append("tarif : " + fiches[i].getTarif() + "DNT par heure");
            sb.append("\n");
            sb.append("* ");
            sb.append("Telephone  : " + fiches[i].getTelephone());
            sb.append("\n");
            sb.append("* ");
            sb.append("Pays  : " + fiches[i].getPays());
            sb.append("\n");
            sb.append("* ");
            sb.append("Ville  : " + fiches[i].getVille());
            sb.append("\n");
            sb.append("* ");
            sb.append("code postal : " + fiches[i].getCodepostal());
            sb.append("\n");
            sb.append("* ");
            sb.append("Experience : " + fiches[i].getExperience());
            sb.append("\n");
        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }

    private void supprimerFiche(int i) {
        try {

            hc = (HttpConnection) Connector.open(urlsupp + "?id=" + fiches[i].getIdfiche());
            dis = new DataInputStream(hc.openDataInputStream());
            while ((ch = dis.read()) != -1) {
                sb.append((char) ch);
            }
            if ("OK".equals(sb.toString().trim())) {
                lstfiche.delete(i);

                System.out.println("m");

            } else {
                disp.setCurrent(fo3);
                System.out.println("no");
            }
            sb = new StringBuffer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void modifierfiche() {

        try {
            hc = (HttpConnection) Connector.open(urlmodif
                    + "?typeb=" + cgtypeb1.getString(cgtypeb1.getSelectedIndex()).trim()
                    + "&nbmissions=" + tfmission1.getString().trim()
                    + "&nbenfants=" + tfenfants1.getString().trim()
                    + "&tarif=" + gtarif1.getValue() + "".trim()
                    + "&distance=" + gdistance1.getValue() + "".trim()
                    + "&experience=" + tfexperience1.getString().trim()
                    + "&sexe=" + cgsexe1.getString(cgsexe1.getSelectedIndex()).trim()
                    + "&telephone=" + tftelephone1.getString().trim()
                    + "&ville=" + tfville1.getString().trim()
                    + "&codepostal=" + tfcodepostal1.getString().trim()
                    + "&pays=" + cgpays1.getString(cgpays1.getSelectedIndex()).trim()
                    + "&id=" + fiches[i].getIdfiche());

            dis = new DataInputStream(hc.openDataInputStream());
            while ((ch = dis.read()) != -1) {
                sb.append((char) ch);
            }
            if ("OK".equals(sb.toString().trim())) {
                disp.setCurrent(alertD4);
            } else {
                disp.setCurrent(alertD5);
            }
            sb = new StringBuffer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void afficheroffre() {
        try {
            OffreMissionHandler offreHandler = new OffreMissionHandler();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/BabySitterJavaME/getXmloffre1_Attributes.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, offreHandler);
            // display the result
            offres = offreHandler.getOffreMission();

            if (offres.length > 0) {
                for (int i = 0; i < offres.length; i++) {
                    lstoffre.append(offres[i].getNumOffre()
                            + offres[i].getDate()
                            + offres[i].getAdresse()
                            + offres[i].getDescription()
                            + offres[i].getHoraire(), null);

                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(lstoffre);
    }

    public String choisiroffre(int i) {
        HttpConnection hc;
        DataInputStream dis;
        String url = "http://localhost/BabySitterJavaME/choisiroffre.php";
        StringBuffer sb = new StringBuffer();
        int ch;
        try {
            //  
            hc = (HttpConnection) Connector.open(url + "?id=" + offres[i].getNumOffre() + "&horaire=" + offres[i].getHoraire() + "&date=" + offres[i].getDate() + "&adresse=" + offres[i].getAdresse() + "&description=" + offres[i].getDescription());
            dis = new DataInputStream(hc.openDataInputStream());
            while ((ch = dis.read()) != -1) {
                sb.append((char) ch);
            }
            sb = new StringBuffer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String x = "c bon  ";
        return x;
    }

    private String modiffiche(int idmodif) {
        String res = "";
        i = lstfiche.getSelectedIndex();
        if (fiches.length > 0) {
            int indicetype = -1, type = 0, indicep = -1, p = 0, indicesexe = -1, sex = 0;

            do {
                indicetype++;
                if (fiches[i].getTypeb().equals(cgtypeb1.getString(indicetype))) {
                    cgtypeb1.setSelectedIndex(indicetype, true);
                    type = 1;
                }

            } while (type == 0);
            do {
                indicesexe++;
                if (fiches[i].getSexe().equals(cgsexe1.getString(indicesexe))) {
                    cgsexe1.setSelectedIndex(indicesexe, true);
                    sex = 1;
                }
            } while (sex == 0);

            tfmission1.setString("" + fiches[i].getNbmissions());
            tfenfants1.setString("" + fiches[i].getNbenfants());
            gdistance1.setValue(fiches[i].getDistance());
            gtarif1.setValue(fiches[i].getTarif());
            tftelephone1.setString("" + fiches[i].getTelephone());
            do {
                indicep++;
                if (fiches[i].getPays().equals(cgpays1.getString(indicep))) {
                    cgpays1.setSelectedIndex(indicep, true);
                    p = 1;
                }
            } while (p == 0);

            tfville1.setString("" + fiches[i].getVille());
            tfcodepostal1.setString("" + fiches[i].getCodepostal());
            tfexperience1.setString("" + fiches[i].getExperience());

        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }

    public void affichermission() {
        try {
            MissionHandler missionsHandler = new MissionHandler();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/BabySitterJavaME/getXmlmission_Attributes.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, missionsHandler);
            missions = missionsHandler.getMission();

            if (missions.length > 0) {
                for (int i = 0; i < missions.length; i++) {
                    lstmission.append(
                            missions[i].getAdresse() + "  "
                            + missions[i].getDate() + "  "
                            + missions[i].getHoraire() + "   "
                            + missions[i].getDescription() + "   ", null);

                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(lstmission);
    }

    private String showmission(int i) {
        String res = "";
        if (missions.length > 0) {
            sb.append("* ");
            sb.append("Localisation: " + missions[i].getAdresse());
            sb.append("\n");
            sb.append("* ");
            sb.append("Date: " + missions[i].getDate());
            sb.append("\n");
            sb.append("* ");
            sb.append("horaire : " + missions[i].getHoraire());
            sb.append("\n");
            sb.append("* ");
            sb.append("Descripton de ma mission : " + missions[i].getDescription());
            sb.append("\n");

        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }

    private void supprimerMission(int i) {
        try {

            hc = (HttpConnection) Connector.open(urlsupprime + "?id=" + missions[i].getIdMission());
            dis = new DataInputStream(hc.openDataInputStream());
            while ((ch = dis.read()) != -1) {
                sb.append((char) ch);
            }
            if ("OK".equals(sb.toString().trim())) {
                lstmission.delete(i);

                System.out.println("m");

            } else {
                disp.setCurrent(fo3);
                System.out.println("no");
            }
            sb = new StringBuffer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
   
}


 
 

