package com.example.msentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")

public class PersonEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name",nullable = false,length = 30)
    private String name;

    @Column(name = "surname",nullable = false,length = 30)
    private String surname;
    @Column(name = "fin", nullable = false,length = 7,unique = true)
    private String fin;

    @OneToMany(targetEntity = UserEntity.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_accounts",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserEntity> accounts;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;


}
