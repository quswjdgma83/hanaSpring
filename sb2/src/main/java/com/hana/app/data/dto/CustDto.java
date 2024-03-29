package com.hana.app.data.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustDto {
    public String id;
    private String pwd;
    private String name;
}
