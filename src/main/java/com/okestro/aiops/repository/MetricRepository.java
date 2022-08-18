package com.okestro.aiops.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.okestro.aiops.common.PagingAndSortingRepository;
import com.okestro.aiops.entity.MetricVO;

@Repository
public interface MetricRepository extends PagingAndSortingRepository<MetricVO, Long>, JpaRepository<MetricVO, Long> {
	
	// paging and order by
	Page<MetricVO> findAll(Pageable pageable);
	
	// total count
	long count();
	
	/**
	 * 최근 한 달 간 메트릭 평균값을 hostname, resource_type, metric_type으로 group by 하여 반환
	 * @return
	 */
	@Query(value="SELECT hostname, CONCAT(resource_type, '.', metric_type) metric_type, REPLACE(FORMAT(AVG(value), 2), ',', '') value, unit\n"
			+ "FROM metric\n"
			+ "WHERE `datetime` BETWEEN DATE_ADD(NOW(), INTERVAL -1 MONTH) AND NOW()\n"
			+ "AND resource_type = :resource_type\n"
			+ "GROUP BY hostname, resource_type, metric_type",
			nativeQuery=true)
	List<Map<String, Object>> getMonthlyMetric(@Param("resource_type") String resourceType);
}
