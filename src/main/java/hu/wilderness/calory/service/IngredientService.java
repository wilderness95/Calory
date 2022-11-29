package hu.wilderness.calory.service;

import hu.wilderness.calory.dataacces.dao.IngredientJdbcDao;
import hu.wilderness.calory.domain.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IngredientJdbcDao ingredientJdbcDao;


    public List<Ingredient> getAllIngredients(){
        List<Ingredient> ingredientList = ingredientJdbcDao.findAll();
        return ingredientList;
    }

    public Ingredient save(Ingredient ingredient){
        if (ingredient.getId() == null) {
            ingredient = ingredientJdbcDao.insert(ingredient);
            log.debug("ingredient has been successfully saved....");
        } else {
            ingredient = ingredientJdbcDao.update(ingredient);
            log.debug("ingredient has been successfully updated....");
        }
        return ingredient;
    }
}
