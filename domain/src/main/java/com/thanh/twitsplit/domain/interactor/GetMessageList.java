
package com.thanh.twitsplit.domain.interactor;

import com.thanh.twitsplit.domain.executor.PostExecutionThread;
import com.thanh.twitsplit.domain.executor.ThreadExecutor;
import com.thanh.twitsplit.domain.repository.UserRepository;

import java.util.Optional;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link com.thanh.twitsplit.domain.MessageTwit}.
 */
public class GetMessageList extends UseCase {

    public static final String NAME = "messageList";

    private final UserRepository userRepository;

    @Inject
    GetMessageList(UserRepository userRepository, ThreadExecutor threadExecutor,
                   PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    @Override
    public Observable buildUseCaseObservable(Optional<Params> params) {
        return this.userRepository.messages();
    }
}
