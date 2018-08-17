package org.wuxinshui.booster.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSort {
    public static void main(String[] args) {
        List<ScoreVo> list=new ArrayList<>();
        ScoreVo vo=new ScoreVo();
        vo.setCreateTime(new Date(100000l));
        vo.setScore(BigDecimal.ONE);
        list.add(vo);
        ScoreVo vo1=new ScoreVo();
        vo1.setCreateTime(new Date(300000l));
        vo1.setScore(BigDecimal.ONE);
        list.add(vo1);

        list= list.stream().sorted(Comparator.comparing(ScoreVo::getCreateTime)).collect(Collectors.toList());
        System.out.println(list);

        list= list.stream().sorted(Comparator.comparing(ScoreVo::getCreateTime).reversed()).collect(Collectors.toList());

        System.out.println(list);
    }

}
