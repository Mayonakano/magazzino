package com.rgi.controller.subcategory;

import com.rgi.model.category.Category;
import com.rgi.model.subcategory.Subcategory;
import com.rgi.service.subcategory.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/magazzino")
public class SubcategoryController {
    @Autowired
    private SubcategoryService subservice;

    @GetMapping("/subcategories")
    public String subcategories (Model model) {
        List<Subcategory>listasubcategories = (List<Subcategory>)subservice.subcategories();
        model.addAttribute("subcategories", listasubcategories);
        return "subcategories";
    }

    @GetMapping("/addsubcategory")
    public String newSubcategory(Model model) {
        model.addAttribute("newSubcategory", new Subcategory());
        return "newSubcategory";
    }

    @PostMapping("/newsubcategory")
    public String addOne(@ModelAttribute Subcategory newSubcategory, Model model) {
        if (subservice.subcategories().contains(newSubcategory)) {
            return "paginaErrore";
        } else {
            subservice.addSubcategory(newSubcategory);
        }
        return subcategories(model);
    }

    @GetMapping("/editsubcategory/{id}")
    public String editSubcategory(@PathVariable long id, @ModelAttribute Subcategory editSubcategory, Model model) {
        Optional<Subcategory> s = subservice.subcategory(id);
        if (s == null)
            return "paginaErrore";
        model.addAttribute("editSubcategory", editSubcategory);
        return "editSubcategory";
    }

    @PostMapping("/savesubcategory")
    public String saveSubcategoty (@ModelAttribute Subcategory saveSubcategory, Model model) {
        Subcategory s = saveSubcategory;
        if(s == null) {
            return "paginaErrore";
        } else {
            subservice.updateSubcategory(s);
        }
        return subcategories(model);
    }

    @GetMapping("/deletesubcategory/{id}")
    public String deleteOne(@PathVariable long id, Model model) {
        subservice.deleteSubcategory(id);
        return subcategories(model);
    }

}
