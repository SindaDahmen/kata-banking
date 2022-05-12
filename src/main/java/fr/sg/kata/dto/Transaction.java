package fr.sg.kata.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import fr.sg.kata.utils.TransactionType;

public class Transaction implements Serializable {

	private static final long serialVersionUID = -7860260138568336314L;

	/** The transaction id. */
	private Long id;

	/** The balance. */
	private BigDecimal balance;

	/** The amount. */
	private BigDecimal amount;

	/** The date. */
	private LocalDateTime date;

	/** The type transaction. */
	private TransactionType transactionType;
	
	/** The account. */
	private Account account;

	public Transaction() {
		super();
	}

	public Transaction(Long id, BigDecimal balance, BigDecimal amount, LocalDateTime date,
			TransactionType transactionType, Account account) {
		super();
		this.id = id;
		this.balance = balance;
		this.amount = amount;
		this.date = date;
		this.transactionType = transactionType;
		this.account = account;
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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
		Transaction other = (Transaction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", balance=" + balance + ", amount=" + amount + ", date=" + date
				+ ", transactionType=" + transactionType + "]";
	}

}
