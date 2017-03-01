 <?php
require_once('connect.php');

mysql_select_db($database_localhost,$con);

$id=$_GET['id'];

if (
mysql_query(" DELETE from  `bd_baby_sitting`.`user`  WHERE  `user`.`id` ='$id';")
){echo "OK";
}
?>