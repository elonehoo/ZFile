package com.zfile.code.entity.systemInfo.vo;

/**
 * [系统的信息实体类](Information entity class of system)
 * @description: zh - 系统的信息实体类
 * @description: en - Information entity class of system
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/5/31 12:44 下午
*/
public class SystemInfo {
    /**
     * 系统名字
     * 例如 -> Apple macOS 10.14.6 (Mojave) build 18G103
     */
    private String osName;
    /**
     * cpu的信息
     * 例如 -> Intel(R) Core(TM) i5-5257U CPU @ 2.70GHz
     */
    private String cpuInfo;
    /**
     * CPU当前空闲率
     * 例如 -> 94.51 %
     */
    private String cpuIdleRate;
    /**
     * CPU利用率
     * 例如 -> 5.49 %
     */
    private String cpuUtilization;
    /**
     * cpu温度
     * 例如 -> 62.375 °C
     */
    private String cpuTemperature;
    /**
     * cpu核心数
     * 例如 -> 4
     */
    private String cpuCore;
    /**
     * cpu的风扇速度
     * 例如 -> [1232]
     */
    private String cpuFanSpeeds;
    /**
     * 使用的内存
     * 例如 -> 10.3 GB
     */
    private String memoryUse;
    /**
     * 总共的内存
     * 例如 -> 16.0 GB
     */
    private String memoryTotal;
    /**
     * 网卡地址
     * 例如 -> 192.168.0.1
     */
    private String wifiAddress;

    private String[] dist;
}
