package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PositiveFilterTest {
    @Test
    void accept(){
        PositiveFilter positiveFilter= new PositiveFilter();
        List<Integer> positiveNumbers= Arrays.asList(2,7,100,145,235,200000,Integer.MAX_VALUE);
        List<Integer> negativeNumbers= Arrays.asList(-2,-7,-100,-145,-234,-200000,Integer.MIN_VALUE);
        for(int i:positiveNumbers) Assertions.assertTrue(positiveFilter.accept(i));
        for(int i:negativeNumbers) Assertions.assertFalse(positiveFilter.accept(i));
    }
}
