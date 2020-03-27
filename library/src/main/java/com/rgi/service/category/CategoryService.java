package com.rgi.service.category;

import com.rgi.dao.category.CategoryRepository;
import com.rgi.model.category.Category;

import com.rgi.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;


    public Collection<? extends Category> categories() {

        return (Collection<? extends Category>) repository.findAll();

    }


    public Optional<Category> category(long id){
        return repository.findById(id);
    }



    public void addCategory(Category category) {
        repository.save(category);
    }


    public void updateCategory(Category category) {
        Optional<Category> toDelete = category(category.getId());
        toDelete.ifPresent(c -> repository.save(category));
    }

    public void deleteCategory(long id) {
        Optional<Category> category= repository.findById(id);
        category.ifPresent(value -> repository.delete(value));
    }



}
