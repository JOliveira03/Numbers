package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class ListFiltererTest {
    @Test
    void filter(){
        GenericListFilter genericListFilter = Mockito.mock(GenericListFilter.class);
        Mockito.when(genericListFilter.accept(1)).thenReturn(true);
        Mockito.when(genericListFilter.accept(2)).thenReturn(false);
        Mockito.when(genericListFilter.accept(3)).thenReturn(true);
        Mockito.when(genericListFilter.accept(4)).thenReturn(false);
        Mockito.when(genericListFilter.accept(5)).thenReturn(true);
        ListFilterer listFilterer = new ListFilterer(genericListFilter);
        Assertions.assertEquals(Arrays.asList(1, 3, 5), listFilterer.filter(Arrays.asList(1,2,3,4,5)));
    }
}
