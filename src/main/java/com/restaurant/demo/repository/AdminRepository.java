package com.restaurant.demo.repository;

import com.restaurant.demo.domain.TableEntity;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository <TableEntity, Long> {
}
