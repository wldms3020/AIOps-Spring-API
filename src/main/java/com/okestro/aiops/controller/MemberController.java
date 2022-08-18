package com.okestro.aiops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.okestro.aiops.common.ResultVO;
import com.okestro.aiops.entity.MemberVO;
import com.okestro.aiops.service.MemberService;

@RestController
@RequestMapping("/user")
public class MemberController {
	@Autowired
	MemberService memberService;
	
	/**
	 * 회원가입
	 * @param member
	 * @return
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<Object> register(@RequestBody MemberVO member) {
		ResultVO resultVO = new ResultVO();
		
		Boolean data = memberService.registerUser(member);
		resultVO.setData(data);
		
		return new ResponseEntity<>(resultVO, HttpStatus.OK);
	}
	
	/**
	 * 로그인
	 * @param member
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<Object> login(@RequestBody MemberVO member) {
		ResultVO resultVO = new ResultVO();
		
		Boolean data = memberService.login(member);
		resultVO.setData(data);
		
		return new ResponseEntity<>(resultVO, HttpStatus.OK);
	}
}
