package com.pickme.pickmeappauthservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "booking_reviews")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel {


   private String content;

   @Column(nullable = false)
   private Double rating;

   @OneToOne
   @JoinColumn(nullable = false,name = "booking_id")
   private Booking booking;

}
