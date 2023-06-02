package com.example.users.infrastructure.repository;

import com.example.users.domain.dto.UserDto;
import com.example.users.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {


    @Override
    Optional<User> findById(Long id);

    @Query(value = "SELECT * FROM USERS ", nativeQuery = true)
    List<Object[]> findAllUsers();


}
