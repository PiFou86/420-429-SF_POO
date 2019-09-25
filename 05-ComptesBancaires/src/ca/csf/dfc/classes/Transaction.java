package ca.csf.dfc.classes;

public abstract class Transaction {
	private final TransactionType m_transactionType;
	private final double m_montant;
	private final String m_description;
	
	public Transaction(TransactionType p_tt, double p_montant, String p_description) {
		if (p_tt == null) {
			throw new IllegalArgumentException("Le type de transaction doit être défini");
		}
		
		if (p_montant <= 0.0) {
			throw new IllegalArgumentException("Le montant de la transaction doit être supérieur à 0 $");
		}

		this.m_transactionType = p_tt;
		this.m_montant = p_montant;
		this.m_description = p_description;
	}
	
	final public double getMontant() {
		return this.m_montant;
	}

	final public TransactionType getType() {
		return this.m_transactionType;
	}

	final public String getDescription() {
		return this.m_description;
	}
	
	@Override
	final public String toString() {
		return this.getDescription() + " (" + this.getType() + ") : " + String.format("%6.02f", this.getMontant());
	}
}
