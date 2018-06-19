package com.thanh.twitsplit.domain.repository;

import com.thanh.twitsplit.domain.MessageTwit;

import io.reactivex.Observable;
import java.util.List;

/**
 * Interface that represents a Repository for getting {@link MessageTwit} related data.
 */
public interface UserRepository {
  /**
   * Get an {@link Observable} which will emit a List of {@link MessageTwit}.
   */
  Observable<List<MessageTwit>> messages();
}
