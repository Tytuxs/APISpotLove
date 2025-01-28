package be.apispotlove.commons.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_card")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class UserCard extends BaseEntity {

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_card_tag",
            joinColumns = @JoinColumn(
                    name = "user_card_id",
                    foreignKey = @ForeignKey(name = "fk__user_card_tag__user_card_id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "tag_id",
                    foreignKey = @ForeignKey(name = "fk__user_card_tag__tag_id")
            ),
            uniqueConstraints = {
                    @UniqueConstraint(
                            name = "uc__tags__user_card_id",
                            columnNames = {"user_card_id", "tag_id"}
                    )
            }
    )
    private List<Tag> tags = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "user_card_photo",
            joinColumns = @JoinColumn(name = "user_card_id")
    )
    @Column(name = "photo_id")
    private List<Long> photoIds = new ArrayList<>();
}
