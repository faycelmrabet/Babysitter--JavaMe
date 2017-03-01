<?php
require_once('connect.php');

mysql_select_db($database_localhost,$con);
$numOffre=$_GET['numOffre'];


mysql_query("Delete from offremission where numOffre='$numOffre' ");
echo "OK";
?>