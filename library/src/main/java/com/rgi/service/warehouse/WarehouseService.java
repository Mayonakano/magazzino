package com.rgi.service.warehouse;

import com.rgi.dao.warehouse.WarehouseRepository;
import com.rgi.model.warehouse.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseRepository warRepo;

    public Collection<? extends Warehouse> getWarehouses () {
        return (Collection<? extends Warehouse>)warRepo.findAll();
    }

    public Optional<Warehouse> getWarehouse (long id) {
        return warRepo.findById(id);
    }

    public void addWarehouse (Warehouse warehouse) {
        warRepo.save(warehouse);
    }

    public void deleteWarehouse (long id) {
        Optional<Warehouse> toDelete = getWarehouse(id);
        toDelete.ifPresent(w -> warRepo.delete(w));
    }

    public void updateWarehouse (Warehouse warehouse) {
        Optional<Warehouse> toModify = getWarehouse(warehouse.getId());
        toModify.ifPresent(m -> warRepo.save(warehouse));
    }

}
