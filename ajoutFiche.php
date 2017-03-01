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



if(
mysql_query("INSERT INTO `bd_baby_sitting`.`fichebabysitter` (`idFiche`, `typeb`, `nbmissions`, `nbenfants`, `tarif`, `distance`, `experience`, `sexe`, `telephone`, `ville`, `codepostal`, `pays`, `photo`, `idUser`) VALUES (NULL, '$typeb', '$nbmissions', '$nbenfants', '$tarif', '$distance', '$experience', '$sexe', '$telephone', '$ville', '$codepostal', '$pays', NULL, NULL);"))
{echo "OK";}

?>
