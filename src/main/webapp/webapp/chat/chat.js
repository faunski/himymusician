var prevResult = [{'id': 0}];
var colorshift = true;

$('#chatbox').perfectScrollbar();

$(document).ready(function() {
    setInterval(update, 1000);
    $.ajax({url: "../php/getchat.php?html",
    datatype: 'html',
    success: function(result){
        $(".msg-wrap").html(result);
        $('#loading').remove();
        $('#padding').remove();
        $('.input-group').css('visibility','visible');
        $('#chatbox').scrollTop($('#chatbox')[0].scrollHeight);
        $('#chatbox').perfectScrollbar('update');
    }});
    $.getJSON("../php/getchat.php", function(result) {
        prevResult = result[result.length - 1].ID;
    });
});

function sendMsg() {
      $.post("../php/addchat.php", {
          message: $('#msgbox').val(),
      }, function(data) {
          $('#msgbox').val('');
          update();
      });
}

function update() {
    $.getJSON("../php/getchat.php", function(result) {
        if (result[result.length - 1].ID != prevResult) {
            doOnce = true;
            prevResult = result[result.length - 1].ID;
            $(".msg-wrap").append('' +
                '<div class="media msg" style='+cardColor()+'>' +
                '<div>' +
                '<small class="pull-right time"><i class="fa fa-clock-o"></i>' + ' ' + result[result.length - 1].timestamp + '</small>' +
                '<h4 class="media-heading">' + result[result.length - 1].username + '</h4>' +
                '<p class="col-lg-10">' + result[result.length - 1].message + '</p>' +
                '</div>' +
                '</div>');
            $('#chatbox').scrollTop($('#chatbox')[0].scrollHeight);
            $('#chatbox').perfectScrollbar('update');
        }
    });
}

$(function() {
    $('#msgbox').keypress(function(e) {
        if (e.which == 13) {
            sendMsg();
        }
    });
});

function cardColor() {
  if (colorshift) {
    colorshift = !colorshift;
    return 'background-color:#d2e2fa;';
  } else {
    colorshift = !colorshift;
    return 'background-color:#def7fe;';
  }
}
