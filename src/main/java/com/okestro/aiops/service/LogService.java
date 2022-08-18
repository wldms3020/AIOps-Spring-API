package com.okestro.aiops.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.okestro.aiops.entity.LogVO;
import com.okestro.aiops.repository.LogRepository;

@Service
public class LogService {
	@Autowired
	LogRepository logRepository;
	
	/**
	 * 페이징된 최신 log data 및 log total count 반환
	 * @param pageNum
	 * @param pageSize
	 * @param isExistTotal
	 * @return
	 */
	public Map<String, Object> getLogTableData(int pageNum, int pageSize, boolean isExistTotal) {
		Map<String, Object> resultMap = new HashMap<>();
		
		// log_date 최신 순으로 페이
		Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by("logDate").descending());
		Page<LogVO> logData = logRepository.findAll(pageable);
		
		resultMap.put("log", logData);
		
		if (isExistTotal) {
			long total = logRepository.count();
			resultMap.put("total", total);
		}
		
		return resultMap;
	}

	/**
	 * 최근 1년 간 월 별 로그 데이터 수를 hostname으로 group by 하여 반환
	 * @return
	 */
	public Map<String, Object> getLogChartData() {
		Map<String, Object> resultMap = new HashMap<>();
		List<Object> resultList = new ArrayList<Object>();
		
		List<String> categories = getDateList();
		
		List<Map<String, Object>> hostnameList = logRepository.getYearlyLogCount();
		
		for (Map<String, Object> hostname : hostnameList) {
			Map<String, Object> dataMap = new HashMap<>();
			List<Object> dataList = new ArrayList<Object>();
			
			for (String month : categories) {
				// date 컬럼과 같은 날짜가 있으면 add
				if (month.equals(hostname.get("date"))) {
					dataList.add(hostname.get("cnt"));
				// 없으면 null add
				} else {
					dataList.add(null);
				}
			}
			
			dataMap.put("name", hostname.get("hostname").toString());
			dataMap.put("data", dataList);
			resultList.add(dataMap);
		}
		
		resultMap.put("categories", categories);
		resultMap.put("data", resultList);
		
		return resultMap;
	}
	
	/**
	 * 최근 1년 간 월 별 리스트 반환
	 * @return
	 */
	public List<String> getDateList() {
		List<String> list = new ArrayList<String>();
		
		for (int i = 11; i >= 0; i--) {
			// 현재 날짜 구하기
			Calendar month = Calendar.getInstance();
			month.add(Calendar.MONTH, -i);
			
			String beforeMonth = new SimpleDateFormat("yyyy-MM").format(month.getTime());
			
			list.add(beforeMonth);
		}
		
		return list;
	}
}