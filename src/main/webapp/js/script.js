$(window).on('load', function() {
           $('#mycalendar').monthly({
             dataType: 'xml',
             xmlUrl: './events.xml',
             weekStart: 'Mon'
         });
         $('#calendar1').monthly({
             dataType: 'xml',
             xmlUrl: './events.xml',
             weekStart: 'Mon'
         });
         $('#calendar2').monthly({
             dataType: 'xml',
             xmlUrl: './events.xml',
             weekStart: 'Mon'
         });
         $('#calendar3').monthly({
             dataType: 'xml',
             xmlUrl: './events.xml',
             weekStart: 'Mon'
         });
         $('#calendar4').monthly({
             dataType: 'xml',
             xmlUrl: './events.xml',
             weekStart: 'Mon'
         });
         $('#calendar5').monthly({
             dataType: 'xml',
             xmlUrl: './events.xml',
             weekStart: 'Mon'
         });
         $('#calendar6').monthly({
             dataType: 'xml',
             xmlUrl: './events.xml',
             weekStart: 'Mon'
         });
         $('#calendar7').monthly({
             dataType: 'xml',
             xmlUrl: './events.xml',
             weekStart: 'Mon'
         });
         $('#calendar8').monthly({
             dataType: 'xml',
             xmlUrl: './events.xml',
             weekStart: 'Mon'
         });
         $('#calendar9').monthly({
             dataType: 'xml',
             xmlUrl: './events.xml',
             weekStart: 'Mon'
         });
         $('#timepicker1').timepicker({
                          minuteStep: 15,
                          appendWidgetTo: 'body',
                          showSeconds: false,
                          showMeridian: false,
                          defaultTime: '18:00'
                        });
        $('#timepicker2').timepicker({
                          minuteStep: 15,
                          appendWidgetTo: 'body',
                          showSeconds: false,
                          showMeridian: false,
                          defaultTime: '20:00'
                        });

         
         
         $('#mycalendar2').monthly({
           mode: 'picker',
           // The element that will have its value set to the date you picked
           target: '#mytarget',
           // Set to true if you want monthly to appear on click
           startHidden: true,
           // Element that you click to make it appear
           showTrigger: '#mytarget',
           // Add a style to days in the past
           stylePast: true,
           // Disable clicking days in the past
           disablePast: true
         });
         $('textarea').each(function() {}).on('input', function() {
           this.style.height = 'auto';
           this.style.height = (this.scrollHeight) + 'px';
         });
  $('.dropdown').on('show.bs.dropdown', function(e){
        $(this).find('.dropdown-menu').first().stop(true, true).slideDown();
    });

    // ADD SLIDEUP ANIMATION TO DROPDOWN //
    $('.dropdown').on('hide.bs.dropdown', function(e){
        e.preventDefault();
        $(this).find('.dropdown-menu').first().stop(true, true).slideUp(400, function(){
            //On Complete, we reset all active dropdown classes and attributes
            //This fixes the visual bug associated with the open class being removed too fast
            $('.dropdown').removeClass('open');
            $('.dropdown').find('.dropdown-toggle').attr('aria-expanded','false');
        });
    });
});
         $('#laheta').click(function() {
           if ($('#name').val() == 'Yksityinen tapahtuma') {
              var color = '#4286f4'
              }
            if ($('#name').val() == 'Julkinen tilaisuus') {
              var color = '#fc4646'
              }
            if ($('#name').val() == 'Ravintolaesiintyminen') {
              var color = '#26b74f'
              }
           
          $.post("../php/soitamme.php", $("#myForm").serialize() +'&color=' + color, function(data) {
             $('#alert').remove();
             if (data == 'success') {
               $('#myModal').modal('hide');
             } else
               $('.modal-footer').prepend("<div id='alert' style='float: left;' class='alert alert-danger'>" + data + "</div>");
           });
             });

$('.kirjaudu').on('submit', function (e) {
    e.preventDefault;
    console.log("testt");
    clearLogin();
});
function clearLogin() {
  $('#loginContainer').remove();
}
function logOut() {
				$.get( "/php/logout.php" , function() {
					location.reload();
				});
}
