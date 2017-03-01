 <?php
require_once('connect.php');

mysql_select_db($database_localhost,$con);

$id=$_GET['id'];
$nom=$_GET['nom'];
$prenom=$_GET['prenom'];
$dn=$_GET['dn'];
$email=$_GET['email'];
$add=$_GET['add'];
$cp=$_GET['cp'];
$tel=$_GET['tel'];
if (
mysql_query(" UPDATE  `bd_baby_sitting`.`user` SET  `email` =  '$email',`nom` =  '$nom',dateNaissance='$dn',codePostale='$cp',adresse='$add',`telephone`='$tel',`prenom` =  '$prenom' WHERE  `user`.`id` ='$id';")
){echo "OK";
}
?>