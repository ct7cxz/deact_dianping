package org.ct.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 此处存放的生成token信息，与之对应的token信息
 */
public class TokenCache {

    private static TokenCache instance;

    private Map<String, Long> map;

    private TokenCache() {
        map = new HashMap<>();
    }

    public static TokenCache getInstance() {
        if (instance == null) {
            synchronized (TokenCache.class) {
                if (instance == null) {
                    instance = new TokenCache();
                }
            }
        }
        return instance;
    }

    /**
     * 保存用户信息
     * @param token
     * @param phone
     */
    public void saveToken(String token, Long phone) {
        map.put(token, phone);
    }

    /**
     * 依据token取出存放的用户信息
     * @param token
     * @return
     */
    public Long getPhone(String token){
        return map.get(token);
    }

}
