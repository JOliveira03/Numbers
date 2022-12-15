package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    private final GenericListFilter genericListFilter;
    public ListFilterer(GenericListFilter genericListFilter){this.genericListFilter=genericListFilter;}
    public List<Integer> filter(List<Integer> list){
        List<Integer> f = new ArrayList<>();
        for(int i:list)
            if (genericListFilter.accept(i)) f.add(i);
        return f;
    }
}
