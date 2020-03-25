package com.rgi.dao.warehouse;

import com.rgi.model.warehouse.Warehouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends CrudRepository<Warehouse, Long> {
}
