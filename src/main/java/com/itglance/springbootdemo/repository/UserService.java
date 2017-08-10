package com.itglance.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itglance.springbootdemo.entity.User;

public interface UserService extends JpaRepository<User,Integer>
{

}
 