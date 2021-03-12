package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "tên từ 5 đến 55 kí tự")
    @Size(min = 5, max = 55)
    private String name;

    @NotEmpty(message = "độ dài tối đa là 255 kí tự")
    @Size(max = 255)
    private String description;

    @NotEmpty
    private Date datetime;

    @NotEmpty
    private String quantity;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Product(){}

    public Product(Long id, @NotEmpty(message = "tên từ 5 đến 55 kí tự") @Size(min = 5, max = 55) String name, @NotEmpty @Size(min = 1, max = 255) String description, @NotEmpty Date datetime, @NotEmpty String quantity, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.datetime = datetime;
        this.quantity = quantity;
        this.category = category;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
