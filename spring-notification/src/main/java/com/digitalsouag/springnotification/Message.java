package com.digitalsouag.springnotification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class Message implements Serializable {
    private String text;
    private String to;
    
}