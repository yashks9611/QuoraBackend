package com.example.QuoraProject.repository.impl;

import com.example.QuoraProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User,String> {

}
