package com.cht.framework.core.spring.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.LoggerRepository;
import org.springframework.web.util.Log4jConfigListener;

import com.cht.framework.core.exception.SystemException;
/**
 * 重写Log4jConfigListener使其能在Weblogic中发布war包时能够正确读取日志配置<br>
 * 注意:目前仅支持properties格式的日志配置不支持xml格式的配置
 * @author WJK
 * @version 2012-11
 */
public class MyLog4jConfigListener extends Log4jConfigListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        String location = servletContext.getInitParameter("log4jConfigLocation");
        String intervalString = servletContext.getInitParameter("log4jRefreshInterval");
        if (intervalString != null){
            try {
                long refreshInterval = Long.parseLong(intervalString);
                PropertyConfigurator.configureAndWatch(location, refreshInterval);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException((new StringBuilder("Invalid 'log4jRefreshInterval' parameter: ")).append(ex.getMessage()).toString());
            }
        } else{
            initLogging(location);
        }
    }

    private void initLogging(String location) {
        LoggerRepository hierarchy = LogManager.getLoggerRepository();
        Properties props = new Properties();
        InputStream istream = this.getClass().getResourceAsStream(location);
        try {
            props.load(istream);
        } catch (IOException e) {
            throw new SystemException("日志配置文件读取失败");
        }
        IOUtils.closeQuietly(istream);
        (new PropertyConfigurator()).doConfigure(props, hierarchy);
        return;
    }
}
