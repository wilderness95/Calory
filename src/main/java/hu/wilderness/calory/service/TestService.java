package hu.wilderness.calory.service;

import hu.wilderness.calory.domain.Ingredient;
import hu.wilderness.calory.utils.CsvProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    @Autowired
    IngredientService ingredientService;


    CsvProcessor csvProcessor = new CsvProcessor();



    public void setUpTheTable(){
        List<Ingredient> ingList;
                ingList = csvProcessor.readFromFile("/home/wilderness/projects/Calory/test.csv", StandardCharsets.UTF_8,";");

        for (Ingredient ing : ingList){
            ingredientService.save(ing);
        }
    }
}
