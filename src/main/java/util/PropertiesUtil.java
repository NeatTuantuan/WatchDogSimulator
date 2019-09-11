package util;

import java.io.*;
import java.util.Properties;

/**
 * @ClassName PropertiesUtil
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/11 11:10
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class PropertiesUtil {

    public static Properties properties = new Properties();

    /**
     * 获取配置文件参数
     * @param key
     * @return
     */
    public String getProperties(String key){
        InputStream inputStream = Object.class.getResourceAsStream("/cfg.properties");
        InputStreamReader inputStreamReader = null;

        try {
            inputStreamReader = new InputStreamReader(inputStream,"GBK");
            properties.load(inputStreamReader);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println(properties.get("name"));
        return properties.get(key).toString();
    }
}
