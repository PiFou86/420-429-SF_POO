package ca.csf.dfc.classes;

public final class ExecutionTransaction {
	private final double m_solde;
	private final Transaction m_transaction;
	
	public ExecutionTransaction(Transaction p_tx, double p_solde) {
		this.m_transaction = p_tx;
		this.m_solde = p_solde;
	}

	public double getSolde() {
		return this.m_solde;
	}
	
	public Transaction getTransaction() {
		return this.m_transaction;
	}
	
	@Override
	public String toString() {
		return this.m_transaction.toString() + " ## " + String.format("%6.02f", this.getSolde());
	}
}
