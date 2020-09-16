package com.greenfoxacademy.rest.services;

import com.greenfoxacademy.rest.models.log_entries.Log;
import com.greenfoxacademy.rest.models.log_entries.LogData;
import com.greenfoxacademy.rest.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {
  private final LogRepository logRepository;

  @Autowired
  public LogService(LogRepository logRepository) {
    this.logRepository = logRepository;
  }

  public void addLog(Log log) {
    logRepository.save(log);
  }

  public LogData fillLogEntries (LogData logData){
    logData.setEntries(logRepository.findAll());
    logData.setEntry_count(logRepository.findAll().size());
    return logData;
  }
}
