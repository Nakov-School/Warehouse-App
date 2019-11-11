package me.tcpackfrequency.Warehouse.repository;

import me.tcpackfrequency.Warehouse.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
