/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webserver.heroku;
import java.util.ArrayList;
import javax.jws.WebService;
@WebService(name="GalgelegI", targetNamespace="http://galgeleg/") 

/**
 *
 * @author Coci0
 */
public interface GalgelegI extends java.rmi.Remote {
    
    public ArrayList<String> getBrugteBogstaver()                           throws java.rmi.RemoteException;
    public String getSynligtOrd()                                           throws java.rmi.RemoteException;
    public String getOrdet()                                                throws java.rmi.RemoteException;
    public int getAntalForkerteBogstaver()                                  throws java.rmi.RemoteException;
    public boolean erSidsteBogstavKorrekt()                                 throws java.rmi.RemoteException;
    public boolean erSpilletVundet()                                        throws java.rmi.RemoteException;
    public boolean erSpilletTabt()                                          throws java.rmi.RemoteException;
    public boolean erSpilletSlut()                                          throws java.rmi.RemoteException;
    public void nulstil()                                                   throws java.rmi.RemoteException;
    public void gætBogstav(String bogstav)                                  throws java.rmi.RemoteException;
    public void logStatus()                                                 throws java.rmi.RemoteException;
    public void hentOrdFraDr()                                              throws Exception;
    public String gætStatus()                                               throws java.rmi.RemoteException;
    public String spilStatus()                                              throws java.rmi.RemoteException;
    public boolean getKørerSpillet()                                        throws java.rmi.RemoteException;
    public void getMenuInput(int input)                                     throws java.rmi.RemoteException;   
    public void checkLoginOplysninger(String username, String password)     throws java.rmi.RemoteException;
    public boolean loggetAf()                                               throws java.rmi.RemoteException;
}
