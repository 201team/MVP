package com.dhcc.csr.network.config;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.SPStaticUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.dhcc.csr.common.base.Constants;
import com.dhcc.csr.util.AESOperator;
import com.orhanobut.logger.Logger;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wlsh
 * @Date: 2019/8/2 10:04
 * @Description: 配置信息  包括公共参数信息
 */
public class BaseRetrofitConfig {

    /**
     * 配置后台需要参数信息
     *
     * @return
     */
    public static Map<String, String> getHeaders() {
        //添加到header请求头
        Map<String, String> header = new HashMap<>();
        AESOperator operator = AESOperator.getInstance();
        //接口版本
        String InterfaceVersion = "v1.0234";
        //客户端类别 Android 1  Ios  2
        String ClientType = "1";
        //私钥
        String SecretKey = "adshfdsfhWEWRFDFADSFasfsfdf";
        //App版本号
        String AppVersion = AppUtils.getAppVersionName();
        //App名称
        String AppName = AppUtils.getAppName();
        //设备厂商
        String Manufacturer = DeviceUtils.getManufacturer();
        //设备名称
        String Model = DeviceUtils.getModel();

        try {
            header.put("InterfaceVersion", operator.encrypt(InterfaceVersion));
            header.put("SecretKey", operator.encrypt(SecretKey));
            header.put("ClientType", operator.encrypt(ClientType));
            header.put("AppVersion", operator.encrypt(AppVersion));
            header.put("AppName", operator.encrypt(AppName));
            header.put("Manufacturer", operator.encrypt(Manufacturer));
            header.put("Model", operator.encrypt(Model));
            header.put("TimeStamp", operator.encrypt(TimeUtils.date2String(Calendar.getInstance().getTime())));
        } catch (Exception e) {
            e.printStackTrace();
            Logger.d("配置后台信息加密出错");
        }

        return header;
    }


    /**
     * 配置后台需要参数信息(未加密)
     *
     * @return
     */
    public static Map<String, String> getOriginalHeaders() {
        //添加到header请求头
        Map<String, String> header = new HashMap<>();
        //接口版本
        String InterfaceVersion = "v1.0234";
        //客户端类别 Android 1  Ios  2
        String ClientType = "1";
        //私钥
        String SecretKey = "adshfdsfhWEWRFDFADSFasfsfdf";
        //App版本号
        String AppVersion = AppUtils.getAppVersionName();
        //App名称
        String AppName = AppUtils.getAppName();
        //设备厂商
        String Manufacturer = DeviceUtils.getManufacturer();
        //设备名称
        String Model = DeviceUtils.getModel();

        header.put("InterfaceVersion", InterfaceVersion);
        header.put("SecretKey", SecretKey);
        header.put("ClientType", ClientType);
        header.put("AppVersion", AppVersion);
        header.put("AppName", AppName);
        header.put("Manufacturer", Manufacturer);
        header.put("Model", Model);
        header.put("Token", SPStaticUtils.getString(Constants.LOGIN_TOKEN));
        header.put("TimeStamp", TimeUtils.date2String(Calendar.getInstance().getTime()));

        return header;
    }
}
