package com.rgi.service.subcategory;

import com.rgi.dao.subcategory.SubcategoryRepository;
import com.rgi.model.category.Category;
import com.rgi.model.subcategory.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
@Service
public class SubcategoryService {
    @Autowired
    private SubcategoryRepository repo;


    public Collection<? extends Subcategory> subcategories() {

        return (Collection<? extends Subcategory>) repo.findAll();

    }


    public Optional<Subcategory> subcategory (long id) {

        return repo.findById(id);

    }

    public void addSubcategory(Subcategory subcategory) {
        repo.save(subcategory);
    }

    public void updateSubcategory(Subcategory subcategory) {
        Optional<Subcategory> toModify = subcategory(subcategory.getId());
        toModify.ifPresent(m -> repo.save(subcategory));
    }

    public void deleteSubcategory(long id) {
        Optional<Subcategory> subcategory = subcategory(id);
        subcategory.ifPresent(sub -> repo.delete(sub));
    }

    public boolean alreadyExist (Subcategory subcategory) {
        for (Subcategory s : subcategories()) {
            if (s.getName().equalsIgnoreCase(subcategory.getName()) && s.getCategory().equals(subcategory.getCategory())) {
                return true;
            }
        }
        return false;
    }
}
