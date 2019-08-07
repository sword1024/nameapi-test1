package com.sword1024.test.nameapi.test1;

import java.math.BigDecimal;

public class NumbersServiceImpl implements NumbersService {

    private BigDecimal min;
    private BigDecimal max;
    private BigDecimal sum = BigDecimal.ZERO;
    private long count;

    @Override
    public void offer(BigDecimal number) {
        if (number != null) {
            min = min != null ? min.min(number) : number;

            max = max != null ? max.max(number) : number;

            sum = sum.add(number);
            count++;
        }
    }

    @Override
    public BigDecimal getMin() {
        return min;
    }

    @Override
    public BigDecimal getMax() {
        return max;
    }

    @Override
    public BigDecimal getAvg() {
        return count != 0 ? sum.divide(BigDecimal.valueOf(count)) : null;
    }

    @Override
    public void clear() {
        min = null;
        max = null;
        sum = BigDecimal.ZERO;
        count = 0L;
    }
}
