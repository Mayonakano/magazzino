package com.rgi.controller.warehouse;

import com.rgi.model.product.Product;
import com.rgi.model.subcategory.Subcategory;
import com.rgi.model.warehouse.Warehouse;
import com.rgi.service.product.ProductService;
import com.rgi.service.subcategory.SubcategoryService;
import com.rgi.service.warehouse.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        warehouse.setProduct(new Product());
        warehouse.getProduct().setSubcategory(new Subcategory());
        model.addAttribute("newWarehouse", warehouse);
        model.addAttribute("products", prodService.products());
        model.addAttribute("subcategories", subService.subcategories());
        return "newWarehouse";
    }

    @PostMapping("/newwarehouse")
    public String addOne(@ModelAttribute Warehouse newWarehouse, Model model) {
        Product product = prodService.product(newWarehouse.getProduct().getId()).orElse(null);
        Subcategory subcategory = subService.subcategory(newWarehouse.getProduct().getSubcategory().getId()).orElse(null);
        newWarehouse.setProduct(product);
        newWarehouse.getProduct().setSubcategory(subcategory);
        if (newWarehouse.getBasePrice()>0 && newWarehouse.getQuantity()>0 && newWarehouse.getProduct().getSubcategory()!= null
                && newWarehouse.getProduct().getShortDescription()!= null && !" ".equals(newWarehouse.getProduct().getShortDescription())
                && newWarehouse.getProduct().getName()!= null && !" ".equals(newWarehouse.getProduct().getName())) {
            warService.addWarehouse(newWarehouse);
        } else {
            return "paginaErrore";
        }
        model.addAttribute("warehouses", warService.getWarehouses());
        return allWare(model);
    }

    @GetMapping("/deletewarehouse/{id}")
    public String deleteOne(@PathVariable long id, Model model) {
        warService.deleteWarehouse(id);
        model.addAttribute("warehouses", warService.getWarehouses());
        return allWare(model);
    }

    @GetMapping("/editwarehouse/{id}")
    public String editWarehouse (@PathVariable long id, Model model) {
        Optional<Warehouse> w = warService.getWarehouse(id);
        model.addAttribute("editWarehouse", w);
        model.addAttribute("products", prodService.products());
        model.addAttribute("subcategories", subService.subcategories());
        return "editWarehouse";
    }

    @PostMapping("/editwarehouse")
    public String saveEditWarehouse (@ModelAttribute Warehouse newWarehouse, Model model) {
        if (newWarehouse.getBasePrice()>0 && newWarehouse.getQuantity()>0 && newWarehouse.getProduct().getSubcategory()!= null
                && newWarehouse.getProduct().getShortDescription()!= null && !" ".equals(newWarehouse.getProduct().getShortDescription())
                && newWarehouse.getProduct().getName()!= null && !" ".equals(newWarehouse.getProduct().getName())) {
            warService.updateWarehouse(newWarehouse);
        } else {
            return "paginaErrore";
        }
        return allWare(model);
    }
}