<?php
  require 'rb.php';
    R::setup( 'mysql:host=localhost;dbname=soitamme',
        'fauni_samu', 'starbucks' ); //for both mysql or mariaDB
session_start();
if (isset($_POST['email'])) {
   $user  = R::findOne( 'user', ' email = ? ', [$_POST['email']] );
 
if ($user->password == md5(md5($_POST['password']).$_POST['email'])) {
  $_SESSION['id'] = $user->email;
  openDash();
}
}
else if (isset($_SESSION['id'])) {
  openDash();
}

function openDash() {
  echo '<section id="calendar" class="container-fluid content-section text-center" style="padding-top: 75px;">
             <div class="row">
               <div class="col-md-5">
                 <div class="monthly admincal" id="mycalendar1"></div>
               </div>
            <div class="col-md-4">
                <iframe style="width: 100%; border: none;" id="chatwindow" src="../chat/chatroom.html" scrolling="no" ></iframe>
               </div>
               <div class="col-md-3">
               <div class="alert alert-info alert-dismissable">
        <a class="panel-close close" data-dismiss="alert">×</a> 
        <i class="fa fa-coffee"></i>
        This is an <strong>.alert</strong>. Use this to show important messages to the user.
      </div>
      <h3>Omat tiedot</h3>
      <form class="form-horizontal" role="form" style="color: white !important;">
        <div class="form-group">
          <label class="col-lg-3 control-label">Nimi</label>
          <div class="col-lg-8">
            <input class="form-control" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Sähköposti:</label>
          <div class="col-lg-8">
            <input class="form-control" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Käyttäjätunnus:</label>
          <div class="col-md-8">
            <input class="form-control" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Salasana:</label>
          <div class="col-md-8">
            <input class="form-control" type="password">
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label">Salasana uudelleen:</label>
          <div class="col-md-8">
            <input class="form-control" type="password">
          </div>
        </div>
        <div class="form-group">
          <label class="col-md-3 control-label"></label>
          <div class="col-md-8">
            <input class="btn btn-default" value="Tallenna" type="button">
            <span></span>
            <input class="btn btn-default" value="Peruuta" type="reset">
          </div>
        </div>
      </form>
               <button class="btn btn-default" onclick="logOut()">Kirjaudu ulos</button>
               </div>
               </div>
     </section>';
}
