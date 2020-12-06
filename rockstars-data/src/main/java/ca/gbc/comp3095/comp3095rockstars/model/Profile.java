/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Profile Class that creates the entity for the database>*/

package ca.gbc.comp3095.comp3095rockstars.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Profile extends BaseEntity{

    public Profile(){}

    public Profile(String city, String country, String postalCode, String shippingAddress, String billingAddress, String shippingAddressDefault, String billingAddressDefault, LocalDate dateCreated, User userForeignKey) {
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.shippingAddressDefault = shippingAddressDefault;
        this.billingAddressDefault = billingAddressDefault;
        this.dateCreated = dateCreated;
        this.userForeignKey = userForeignKey;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getShippingAddressDefault() {
        return shippingAddressDefault;
    }

    public void setShippingAddressDefault(String shippingAddressDefault) {
        this.shippingAddressDefault = shippingAddressDefault;
    }

    public String getBillingAddressDefault() {
        return billingAddressDefault;
    }

    public void setBillingAddressDefault(String billingAddressDefault) {
        this.billingAddressDefault = billingAddressDefault;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public long getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(long profile_id) {
        this.profile_id = profile_id;
    }

    public User getUserForeignKey() {
        return userForeignKey;
    }

    public void setUserForeignKey(User userForeignKey) {
        this.userForeignKey = userForeignKey;
    }

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String shippingAddress;

    @Column(nullable = false)
    private String billingAddress;

    @Column(nullable = false)
    private String shippingAddressDefault;

    @Column(nullable = false)
    private String billingAddressDefault;

    @Column(nullable = false)
    private LocalDate dateCreated;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long profile_id;

    @JoinColumn(name = "uKey")
    private User userForeignKey;


}
