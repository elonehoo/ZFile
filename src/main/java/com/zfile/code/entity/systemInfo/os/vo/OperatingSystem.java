package com.zfile.code.entity.systemInfo.os.vo;

import lombok.*;

/**
 * [操作系统的具体信息](Operating system specific information)
 * @description: zh - 操作系统的具体信息
 * @description: en - Operating system specific information
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/1 9:20 上午
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OperatingSystem {
    /**
     * 系统名称
     * 例如 ==> Apple macOS 10.14.6 (Mojave) build 18G103
     */
    private String name;

}
