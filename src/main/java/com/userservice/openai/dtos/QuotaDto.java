package com.userservice.openai.dtos;

import lombok.Data;

@Data
public class QuotaDto {
    private Long entity_id;
    private int quota;

}
