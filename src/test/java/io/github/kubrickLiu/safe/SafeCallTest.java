package io.github.kubrickLiu.safe;

import org.junit.Assert;
import org.junit.Test;

public class SafeCallTest {

    @Test
    public void testCommon() {
        Integer a = SafeCall.wrap(() -> {
            System.out.println("safe call test common");
            return 1;
        });

        Assert.assertTrue(a == 1);
    }

    @Test
    public void testErrorWithoutDefault() {
        Integer a = SafeCall.wrap(() -> {
            System.out.println("safe call test error without default");
            throw new RuntimeException();
        });

        Assert.assertTrue(a == null);
    }

    @Test
    public void testErrorWithDefault() {
        Integer a = SafeCall.wrap(() -> {
            System.out.println("safe call test error with default");
            throw new RuntimeException();
        }, 2);

        Assert.assertTrue(a == 2);
    }

    @Test
    public void testErrorWithDefaultAndConsumer() {
        Integer a = SafeCall.wrap(() -> {
            System.out.println("safe call test error with default");
            throw new RuntimeException();
        }, 3, throwable -> {
            System.out.println(throwable.fillInStackTrace());
        });

        Assert.assertTrue(a == 3);
    }
}
