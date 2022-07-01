package io.github.kubrick.safe;

import java.util.function.Consumer;

public interface SafeCall<T> {

    T call() throws Throwable;

    static <T> T wrap(SafeCall<T> safeCall) {
        return wrap(safeCall, null,  NonConsumer.INSTANCE);
    }

    static <T> T wrap(SafeCall<T> safeCall, T defaultValue) {
        return wrap(safeCall, defaultValue, NonConsumer.INSTANCE);
    }

    static <T> T wrap(SafeCall<T> safeCall, Consumer<Throwable> consumer) {
        return wrap(safeCall, null, consumer);
    }

    static <T> T wrap(SafeCall<T> safeCall, T defaultValue, Consumer<Throwable> consumer) {
        T ret = defaultValue;
        try {
            ret = safeCall.call();
        } catch (Throwable e) {
            consumer.accept(e);
        }
        return ret;
    }
}
