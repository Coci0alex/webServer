/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webserver.heroku;

import java.io.IOException;
import java.net.URL;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author alexandercarlsen
 */
@Path("DoOrDie")
public class CheckLetter {
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String checkingLetter(@FormParam("bogstav") String bn) throws IOException
    {
        URL url = new URL("http://ubuntu4.saluton.dk:9929/kontotjeneste?wsdl");
        QName qname = new QName("http://galgeleg/", "GalgelogikService");
        Service service = Service.create(url, qname);
        GalgelegI k = service.getPort(GalgelegI.class);
        StringBuilder builder = new StringBuilder();
        k.gætBogstav(bn);
        builder.append("<html>");
        builder.append("<head><title>GætLæstInd</title>");
        builder.append("</head>");
        builder.append("<body>");
        builder.append("<br/>\n" + "Klik <a href=\"StartGame\"/>her</a> for at gætte på næste bogstav  <br/>");
        builder.append("</body>" + "</html>");
        if (k.erSpilletSlut() == false && k.getKørerSpillet() == true)
        {
        return k.gætStatus() + builder.toString();
        }
        else 
        {
            return "DU HAR TABT OG DIN HOMIE DØDE VED HÆNGNING" + builder.toString();
        }
    }
}
