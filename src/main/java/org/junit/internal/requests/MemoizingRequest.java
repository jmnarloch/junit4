package org.junit.internal.requests;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.runner.Request;
import org.junit.runner.Runner;

abstract class MemoizingRequest extends Request {
    private final Lock runnerLock = new ReentrantLock();
    private volatile Runner runner;

    @Override
    public final Runner getRunner() {
        
    }

    /** Creates the {@link Runner} to return from {@link #getRunner()}. Called at most once. */
    protected abstract Runner createRunner();
}
