package main.java.dev.patika.hw01.entities.concretes;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "creditScore", nullable = false)
    private byte creditScore;

}
