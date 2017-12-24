package com.company.service;

import com.company.factory.ServiceFactory;
import com.company.model.RewardPublish;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 柏欢欢 on 2017/12/23.
 */
public class RpServiceTest {
    private RpService rpService;
    @Before
    public void setUp() throws Exception {
        rpService = ServiceFactory.getRpServiceInstance();
    }

    @Test
    public void getRP() throws Exception {
        List<RewardPublish> list = rpService.getRP("1001");
        list.forEach(rp -> System.out.println(rp));
    }

    @Test
    public void insertRP() throws Exception {
        String timeString = "2017-10-10";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = sdf.parse(timeString);
        Date date = new Date(utilDate.getTime());
        RewardPublish rewardPublish = new RewardPublish(10,"1003","惩","多次迟到",date);
        int n = rpService.insertRP(rewardPublish);
        assertEquals(1,n);
    }

    @Test
    public void bathchDeleteRP() throws Exception {
        List<Integer> ids = new ArrayList<>();
        ids.add(6);
        ids.add(7);
        int[] result = rpService.bathchDeleteRP(ids);
        assertEquals(2,result.length);
    }

    @Test
    public void getAllRP() throws Exception {
        List<RewardPublish> list = rpService.getAllRP();
        list.forEach(rewardPublish -> System.out.println(rewardPublish));
    }

    @Test
    public void queryFilter() throws Exception {
        List<RewardPublish> list = rpService.queryFilter("WHERE flag = '惩' ");
        list.forEach(rewardPublish -> System.out.println(rewardPublish));
    }

    @Test
    public void queryLike() throws Exception {
        List<RewardPublish> list = rpService.queryLike("先进个人");
        list.forEach(rewardPublish -> System.out.println(rewardPublish));
    }

}