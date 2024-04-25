package com.serviceManagementSystem.serviceManagementSystem.admin.data.model;

import com.serviceManagementSystem.serviceManagementSystem.appUser.data.model.enums.SystemRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Getter
@Setter
public class BaseUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private SystemRole role;

    private final LocalDate registrationDate = LocalDate.now();

}
