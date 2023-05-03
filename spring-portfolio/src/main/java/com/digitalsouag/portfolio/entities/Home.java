package com.digitalsouag.portfolio.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Home implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 25)
    @Size(max = 25, message = "Salutation length is long > 25")
    private String salutation;
    @NotBlank @Column(nullable = false)
    @Size(min = 25, message = "Description minimum length is 25")
    private String description;
}
