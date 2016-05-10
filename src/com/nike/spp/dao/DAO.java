package com.nike.spp.dao;

import com.nike.spp.dto.User;

public interface DAO {

	public void add();

	public User getUserByName(String name);

}
