package org.ct.dao;

import org.ct.util.FileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/applicationContext_util.xml"})
public class Test2 {

    /*@Test
    public void test1(){
        FileUtil.adDelete("34",6);
    }*/
}
