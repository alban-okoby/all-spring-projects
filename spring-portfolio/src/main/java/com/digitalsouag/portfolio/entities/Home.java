package com.digitalsouag.portfolio.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 25)
    @Size(max = 25, message = "Salutation length is long > 25")
    private String salutation;
    @NotBlank @Column(nullable = false)
    @Size(min = 25, message = "Description minimum length is 25")
    private String description;
}
