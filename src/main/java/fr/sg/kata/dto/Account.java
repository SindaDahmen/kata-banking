package fr.sg.kata.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Account implements Serializable {

	private static final long serialVersionUID = 8978272061203382722L;

	/** The id. */
	private Long id;

	/** The balance. */
	private BigDecimal balance;

	/** The client. */
	private Client client;

	/** The transactions list. */
	private List<Transaction> transactionsList;

	public Account() {
		super();
	}

	public Account(Long id, BigDecimal balance, Client client, List<Transaction> transactionsList) {
		super();
		this.id = id;
		this.balance = balance;
		this.client = client;
		this.transactionsList = transactionsList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Transaction> getTransactionsList() {
		return transactionsList;
	}

	public void setTransactionsList(List<Transaction> transactionsList) {
		this.transactionsList = transactionsList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", client=" + client + ", transactionsList="
				+ transactionsList + "]";
	}
	
}
