package org.ct.service.impl;


import org.ct.cache.CodeCache;
import org.ct.cache.TokenCache;
import org.ct.dao.IMemberDao;
import org.ct.service.IMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements IMemberService {

    private final static Logger LOGGER = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Autowired
    private IMemberDao memberDao;

    /**
     * 判断当前的用户信息是否存在
     *
     * @param phone 号码
     * @return
     */
    @Override
    public boolean exists(Long phone) {
        Long i = memberDao.exists(phone);
        return i == 1 ? true : false;
    }

    /**
     * 将生成的用户验证码存放到缓存当中
     *
     * @param phone
     * @param code
     * @return
     */
    @Override
    public boolean save(Long phone, String code) {
        //TODO  此处使用的是模拟缓存，后期更改为真实的缓存
        CodeCache codeCache = CodeCache.getInstance();
        return codeCache.save(phone, code);
    }

    /**
     * 将验证码信息发送给客户
     * @param phone
     * @param code
     * @return
     */
    @Override
    public boolean send(Long phone, String code) {
        LOGGER.info(phone + "|" + code);
        return true;
    }

    /**
     * 获取验证码信息
     * @param phone
     * @return
     */
    @Override
    public String getCode(Long phone) {
        return CodeCache.getInstance().getCode(phone);
    }

    @Override
    public Long getIdByPhone(String token) {
        Long phone = TokenCache.getInstance().getPhone(token);
        List<Long> idByPhone = memberDao.getIdByPhone(phone);
        if(idByPhone!=null && idByPhone.size()==1){
            return idByPhone.get(0);
        }
        return null;
    }

    @Override
    public Long getIdBy(Long username) {
        List<Long> idByPhone = memberDao.getIdByPhone(username);
        if(idByPhone!=null && idByPhone.size()==1){
            return idByPhone.get(0);
        }
        return null;
    }

}
