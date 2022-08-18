package com.okestro.aiops.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.okestro.aiops.entity.MemberVO;

@Repository
public interface MemberRepository extends JpaRepository<MemberVO, Long> {
	/**
	 * member id 중복 확인
	 * @param id
	 * @return
	 */
	public boolean existsById(String id);
	
	/**
	 * id, password 확인
	 * @param id, password
	 * @return
	 */
	public Optional<MemberVO> findByIdAndPassword(String id, String password);
}
