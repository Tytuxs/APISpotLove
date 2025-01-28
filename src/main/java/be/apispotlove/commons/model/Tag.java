package be.apispotlove.commons.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Entity
@Table(name = "tag")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class Tag extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;
}
