package org.ct.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.ct.constant.ApiCodeEnum;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiCodeDto {

    private Integer error;
    private String msg;
    private String code;
    private String token;

    public ApiCodeDto() {
    }

    public ApiCodeDto(Integer errno, String msg) {
        this.error = errno;
        this.msg = msg;
    }

    public ApiCodeDto(ApiCodeEnum apiCodeEnum) {
        this.msg = apiCodeEnum.getMsg();
        this.error = apiCodeEnum.getError();
    }

    public ApiCodeDto code(String code){
        this.code = code;
        return this;
    }

    public ApiCodeDto token(String token){
        this.token = token;
        return this;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
