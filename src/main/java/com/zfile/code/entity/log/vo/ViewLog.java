package com.zfile.code.entity.log.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * [展示日志VO类](Show log VO class)
 * @description: zh - 展示日志VO类
 * @description: en - Show log VO class
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/3 5:19 下午
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ViewLog implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 日志数据
     */
    private String logValue;

    /**
     * 日志时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date logDate;
}
