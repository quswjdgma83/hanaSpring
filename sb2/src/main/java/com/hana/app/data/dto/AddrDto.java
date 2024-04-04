package com.hana.app.data.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddrDto {
    private int addrId;
    private String addrName;
    private String addrDetail;
    private String custId;
}