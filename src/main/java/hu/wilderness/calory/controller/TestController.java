package hu.wilderness.calory.controller;

import hu.wilderness.calory.service.IngredientService;
import hu.wilderness.calory.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    TestService testService;

    @Autowired
    IngredientService ingredientService;
    @GetMapping("/calory")
    public String stories(Model model){
        testService.setUpTheTable();
        model.addAttribute("ingredients",ingredientService.getAllIngredients());
        return "calory";
    }

}
