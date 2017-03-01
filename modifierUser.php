 <?php
require_once('connect.php');

mysql_select_db($database_localhost,$con);


$etat=$_GET['etat'];
$id=$_GET['id'];

$requete="UPDATE `user`  SET `etat`='$etat' WHERE `id`=$id;";

if (mysql_query($requete))
echo "OK"; 

?>