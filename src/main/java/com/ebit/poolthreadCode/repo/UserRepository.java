package com.ebit.poolthreadCode.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebit.poolthreadCode.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
