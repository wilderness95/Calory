package hu.wilderness.calory.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Ingredient {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String  ingredientsName;

    private Float energyInKj;

    private Float energyInKcal;

    private Float protein;

    private Float fat;

    private Float carbohydrate;

    private Float sodium;

    private Float potassium;

    private Float calcium;

    private Float magnesium;

    private Float retinol;

    private Float cholesterol;
@Column(name = "vitamin_b6")
    private Float vitaminB6;
@Column(name = "vitamin_c")
    private Float vitaminC;
@Column(name = "vitamin_d")
    private Float vitaminD;
@Column(name = "vitamin_e")
    private Float vitaminE;

    @Column
    @Enumerated(EnumType.STRING)
    private IngredientCategory ingredientsCategory;

}
