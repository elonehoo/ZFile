package com.zfile.code.entity.script.dto;

import com.zfile.code.service.CategoryService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.annotation.Resource;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * [保存脚本](Save script)
 * @description: zh - 保存脚本
 * @description: en - Save script
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/6 12:03 下午
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "保存脚本")
public class SaveScript implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 脚本类别的序号
     */
    @ApiModelProperty( value = "脚本类别的序号" )
    private String categoryId;

    /**
     * 脚本内容和排序的集合
     */
    @ApiModelProperty( value = "脚本内容和排序的集合" )
    private List<ScriptValue> scriptValues;

}
