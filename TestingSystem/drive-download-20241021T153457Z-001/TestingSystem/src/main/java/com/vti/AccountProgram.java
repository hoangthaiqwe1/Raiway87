package com.vti;

import java.util.Date;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Group;
import com.vti.repository.AccountRepository;


public class AccountProgram {
	public static void main(String[] args) {
		AccountRepository repository = new AccountRepository();

//		System.out.println("***********GET ALL ACCOUNTS***********");
//
//		List<Account> accounts = repository.getAllAccounts();
//
//		for (Account account : accounts) {
//			System.out.println(account);
//		}

//		System.out.println("\n\n***********GET ACCOUNT BY ID***********");
//
//		Account accountById = repository.getAccountByID((short) 2);
//		System.out.println(accountById);
//
//		System.out.println("\n\n***********GET ACCOUNT BY NAME***********");
//
//		Account accountByName = repository.getAccountByName("quanganh");
//		System.out.println(accountByName);

//		System.out.println("\n\n***********CREATE ACCOUNT***********");
//
//		Account accountCreate = new Account();
//		accountCreate.setEmail("thaidang11041104@gmail.com");
//		accountCreate.setName("HoangThai1104");
//		accountCreate.setFirstName("Hoang Thai");
//		accountCreate.setLastName("Dang Le");
//		repository.createAccount(accountCreate);
//
//		System.out.println("\n\n***********UPDATE ACCOUNT 1***********");
//
//		repository.updateAccount((short) 11, "thaidang110411041@gmail.com","HoangThai1104","Hoang Thai","Dang Le");

//		System.out.println("\n\n***********UPDATE ACCOUNT 2***********");
//
//		Account accountUpdate = new Account();
//		accountUpdate.setId((short) 2);
//		accountUpdate.setEmail("thaidang11@gmail.com");
//		accountUpdate.setName("HoangThai114");
//		accountUpdate.setFirstName("Hoang thai");
//		accountUpdate.setLastName("Dang");
//		repository.updateAccount(accountUpdate);
//
//		System.out.println("\n\n***********DELETE ACCOUNTS***********");
//		repository.deleteAccount((short) 2);
//
//		System.out.println("***********CHECK ACCOUNT EXISTS BY ID***********");
//		System.out.println(repository.isAccountExistsByID((short) 1));
//
		System.out.println("***********CHECK ACCOUNT EXISTS BY NAME***********");
		System.out.println(repository.isAccountExistsByName("dangblack"));

	}
}
