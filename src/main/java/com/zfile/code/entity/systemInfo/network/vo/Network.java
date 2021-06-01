package com.zfile.code.entity.systemInfo.network.vo;

import lombok.*;

/**
 * [网卡的具体信息](Specific information of network card)
 * @description: zh - 网卡的具体信息
 * @description: en - Specific information of network card
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/1 9:57 上午
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Network {
    /**
     * MAC 物理地址
     * 例如 ==> 98:01:a7:8b:e4:c3
     */
    private String macAddress;

    /**
     * IPV4 地址
     * 例如 ==> 192.168.1.102/24
     */
    private String ipv4Address;

    /**
     * IPV6 地址
     * 例如 ==> fe80:0:0:0:1806:22e9:c2c6:5e64/64
     */
    private String ipv6Address;

}
