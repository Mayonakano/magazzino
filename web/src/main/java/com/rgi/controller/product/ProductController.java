package com.rgi.controller.product;

import com.rgi.model.product.Product;
import com.rgi.model.subcategory.Subcategory;
import com.rgi.service.product.ProductService;
import com.rgi.service.subcategory.SubcategoryService;
import com.rgi.service.warehouse.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/magazzino")
public class ProductController {

     @Autowired
     private ProductService service;

     @Autowired
     private SubcategoryService subcategoryService;

     @Autowired
     private WarehouseService warSub;

     @GetMapping
     public String home(Model model) {
         model.addAttribute("home", model);
         return "home";
     }
     @GetMapping("/products")
     public String products(Model model) {
         List<Product> productsList = (List<Product>)service.products();
       model.addAttribute("products",productsList );
       return "products";
     }
     @GetMapping("/product/{id}")
     public String product(Model model, long id) {
         Optional<Product> product = service.product(id);
         model.addAttribute("product",product);
         return "product";
     }
     @GetMapping("/addproduct")
     public String newProduct(Model model) {
        Product newProduct = new Product();
        newProduct.setSubcategory(new Subcategory());
        model.addAttribute("newProduct", newProduct);
        model.addAttribute("warehouses", warSub.getWarehouses());
        model.addAttribute("subcategories", subcategoryService.subcategories());
        return "newProduct";
    }

     @PostMapping("/newproduct")
     public String addOne(@ModelAttribute Product newProduct, Model model) {
         Subcategory subcategory = subcategoryService.subcategory(newProduct.getSubcategory().getId()).orElse(null);
         newProduct.setSubcategory(subcategory);
         if (newProduct.getName() == null || " ".equals(newProduct.getName()) || "".equals(newProduct.getName()) ||
                 newProduct.getSubcategory() == null || newProduct.getShortDescription() == null
                 || " ".equals(newProduct.getShortDescription()) || "".equals(newProduct.getShortDescription())) {
             return "erroreAddProduct";
            } else {
              service.addProduct(newProduct);
         }
         model.addAttribute("products", service.products());
         return products(model);
     }

     @GetMapping("/deleteproduct/{id}")
        public String deleteOne(@PathVariable long id, Model model) {
        service.deleteProduct(id);
        model.addAttribute("products", service.products());
        return "products";
     }

     @GetMapping("/editproduct/{id}")
     public String editProduct (@PathVariable long id, Model model) {
         Optional<Product> p = service.product(id);
         model.addAttribute("editProduct", p);
         model.addAttribute("subcategories", subcategoryService.subcategories());
         return "editProduct";
     }

     @PostMapping("/editproduct")
     public String saveEditProduct (@ModelAttribute Product newProduct, Model model) {
         if (newProduct.getName().equals(null) || " ".equals(newProduct.getName()) || "".equals(newProduct.getName()) ||
                 newProduct.getSubcategory().equals(null) || newProduct.getShortDescription().equals(null)
                 || " ".equals(newProduct.getShortDescription()) || "".equals(newProduct.getShortDescription())) {
                 return "erroreEditProduct";
            } else if (service.products().contains(newProduct)) {
             List<Product> productList = (List<Product>)service.products();
             for(Product p : productList) {
                 if(p.getName().equals(newProduct.getName())) {
                     p.setQuantity(p.getQuantity() + newProduct.getQuantity());
                     break;
                 }
             }
             return products(model);
            } else {
             service.updateProduct(newProduct);
            }
         return products(model);
     }
}