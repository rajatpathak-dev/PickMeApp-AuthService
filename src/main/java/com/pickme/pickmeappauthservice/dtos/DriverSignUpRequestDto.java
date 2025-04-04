package com.pickme.pickmeappauthservice.dtos;

import com.pickme.pickmeappentityservice.models.Car;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverSignUpRequestDto {
    private String name;
    private String email;
    private String password;
    private String phoneNo;
    private Car car;
    private String licenceNo;
}
