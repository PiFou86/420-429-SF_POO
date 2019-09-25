package ca.csf.dfc.classes;

public class TransactionDepot extends Transaction {

	public TransactionDepot(double p_montant) {
		super(TransactionType.CREDIT, p_montant, "Dépot d'argent sur le compte");
	}

}
