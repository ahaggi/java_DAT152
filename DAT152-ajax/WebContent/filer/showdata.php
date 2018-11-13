<?php
header('content-type: application/xml');
?>
<?xml version="1.0" standalone="yes"?>

<!DOCTYPE data [
  <!ELEMENT data (#PCDATA)>
]>



<data>
<?php
  if (isset($_POST["data"])) {
   $data = trim($_POST["data"]);
   if (empty($data) && $data != "0") unset($data);
}

if (isset($data)) {
  echo "<data>"+$data+"</data>";
}
?>
</data>