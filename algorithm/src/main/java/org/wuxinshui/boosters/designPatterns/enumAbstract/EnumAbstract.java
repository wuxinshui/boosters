package org.wuxinshui.boosters.designPatterns.enumAbstract;

/**
 * <p>EnumAbstract</p>
 * 枚举抽象方法
 *
 * @author wuxinshui
 */
public class EnumAbstract {

    //对外提供方法
    public void print(int key) {
        keyOf(key).print();
    }

    public void print(WorkDays workDays) {
        workDays.print();
    }

    //获取Key对应的实例
    private WorkDays keyOf(int key) {
        switch (key) {
            case 1:
                return WorkDays.MONDAY;
            case 2:
                return WorkDays.TUESDAY;
            case 3:
                return WorkDays.WEDNESDAY;
            case 4:
                return WorkDays.THURSDAY;
            case 5:
                return WorkDays.FRIDAY;
            case 6:
                return WorkDays.SUNDAY;
            case 7:
                return WorkDays.SATURDAY;
            default:
                return null;
        }
    }

    //最小访问权限设计原则，根据需要设置访问权限
    public enum WorkDays {
        MONDAY(1) {
            @Override
            protected void print() {
                System.out.println(getKey() + " : 消息1");
            }
        }, TUESDAY(2) {
            @Override
            protected void print() {
                System.out.println(getKey() + " : 消息2");
            }
        }, WEDNESDAY(3) {
            @Override
            protected void print() {
                System.out.println(getKey() + ": 消息3");
            }
        }, THURSDAY(4) {
            @Override
            protected void print() {
                System.out.println(getKey() + " : 消息4");
            }
        }, FRIDAY(5) {
            @Override
            protected void print() {
                System.out.println(getKey() + " : 消息5");

            }
        }, SATURDAY(6) {
            @Override
            protected void print() {
                System.out.println(getKey() + " : 消息6");
            }
        }, SUNDAY(7) {
            @Override
            protected void print() {
                System.out.println(getKey() + " : 消息7");
            }
        };

        private int key;

        //私有化构造方法
        private WorkDays(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        //抽象方法
        protected abstract void print();
    }

    public enum WorkDaysName {
        MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"), THURSDAY("星期四"), FRIDAY("星期五"), SATURDAY("星期六"), SUNDAY("星期日");
        private String name;

        WorkDaysName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
