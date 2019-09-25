package ca.csf.dfc.classes;

import java.util.ArrayList;
import java.util.List;

public abstract class CompteBancaire {
	private double m_solde;
	private List<ExecutionTransaction> m_historiqueTransactions;

	public CompteBancaire() {
		this(0);
	}

	public CompteBancaire(double p_solde) {
		this.m_historiqueTransactions = new ArrayList<ExecutionTransaction>();
		if (p_solde != 0) {
			this.appliquerTransaction(new TransactionDepot(p_solde));
		}
	}
	
	public void retirer(double p_montant) {
		List<Transaction> listeTransactions = this.preparerRetrait(p_montant);

		this.appliquerTransaction(listeTransactions);
	}

	public void deposer(double p_montant) {
		List<Transaction> listeTransactions = this.preparerDepot(p_montant);

		this.appliquerTransaction(listeTransactions);
	}

	protected List<Transaction> preparerRetrait(double p_montant) {
		List<Transaction> listeTransactions = new ArrayList<Transaction>();
		listeTransactions.add(new TransactionRetrait(p_montant));

		return listeTransactions;
	}

	protected List<Transaction> preparerDepot(double p_montant) {
		List<Transaction> listeTransactions = new ArrayList<Transaction>();
		listeTransactions.add(new TransactionDepot(p_montant));

		return listeTransactions;
	}

	final protected double simulerTransaction(Transaction p_tx, double p_solde) {
		switch (p_tx.getType()) {
		case DEBIT:
			p_solde -= p_tx.getMontant();
			break;
		case CREDIT:
			p_solde += p_tx.getMontant();
			break;
		}

		return p_solde;
	}

	final protected double simulerTransaction(List<Transaction> p_listeTx) {
		double solde = this.getSolde();

		for (Transaction tx : p_listeTx) {
			solde = this.simulerTransaction(tx, solde);
		}

		return solde;
	}

	final protected void appliquerTransaction(Transaction p_tx) {
		this.m_solde = this.simulerTransaction(p_tx, this.getSolde());
		m_historiqueTransactions.add(new ExecutionTransaction(p_tx, this.getSolde()));
	}

	final protected void appliquerTransaction(List<Transaction> p_listeTx) {
		for (Transaction tx : p_listeTx) {
			this.appliquerTransaction(tx);
		}
	}

	public double getSolde() {
		return this.m_solde;
	}

	public void afficherHistoriqueCompte() {
		System.out.print(this.toString());
	}
	
	@Override
	final public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getDescription());
		sb.append(System.lineSeparator());
		int line = 1;
		for (ExecutionTransaction et : this.m_historiqueTransactions) {
			sb.append(String.format("%5d : ",line));
			sb.append(et.toString());
			sb.append(System.lineSeparator());
			
			++line;
		}

		return sb.toString();
	}
	
	protected abstract String getDescription();
}
