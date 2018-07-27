package com.dtdream.report.controller;

import com.dtdream.pojo.Report;
import com.dtdream.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报表controller
 */
@RestController
@RequestMapping(value = "/report")
@EnableAutoConfiguration
public class ReportController {
    @Autowired
    ReportService reportService;

    @RequestMapping(value = "/getReportList")
    @ResponseBody
    public Map<String,Object> getReportList(HttpServletRequest request, HttpServletResponse response,
                                @RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam String title,
                                @RequestParam String createTime,
                                @RequestParam String model,
                                @RequestParam String conformity) {
        Map<String,Object> resultMap = new HashMap<>();
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 20;
        }

        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("title",title);
        paramMap.put("createTime",createTime);
        paramMap.put("model",model);
        paramMap.put("conformity",conformity);

        Integer count = reportService.queryCountByParam(paramMap);
        List<Report> reportList = reportService.queryListByParam(paramMap, pageNum, pageSize);

        resultMap.put("count",count);
        resultMap.put("reportList",reportList);
        return resultMap;
    }
}
