package com.rgi.controller.warehouse;

import com.rgi.model.warehouse.Warehouse;
import com.rgi.service.warehouse.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/magazzino")
public class WarehouseController {
    @Autowired
    private WarehouseService warService;

    @GetMapping("/warehouse")
    public String magazzino (Model model) {
        List<Warehouse> warehouseList = (List<Warehouse>) warService.getWarehouses();
        model.addAttribute("warehouse", warehouseList);
        return "warehouse";
    }
}
