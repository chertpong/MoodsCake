package com.kritacademy.projects.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Chertpong on 12/11/2558.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id;
    @NotNull(message = "errors.name.notnull")
    @Size(min = 2,max = 100,message = "errors.name.size")
    String name;
    @NotNull(message = "errors.phone.notnull")
    @Size(min = 8,max = 12,message = "errors.phone.size")
    String phoneNumber;
    String allergic;
    String specialNeed;
    @NotNull(message = "errors.date.notnull")
    @Temporal(TemporalType.TIMESTAMP)
    Date pickupDate;
    @ManyToOne
    Cake cake;
    @NotNull(message = "errors.size.notnull")
    Double size;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    List<Topping> topping = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    OrderStatus status;

    public Order() {
    }

    public Order(String name, String phoneNumber, String allergic, String specialNeed, Date pickupDate, Cake cake, Double size, List<Topping> topping, OrderStatus status) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.allergic = allergic;
        this.specialNeed = specialNeed;
        this.pickupDate = pickupDate;
        this.cake = cake;
        this.size = size;
        this.topping = topping;
        this.status = status;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAllergic() {
        return allergic;
    }

    public void setAllergic(String allergic) {
        this.allergic = allergic;
    }

    public String getSpecialNeed() {
        return specialNeed;
    }

    public void setSpecialNeed(String specialNeed) {
        this.specialNeed = specialNeed;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public List<Topping> getTopping() {
        return topping;
    }

    public void setTopping(List<Topping> topping) {
        this.topping = topping;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (getId() != null ? !getId().equals(order.getId()) : order.getId() != null) return false;
        if (getName() != null ? !getName().equals(order.getName()) : order.getName() != null) return false;
        if (getPhoneNumber() != null ? !getPhoneNumber().equals(order.getPhoneNumber()) : order.getPhoneNumber() != null)
            return false;
        if (getAllergic() != null ? !getAllergic().equals(order.getAllergic()) : order.getAllergic() != null)
            return false;
        if (getSpecialNeed() != null ? !getSpecialNeed().equals(order.getSpecialNeed()) : order.getSpecialNeed() != null)
            return false;
        if (getPickupDate() != null ? !getPickupDate().equals(order.getPickupDate()) : order.getPickupDate() != null)
            return false;
        if (getCake() != null ? !getCake().equals(order.getCake()) : order.getCake() != null) return false;
        if (getSize() != null ? !getSize().equals(order.getSize()) : order.getSize() != null) return false;
        if (getTopping() != null ? !getTopping().equals(order.getTopping()) : order.getTopping() != null) return false;
        return getStatus() == order.getStatus();

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        result = 31 * result + (getAllergic() != null ? getAllergic().hashCode() : 0);
        result = 31 * result + (getSpecialNeed() != null ? getSpecialNeed().hashCode() : 0);
        result = 31 * result + (getPickupDate() != null ? getPickupDate().hashCode() : 0);
        result = 31 * result + (getCake() != null ? getCake().hashCode() : 0);
        result = 31 * result + (getSize() != null ? getSize().hashCode() : 0);
        result = 31 * result + (getTopping() != null ? getTopping().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", allergic='" + allergic + '\'' +
                ", specialNeed='" + specialNeed + '\'' +
                ", pickupDate=" + pickupDate +
                ", cake=" + cake +
                ", size=" + size +
                ", topping=" + topping +
                ", status=" + status +
                '}';
    }
}
