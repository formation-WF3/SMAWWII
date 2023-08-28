package com.example.ww2germansubmarines.core.domain.models;

import com.example.ww2germansubmarines.core.domain.enums.RoleEnum;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "role")
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, length = 10, nullable = false)
    private RoleEnum nom;
}
