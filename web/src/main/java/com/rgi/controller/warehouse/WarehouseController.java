package com.rgi.controller.warehouse;

import com.rgi.model.warehouse.Warehouse;
import com.rgi.service.warehouse.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/magazzino")
public class WarehouseController {
    @Autowired
    private WarehouseService warService;

    @GetMapping("/warehouse")
    public String magazzino (@ModelAttribute Warehouse warehouse, Model model) {
        model.addAttribute("warehouse", warehouse);
        return "warehouse";
    }

    @PostMapping("/stockwarehouse")
    public void addProdOnWarehouse (@ModelAttribute Warehouse warehouse, Model model, long id) {
        warService.getWarehouse(id);
    }
}
