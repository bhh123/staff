package com.company.factory;

import com.company.service.RpService;
import com.company.service.impl.RpServiceImpl;

/**
 * Created by 柏欢欢 on 2017/12/21.
 */
public class ServiceFactory {
    public static RpService getRpServiceInstance(){
        return new RpServiceImpl();
    }
}
