package fr.sg.kata.repository;

import java.util.List;

import fr.sg.kata.dto.Transaction;

public interface ITransactionFakeRepository {

	void saveTransaction(Transaction transaction);

	List<Transaction> findTransactionListByIdAccount(Long idAccount);

}
