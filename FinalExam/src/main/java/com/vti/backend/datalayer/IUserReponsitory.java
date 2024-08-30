package com.vti.backend.datalayer;

public interface IUserReponsitory {
	public abstract boolean checkLogin(String email, String password);
}
