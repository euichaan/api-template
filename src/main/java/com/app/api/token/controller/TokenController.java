package com.app.api.token.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.token.dto.AccessTokenResponseDto;
import com.app.api.token.service.TokenService;
import com.app.global.util.AuthorizationHeaderUtils;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TokenController {

	private final TokenService tokenService;

	/**
	 * Refresh Token으로 access Token 재발급
	 */
	@PostMapping("/access-token/issue")
	public ResponseEntity<AccessTokenResponseDto> createAccessToken(HttpServletRequest httpServletRequest) {
		String authorizationHeader = httpServletRequest.getHeader("Authorization");
		AuthorizationHeaderUtils.validateAuthorization(authorizationHeader);

		String refreshToken = authorizationHeader.split(" ")[1];
		AccessTokenResponseDto accessTokenResponseDto = tokenService.createAccessTokenByRefreshToken(refreshToken);
		return ResponseEntity.ok(accessTokenResponseDto);
	}

}
