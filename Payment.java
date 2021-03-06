package com.okta.Car.Payment.entity;

import com.okta.Car.FileSharing.entity.Employee;
import com.okta.Car.CarRental.entity.RentCar;
import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@NoArgsConstructor
@Table(name="Payment")
public class Payment {
    @Id
    @SequenceGenerator(name="payment_seq",sequenceName="payment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="payment_seq")
    @Column(name = "PAYMENT_ID", unique = true, nullable = true)
    private @NonNull Long id;
    @Column(name="DATE")
    private @NonNull LocalDateTime date;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PaymentOptions.class)
    @JoinColumn(name = "OPTIONS_ID", insertable = true)
    private PaymentOptions payoptions;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RentCar.class)
    @JoinColumn(name = "RENT_CAR_ID", insertable = true)
    private RentCar rent;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
    @JoinColumn(name = "EMPLOYEE_ID", insertable = true)
    private Employee createdby;
}

