package com.tensor.org.work.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Predicate;

public class CronExpressUtilsTest {

    @Test
    public void TestPredicate() {
        Predicate p = (Object s) -> s != null;
        Assert.assertTrue(p.test(new Object()));

        Predicate<String> p2 = (String s) -> s.length() != 0;
        Assert.assertTrue(p2.test("asdasd"));
    }

}