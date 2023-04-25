package com.app.external.oauth.kakao.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.app.domain.member.constant.MemberType;
import com.app.external.oauth.service.SocialLoginApiService;

@Service
public class SocialLoginApiServiceFactory {

	private static Map<String, SocialLoginApiService> socialLoginApiServices;

	public SocialLoginApiServiceFactory(Map<String, SocialLoginApiService> socialLoginApiServices) {
		this.socialLoginApiServices = socialLoginApiServices;
	}

	public static SocialLoginApiService getSocialLoginApiService(MemberType memberType) {
		String socialLoginApiServiceBeanName = "";

		if (MemberType.KAKAO == memberType) {
			socialLoginApiServiceBeanName = "kakaoLoginApiServiceImpl";
		}
		return socialLoginApiServices.get(socialLoginApiServiceBeanName);
	}
}
