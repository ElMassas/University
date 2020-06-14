<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Hello Page</title>
    </head>
<%
    String exemplo= "um titulo";

    // outro codigo java qualquer...
    
    
    String sufixo= "ALGO QUE PODIA VIR DE UM SERVICO OU BD";
    
%>
    <body>
    
        <h2>Hello, ${user}!</h2>

<%=exemplo%>  <br/>

<p> <%=sufixo%> </p>       
        
    </body>
</html>
