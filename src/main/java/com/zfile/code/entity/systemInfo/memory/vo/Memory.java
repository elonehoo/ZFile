package com.zfile.code.entity.systemInfo.memory.vo;

import lombok.*;

/**
 * [内存的具体信息](Memory specific information)
 * @description: zh - 内存的具体信息
 * @description: en - Memory specific information
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/1 9:44 上午
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Memory {
    /**
     * 使用的内存
     * 例如 ==> 7.3 GiB
     */
    private String usedMemory;
    /**
     * 总共的内存
     * 例如 ==> 16 GiB
     */
    private String totalMemory;
}
