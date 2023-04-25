package com.app.domain.member.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.domain.member.entity.Member;
import com.app.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	public Member registerMember(Member member) {
		validateDuplicateMember(member);
		return memberRepository.save(member);
	}

	private void validateDuplicateMember(Member member) {
		Optional<Member> optionalMember = memberRepository.findByEmail(member.getEmail());
		// if (optionalMember.isPresent()) {
		// 	throw new BusinessException(ErrorCode.ALREADY_REGISTERED_MEMBER);
		// }
	}

	public Optional<Member> findMemberByEmail(String email) {
		return memberRepository.findByEmail(email);
	}
}
