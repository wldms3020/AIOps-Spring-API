package com.okestro.aiops.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.okestro.aiops.common.ResultVO;
import com.okestro.aiops.service.MetricService;

@RestController
@RequestMapping("/metric")
public class MetricController {
	@Autowired
	MetricService metricService;

	/**
	 * metric table data 반환
	 * @param pageNum
	 * @param pageSize
	 * @param isExistTotal
	 * @return
	 */
	@RequestMapping(value="/table", method=RequestMethod.GET)
	public ResponseEntity<Object> getMetricTableData(@RequestParam int pageNum, int pageSize, boolean isExistTotal) {
		ResultVO resultVO = new ResultVO();
		
		Map<String, Object> data = metricService.getMetricTableData(pageNum, pageSize, isExistTotal);
		resultVO.setData(data);
		
		return new ResponseEntity<>(resultVO, HttpStatus.OK);
	}
	
	/**
	 * metric chart data 반환
	 * @return
	 */
	@RequestMapping(value="/chart", method=RequestMethod.GET)
	public ResponseEntity<Object> getMetricChartData(@RequestParam String resourceType) {
		ResultVO resultVO = new ResultVO();
		
		Map<String, Object> data = metricService.getMetricChartData(resourceType);
		resultVO.setData(data);
		
		return new ResponseEntity<>(resultVO, HttpStatus.OK);
	}
}
