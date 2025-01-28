package be.apispotlove.commons.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class User extends BaseEntity {

    @Column(name = "pseudo", nullable = false)
    private String pseudo;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "role_app", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private RoleApp roleApp;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id", referencedColumnName = "id") // Colonne de jointure dans Subscription
    private List<Subscription> subscriptions = new ArrayList<>();

    @Column(name = "total_expense", nullable = false, precision = 15, scale = 2)
    private BigDecimal totalExpense;
}
