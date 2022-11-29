package hu.wilderness.calory.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value_key")
    private String key;

    @Column(name = "value_data")
    private String value;

    private String description;

    @Column(name="active")
    private Boolean active;
}