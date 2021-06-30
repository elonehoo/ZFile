package com.zfile.code.entity.file.dto;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * [上传的文件夹](Uploaded folder)
 * @description: zh - 上传的文件夹
 * @description: en - Uploaded folder
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/30 9:09 上午
*/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Folder implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 文件上传路径
     */
    private String rootPath;

}
