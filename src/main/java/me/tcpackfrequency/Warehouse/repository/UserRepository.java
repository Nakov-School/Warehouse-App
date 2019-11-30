package me.tcpackfrequency.Warehouse.repository;

import me.tcpackfrequency.Warehouse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();

    @Query(value = "SELECT user_name FROM users", nativeQuery = true)
    List<String> findAllNames();
}
