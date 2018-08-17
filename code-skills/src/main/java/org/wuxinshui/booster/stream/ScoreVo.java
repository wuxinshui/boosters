package org.wuxinshui.booster.stream;

import java.math.BigDecimal;
import java.util.Date;

public class ScoreVo {
    private BigDecimal score;
    /**
     * 创建时间
     */
    private Date createTime;

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
