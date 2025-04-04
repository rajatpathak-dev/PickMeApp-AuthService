package com.pickme.pickmeappauthservice.dtos;

import com.pickme.pickmeappentityservice.models.Driver;
import com.pickme.pickmeappentityservice.models.Passenger;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {
    private String id;

    private String name;

    private String email;

    private String password;
    private String phoneNo;

    public static DriverDto convert(Driver driver){
        return   DriverDto.builder()
                .id(driver.getId().toString())
                .email(driver.getEmail())
                .phoneNo(driver.getPhoneNo())
                .password(driver.getPassword())
                .name(driver.getName())
                .build();
    }
}
