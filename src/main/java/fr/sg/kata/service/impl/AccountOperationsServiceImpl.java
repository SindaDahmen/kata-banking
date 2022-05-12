package fr.sg.kata.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.sg.kata.dto.Account;
import fr.sg.kata.dto.Client;
import fr.sg.kata.dto.Transaction;
import fr.sg.kata.exception.AccountNotFoundException;
import fr.sg.kata.repository.IAccountFakeRepository;
import fr.sg.kata.repository.ITransactionFakeRepository;
import fr.sg.kata.service.IAccountOperationsService;
import fr.sg.kata.utils.TransactionType;

@Service("AccountOperationsServiceImpl")
public class AccountOperationsServiceImpl implements IAccountOperationsService {

	@Autowired
	@Qualifier("AccountFakeRepositoryImpl")
	private IAccountFakeRepository iAccountFakeRepository;

	@Autowired
	@Qualifier("TransactionFakeRepositoryImpl")
	private ITransactionFakeRepository iTransactionFakeRepository;

	@Override
	public void depositWithdrawalMoney(Long idClient, Long idAccount, BigDecimal amount,
			TransactionType transactionType) throws AccountNotFoundException {
		Account account = this.checkAccount(idClient, idAccount);
		BigDecimal balanceResult = null;
		if (transactionType.equals(TransactionType.DEPOSIT)) {
			balanceResult = account.getBalance().add(amount);
		}
		if (transactionType.equals(TransactionType.WITHDRAWAL)) {
			balanceResult = account.getBalance().subtract(amount);
		}
		account.setBalance(balanceResult);
		this.iAccountFakeRepository.updateAccount(account);
		Transaction transaction = new Transaction(null, balanceResult, amount, LocalDateTime.now(), transactionType, account);
		this.iTransactionFakeRepository.saveTransaction(transaction);
	}

	@Override
	public List<Transaction> findTransactionList(Long idClient, Long idAccount) throws AccountNotFoundException {
		this.checkAccount(idClient, idAccount);
		return this.iTransactionFakeRepository.findTransactionListByIdAccount(idAccount);
	}

	private Account checkAccount(Long idClient, Long idAccount) throws AccountNotFoundException {
		Optional<Account> accountOptional = this.iAccountFakeRepository.getAccountByIdAccount(idAccount);
		if (accountOptional.isPresent()) {
			Account account = accountOptional.get();
			Client client = account.getClient();
			if (client != null && client.getId().equals(idClient)) {
				return account;
			}
		}
		throw new AccountNotFoundException("Account " + idAccount + " not found for Client " + idClient);
	}

}
