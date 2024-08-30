package com.vti.backend.businesslayer;

public interface IUserService {
	public abstract boolean checkLogin(String email, String password);
}
