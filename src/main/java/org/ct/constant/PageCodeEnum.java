package org.ct.constant;

public enum PageCodeEnum {
    ADD_SUCCESS(1000,"新增成功!"),
    ADD_FAIL(1001,"新增失败!"),
    DELETE_SUCCESS(2000,"删除成功!"),
    DELETE_FAIL(2001,"删除失败!"),
    INSERT_SUCCESS(3000,"新增成功!"),
    INSERT_FALI(3001,"新增失败!"),
    UPDATE_SUCCESS(4000,"修改成功!"),
    UPDATE_FALI(4001,"修改失败!");

    private Integer code;
    private String msg;

    public final static String KEY="pageCode";

    PageCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
