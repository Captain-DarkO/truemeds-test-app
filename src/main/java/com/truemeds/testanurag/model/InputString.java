package com.truemeds.testanurag.model;

import javax.persistence.*;

@Entity
@Table(name = "input_details")
public class InputString {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "input_string")
    private String inputString;

    public InputString(){}

    public InputString(Long id, String inputString) {
        this.id = id;
        this.inputString = inputString;
    }

    public Long getId() {
        return id;
    }

    public String getInputString() {
        return inputString;
    }
}
