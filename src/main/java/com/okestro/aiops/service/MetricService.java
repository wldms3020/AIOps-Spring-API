package com.okestro.aiops.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.okestro.aiops.entity.MetricVO;
import com.okestro.aiops.repository.MetricRepository;

@Service
public class MetricService {
	@Autowired
	MetricRepository metricRepository;
	
	/**
	 * 페이징된 최신 metric data 및 metric total count 반환
	 * @param pageNum
	 * @param pageSize
	 * @param isExistTotal
	 * @return
	 */
	public Map<String, Object> getMetricTableData(int pageNum, int pageSize, boolean isExistTotal) {
		Map<String, Object> resultMap = new HashMap<>();
		
		// datetime 최신 순으로 페이
		Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by("datetime").descending());
		Page<MetricVO> metricData = metricRepository.findAll(pageable);
		
		resultMap.put("metric", metricData);
		
		if (isExistTotal) {
			long total = metricRepository.count();
			resultMap.put("total", total);
		}
		
		return resultMap;
	}

	/**
	 * 최근 한 달 간 메트릭 평균값을 hostname, resource_type, metric_type으로 group by 하여 반환
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> getMetricChartData(String resourceType) {
		Map<String, Object> resultMap = new HashMap<>();
		
		// metric list
		List<Map<String, Object>> metricList = metricRepository.getMonthlyMetric(resourceType);
		// return series data
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();

		for (Map<String, Object> metric : metricList) {
			String hostname = metric.get("hostname").toString();
			BigDecimal value = new BigDecimal(metric.get("value").toString());

			// series.data
			Map<String, Object> dataMap = new HashMap<>();
			// series.data.name
			dataMap.put("name", metric.get("metric_type").toString());
			// series.data.data
			dataMap.put("y", value);
			// series.data.hostname
			dataMap.put("hostname", hostname);
			// series.data.unit
			if (null != metric.get("unit").toString()) {
				dataMap.put("unit", metric.get("unit").toString());
			}
			
			dataList.add(dataMap);
		}
		
		Map<String, Object> seriesMap = new HashMap<>();
		seriesMap.put("name", "hostname");
		seriesMap.put("data", dataList);
		
		resultMap.put("data", seriesMap);
		
		return resultMap;
	}
}