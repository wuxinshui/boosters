package org.wuxinshui.boosters.data;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @ClassName: MathUtils
 * @author: [Wuxinshui]
 * @CreateDate: 2017/8/1 14:07
 * @UpdateUser: [Wuxinshui]
 * @UpdateDate: 2017/8/1 14:07
 * @UpdateRemark: [说明本次修改内容]
 * @Description: [TODO(用一句话描述该文件做什么)]
 * @version: [V1.0]
 */
public class MathUtils {

    /**
     * 由于Java的简单类型不能够精确的对浮点数进行运算，这个工具类提供精 确的浮点数运算，包括加减乘除和四舍五入。
     */

    // 默认运算精度
    private static final int DEFAULT_SCALE = 10;

    // 这个类不能实例化
    private MathUtils() {
    }

    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */

    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */

    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */

    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */

    public static double div(double v1, double v2) {
        return div(v1, v2, DEFAULT_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */

    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The   scale   must   be   a   positive   integer   or   zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */

    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The   scale   must   be   a   positive   integer   or   zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static BigDecimal getBigDecimalByObject(Object obj) {
        BigDecimal bd = new BigDecimal(0);
        if (obj.getClass().getName().equals("java.lang.Integer")) {
            bd = new BigDecimal((Integer) obj);
        } else if (obj.getClass().getName().equals("java.lang.Float")) {
            bd = new BigDecimal((Float) obj);
        } else if (obj.getClass().getName().equals("java.lang.Double")) {
            bd = new BigDecimal((Double) obj);
        } else if (obj.getClass().getName().equals("java.math.BigDecimal")) {
            bd = (BigDecimal) obj;
        }
        return bd;
    }

    /**
     * 方差s^2=[(x1-x)^2 +...(xn-x)^2]/n
     * 默认精度：10
     *
     * @param x
     * @return
     */
    public static BigDecimal variance(BigDecimal[] x) {
        return variance(x, 10);
    }

    /**
     * 方差s^2=[(x1-x)^2 +...(xn-x)^2]/n
     * 默认精度：10
     * 默认精度策略：RoundingMode.HALF_UP
     *
     * @param x
     * @return
     */
    public static BigDecimal variance(BigDecimal[] x, int scale) {
        return variance(x, scale, RoundingMode.HALF_UP);
    }

    /**
     * 方差s^2=[(x1-x)^2 +...(xn-x)^2]/n
     * 结果精度：scale
     *
     * @param x
     * @param scale
     * @return
     */
    public static BigDecimal variance(BigDecimal[] x, int scale, RoundingMode setRoundingMode) {
        BigDecimal m = new BigDecimal(x.length);
        if (m.compareTo(BigDecimal.ZERO)==0){
            return BigDecimal.ZERO;
        }
        BigDecimal sum = BigDecimal.ZERO;
        //求和
        for (BigDecimal b : x) {
            sum = sum.add(b);
        }
        //求平均值
        BigDecimal dAve = sum.divide(m, 10, setRoundingMode);
        BigDecimal dVar = BigDecimal.ZERO;
        //求方差
        for (BigDecimal b : x) {
            dVar = dVar.add(b.subtract(dAve).pow(2));
        }
        return dVar.divide(m, 10, setRoundingMode).setScale(scale, setRoundingMode);
    }

    /**
     * 标准差σ=sqrt(s^2)
     * 默认精度：10
     *
     * @param x
     * @return
     */
    public static BigDecimal standardDeviation(BigDecimal[] x) {
        return standardDeviation(x, DEFAULT_SCALE);
    }


    /**
     * 标准差σ=sqrt(s^2)
     * 结果精度：scale
     * 默认精度策略：RoundingMode.HALF_UP
     * 牛顿迭代法求大数开方
     *
     * @param x
     * @param scale
     * @return
     */
    public static BigDecimal standardDeviation(BigDecimal[] x, int scale) {
        //默认RoundingMode.HALF_UP
        return standardDeviation(x, scale, RoundingMode.HALF_UP);
    }

    /**
     * 标准差σ=sqrt(s^2)
     * 结果精度：scale
     * 牛顿迭代法求大数开方
     *
     * @param x
     * @param scale
     * @return
     */
    public static BigDecimal standardDeviation(BigDecimal[] x, int scale, RoundingMode setRoundingMode) {
        //方差
        BigDecimal variance = variance(x, scale);
        if (variance.compareTo(BigDecimal.ZERO)==0){
            return BigDecimal.ZERO;
        }
        BigDecimal base2 = BigDecimal.valueOf(2.0);
        //计算精度
        int precision = 100;
        MathContext mc = new MathContext(precision, setRoundingMode);
        BigDecimal deviation = variance;
        int cnt = 0;
        while (cnt < 100) {
            deviation = (deviation.add(variance.divide(deviation, mc))).divide(base2, mc);
            cnt++;
        }
        deviation = deviation.setScale(scale, setRoundingMode);
        return deviation;
    }
}
