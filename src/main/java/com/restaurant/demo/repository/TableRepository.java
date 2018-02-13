package com.restaurant.demo.repository;


import com.restaurant.demo.domain.TableEntity;
import com.restaurant.demo.domain.TableType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TableRepository extends CrudRepository<TableEntity, Long> {
	public List<TableEntity> findByTableType(TableType quadriple);
}
