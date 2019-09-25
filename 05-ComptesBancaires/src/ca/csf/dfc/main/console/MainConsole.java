package ca.csf.dfc.main.console;

import ca.csf.dfc.classes.CompteAInteret;
import ca.csf.dfc.classes.CompteBancaire;
import ca.csf.dfc.classes.CompteMargeCredit;

public class MainConsole {

	public static void main(String[] args) {
		CompteBancaire cbai = new CompteAInteret(1000);

		cbai.retirer(100);
		cbai.deposer(100);
		
		try {
			cbai.retirer(1000);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		cbai.afficherHistoriqueCompte();
		
		System.out.println();
		
		CompteBancaire cbmc = new CompteMargeCredit(1000);

		cbmc.retirer(100);
		cbmc.deposer(100);

		cbmc.retirer(1000);
		cbmc.retirer(1000);
		cbmc.retirer(1000);
		cbmc.retirer(1000);
		cbmc.retirer(1000);
		cbmc.retirer(1000);
		cbmc.retirer(1000);
		cbmc.retirer(1000);
		cbmc.retirer(1000);
		cbmc.retirer(1000);
		cbmc.retirer(1000);

		cbmc.afficherHistoriqueCompte();
		
	}

}
