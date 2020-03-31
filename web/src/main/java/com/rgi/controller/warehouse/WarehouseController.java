package com.rgi.controller.warehouse;

import com.rgi.model.product.Product;
import com.rgi.model.warehouse.Warehouse;
import com.rgi.service.product.ProductService;
import com.rgi.service.subcategory.SubcategoryService;
import com.rgi.service.warehouse.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/magazzino")
public class WarehouseController {
    @Autowired
    private WarehouseService warService;

    @Autowired
    private ProductService prodService;

    @Autowired
    private SubcategoryService subService;

    @GetMapping("/warehouses")
    public String allWare (Model model) {
        List<Warehouse> warehouseList = (List<Warehouse>) warService.getWarehouses();
        model.addAttribute("warehouses", warehouseList);
        return "warehouses";
    }

    @GetMapping("/warehouse/{id}")
    public String warehouse (@PathVariable long id, Model model) {
        Optional<Warehouse> w = warService.getWarehouse(id);
        model.addAttribute("warehouse", w);
        model.addAttribute("products", prodService.products());
        return "warehouse";
    }

    @GetMapping("/addwarehouse")
    public String newWarehouse(Model model) {
        Warehouse warehouse = new Warehouse();
        warehouse.setProducts(new ArrayList<>());
        model.addAttribute("newWarehouse", warehouse);
        model.addAttribute("products", prodService.products());
        model.addAttribute("subcategories", subService.subcategories());
        return "newWarehouse";
    }

    @PostMapping("/addwarehouse")
    public String addWarehouse(@ModelAttribute Warehouse warehouse, Model model) {
        warService.addWarehouse(warehouse);
        model.addAttribute("warehouses", warService.getWarehouses());
        return "warehouses";
    }

    @PostMapping("/warehouse/{id}/addonwarehouse")
    public String addOne(@PathVariable long warehouseId,@ModelAttribute Product newProduct, Model model) {
        if (newProduct.getBasePrice()>0 && newProduct.getQuantity()>0 && newProduct.getSubcategory()!= null
                && newProduct.getShortDescription()!= null && !" ".equals(newProduct.getShortDescription())
                && newProduct.getName()!= null && !" ".equals(newProduct.getName())) {
            warService.addProductOnWarehouse(warehouseId, newProduct);
        } else {
            return "paginaErrore";
        }
        model.addAttribute("warehouses", warService.getWarehouses());
        return allWare(model);
    }

    @GetMapping("/warehouse/{id}/deleteproductonwarehouse/{id}")
    public String deleteOne(@PathVariable long warehouseId,@PathVariable long productId, Model model) {
        warService.deleteProductOnWarehouse(warehouseId, productId);
        model.addAttribute("warehouses", warService.getWarehouses());
        return allWare(model);
    }

    @GetMapping("/deletewarehouse/{id}")
    public String deleteWar(@PathVariable long id, Model model) {
        warService.deleteWarehouse(id);
        model.addAttribute("warehouses", warService.getWarehouses());
        return "warehouses";
    }


    @GetMapping("/editwarehouse/{id}")
    public String editWarehouse (@PathVariable long id, Model model) {
        Optional<Warehouse> w = warService.getWarehouse(id);
        model.addAttribute("editWarehouse", w);
        return "editWarehouse";
    }

    @PostMapping("/editwarehouse")
    public String saveEditWarehouse (@ModelAttribute Warehouse newWarehouse, Model model) {
        if (newWarehouse.getName()!=null && !"".equals(newWarehouse.getName())){
            warService.updateWarehouse(newWarehouse);
        } else {
            return "erroreWarehouse";
        }
        model.addAttribute("warehouses", warService.getWarehouses());
        return allWare(model);
    }
}