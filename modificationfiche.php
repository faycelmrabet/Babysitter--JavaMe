 <?php
require_once('connect.php');

mysql_select_db($database_localhost,$con);



$typeb=$_GET['typeb'];
$nbmissions=$_GET['nbmissions'];
$nbenfants=$_GET['nbenfants'];
$tarif=$_GET['tarif'];
$distance=$_GET['distance'];
$experience=$_GET['experience'];
$sexe=$_GET['sexe'];
$telephone=$_GET['telephone'];
$ville=$_GET['ville'];
$codepostal=$_GET['codepostal'];
$pays=$_GET['pays'];
$idfiche=$_GET['id'];

if (
mysql_query("UPDATE  `fichebabysitter` SET  `typeb` =  '$typeb',
`nbmissions` ='$nbmissions',
`nbenfants` ='$nbenfants',
`tarif` ='$tarif',
`distance` ='$distance',
`experience` =  '$experience',
`sexe` =  '$sexe',
`telephone` ='$telephone',
`ville` =  '$ville',
`codepostal` ='$codepostal',
`pays` =  '$pays' WHERE  `idfiche` ='$idfiche';")
)
{
echo "OK";

}
?>

