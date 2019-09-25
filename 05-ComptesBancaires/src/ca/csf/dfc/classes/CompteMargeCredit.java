package ca.csf.dfc.classes;

import java.util.List;

public class CompteMargeCredit extends CompteBancaire {
	final public static double FRAIS_TRANSACTION = 0.25;
	final public static double TAUX_INTERET = 0.05;
	private int m_nombreOperationNegatif;

	public CompteMargeCredit() {

	}

	public CompteMargeCredit(double p_solde) {
		super(p_solde);

		this.m_nombreOperationNegatif = 0;
	}

	@Override
	protected List<Transaction> preparerDepot(double p_montant) {
		List<Transaction> listeTx = super.preparerDepot(p_montant);
		listeTx.add(new TransactionFrais(FRAIS_TRANSACTION));

		return listeTx;
	}

	@Override
	protected List<Transaction> preparerRetrait(double p_montant) {
		List<Transaction> listeTx = super.preparerRetrait(p_montant);
		listeTx.add(new TransactionFrais(FRAIS_TRANSACTION));

		return listeTx;
	}

	@Override
	public void deposer(double p_montant) {
		super.deposer(p_montant);

		this.appliquerInteret();
	}

	@Override
	public void retirer(double p_montant) {
		super.retirer(p_montant);

		this.appliquerInteret();
	}

	private void appliquerInteret() {
		if (this.getSolde() >= 0) {
			this.m_nombreOperationNegatif = 0;
		} else {
			this.m_nombreOperationNegatif++;
		}
		
		if (this.m_nombreOperationNegatif == 10) {
			double interet = Math.abs(this.getSolde() * TAUX_INTERET);
			this.appliquerTransaction(new TransactionInteret(interet));
			
			this.m_nombreOperationNegatif = 0;
		}
	}

	@Override
	protected String getDescription() {
		return "Compte à marge de crédit";
	}
}
