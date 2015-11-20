package com.kritacademy.projects.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Chertpong on 12/11/2558.
 */
@Entity
public class Cake implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotNull
    String name;
    @NotNull
    Double price;
    String description;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    Set<Topping> availableTopping = new HashSet<>();
    @ElementCollection
    List<Double> availableSize = new ArrayList<>();
    String profilePicture;

    public Cake() {
    }

    public Cake(String name, Double price, String description, Set<Topping> availableTopping, List<Double> availableSize, String profilePicture) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.availableTopping = availableTopping;
        this.availableSize = availableSize;
        this.profilePicture = profilePicture;
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

    public Set<Topping> getAvailableTopping() {
        return availableTopping;
    }

    public void setAvailableTopping(Set<Topping> availableTopping) {
        this.availableTopping = availableTopping;
    }

    public List<Double> getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(List<Double> availableSize) {
        this.availableSize = availableSize;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cake cake = (Cake) o;

        if (getId() != null ? !getId().equals(cake.getId()) : cake.getId() != null) return false;
        if (getName() != null ? !getName().equals(cake.getName()) : cake.getName() != null) return false;
        if (getPrice() != null ? !getPrice().equals(cake.getPrice()) : cake.getPrice() != null) return false;
        if (getDescription() != null ? !getDescription().equals(cake.getDescription()) : cake.getDescription() != null)
            return false;
        if (getAvailableTopping() != null ? !getAvailableTopping().equals(cake.getAvailableTopping()) : cake.getAvailableTopping() != null)
            return false;
        if (getAvailableSize() != null ? !getAvailableSize().equals(cake.getAvailableSize()) : cake.getAvailableSize() != null)
            return false;
        return !(getProfilePicture() != null ? !getProfilePicture().equals(cake.getProfilePicture()) : cake.getProfilePicture() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getAvailableTopping() != null ? getAvailableTopping().hashCode() : 0);
        result = 31 * result + (getAvailableSize() != null ? getAvailableSize().hashCode() : 0);
        result = 31 * result + (getProfilePicture() != null ? getProfilePicture().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", availableTopping=" + availableTopping +
                ", availableSize=" + availableSize +
                ", profilePicture='" + profilePicture + '\'' +
                '}';
    }
}
