<?php
require_once('connect.php');

mysql_select_db($database_localhost,$con);


$idfiche=$_GET['id'];
$requete="DELETE FROM  `fichebabysitter` WHERE idfiche =$idfiche";


mysql_query($requete);
echo "OK";
?>