/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Message Class that creates the entity for the database>*/

package ca.gbc.comp3095.comp3095rockstars.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Message extends BaseEntity{

    @Column(nullable = false)
    private String fromWho;

    @Column(nullable = false)
    private String toWho;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String messageSubject;

    @Column(nullable = false)
    private LocalDate dateCreated;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long message_id;
}
