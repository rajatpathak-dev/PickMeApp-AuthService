package com.pickme.pickmeappauthservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Booking extends  BaseModel{



    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;
    private LocalDateTime start;
    private LocalDateTime end;
    private Long distance;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Passenger passenger;
}
