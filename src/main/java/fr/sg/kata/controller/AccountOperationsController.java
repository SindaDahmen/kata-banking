package fr.sg.kata.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.sg.kata.dto.Transaction;
import fr.sg.kata.exception.AccountNotFoundException;
import fr.sg.kata.service.IAccountOperationsService;
import fr.sg.kata.utils.TransactionType;

@RestController
public class AccountOperationsController {

	@Autowired
	@Qualifier("AccountOperationsServiceImpl")
	private IAccountOperationsService iAccountOperationsService;

	@PostMapping(value = "/depositMoney")
	public void depositMoney(@RequestParam("idClient") Long idClient, @RequestParam("idAccount") Long idAccount,
			@RequestParam("amount") BigDecimal amount) throws AccountNotFoundException {
		this.iAccountOperationsService.depositWithdrawalMoney(idClient, idAccount, amount, TransactionType.DEPOSIT);
	}

	@PostMapping(value = "/withdrawalMoney")
	public void withdrawalMoney(@RequestParam("idClient") Long idClient, @RequestParam("idAccount") Long idAccount,
			@RequestParam("amount") BigDecimal amount) throws AccountNotFoundException {
		this.iAccountOperationsService.depositWithdrawalMoney(idClient, idAccount, amount, TransactionType.WITHDRAWAL);
	}

	@GetMapping(value = "/findTransactionList")
	public List<Transaction> findTransactionList(@RequestParam("idClient") Long idClient,
			@RequestParam("idAccount") Long idAccount) throws AccountNotFoundException {
		return this.iAccountOperationsService.findTransactionList(idClient, idAccount);
	}

}
