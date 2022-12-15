package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private List<Integer> list;
    @BeforeEach
    public void helper(){
        list=Arrays.asList(1,2,4,2,5);
    }
    @Test
    public void sum() {

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        ListDeduplicator listDeduplicator = new ListDeduplicator(new ListSorter());
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list, listDeduplicator);

        Assertions.assertEquals(4, distinct);
    }
    @Test
    public void max_bug_7263(){
        ListAggregator listAggregator = new ListAggregator();
        int max=listAggregator.max(Arrays.asList(-1,-4,-5));
        Assertions.assertEquals(-1,max);
    }
    @Test
    public void distinct_bug_8726(){
        ListAggregator listAggregator=new ListAggregator();
        GenericListDeduplicator genericListDeduplicator= Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(genericListDeduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1,2,4));
        int distinct = listAggregator.distinct(Arrays.asList(1, 2, 4, 2), genericListDeduplicator);
        Assertions.assertEquals(3, distinct);
    }
}
