package brugerautorisation.transport.rmi;

import brugerautorisation.data.Diverse;
import brugerautorisation.data.Bruger;
import java.rmi.Naming;

public class Brugeradminklient {
	public static void main(String[] arg) throws Exception {
//		Brugeradmin ba =(Brugeradmin) Naming.lookup("rmi://localhost/brugeradmin");
		Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");

		Bruger b = ba.hentBruger("s164929", "1234");
		System.out.println("Fik bruger = " + b);
		System.out.println("Data: " + Diverse.toString(b));
               //ba.ændrAdgangskode("s164929", "kodepwsmto", "1234");
		//ba.sendEmail("s164929", "1234", "Hurra det virker!", "Jeg er så glad");
                //ba.sendGlemtAdgangskodeEmail("s164929", "Dette er en test, husk at skifte kode");

		Object ekstraFelt = ba.getEkstraFelt("s164929", "1234", "hobby");
		//System.out.println("Brugerens hobby er: " + ekstraFelt);

		ba.setEkstraFelt("s164929", "1234", "hobby", "Træning, Sundhed, Helse, Moral og Etik"); // Skriv noget andet her
                //String hobby = (String) ba.getEkstraFelt("s164929", "1234", "hobby");
		//String webside = (String) ba.getEkstraFelt("s123456", "kode1xyz", "webside");
		//System.out.println("Brugerens webside er: " + webside);
	}
}
