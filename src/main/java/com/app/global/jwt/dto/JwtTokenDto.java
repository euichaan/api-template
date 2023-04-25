package com.app.global.jwt.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class JwtTokenDto {

	private String grantType;
	private String accessToken;
	private Date accessTokenExpireTime;
	private String refreshToken;
	private Date refreshTokenExpireTime;
}
