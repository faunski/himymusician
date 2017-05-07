<?php
  header('Content-Type: application/json');
  require 'rb.php';
    R::setup( 'mysql:host=localhost;dbname=soitamme',
        'fauni_samu', 'starbucks' ); //for both mysql or mariaDB

  $joku = array('monthly'=>R::getAll('SELECT * FROM events;'));
  echo json_encode($joku, JSON_PRETTY_PRINT);
?>
  