<?php
require_once('connect.php');

mysql_select_db($database_localhost,$con);

$numoffre=$_GET['id'];
$horaire=$_GET['horaire'];
$date=$_GET['date'];
$adresse=$_GET['adresse'];
$description=$_GET['description'];





$requete="INSERT INTO `mission`(`idMission`, `date`, `description`, `adresse`, `horaire`, `idUser`, `typeUser`) VALUES (NULL,'$date','$description','$adresse','$description',NULL,NULL) ";
$resultat=mysql_query($requete);
if ($resultat){
}
else {

}


$requete1="DELETE FROM `offremission` WHERE numOffre=$numoffre";

$resultat1=mysql_query($requete1);
if ($resultat1){
	echo "Ok";
}
else  echo"no"

?>