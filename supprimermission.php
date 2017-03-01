<?php
require_once('connect.php');

mysql_select_db($database_localhost,$con);


$idMission=$_GET['id'];
$requete="DELETE FROM  `mission` WHERE idMission =$idMission";


mysql_query($requete);
echo "OK";
?>