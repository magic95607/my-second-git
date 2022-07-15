package com.example.ch01_RestController;

import java.text.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.*;
import java.util.logging.*;

@Component
public class MonitorInterceptor implements HandlerInterceptor {

	ThreadLocal<StopWatch> threadTimer = new ThreadLocal<>();
	// 建立一個ThreadLocal物件，型別StopWatch可提供計時功能
	Logger logger = Logger.getLogger(this.getClass().getName());

	private String getURLPath(HttpServletRequest request) {
		String currentPath = request.getRequestURI();
		String queryString = request.getQueryString();
		queryString = queryString == null ? "" : "?" + queryString;
		return currentPath + queryString; // Request的完成Path
	}

	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy 'at' hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		StopWatch stopWatch = new StopWatch(handler.toString());
		// New 一個StopWatch物件
		stopWatch.start(handler.toString());// 開始計時
		threadTimer.set(stopWatch); // 放入ThreadLocal由獨立的Thread計時

		// 紀錄存取的網址
		logger.info("Accessing URL Path:" + getURLPath(request));
		// 紀錄呼叫Controller前的時間
		logger.info("Request processing started on: " + getCurrentTime());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		// 紀錄Controller處理一個Request結束後的時間
		logger.info("Request processing ended on: " + getCurrentTime());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		StopWatch stopWatch = threadTimer.get(); // 從ThreadLocal取得StopWatch物件
		stopWatch.stop(); // 呼叫stop()，停止計數
		// 呼叫StopWatch物件getTotalTimemillis方法，可得知處理一個Request，Controller花了多少時間
		logger.info("Total time taken for processing: " + stopWatch.getTotalTimeMillis() + " ms");
		threadTimer.set(null); // 清空ThreadLocal物件 ，以免與下次Request再設定同樣的StopWatch衝突
		logger.info("========================================");
	}
}
