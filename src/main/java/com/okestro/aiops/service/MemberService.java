package com.okestro.aiops.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.okestro.aiops.entity.MemberVO;
import com.okestro.aiops.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	MemberRepository memberRepository;

	/**
	 * 회원가입 - user info 저장
	 * @param member
	 * @return
	 */
	@Transactional
	public Boolean registerUser(MemberVO member) {
		// 중복 체크
		if (memberRepository.existsById(member.getId())) {
			return false;
		}

		// insert
		MemberVO result = memberRepository.save(member);
		if (null != result) {
			return true;
		}

		return false;
	}
	
	/**
	 * 로그인 - id, password 체크
	 * @param member
	 * @return
	 */
	public Boolean login(MemberVO member) {
		// 아이디, 비밀번호 체크
		Optional<MemberVO> result = memberRepository.findByIdAndPassword(member.getId(), member.getPassword());

		// 유효하지 않은 정보
		if (result.isPresent()) {
			return true;
		}

		return false;
	}
}
