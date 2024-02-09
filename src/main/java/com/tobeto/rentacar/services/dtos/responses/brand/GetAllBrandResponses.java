package com.tobeto.rentacar.services.dtos.responses.brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandResponses implements Serializable {

    private int id;
    private String name;
}
