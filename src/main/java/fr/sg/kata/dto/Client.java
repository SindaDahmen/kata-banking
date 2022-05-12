package fr.sg.kata.dto;

import java.io.Serializable;

public class Client implements Serializable {

	private static final long serialVersionUID = -3825222352114507394L;

	/** The id. */
	private Long id;

	/** The first name. */
	private String firstname;

	/** The last name. */
	private String lastname;

	/** The account. */
	private Account account;

	public Client() {
		super();
	}

	public Client(Long id, String firstname, String lastname, Account account) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", account=" + account
				+ "]";
	}

}
