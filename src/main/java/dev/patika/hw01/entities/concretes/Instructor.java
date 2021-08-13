package dev.patika.hw01.entities.concretes;

import javax.persistence.*;

@Entity
@Table(name = "instructors")
@Inheritance(strategy = InheritanceType.JOINED)
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @Column(name = "phone_number", unique = true, nullable = false, length = 30)
    private String phoneNumber;

}
