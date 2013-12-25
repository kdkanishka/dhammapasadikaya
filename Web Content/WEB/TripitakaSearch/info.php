<?php
$userIP=$_SERVER['REMOTE_ADDR'];
$browser=$_SERVER['HTTP_USER_AGENT'];
$referer=$_SERVER['HTTP_REFERER'];
if($referer==""){
	$referer="DIRECT";
}
print "user IP ".$userIP."</br>";
print "Browser ".$browser."</br>";
print "Referer ".$referer."</br>";

?>