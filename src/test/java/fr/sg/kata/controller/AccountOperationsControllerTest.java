package fr.sg.kata.controller;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.sg.kata.dto.Transaction;
import fr.sg.kata.utils.TransactionType;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountOperationsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void deposit_money_test_with_account_not_found() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("idClient", "1001");
		params.add("idAccount", "456789");
		params.add("amount", "55.5");
		MvcResult mvcResult;
		try {
			mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/depositMoney").params(params)).andReturn();
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Account 456789 not found for Client 1001"));
		}
	}

	@Test
	void deposit_money_test() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("idClient", "1");
		params.add("idAccount", "1001");
		params.add("amount", "55.5");
		mockMvc.perform(MockMvcRequestBuilders.post("/depositMoney").params(params)).andReturn();
		
		// Check the add of Transaction
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/findTransactionList").params(params)).andReturn();
		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		List<Transaction> transactionList = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<Transaction>>() {});
		assertTrue(transactionList.size() == 3);
		assertTrue(transactionList.get(2).getBalance().equals(new BigDecimal(1055.5)));
		assertTrue(transactionList.get(2).getAmount().equals(new BigDecimal(55.5)));
		assertTrue(transactionList.get(2).getTransactionType().equals(TransactionType.DEPOSIT));
	}

	@Test
	void withdrawal_money_test_with_account_not_found() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("idClient", "1002");
		params.add("idAccount", "456789");
		params.add("amount", "55.5");
		MvcResult mvcResult;
		try {
			mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/withdrawalMoney").params(params)).andReturn();
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Account 456789 not found for Client 1002"));
		}
	}
	
	@Test
	void withdrawal_money_test() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("idClient", "1");
		params.add("idAccount", "1001");
		params.add("amount", "55.5");
		mockMvc.perform(MockMvcRequestBuilders.post("/withdrawalMoney").params(params)).andReturn();
		
		// Check the add of Transaction
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/findTransactionList").params(params)).andReturn();
		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		List<Transaction> transactionList = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<Transaction>>() {});
		assertTrue(transactionList.size() == 3);
		assertTrue(transactionList.get(2).getBalance().equals(new BigDecimal(944.5)));
		assertTrue(transactionList.get(2).getAmount().equals(new BigDecimal(55.5)));
		assertTrue(transactionList.get(2).getTransactionType().equals(TransactionType.WITHDRAWAL));
	}

	@Test
	void find_transaction_list_test_with_account_not_found() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("idClient", "1003");
		params.add("idAccount", "456789");
		MvcResult mvcResult;
		try {
			mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/findTransactionList").params(params)).andReturn();
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Account 456789 not found for Client 1003"));
		}
	}
	
	@Test
	void find_transaction_list_test() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("idClient", "1");
		params.add("idAccount", "1001");
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/findTransactionList").params(params)).andReturn();
		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		List<Transaction> transactionList = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<Transaction>>() {});
		assertTrue(transactionList.size() == 2);
		assertTrue(transactionList.get(0).getId().equals(456L));
		assertTrue(transactionList.get(1).getId().equals(789L));

	}

}
