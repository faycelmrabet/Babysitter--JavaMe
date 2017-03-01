 <?php
require_once('connect.php');

mysql_select_db($database_localhost,$con);

$numOffre=$_GET['numOffre'];
$date=$_GET['date'];
$description=$_GET['description'];
$adresse=$_GET['adresse'];
$horaire=$_GET['horaire'];


$requete="UPDATE `offremission`  SET `date`='$date',`description`='$description',`adresse`='$adresse',`horaire`='$horaire' WHERE `numOffre`=$numOffre;";

if (mysql_query($requete))
echo "OK";else 
echo "NNNNNNNNNNNNNN";
?>

