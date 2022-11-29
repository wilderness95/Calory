package hu.wilderness.calory.dataacces.mapper;

import hu.wilderness.calory.domain.Ingredient;

import hu.wilderness.calory.domain.IngredientCategory;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientMapper implements RowMapper<Ingredient> {

    @Override
    public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException{

        Ingredient ingredient = new Ingredient();

        ingredient.setId(rs.getLong("id"));
        ingredient.setIngredientsName(rs.getString("ingredients_name"));
        ingredient.setEnergyInKj(rs.getFloat("energy_in_kj"));
        ingredient.setEnergyInKcal(rs.getFloat("energy_in_kcal"));
        ingredient.setProtein(rs.getFloat("protein"));
        ingredient.setFat(rs.getFloat("fat"));
        ingredient.setCarbohydrate(rs.getFloat("carbohydrate"));
        ingredient.setSodium(rs.getFloat("sodium"));
        ingredient.setPotassium(rs.getFloat("potassium"));
        ingredient.setCalcium(rs.getFloat("calcium"));
        ingredient.setMagnesium(rs.getFloat("magnesium"));
        ingredient.setRetinol(rs.getFloat("retinol"));
        ingredient.setCholesterol(rs.getFloat("cholesterol"));
        ingredient.setVitaminB6(rs.getFloat("vitamin_b6"));
        ingredient.setVitaminC(rs.getFloat("vitamin_c"));
        ingredient.setVitaminD(rs.getFloat("vitamin_d"));
        ingredient.setVitaminE(rs.getFloat("vitamin_e"));
        try {ingredient.setIngredientsCategory(IngredientCategory.valueOf(rs.getString("ingredients_category")));} catch (Exception e) {}

        return ingredient;
    }

}
