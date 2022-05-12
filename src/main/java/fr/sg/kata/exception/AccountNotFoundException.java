package fr.sg.kata.exception;

public class AccountNotFoundException extends Exception {

	private static final long serialVersionUID = -5799917336245700456L;

	public AccountNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
