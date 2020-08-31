package com.timwang.basic.reflection.clazz;

import com.timwang.basic.reflection.logger.Log4jFactory;
import com.timwang.basic.reflection.logger.LogJdkFactory;
import com.timwang.basic.reflection.logger.LoggerFactory;

/**
 * @author wangjun
 * @date 2020-07-04
 */
public class DynamicLoggerFactory {
    private static LoggerFactory getLoggerFactory() {
        LoggerFactory logger = null;
        if (isClassPresent("com.timwang.basic.reflection.logger.Log4jFactory")) {
            logger = new Log4jFactory();
        } else {
            logger = new LogJdkFactory();
        }
        return logger;
    }

    public static void main(String[] args) {
        LoggerFactory loggerFactory = getLoggerFactory();
        System.out.println(loggerFactory.toString());
    }

    private static boolean isClassPresent(String name) {
        try {
            Class.forName(name);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
