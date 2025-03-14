package com.pickme.pickmeappauthservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PassengerReview extends Review{


   private String passengerReviewContent;

   @Column(nullable = false)
   private Double passengerRating;

}
