package fr.sg.kata.repository;

import java.util.Optional;

import fr.sg.kata.dto.Account;

public interface IAccountFakeRepository {

	Optional<Account> getAccountByIdAccount(Long idAccount);

	void updateAccount(Account account);

}
