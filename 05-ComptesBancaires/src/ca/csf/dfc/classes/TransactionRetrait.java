package ca.csf.dfc.classes;

public class TransactionRetrait extends Transaction {

	public TransactionRetrait(double p_montant) {
		super(TransactionType.DEBIT, p_montant, "Retrait d'argent");
	}

}
