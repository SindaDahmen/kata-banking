package fr.sg.kata.service;

import java.math.BigDecimal;
import java.util.List;

import fr.sg.kata.dto.Transaction;
import fr.sg.kata.exception.AccountNotFoundException;
import fr.sg.kata.utils.TransactionType;

public interface IAccountOperationsService {

	void depositWithdrawalMoney(Long idClient, Long idAccount, BigDecimal amount, TransactionType transactionType)
			throws AccountNotFoundException;

	List<Transaction> findTransactionList(Long idClient, Long idAccount) throws AccountNotFoundException;

}
