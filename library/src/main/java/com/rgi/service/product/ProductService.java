package com.rgi.service.product;


import com.rgi.dao.product.ProductRepository;
import com.rgi.model.category.Category;
import com.rgi.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Collection<? extends Product> products() {
        return (Collection<? extends Product>)repository.findAll();
    }

    public Optional<Product> product(long id) {
        return repository.findById(id);
    }

    public void addProduct(Product product) {
        List<Product> productList = (List<Product>) products();
        boolean finished = false;
        for (int i = 0; i < productList.size(); i++) {
            Product p = productList.get(i);
            if (p.getName().equalsIgnoreCase(product.getName()) && p.getShortDescription().equalsIgnoreCase(product.getShortDescription())
                    && p.getSubcategory().equals(product.getSubcategory())) {
                p.setQuantity(p.getQuantity() + product.getQuantity());
                repository.save(p);
                finished = true;
            }
        }
        if (!finished) {
            repository.save(product);
        }
    }

    public void updateProduct(Product product) {
        List<Product> productList = (List<Product>) products();
        boolean finished = false;
        for (int i = 0; i < productList.size(); i++) {
            Product p = productList.get(i);
            if (p.getName().equalsIgnoreCase(product.getName()) && p.getShortDescription().equalsIgnoreCase(product.getShortDescription())
                    && p.getSubcategory().equals(product.getSubcategory())) {
                p.setQuantity(p.getQuantity() + product.getQuantity());
                repository.save(p);
                finished = true;
            }
        }
        if (!finished) {
            repository.save(product);
        }
    }

    public void deleteProduct(long id) {
        Optional<Product> product = product(id);
        product.ifPresent(value -> repository.delete(value));
    }

    public boolean alreadyExist (Product product) {
        for (Product p : products()) {
            if (p.getName().equalsIgnoreCase(product.getName()) && p.getSubcategory().equals(product.getSubcategory()) &&
                p.getBasePrice()==product.getBasePrice()) {
                return true;
            }
        }
        return false;
    }

}
