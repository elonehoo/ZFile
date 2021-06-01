package com.zfile.code.entity.systemInfo.dist.vo;

import lombok.*;

/**
 * [磁盘的展示实体类](Display entity class of disk)
 * @description: zh - 磁盘的展示实体类
 * @description: en -  Display entity class of disk
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/5/31 7:52 下午
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Dist {

    /**
     * 磁盘的名字
     */
    private String name;

    /**
     * 磁盘大小
     */
    private String size;

    /**
     * 读出量
     */
    private String reads;

    /**
     * 写入量
     */
    private String writes;
}
