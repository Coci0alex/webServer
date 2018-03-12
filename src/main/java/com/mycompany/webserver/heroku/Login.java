/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webserver.heroku;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author alexandercarlsen
 */
@Path("Login")
public class Login {
   
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String checkLogin()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<head><title>Galgeleg</title>");
        builder.append("</head>");
        builder.append("<body>");

        builder.append("<h1>Indtast dine oplysninger</h1" + "\n");
        builder.append("<br/> <form action=\"CheckLogin\" method=\"post\">");
        builder.append("<font color=\"blue\">Brugernavn</font>:<input name=\"brugernavn\" type=\"text\" />\n");
        builder.append("<font color=\"blue\">Kodeord</font>:<input name=\"kode\" type=\"password\" />\n");
        builder.append("<button type=\"submit\">Login</button> </form> <br/>");
        builder.append("</body>" + "</html>");
        
            return builder.toString();
    }
}
