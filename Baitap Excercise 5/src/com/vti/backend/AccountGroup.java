package com.vti.backend;

import java.util.Date;

public class AccountGroup {
	String account;
	String group;
	Date create;
	AccountGroup(String account, String group,Date create) {
		this.account = account;
		this.group = group;
		this.create = create;
	}
}
