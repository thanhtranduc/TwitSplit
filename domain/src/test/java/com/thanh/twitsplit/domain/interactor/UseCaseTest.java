package com.thanh.twitsplit.domain.interactor;

import com.thanh.twitsplit.domain.executor.PostExecutionThread;
import com.thanh.twitsplit.domain.executor.ThreadExecutor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.TestScheduler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class UseCaseTest {

    private UseCaseTestClass useCase;

    private TestDisposableObserver testObserver;

    @Mock
    private ThreadExecutor mockThreadExecutor;
    @Mock
    private PostExecutionThread mockPostExecutionThread;

    @Before
    public void setUp() {
        this.useCase = new UseCaseTestClass(mockThreadExecutor, mockPostExecutionThread);
        this.testObserver = new TestDisposableObserver<>();
        given(mockPostExecutionThread.getScheduler()).willReturn(new TestScheduler());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testBuildUseCaseObservableReturnCorrectResult() {
        useCase.execute(testObserver, Params.EMPTY);

        assertThat(testObserver.valuesCount).isZero();
    }

    @Test
    public void testSubscriptionWhenExecutingUseCase() {
        useCase.execute(testObserver, Params.EMPTY);
        useCase.dispose();

        assertThat(testObserver.isDisposed()).isTrue();
    }

    private static class UseCaseTestClass extends UseCase {

        UseCaseTestClass(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
            super(threadExecutor, postExecutionThread);
        }

        @Override
        protected Observable buildUseCaseObservable(Optional<Params> params) {
            return Observable.empty();
        }

        @Override
        public void execute(DisposableObserver observer, Params params) {
            super.execute(observer, Params.EMPTY);
        }
    }

    private static class TestDisposableObserver<T> extends DisposableObserver<T> {
        private int valuesCount = 0;

        @Override
        public void onNext(T value) {
            valuesCount++;
        }

        @Override
        public void onError(Throwable e) {
            // no-op by default.
        }

        @Override
        public void onComplete() {
            // no-op by default.
        }
    }
}
