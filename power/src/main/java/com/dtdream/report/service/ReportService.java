package com.dtdream.report.service;

import com.dtdream.pojo.Report;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author lcl
 * @date 2018-07-27
 */
@Service
public interface ReportService {
    /**
     * 根据条件过滤report表数量
     * @param paramMap
     * @return int
     */
    int queryCountByParam(Map<String, Object> paramMap);

    /**
     * 根据条件过滤report表数据
     * @param paramMap
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Report> queryListByParam(Map<String, Object> paramMap, Integer pageNum, Integer pageSize);
}
