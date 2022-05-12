package fr.sg.kata.repository.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import fr.sg.kata.dto.Account;
import fr.sg.kata.dto.Client;
import fr.sg.kata.repository.IAccountFakeRepository;

@Repository("AccountFakeRepositoryImpl")
public class AccountFakeRepositoryImpl implements IAccountFakeRepository {
	
	Client fakeClient = new Client(1L, "abc", "xyz", null);
	Account fakeAccount = new Account(1001L, new BigDecimal(1000), fakeClient, null);

	@Override
	public Optional<Account> getAccountByIdAccount(Long idAccount) {
		return Optional.of(fakeAccount);
	}

	@Override
	public void updateAccount(Account account) {
		this.fakeAccount = account;
	}

}
