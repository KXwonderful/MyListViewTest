package com.kxwon.mylistviewtest;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;

import com.kxwon.mylistviewtest.bean.BlackNumberInfo;
import com.kxwon.mylistviewtest.dao.BlackNumberDao;

import java.util.List;
import java.util.Random;

/**
 * 测试类
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public Context mContext;
    @Override
    protected void setUp() throws Exception {
        this.mContext = getContext();
        super.setUp();
    }

    /**
     * 测试添加黑名单
     */
    public void testAdd(){
        BlackNumberDao dao = new BlackNumberDao(mContext);
        Random random = new Random();
        for (int i = 0; i < 200; i++) {
            Long number = 13300000000l +i;
            dao.add(number +"",String.valueOf(random.nextInt(3) + 1));
        }
    }

    /**
     * 测试删除黑名单
     */
    public void testDelete(){
        BlackNumberDao dao = new BlackNumberDao(mContext);
        boolean delete = dao.delete("13300000000");
        assertEquals(true,delete);
    }

    /**
     * 测试查询黑名单
     */
    public void testFind(){
        BlackNumberDao dao = new BlackNumberDao(mContext);
        String number = dao.findNumber("13300000004");
        System.out.println(number);
    }

    /**
     * 测试查询所有黑名单数据
     */
    public void testFindAll(){
        BlackNumberDao dao = new BlackNumberDao(mContext);
        List<BlackNumberInfo> blackNumberInfos = dao.findAll();
        for (BlackNumberInfo blackNumberInfo : blackNumberInfos) {
            System.out.println(blackNumberInfo.getMode() + "" + blackNumberInfo.getNumber());
        }
    }
}
