package be.apispotlove.commons.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Entity
@Table(name = "photo")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class Photo extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "data", nullable = false)
    private byte[] data;

    @Column(name = "is_main", nullable = false)
    private Boolean isMain;

    @Column(name = "is_private", nullable = false)
    private Boolean isPrivate;
}
