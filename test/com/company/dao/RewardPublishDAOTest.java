package com.company.dao;

import com.company.factory.DAOFactory;
import com.company.model.RewardPublish;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 柏欢欢 on 2017/12/20.
 */
public class RewardPublishDAOTest {
    private RewardPublishDAO rewardPublishDAO;
    @Before
    public void setUp() throws Exception {
        rewardPublishDAO = DAOFactory.getRewardPublishInstance();
    }

    @Test
    public void insertRP() throws Exception {
        String timeString = "2017-11-10";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = sdf.parse(timeString);
        Date date = new Date(utilDate.getTime());
        RewardPublish rewardPublish = new RewardPublish("1002","奖","明星员工",date);
        int n = rewardPublishDAO.insertRP(rewardPublish);
        assertEquals(1,n);

    }

    @Test
    public void batchDelteRP() throws Exception {
        List<Integer> ids = new ArrayList<>();
        ids.add(6);
        ids.add(7);
        int[] result = rewardPublishDAO.batchDelteRP(ids);
        assertEquals(2,result.length);

    }

    @Test
    public void getAll() throws Exception {
        List<RewardPublish> list = rewardPublishDAO.getAll();
        list.forEach(rewardPublish -> System.out.println(rewardPublish));

    }

    @Test
    public void getRP() throws Exception {
        List<RewardPublish> list = rewardPublishDAO.getRP("1002");
        list.forEach(rewardPublish -> System.out.println(rewardPublish));


    }

    @Test
    public void queryLike() throws Exception {
        List<RewardPublish> list = rewardPublishDAO.queryLike("先进个人");
        list.forEach(rewardPublish -> System.out.println(rewardPublish));
    }

    @Test
    public void queryFilter() throws Exception {
        List<RewardPublish> list = rewardPublishDAO.queryFilter("WHERE flag = '惩' ");
        list.forEach(rewardPublish -> System.out.println(rewardPublish));

    }

}