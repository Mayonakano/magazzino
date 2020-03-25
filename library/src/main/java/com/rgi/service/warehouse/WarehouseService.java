package com.rgi.service.warehouse;

import com.rgi.dao.product.ProductRepository;
import com.rgi.dao.warehouse.WarehouseRepository;
import com.rgi.model.warehouse.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

public class WarehouseService {

    @Autowired
    private WarehouseRepository repo;
    @Autowired
    private ProductRepository repoPro;

    public void updateWarehouse (Warehouse warehouse) {
        Optional<Warehouse> toModify = repo.findById(warehouse.getId());
        toModify.ifPresent(w -> repo.save(warehouse));
    }

    public void deleteWarehouse (long id) {
        Optional<Warehouse> toDelete = repo.findById(id);
        toDelete.ifPresent(w -> repo.delete(w));
    }

}
