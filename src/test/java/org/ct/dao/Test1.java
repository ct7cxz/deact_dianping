package org.ct.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Test1 {

    IAdDao adDao = null;
    @Before
    public void init() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext_dao.xml");
        adDao = context.getBean("IAdDao", IAdDao.class);
    }

    @Test
    public void testFindAll() {
        adDao.findAll();
    }


}
