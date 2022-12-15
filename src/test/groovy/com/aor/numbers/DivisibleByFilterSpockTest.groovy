package com.aor.numbers

import spock.lang.Specification

class DivisibleByFilterSpockTest extends Specification{
    def "accept divide by 2"() {
        given:
        def filter = new DivisibleByFilter(2)
        when:
        def divisible = Arrays.asList(0, 120, 360, 402, 808, 900, 15002)
        def notDivisible = Arrays.asList(3, 7, 11, 31, 401, 15001)
        then:
        divisible.every {it -> filter.accept(it) }
        notDivisible.every {it -> !filter.accept(it) }
    }

    def "accept divide by 5"() {
        given:
        def filter = new DivisibleByFilter(5)
        when:
        def divisible = Arrays.asList(5, 120, 360, 405, 800, 905, 15000)
        def notDivisible = Arrays.asList(3, 7, 11, 31, 401, 15001)
        then:
        divisible.every {it -> filter.accept(it) }
        notDivisible.every {it -> !filter.accept(it) }
    }
}
