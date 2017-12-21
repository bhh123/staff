package com.company.factory;

import com.company.dao.RewardPublishDAO;
import com.company.dao.impl.RewardPublishDAOImpl;

/**
 * Created by 柏欢欢 on 2017/12/20.
 */
public class DAOFactory {
    public static RewardPublishDAO getRewardPublishInstance(){
        return new RewardPublishDAOImpl();
    }
}
