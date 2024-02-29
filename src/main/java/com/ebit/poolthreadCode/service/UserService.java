package com.ebit.poolthreadCode.service;

import java.util.List;

import com.ebit.poolthreadCode.entity.User;

public interface UserService {

	void saveUsersInChunks(List<User> users);

}
