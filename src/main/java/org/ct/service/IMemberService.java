package org.ct.service;

public interface IMemberService {

    /**
     * 判断当前用户的信息是否存在
     * @param phone 号码
     * @return
     */
    boolean exists(Long phone);


    boolean save(Long phone,String code);

    boolean send(Long phone, String code);

    String getCode(Long phone);

    Long getIdByPhone(String token);

    Long getIdBy(Long username);
}
