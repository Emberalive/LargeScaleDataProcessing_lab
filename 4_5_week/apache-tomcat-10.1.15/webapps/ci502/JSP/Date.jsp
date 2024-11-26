<HTML>
<BODY>
	<h1> this date thing does not work at all <h1>
<%
// This scriptlet declares and initializes "date"
System.out.println( "Evaluating date now" );
java.util.Date date = new java.util.Date();
%>
Hello! The time is now
<%
out.println( date );
out.println( "<BR>Your machine`s address is" );
out.println( request.getRemoteAddr());
%>
</BODY>
</HTML>
