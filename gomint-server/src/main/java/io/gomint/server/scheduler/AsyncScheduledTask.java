/*
 * Copyright (c) 2017, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.scheduler;

import io.gomint.scheduler.Task;
import io.gomint.util.CompleteHandler;
import io.gomint.util.ExceptionHandler;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author geNAZt
 * @version 1.0
 */
public class AsyncScheduledTask implements Task, Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger( AsyncScheduledTask.class );
    @Getter private final Runnable task;

    private ExceptionHandler exceptionHandler;
    private List<CompleteHandler> completeHandlerList;

    private Future<?> future;

    /**
     * Constructs a new AsyncScheduledTask. It needs to be executed via a normal {@link java.util.concurrent.ExecutorService}
     *
     * @param task runnable which should be executed
     */
    public AsyncScheduledTask( Runnable task ) {
        this.task = task;
    }

    @Override
    public void cancel() {
        this.future.cancel( true );
    }

    @Override
    public void onException( ExceptionHandler exceptionHandler ) {
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public void onComplete( CompleteHandler completeHandler ) {
        if ( this.completeHandlerList == null ) {
            this.completeHandlerList = new ArrayList<>();
        }

        this.completeHandlerList.add( completeHandler );
    }

    @Override
    public void run() {
        // CHECKSTYLE:OFF
        try {
            this.task.run();
        } catch ( Exception e ) {
            if ( this.exceptionHandler != null ) {
                if ( !this.exceptionHandler.onException( e ) ) {
                    this.fireCompleteHandlers();
                    this.cancel();
                }
            } else {
                LOGGER.error( "No exception handler given", e );
            }
        }
        // CHECKSTYLE:ON
    }

    private void fireCompleteHandlers() {
        if ( this.completeHandlerList != null ) {
            for ( CompleteHandler completeHandler : this.completeHandlerList ) {
                completeHandler.onComplete();
            }

            this.completeHandlerList = null;
        }
    }

    /**
     * Set the future of this task
     *
     * @param future of this task
     */
    void setFuture( Future<?> future ) {
        this.future = future;
    }

}
