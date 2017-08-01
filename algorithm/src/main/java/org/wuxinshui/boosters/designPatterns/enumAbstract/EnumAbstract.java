package org.wuxinshui.boosters.designPatterns.enumAbstract;

/**
 * <p>EnumAbstract</p>
 * 枚举抽象方法
 *
 * @author wuxinshui
 */
public class EnumAbstract {


    public void print(int key) {
        keyOf(key).print();
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
    private enum WorkDays {
        MONDAY(1) {
            @Override
            protected void print() {
                System.out.println(getKey());
            }
        }, TUESDAY(2) {
            @Override
            protected void print() {
                System.out.println(getKey());
            }
        }, WEDNESDAY(3) {
            @Override
            protected void print() {
                System.out.println(getKey());
            }
        }, THURSDAY(4) {
            @Override
            protected void print() {
                System.out.println(getKey());
            }
        }, FRIDAY(5) {
            @Override
            protected void print() {
                System.out.println(getKey());
            }
        }, SATURDAY(6) {
            @Override
            protected void print() {
                System.out.println(getKey());
            }
        }, SUNDAY(7) {
            @Override
            protected void print() {
                System.out.println(getKey());
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
}
