package com.pickme.pickmeappauthservice.dtos;

import lombok.*;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class AuthPassengerRequestDto {
        private String email;
        private String password;
    }


