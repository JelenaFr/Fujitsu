package com.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Data
@Entity
public class FormCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;
    private String firstLevel;
    private String secondLevel;
    private String thirdLevel;

    @ManyToOne
    private Message message;

    public FormCategory(String firstLevel, String secondLevel, String thirdLevel) {
        this.firstLevel = firstLevel;
        this.secondLevel = secondLevel;
        this.thirdLevel = thirdLevel;
    }
}
