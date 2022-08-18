package com.okestro.aiops.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.okestro.aiops.common.PagingAndSortingRepository;
import com.okestro.aiops.entity.LogVO;

@Repository
public interface LogRepository extends PagingAndSortingRepository<LogVO, Long>, JpaRepository<LogVO, Long> {
	
	// paging and order by
	Page<LogVO> findAll(Pageable pageable);
	
	// total count
	long count();
	
	/**
	 * 최근 1년 간 월 별 로그 데이터 수를 hostname으로 group by 하여 반환
	 * @return
	 */
	@Query(value="SELECT DATE_FORMAT(log_date,'%Y-%m') date, hostname, COUNT(hostname) cnt \n"
			+ "FROM log \n"
			+ "WHERE log_date BETWEEN DATE_ADD(NOW(), INTERVAL -1 YEAR) AND NOW() \n"
			+ "GROUP BY hostname \n"
			+ "ORDER BY log_date",
			nativeQuery=true)
	List<Map<String, Object>> getYearlyLogCount();
}
