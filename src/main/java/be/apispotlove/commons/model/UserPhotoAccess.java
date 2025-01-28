package be.apispotlove.commons.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_photo_access",
        uniqueConstraints = @UniqueConstraint(
                name = "uc_user_photo_access", columnNames = {"owner_user_id", "authorized_user_id"}
        ))
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserPhotoAccess extends BaseEntity {

    @Column(name = "owner_user_id", nullable = false)
    private Long ownerUserId; // Utilisateur qui possède les photos

    @Column(name = "authorized_user_id", nullable = false)
    private Long authorizedUserId; // Utilisateur autorisé à voir les photos privées
}
