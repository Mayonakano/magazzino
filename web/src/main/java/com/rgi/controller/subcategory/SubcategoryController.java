package com.rgi.controller.subcategory;

import com.rgi.model.category.Category;
import com.rgi.model.product.Product;
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

    @GetMapping("/addsubcategory")
    public String newSubcategory(Model model) {
        Subcategory newSubcategory = new Subcategory();
        newSubcategory.setCategory(new Category());
        model.addAttribute("newSubcategory", new Subcategory());
        model.addAttribute("categories", cateService.categories());
        return "newSubcategory";
    }

    @PostMapping("/newsubcategory")
    public String addOne(@ModelAttribute Subcategory newSubcategory, Model model) {
        Category category = cateService.category(newSubcategory.getCategory().getId()).orElse(null);
        newSubcategory.setCategory(category);
        newSubcategory.getName().trim();
        newSubcategory.getDescription().trim();
        if(newSubcategory.getName() == null || newSubcategory.getCategory() == null || newSubcategory.getDescription() == null) {
            return "erroreAddSubcategory";
        } else if (subService.alreadyExist(newSubcategory)) {
                    return "copyAddSubcategory";
        } else {
             subService.addSubcategory(newSubcategory);
        }
        model.addAttribute("subcategories", subService.subcategories());
        return subcategories(model);
    }

    @GetMapping("/editsubcategory/{id}")
    public String editSubcategory(@PathVariable long id, Model model) {
        Optional<Subcategory> subcategory = subService.subcategory(id);
            model.addAttribute("editSubcategory", subcategory);
            model.addAttribute("categories", cateService.categories());
            return "editSubcategory";
    }

    @PostMapping("/savesubcategory")
    public String saveSubcategoty (@ModelAttribute Subcategory saveSubcategory, Model model) {
        Subcategory s = saveSubcategory;
        s.getName().trim();
        s.getDescription().trim();
        if(s.getName() == null || s.getCategory() == null || s.getDescription() == null) {
            return "erroreEditSubcategory";
        } else if(subService.alreadyExist(s)) {
            return "copyEditSubcategory";
        } else {
             subService.updateSubcategory(s);
        }
        return subcategories(model);
    }

    @GetMapping("/deletesubcategory/{id}")
    public String deleteOne(@PathVariable long id, Model model) {
        subService.deleteSubcategory(id);
        return subcategories(model);
    }

}
