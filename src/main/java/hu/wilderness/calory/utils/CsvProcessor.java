package hu.wilderness.calory.utils;

import hu.wilderness.calory.domain.Ingredient;
import hu.wilderness.calory.domain.IngredientCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CsvProcessor {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public List<Ingredient> readFromFile(String path, Charset charset, String separator) {

        List<Ingredient> ingredientList =  new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(path),charset));
            log.debug("The choosen file path: " + path);

            String header = br.readLine();
log.debug(header);
            while (br.ready()) {
                String row = br.readLine();
                log.debug(row);
                String[] splitRow=row.split(separator);
                Ingredient ingredientObj = new Ingredient();
                //ingredientObj.setId(Long.parseLong(splitRow[0]));
                try{ingredientObj.setIngredientsName(splitRow[0]);}catch (NumberFormatException ex){ingredientObj.setIngredientsName(null);}
                try{ingredientObj.setEnergyInKj(Float.parseFloat(splitRow[1]));}catch (NumberFormatException ex){ingredientObj.setEnergyInKj(null);}
                try{ingredientObj.setEnergyInKcal(Float.parseFloat(splitRow[2]));}catch (NumberFormatException ex){ingredientObj.setEnergyInKcal(null);}
                try{ingredientObj.setProtein(Float.parseFloat(splitRow[3]));}catch (NumberFormatException ex){ingredientObj.setProtein(null);}
                try{ingredientObj.setFat(Float.parseFloat(splitRow[4]));}catch (NumberFormatException ex){ingredientObj.setFat(null);}
                try{ingredientObj.setCarbohydrate(Float.parseFloat(splitRow[5]));}catch (NumberFormatException ex){ingredientObj.setCarbohydrate(null);}
                try{ingredientObj.setSodium(Float.parseFloat(splitRow[6]));}catch (NumberFormatException ex){ingredientObj.setSodium(null);}
                try{ingredientObj.setPotassium(Float.parseFloat(splitRow[7]));}catch (NumberFormatException ex){ingredientObj.setPotassium(null);}
                try{ingredientObj.setCalcium(Float.parseFloat(splitRow[8]));}catch (NumberFormatException ex){ingredientObj.setCalcium(null);}
                try{ingredientObj.setMagnesium(Float.parseFloat(splitRow[9]));}catch (NumberFormatException ex){ingredientObj.setMagnesium(null);}
                try{ingredientObj.setRetinol(Float.parseFloat(splitRow[10]));}catch(NumberFormatException ex){ingredientObj.setRetinol(null);}
                try{ingredientObj.setCholesterol(Float.parseFloat(splitRow[11]));}catch (NumberFormatException ex){ingredientObj.setCholesterol(null);}
                try{ingredientObj.setVitaminB6(Float.parseFloat(splitRow[12]));}catch (NumberFormatException ex){ingredientObj.setVitaminB6(null);}
                try{ingredientObj.setVitaminC(Float.parseFloat(splitRow[13]));}catch (NumberFormatException ex){ingredientObj.setVitaminC(null);}
                try{ingredientObj.setVitaminD(Float.parseFloat(splitRow[14]));}catch (NumberFormatException ex){ingredientObj.setVitaminD(null);}
                try{ingredientObj.setVitaminE(Float.parseFloat(splitRow[15]));}catch (NumberFormatException ex){ingredientObj.setVitaminE(null);}
                try {ingredientObj.setIngredientsCategory(IngredientCategory.valueOf(splitRow[16]));} catch (Exception e) {ingredientObj.setIngredientsCategory(IngredientCategory.CATEGORY_FRUITS);}
                ingredientList.add(ingredientObj);
                log.debug(ingredientList.toString());
            }
            br.close();

        }
        catch (FileNotFoundException e) {
            log.debug("File not found in the given path..");
        }
        catch (IOException e) {
            log.debug("There is something wrong with the file");
        }
        catch (Exception e) {
            log.debug("kurvaanyád");
        }
        return ingredientList;
    }
}
