package main.java.dev.patika.hw01.entities.concretes;

import main.java.dev.patika.hw01.entities.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "birth_date", nullable = false, columnDefinition = "DATE")
    private LocalDate birthDate;

    @Enumerated
    @Column(name = "gender", columnDefinition = "TINYINT")
    private Gender gender;
}
