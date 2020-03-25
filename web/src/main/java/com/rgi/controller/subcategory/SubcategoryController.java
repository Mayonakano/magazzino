package com.rgi.controller.subcategory;

import com.rgi.model.category.Category;
import com.rgi.model.subcategory.Subcategory;
import com.rgi.service.category.CategoryService;
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
    private SubcategoryService subService;
    @Autowired
    private CategoryService cateService;

    @GetMapping("/subcategories")
    public String subcategories (Model model) {
        List<Subcategory>listasubcategories = (List<Subcategory>)subService.subcategories();
        model.addAttribute("subcategories", listasubcategories);
        return "subcategories";
    }

    @GetMapping("/subcategory")
    public String subcategory (long id, Model model) {
        Subcategory subcategorySelected = subService.subcategory(id).orElse(null);
        model.addAttribute("subcategory", subcategorySelected);
        return "subcategory";
    }

    @GetMapping("/addsubcategory")
    public String newSubcategory(Model model) {
        model.addAttribute("newSubcategory", new Subcategory());
        return "newSubcategory";
    }

    @PostMapping("/newsubcategory")
    public String addOne(@ModelAttribute Subcategory newSubcategory, Model model) {
        if (subService.subcategories().contains(newSubcategory)) {
            return "paginaErrore";
        } else {
            subService.addSubcategory(newSubcategory);
        }
        return subcategories(model);
    }

    @GetMapping("/editsubcategory/{id}")
    public String editSubcategory(@PathVariable long id, @ModelAttribute Subcategory editSubcategory, Model model) {
        Optional<Subcategory> s = subService.subcategory(id);
        model.addAttribute("editSubcategory", editSubcategory);
        model.addAttribute("categories", cateService.categories());
        return "editSubcategory";
    }

    @PostMapping("/savesubcategory")
    public String saveSubcategoty (@ModelAttribute Subcategory saveSubcategory, Model model) {
        Subcategory s = saveSubcategory;
        subService.updateSubcategory(s);
        return subcategories(model);
    }

    @GetMapping("/deletesubcategory/{id}")
    public String deleteOne(@PathVariable long id, Model model) {
        subService.deleteSubcategory(id);
        return subcategories(model);
    }

}
