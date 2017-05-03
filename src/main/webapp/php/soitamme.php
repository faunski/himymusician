<?php
  require 'rb.php';
    R::setup( 'mysql:host=localhost;dbname=soitamme',
        'fauni_samu', 'starbucks' ); //for both mysql or mariaDB
    echo events();

function events() {
  $event = R::dispense('events');
    if ($_POST['name'] != "") {
      $event->name=$_POST['name'];
    } else return 'Tapahtuma puuttuu';
  if ($_POST['starttime'] != "") {
      $event->starttime=$_POST['starttime'];
    }
  if ($_POST['endtime'] != "") {
   $event->endtime=$_POST['endtime'];
    }
  if ($_POST['startdate'] != "") {
    $datearray = explode('/',$_POST['startdate']);
    $date = $datearray[2].'-'.$datearray[0].'-'.$datearray[1];
    $event->startdate=$date;
    $event->enddate=$date;
  }
  else return 'Päivämäärä puuttuu';
  if ($_POST['phone'] != "") {
  $event->phone=$_POST['phone'];
    }
  if ($_POST['customer'] != "") {
  $event->phone=$_POST['customer'];
    } else return 'Nimi puuttuu';
  if ($_POST['email'] != "") {
   $event->email=$_POST['email'];
    }
  else return 'Sähköposti puuttuu';
  if ($_POST['message'] != "") {
   $event->message=$_POST['message'];
    }
  if ($_POST['color'] != "") {
   $event->color=$_POST['color'];
    }
  R::store($event);
    return 'success';
}
?>