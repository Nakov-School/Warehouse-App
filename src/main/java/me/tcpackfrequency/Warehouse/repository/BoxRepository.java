package me.tcpackfrequency.Warehouse.repository;

import me.tcpackfrequency.Warehouse.model.Box;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoxRepository extends JpaRepository<Box, Integer> {

    List<Box> findAll();

}
