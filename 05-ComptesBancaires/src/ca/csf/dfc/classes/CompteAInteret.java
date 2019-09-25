package ca.csf.dfc.classes;

import java.util.List;

public class CompteAInteret extends CompteBancaire {
	final public static double FRAIS_TRANSACTION = 0.25;
	
	public CompteAInteret() {

	}

	public CompteAInteret(double p_solde) {
		super(p_solde);
	}
	
	@Override
	protected List<Transaction> preparerDepot(double p_montant) {
		List<Transaction> listeTx = super.preparerDepot(p_montant);
		listeTx.add(new TransactionFrais(FRAIS_TRANSACTION));
		
		this.validerTransactions(listeTx);
		
		return listeTx;
	}
	
	@Override
	protected List<Transaction> preparerRetrait(double p_montant) {
		List<Transaction> listeTx = super.preparerRetrait(p_montant);
		listeTx.add(new TransactionFrais(FRAIS_TRANSACTION));
		
		this.validerTransactions(listeTx);

		return listeTx;
	}
	
	private void validerTransactions(List<Transaction> p_listeTx) {
		double soldeSimule = this.simulerTransaction(p_listeTx);
		
		if (soldeSimule < 0) {
			throw new IllegalArgumentException("Impossible d'effectuer cette transaction car le montant ne peut être négatif");
		}
	}

	@Override
	protected String getDescription() {
		return "Compte à intérêt";
	}

}
