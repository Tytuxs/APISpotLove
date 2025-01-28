package be.apispotlove.commons.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.time.Instant;

@Entity
@Table(name = "subscription")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class Subscription extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "subscription_type_id", nullable = false, foreignKey = @ForeignKey(name = "fk_subscription_subscription_type"))
    private SubscriptionType subscriptionType;

    @Column(name = "unlimited", nullable = false)
    private Boolean unlimited;

    @Column(name = "start_date", nullable = false)
    private Instant startDate;

    @Column(name = "end_date", nullable = false)
    private Instant endDate;

    @Column(name = "automatically_renewable", nullable = false)
    private Boolean automaticallyRenewable;
}
