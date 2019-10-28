package org.ct.cache;


import java.util.HashMap;
import java.util.Map;

public class CodeCache {

    private static CodeCache instance;

    private Map<Long,String> cacheMap;

    private CodeCache(){
        cacheMap = new HashMap<>();
    }

    /**
     * 单例构造函数，当且仅当第一次获取缓存对象的时候才进行初始化map
     * @return
     */
    public static CodeCache getInstance(){
        if(instance == null){
            synchronized (CodeCache.class){
                if(instance == null){
                    instance = new CodeCache();
                }
            }
        }
        return instance;
    }

    /**
     * 保存获取到的对象
     * @param phone 手机号码
     * @param code  验证信息
     * return  true 手机号不存在，进行保存当前对象 | false 手机号存在直接返回false，不进行保存操作
     */
    public boolean save(Long phone,String code){
        if(cacheMap.containsKey(phone)){
            return false;
        }else {
            cacheMap.put(phone,code);
            return true;
        }
    }

    /**
     * 获取保存的验证码信息
     * @param phone
     * @return
     */
    public String getCode(Long phone){
        return cacheMap.get(phone);
    }
}
