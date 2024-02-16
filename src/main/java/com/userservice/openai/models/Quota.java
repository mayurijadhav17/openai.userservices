package com.userservice.openai.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "quota")
public class Quota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer totalQuota;
    private Integer token;
    private Long entityId;

}

//--company quaota on creation entry
//--