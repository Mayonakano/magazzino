package com.rgi.dao.category;


import com.rgi.model.category.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
