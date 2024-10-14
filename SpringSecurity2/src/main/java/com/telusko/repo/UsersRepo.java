package com.telusko.repo;

import com.telusko.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, String> {
   Users findByUserName(String userName);
}
