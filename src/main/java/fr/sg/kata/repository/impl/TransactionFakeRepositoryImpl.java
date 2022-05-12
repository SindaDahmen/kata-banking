package fr.sg.kata.repository.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.sg.kata.dto.Account;
import fr.sg.kata.dto.Client;
import fr.sg.kata.dto.Transaction;
import fr.sg.kata.repository.ITransactionFakeRepository;
import fr.sg.kata.utils.TransactionType;

@Repository("TransactionFakeRepositoryImpl")
public class TransactionFakeRepositoryImpl implements ITransactionFakeRepository {
	
	Client fakeClient = new Client(1L, "abc", "xyz", null);
	Account fakeAccount = new Account(1001L, new BigDecimal(1000), fakeClient, null);
	Transaction transaction1 = new Transaction(456L, new BigDecimal(1000), new BigDecimal(50), LocalDateTime.of(2022, 05, 05, 16, 10), TransactionType.DEPOSIT, fakeAccount);
	Transaction transaction2 = new Transaction(789L, new BigDecimal(950), new BigDecimal(20), LocalDateTime.of(2022, 05, 12, 11, 22), TransactionType.WITHDRAWAL, fakeAccount);
	List<Transaction> transactionList = new ArrayList<>(Arrays.asList(transaction1, transaction2));

	@Override
	public void saveTransaction(Transaction transaction) {
		transactionList.add(transaction);
	}

	@Override
	public List<Transaction> findTransactionListByIdAccount(Long idAccount) {
		return transactionList;
	}

}
