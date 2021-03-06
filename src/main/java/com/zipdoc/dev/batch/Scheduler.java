package com.zipdoc.dev.batch;

import com.zipdoc.dev.service.PasteStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 스케줄러
 * @author 백찬주
 * @date 2021.03.06
 */
@Component
public class Scheduler {

	@Autowired
	PasteStatsService pasteStatsService;

	//일배치 스케줄러(매일 0시 paste별 접속 로그 카운트 통계 테이블 insert, 하루전 날짜 기준)
	@Scheduled(cron = "0 0 0 * * *")
	public void DailyStatsScheduler() throws Exception {
		pasteStatsService.insertPasteStats();
	}
}