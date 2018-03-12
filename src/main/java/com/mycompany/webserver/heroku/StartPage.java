/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webserver.heroku;



import java.io.IOException;
import java.net.URL;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author alexandercarlsen
 */
@Path("InitGame")
public class StartPage 
{
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getMessage() throws IOException
    {
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<head><title>Galgeleg</title>");
        builder.append("</head>");
        builder.append("<body>");

        builder.append("<h1>Velkommen Til Den Vildeste Galgeleg Nogensinde</h1");
        builder.append("<br/>\n" + "Klik <a href=\"Login\"/>her</a> for at logge ind  <br/>");
        builder.append("</body>" + "</html>");
        
      return builder.toString();
 
    }
}
