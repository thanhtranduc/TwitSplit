package com.thanh.twitsplit.domain.interactor;

import com.thanh.twitsplit.domain.executor.PostExecutionThread;
import com.thanh.twitsplit.domain.executor.ThreadExecutor;
import com.thanh.twitsplit.domain.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(MockitoJUnitRunner.class)
public class GetMessageListTest {

  private GetMessageList getMessageList;

  @Mock private ThreadExecutor mockThreadExecutor;
  @Mock private PostExecutionThread mockPostExecutionThread;
  @Mock private UserRepository mockUserRepository;

  @Before
  public void setUp() {
    getMessageList = new GetMessageList(mockUserRepository, mockThreadExecutor,
        mockPostExecutionThread);
  }

}
