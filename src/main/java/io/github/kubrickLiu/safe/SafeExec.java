package io.github.kubrickLiu.safe;

import java.util.function.Consumer;

public interface SafeExec {

    void wrap() throws Throwable;

    static void wrap(SafeExec safeExec) {
        wrap(safeExec, throwable -> {
            // ignore
        });
    }

    static void wrap(SafeExec safeExec, Consumer<Throwable> consumer) {
        try {
            safeExec.wrap();
        } catch (Throwable e) {
            consumer.accept(e);
        }
    }
}
