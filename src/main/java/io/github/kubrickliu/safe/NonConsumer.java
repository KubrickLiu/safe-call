package io.github.kubrickliu.safe;

import java.util.function.Consumer;

public class NonConsumer<T extends Throwable> implements Consumer<T> {

    public static final NonConsumer<Throwable> INSTANCE = new NonConsumer();

    private NonConsumer() {
    }

    public void accept(T t) {
        // ignore
    }
}
