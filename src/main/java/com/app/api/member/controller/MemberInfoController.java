package com.app.api.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.member.dto.MemberInfoResponseDto;
import com.app.api.member.service.MemberInfoService;
import com.app.global.resolver.memberinfo.MemberInfo;
import com.app.global.resolver.memberinfo.MemberInfoDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberInfoController {

	private final MemberInfoService memberInfoService;

	@GetMapping("/info")
	public ResponseEntity<MemberInfoResponseDto> getMemberInfo(@MemberInfo MemberInfoDto memberInfoDto) {
		Long memberId = memberInfoDto.getMemberId();
		MemberInfoResponseDto memberInfoResponseDto = memberInfoService.getMemberInfo(memberId);

		return ResponseEntity.ok(memberInfoResponseDto);
	}
}
