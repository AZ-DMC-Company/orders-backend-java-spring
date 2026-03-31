package com.logisticajjr.bodega.security;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JwtResponse(
        @JsonProperty(value = "access_token") String accessToken,
        @JsonProperty(value = "user_id") int userId
) {
}
