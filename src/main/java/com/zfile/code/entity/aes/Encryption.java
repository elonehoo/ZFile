package com.zfile.code.entity.aes;

import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;

/**
 * [加密](Encryption)
 * @description: zh - 加密
 * @description: en - Encryption
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/26 3:37 下午
*/

@Getter
@Setter
@ToString
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Encryption implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Value("${aes.key}")
    private String key;

    public AES createAes(){
        return new AES("CBC", "PKCS7Padding",
                // 密钥，可以自定义
                ("ZFile" + this.key).getBytes(),
                ("ZFile" + this.key).getBytes());
    }

}
