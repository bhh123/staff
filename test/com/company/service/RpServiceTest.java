package com.company.service;

import com.company.factory.ServiceFactory;
import com.company.model.RewardPublish;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 柏欢欢 on 2017/12/21.
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

}