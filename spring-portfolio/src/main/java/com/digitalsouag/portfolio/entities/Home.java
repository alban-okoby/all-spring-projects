package com.digitalsouag.portfolio.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 15, message = "Salutation length is long > 15")
    private String salutation;
    @NotBlank
    @Size(min = 25, message = "Description minimum length is 25")
    private String description;
}
