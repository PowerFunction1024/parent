package com.jadd.constant;

/**
 * @author : _xu_
 * @desc : TODO
 * @date : 2020/3/19
 */
public enum TestEnum {
    //注释，不然会报警
    CHANGE(0,"变更"),
    BREAK(1,"解约"),
    END(2,"终止");

    private final Integer type;
    private final String desc;

    TestEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
    //定义为static的话可以直接用
    public static Integer getType(String desc) {
        for (TestEnum testEnum : TestEnum.values()) {
            if (testEnum.getDesc().equals(desc)) {
                return testEnum.getType();
            }
        }
        return null;
    }

    public static String getDesc(Integer type) {
        for (TestEnum testEnum : TestEnum.values()) {
            if (testEnum.getType().equals(type)) {
                return testEnum.getDesc();
            }
        }
        return null;
    }
}
