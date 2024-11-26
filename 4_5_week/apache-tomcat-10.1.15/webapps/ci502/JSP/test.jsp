<HTML>
<HEAD>
<TITLE>Order Confirmation</TITLE>
</HEAD>
<BODY>
<H2>Order Confirmation</H2>
<%String title = request.setParameter("yatch");%>
Thanks for ordering <I><%= request.getParameter(“title”) %></I>!
</BODY></HTML>
