 <?php
require_once('connect.php');

mysql_select_db($database_localhost,$con);
$log=$_GET['log'];
$pass=$_GET['pass'];
$nom=$_GET['nom'];
$prenom=$_GET['prenom'];
$dn=$_GET['dn'];
$email=$_GET['email'];
$cin=$_GET['cin'];
$add=$_GET['add'];
$cp=$_GET['cp'];
$tel=$_GET['tel'];

$query_search = "SELECT * FROM user where username = '$log' " ;  
$result = mysql_query($query_search); 
if(mysql_fetch_assoc($result)==null){ 
mysql_query("INSERT INTO `bd_baby_sitting`.`user` (`id`, `username`, `email`, `password`,`nom`, `prenom`, `dateNaissance`, `cin`, `adresse`, `codePostale`, `telephone`, `typeUser`, `etat`) VALUES (NULL,'$log','$email','$pass','$nom','$prenom','$dn','$cin','$add','$cp','$tel','BabySitter', '0')");
echo "OK";}
?>