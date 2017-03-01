<?php 
require_once('connect.php'); 
mysql_select_db($database_localhost,$con);  

$login = $_GET['login'];
$password = $_GET['password'];

	
    $query_search = "SELECT id,username,nom,prenom,dateNaissance,password,email,adresse,codePostale,telephone,nbreEnfant,etat,cin,typeUser,note FROM user where username LIKE '$login' and password LIKE '$password'";  
	$query_exec = mysql_query($query_search) or die(mysql_error());  
      
if($query_exec!=null){  
    $xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
      $root_element = "utilisateur"; 
      $xml .= "<$root_element>";
	while($result_array = mysql_fetch_assoc($query_exec))
     {
      $xml .= "<user ";
 
      foreach($result_array as $key => $value)
      {
         //$key holds the table column name
         $xml .= " $key=\"$value\"";
 
         //embed the SQL data in a CDATA element to avoid XML entity issues
         $xml .= ""; 
      }
 
      $xml.="></user>";
   }
//close the root element
$xml .= "</$root_element>";
 
//send the xml header to the browser
header ("Content-Type:text/xml"); 
 
//output the XML data
echo $xml;
 }  
 ?>  

	
