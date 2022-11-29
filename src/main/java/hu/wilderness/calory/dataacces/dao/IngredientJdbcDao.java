package hu.wilderness.calory.dataacces.dao;

import hu.wilderness.calory.dataacces.dao.parents.BaseJdbcDao;

import hu.wilderness.calory.dataacces.mapper.IngredientMapper;
import hu.wilderness.calory.domain.Ingredient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IngredientJdbcDao extends BaseJdbcDao {

    @Override
    public String getTableName(){
        return "ingredient";
    }

    public List<Ingredient> findAll() {
        String sql = "select * from "+getTableName();
        List<Ingredient> result = jdbcTemplate.query(sql, new IngredientMapper());
        return result;
    }

    public Ingredient insert(Ingredient i){
        Map<String, Object> parameters = new HashMap();
        parameters.put("ingredients_name", i.getIngredientsName());
        parameters.put("energy_in_kj", i.getEnergyInKj());
        parameters.put("energy_in_kcal", i.getEnergyInKcal());
        parameters.put("protein", i.getProtein());
        parameters.put("fat", i.getFat());
        parameters.put("carbohydrate", i.getCarbohydrate());
        parameters.put("sodium", i.getSodium());
        parameters.put("potassium", i.getPotassium());
        parameters.put("calcium", i.getCalcium());
        parameters.put("magnesium", i.getMagnesium());
        parameters.put("retinol", i.getRetinol());
        parameters.put("cholesterol", i.getCholesterol());
        parameters.put("vitamin_c", i.getVitaminC());
        parameters.put("vitamin_b6", i.getVitaminB6());
        parameters.put("vitamin_d", i.getVitaminD());
        parameters.put("vitamin_e", i.getVitaminE());
        parameters.put("ingredients_category", i.getIngredientsCategory());

        Number result = insert.executeAndReturnKey(parameters);
        i.setId(result.longValue());

        return i;
    }

    public Ingredient update(Ingredient i){
        if (i.getId() == null)
            return null;

        String sql = "update " + getTableName() + " set " +
                "     ingredients_name=?, " +
                "     energy_in_kj=?, " +
                "     energy_in_kcal=?, " +
                "     protein=?, " +
                "     fat=?, " +
                "     carbohydrate=?, " +
                "     sodium=?, " +
                "     potassium=?, " +
                "     calcium=?, " +
                "     magnesium=?, " +
                "     retinol=?, " +
                "     cholesterol=?, " +
                "     vitamin_c=?, " +
                "     vitamin_b6=?, " +
                "     vitamin_d=?, " +
                "     vitamin_e=?, " +
                "     ingredients_category=? " +
                "     where " +
                "     id=? ";
        Object[] parameters = {
                i.getIngredientsName(),
                i.getEnergyInKj(),
                i.getEnergyInKcal(),
                i.getProtein(),
                i.getFat(),
                i.getCarbohydrate(),
                i.getSodium(),
                i.getPotassium(),
                i.getCalcium(),
                i.getMagnesium(),
                i.getRetinol(),
                i.getCholesterol(),
                i.getVitaminB6(),
                i.getVitaminC(),
                i.getVitaminD(),
                i.getVitaminE(),
                i.getIngredientsCategory()
        };

        int result = jdbcTemplate.update(sql, parameters);

        return i;
    }
}
