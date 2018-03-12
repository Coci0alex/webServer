/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webserver.heroku;

import brugerautorisation.data.Bruger;
import java.io.IOException;
import java.net.URL;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
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
@Path("CheckLogin")
public class CheckLogin {
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String checkLogin(@FormParam("brugernavn") String bn, @FormParam("kode") String kode) throws IOException
    {
                int id = 0;
                URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
		QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
                Service service = Service.create(url, qname);
		brugerautorisation.transport.soap.Brugeradmin ba = service.getPort(brugerautorisation.transport.soap.Brugeradmin.class);
                Bruger b = ba.hentBruger(bn, kode);
                System.out.println("Fik bruger" + b);
                StringBuilder builder = new StringBuilder();
                builder.append("<html>");
                builder.append("<head><title>Galgeleg</title>");
                builder.append("</head>");
                builder.append("<body>"); 
                builder.append("<h1>Du er nu logget ind</h1");
                builder.append("<br/>\n" + "Klik <a href=\"StartGame\"/>her</a> for at begynde spillet  <br/>");
                builder.append("</body>" + "</html>");
                
                return builder.toString();
    }

}
