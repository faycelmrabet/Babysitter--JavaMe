 <?php
require_once('connect.php');

mysql_select_db($database_localhost,$con);

$date=$_GET['date'];
$description=$_GET['description'];
$adresse=$_GET['adresse'];
$horaire=$_GET['horaire'];
$id=$_GET['id'];
mysql_query("INSERT INTO offremission VALUES ('','$date','$description','$adresse','$horaire',null,'$id') ");
echo "OK";
?>