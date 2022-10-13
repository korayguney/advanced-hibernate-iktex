package com.iktex.hb04.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTO {
    private String firstName;
    private String lastName;
    private String address;
    private Long ssid;
    private long phoneNumber;
}
