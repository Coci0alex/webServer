/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webserver.heroku;

import java.io.IOException;
import static java.lang.System.out;
import java.net.URL;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author alexandercarlsen
 */
@Path("StartGame")

public class StartSpil  { 
    
    @GET
    public String StartGame() throws IOException
    {
        URL url = new URL("http://ubuntu4.saluton.dk:9929/kontotjeneste?wsdl");
        QName qname = new QName("http://galgeleg/", "GalgelogikService");
        Service service = Service.create(url, qname);
        GalgelegI k = service.getPort(GalgelegI.class);
        
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<head><title>Galgeleg</title>");
        builder.append("</head>");
        builder.append("<body>");

        builder.append("<h1>Spillet er begyndt</h1" + "\n");
        builder.append("<br/> <form action=\"DoOrDie\" method=\"post\">");
        builder.append("<font color=\"blue\">Indtast bogstav her</font>:<input name=\"bogstav\" type=\"text\" />\n");
        builder.append("<button type=\"submit\">Tryk</button> </form> <br/>");
        builder.append("</body>" + "</html>");


      return k.getSynligtOrd() + k.getBrugteBogstaver() + builder.toString();
      
        
    }

}
