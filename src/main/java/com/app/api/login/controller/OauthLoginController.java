package com.app.api.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.login.dto.OauthLoginDto;
import com.app.api.login.service.OauthLoginService;
import com.app.api.login.validator.OauthValidator;
import com.app.domain.member.constant.MemberType;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/oauth")
public class OauthLoginController {

	private final OauthValidator oauthValidator;
	private final OauthLoginService oauthLoginService;

	@PostMapping("/login")
	public ResponseEntity<OauthLoginDto.Response> oauthLogin(@RequestBody OauthLoginDto.Request oauthLoginRequestDto,
															 HttpServletRequest httpServletRequest) {
		String authorizationHeader = httpServletRequest.getHeader("Authorization");
		oauthValidator.validateAuthorization(authorizationHeader);
		oauthValidator.validateMemberType(oauthLoginRequestDto.getMemberType());

		String accessToken = authorizationHeader.split(" ")[1];
		OauthLoginDto.Response jwtTokenResponseDto = oauthLoginService.
			oauthLogin(accessToken, MemberType.from(oauthLoginRequestDto.getMemberType()));

		return ResponseEntity.ok(jwtTokenResponseDto);
	}
}
