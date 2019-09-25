package ca.csf.dfc.classes;

public class TransactionInteret extends Transaction {

	public TransactionInteret(double p_montant) {
		super(TransactionType.DEBIT, p_montant, "Application d'un intérêt");
	}
	
}
