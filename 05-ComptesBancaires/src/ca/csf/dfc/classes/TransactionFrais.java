package ca.csf.dfc.classes;

public class TransactionFrais extends Transaction {

	public TransactionFrais(double p_montant) {
		super(TransactionType.DEBIT, p_montant, "Frais de transaction");
	}
}
