package com.thanh.twitsplit.domain.executor;

import io.reactivex.Scheduler;

public interface PostExecutionThread {
  Scheduler getScheduler();
}
