package com.ebit.poolthreadCode.serviceImpl;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebit.poolthreadCode.entity.User;
import com.ebit.poolthreadCode.repo.UserRepository;
import com.ebit.poolthreadCode.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUsersInChunks(List<User> users) {
		int chunkSize = 1000; // Define your chunk size
		ExecutorService executor = Executors.newFixedThreadPool(5); // Adjust number of threads as needed

		for (int i = 0; i < users.size(); i += chunkSize) {
			List<User> chunk = users.subList(i, Math.min(i + chunkSize, users.size()));
			executor.submit(() -> {
				userRepository.saveAll(chunk);
			});
		}

		executor.shutdown();
	}
}
