package org.wuxinshui.boosters.test.data;

import org.junit.Test;

import java.math.BigDecimal;

import static org.wuxinshui.boosters.data.MathUtils.standardDeviation;
import static org.wuxinshui.boosters.data.MathUtils.variance;

/**
 * Created with IntelliJ IDEA.
 * User: Wuxinshui
 * Date: 2017/9/21
 * Time: 14:24
 */
public class MathUtilsTest {
    @Test
    public void testVarianceAndStandardDeviation() {
        BigDecimal[] bigDecimals = {
                new BigDecimal(1),
                new BigDecimal(2),
                new BigDecimal(3),
                new BigDecimal(4),
                new BigDecimal(5),
                new BigDecimal(6),
                new BigDecimal(7),
                new BigDecimal(8),
                new BigDecimal(9),
                new BigDecimal(10),
                new BigDecimal(11),
                new BigDecimal(12),
                new BigDecimal(13)
        };
        System.out.println("方差：" + variance(bigDecimals, 5).toString());
        System.out.println("标准差：" + standardDeviation(bigDecimals, 100).toString());
    }
}
