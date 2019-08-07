package com.sword1024.test.nameapi.test1;

import java.math.BigDecimal;

public interface NumbersService {

    void offer(BigDecimal number);

    BigDecimal getMin();

    BigDecimal getMax();

    BigDecimal getAvg();

    void clear();
}
