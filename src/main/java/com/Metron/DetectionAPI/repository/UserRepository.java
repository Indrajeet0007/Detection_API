package com.Metron.DetectionAPI.repository;

import com.Metron.DetectionAPI.enities.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserTable, Long> {
    public Optional <UserTable> findByUserName (String userName);
}
