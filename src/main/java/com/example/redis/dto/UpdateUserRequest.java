package com.example.redis.dto;

import lombok.Data;

@Data
public class UpdateUserRequest {

    private String name;
    private String email;
}
