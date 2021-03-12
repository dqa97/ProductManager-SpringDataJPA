package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "provinces")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "nhập tên từ 5 đến 55 kí tự")
    @Size(min = 5, max = 55)
    private String name;


    public Category() {}

    public Category(Long id, @NotEmpty(message = "nhập tên từ 5 đến 55 kí tự") @Size(min = 5, max = 55) String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
