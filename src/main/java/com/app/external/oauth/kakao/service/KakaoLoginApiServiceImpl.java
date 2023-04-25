package com.app.external.oauth.kakao.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.app.domain.member.constant.MemberType;
import com.app.external.oauth.kakao.client.KakaoUserInfoClient;
import com.app.external.oauth.kakao.dto.KakaoUserInfoResponseDto;
import com.app.external.oauth.model.OauthAttributes;
import com.app.external.oauth.service.SocialLoginApiService;
import com.app.global.jwt.constant.GrantType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class KakaoLoginApiServiceImpl implements SocialLoginApiService {

	private final KakaoUserInfoClient kakaoUserInfoClient;
	private final String CONTENT_TYPE = "application/x-www-form-urlencoded;charset=utf-8";

	@Override
	public OauthAttributes getUserInfo(final String accessToken) {
		// authorization header에 accessToken 담아서 보내야 한다.
		KakaoUserInfoResponseDto kakaoUserInfoResponseDto = kakaoUserInfoClient.getKakaoUserInfo(CONTENT_TYPE,
			GrantType.BEARER.getType() + " " + accessToken);
		KakaoUserInfoResponseDto.KakaoAccount kakaoAccount = kakaoUserInfoResponseDto.getKakaoAccount();
		String email = kakaoAccount.getEmail();

		return OauthAttributes.builder()
			.email(!StringUtils.hasText(email) ? kakaoUserInfoResponseDto.getId() : email)
			.profile(kakaoAccount.getProfile().getThumbnailImageUrl())
			.memberType(MemberType.KAKAO)
			.build();
	}
}
