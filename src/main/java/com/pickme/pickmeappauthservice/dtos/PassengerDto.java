package com.pickme.pickmeappauthservice.dtos;

import com.pickme.pickmeappentityservice.models.Passenger;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {

    private String id;

    private String name;

    private String email;

    private String password;
    private String phoneNo;


    public static PassengerDto convert(Passenger passenger){
        return PassengerDto.builder()
                .id(passenger.getId().toString())
                .email(passenger.getEmail())
                .phoneNo(passenger.getPhoneNo())
                .password(passenger.getPassword())
                .name(passenger.getName())
                .build();
    }

}