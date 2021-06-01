package com.zfile.code.entity.systemInfo.cpu.vo;

import lombok.*;

/**
 * [核心处理器的具体信息](Core processor specific information)
 * @description: zh - 核心处理器的具体信息
 * @description: en - Core processor specific information
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/1 9:24 上午
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CentralProcessor {
    /**
     * CPU核心数
     * 例如 ==> 4
     */
    private Integer coresNumber;

    /**
     * 系统使用率
     * 例如 ==> 1.99%
     */
    private String systemUtilization;

    /**
     * 用户使用率
     * 例如 ==> 4.23%
     */
    private String userUtilization;

    /**
     * 当前空闲率
     * 例如 ==> 93.78%
     */
    private String currentIdleRate;

    /**
     * 利用率
     * 例如 ==> 6.22%
     */
    private String utilizationRate;

    /**
     * 温度
     * 例如 ==> 57.25°C
     */
    private String temperature;

    /**
     * 风扇转速
     * 例如 ==> 1289
     */
    private String fanSpeeds;
}
