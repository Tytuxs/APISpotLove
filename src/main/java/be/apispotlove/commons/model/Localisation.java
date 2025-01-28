package be.apispotlove.commons.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.geo.Point;

@Entity
@Table(name = "localisation")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class Localisation extends BaseEntity {

    @Column(nullable = false, columnDefinition = "POINT")
    private Point coordinates;
}
