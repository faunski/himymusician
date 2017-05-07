<?php
  require 'rb.php';
    R::setup( 'mysql:host=localhost;dbname=soitamme',
        'fauni_samu', 'starbucks' ); //for both mysql or mariaDB
    session_start();

    $message = R::dispense('chatroom');
    $message->username = $_SESSION['id'];
    $message->message = $_REQUEST['message'];
    R::store( $message );