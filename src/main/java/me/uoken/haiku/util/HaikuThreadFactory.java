package me.uoken.haiku.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class HaikuThreadFactory implements ThreadFactory {
    private final AtomicInteger threadNumber;

    public HaikuThreadFactory() {
        this.threadNumber = new AtomicInteger(1);
    }

    @Override
    public Thread newThread(final Runnable r) {
        return new Thread(r, "Haiku" + this.threadNumber.getAndIncrement());
    }
}
