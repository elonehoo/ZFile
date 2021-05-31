package com.zfile.code.service.impl;

import com.zfile.code.entity.cipher.po.Cipher;
import com.zfile.code.mapper.CipherMapper;
import com.zfile.code.service.CipherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 密码表 服务实现类
 * </p>
 *
 * @author HCY
 * @since 2021-04-28
 */
@Service
public class CipherServiceImpl extends ServiceImpl<CipherMapper, Cipher> implements CipherService {

}
