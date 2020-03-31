package com.rgi.service.warehouse;

import com.rgi.dao.product.ProductRepository;
import com.rgi.dao.warehouse.WarehouseRepository;
import com.rgi.model.product.Product;
import com.rgi.model.warehouse.Warehouse;
import com.rgi.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseRepository warRepo;

    @Autowired
    private ProductRepository prodRepo;

    public Collection<? extends Warehouse> getWarehouses () {
        return (Collection<? extends Warehouse>)warRepo.findAll();
    }

    public Optional<Warehouse> getWarehouse (long id) {
        return warRepo.findById(id);
    }

    public void addWarehouse (Warehouse warehouse) {
        warRepo.save(warehouse);
    }

    public void deleteProductOnWarehouse (long productId, long warehouseId) {
        Warehouse warehouse = getWarehouse(warehouseId).orElse(null);
        Product product = warehouse.getProducts().get((int) productId);
        warehouse.getProducts().remove(product);
    }

    public void addProductOnWarehouse (long id, Product product) {
        Warehouse warehouse = getWarehouse(id).orElse(null);
        warehouse.getProducts().add(product);
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
