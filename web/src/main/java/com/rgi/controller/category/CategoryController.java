package com.rgi.controller.category;

import com.rgi.model.category.Category;
import com.rgi.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/magazzino")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String categories(Model model) {
        List<Category> categoryList = new ArrayList<Category>();
        categoryList = (List<Category>) categoryService.categories();
        model.addAttribute("categories", categoryList);
        return "categories";
    }

    @GetMapping("/addcategory")
    public String newCategory(Model model) {
        model.addAttribute("newCategory", new Category());
        return "newCategory";
    }

    @PostMapping("/newcategory")
    public String addOne(@ModelAttribute Category newCategory, Model model) {
      List<Category> categoryList = (List<Category>) categoryService.categories();
        if (newCategory.getName().equals(null) || " ".equals(newCategory.getName())
              || "".equals(newCategory.getName()) || newCategory.getTax()<=0) {
                return "erroreAddCategory";
        } else if (categoryService.alreadyExist(newCategory)) {
                return "copyAddCategory";
        } else {
                categoryService.addCategory(newCategory);
        }
        return categories(model);
    }

    @GetMapping("/editcategory/{id}")
    public String editCategory(@PathVariable long id, Model model) {
        Optional<Category> c = categoryService.category(id);
        model.addAttribute("editCategory", c);
        return "editCategory";
    }

    @PostMapping("/savecategory")
    public String saveCategory (@ModelAttribute Category editCategory, Model model) {
        Category c = editCategory;
        if(c.getName().equals(null) || " ".equals(c.getName()) || "".equals(c.getName()) || c.getTax()<=0) {
            return "erroreEditCategory";
        } else if(categoryService.categories().contains(c)) {
            return "copyEditCategory";
            } else {
            categoryService.updateCategory(c);
        }
        return categories(model);
    }

    @GetMapping("/deletecategory/{id}")
    public String deleteOne(@PathVariable long id, Model model) {
        categoryService.deleteCategory(id);
        return categories(model);
    }
}