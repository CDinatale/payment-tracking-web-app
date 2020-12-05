/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Credit Profile Class that creates the entity for the database>*/

package ca.gbc.comp3095.comp3095rockstars.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class CreditProfile extends BaseEntity{

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String expiry;

    @Column(nullable = false)
    private String cardHolder;

    @Column(nullable = false)
    private Long cardNumber;

    @Column(nullable = false)
    private String defaultCreditCard;

    @Column(nullable = false)
    private LocalDate dateCardCreated;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long credit_profile_id;

    @Column(nullable = false)
    private String userForeignKey;
}
