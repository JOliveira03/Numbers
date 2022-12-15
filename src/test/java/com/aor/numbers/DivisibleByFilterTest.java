package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DivisibleByFilterTest {
    @Test
    void accept2(){
        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(2);
        List<Integer> divisible = Arrays.asList(0, 120, 360, 402, 808, 900, 15002);
        List<Integer> notDivisible = Arrays.asList(3, 7, 11, 31, 401, 15001);
        for (int n : divisible) Assertions.assertTrue(divisibleByFilter.accept(n));
        for (int n : notDivisible) Assertions.assertFalse(divisibleByFilter.accept(n));
    }
    @Test
    void accept5(){
        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(5);
        List<Integer> divisible = Arrays.asList(5, 120, 360, 405, 800, 905, 15000);
        List<Integer> notDivisible = Arrays.asList(3, 7, 11, 31, 401, 15001);
        for (int n : divisible) Assertions.assertTrue(divisibleByFilter.accept(n));
        for (int n : notDivisible) Assertions.assertFalse(divisibleByFilter.accept(n));
    }
}
