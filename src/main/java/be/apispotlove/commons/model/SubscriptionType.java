package be.apispotlove.commons.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;

@Entity
@Table(name = "subscription_type")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class SubscriptionType extends BaseEntity {

    @Column(name = "price", nullable = false, precision = 15, scale = 2)
    private BigDecimal price;

    @Column(name = "unlimited_like", nullable = false)
    private Boolean unlimitedLike;

    @Column(name = "view_profile_like", nullable = false)
    private Boolean viewProfileLike;

    @Column(name = "unlimited_message", nullable = false)
    private Boolean unlimitedMessage;

    @Column(name = "no_pub", nullable = false)
    private Boolean noPub;
}
