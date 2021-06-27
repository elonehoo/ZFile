package com.inet;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.text.StrSpliter;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.system.oshi.OshiUtil;
import com.xiaoTools.core.strUtil.StrUtil;
import com.zfile.SpringBootZfileApplication;
import com.zfile.code.entity.aes.Encryption;
import com.zfile.code.entity.mail.vo.SendMail;
import com.zfile.code.util.LocalCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import oshi.hardware.HWDiskStore;
import oshi.hardware.NetworkIF;

import javax.annotation.Resource;


/**
 * [测试模块](Test module)
 * @description: zh - 测试模块
 * @description: en - Test module
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/3 11:49 上午
*/
@SpringBootTest(classes = SpringBootZfileApplication.class)
class SpringBootZfileApplicationTests {


    @Resource
    private SendMail sendMail;

    @Resource
    private Encryption aes;

    /**
     * 测试07
     * 测试模块: 测试字符串截取
     * 测试结果: unknown
     */
    @Test
    void contextLoads_06(){
        String a = "/User/home/Downloads";
        String b = "/User/home/Downloads/";
        System.out.println(StrUtil.sub(a,a.length()-1,a.length()));
        System.out.println(StrUtil.sub(b,b.length()-1,b.length()));
        System.out.println("---------------------------------------------");
        String c = "/demo";
        String d = "demo";
        System.out.println(StrUtil.sub(c,0,1));
        System.out.println(StrUtil.sub(c, 1, c.length()));
        System.out.println(StrUtil.sub(d,0,1));
        System.out.println(StrUtil.sub(d, 1, c.length()));
    }

    /**
     * 测试06
     * 测试模块: 测试密钥加密和解密
     * 测试结果: ok
     */
    @Test
    void contextLoads_05(){
        AES aesAes = this.aes.createAes();
        String email1 = "huchengyea@163.com";
        String email2 = "huchengyea@163.com";
        System.out.println(aesAes.encryptHex(email1));
        System.out.println(aesAes.decryptStr(aesAes.encryptHex(email2)));
    }

    /**
     * 测试05
     * 测试模块: 「SM4」国密算法 加密测试
     * 测试结果: error
     */
    @Test
    void contextLoads_04(){
        String email1 = "huchengyea@163.com";
        String email2 = "huchengyea@163.com";
        System.out.println(SmUtil.sm4().encryptHex(email1));
        System.out.println(SmUtil.sm4().encryptHex(email2));
    }

    /**
     * 测试04
     * 测试模块：缓存cache的使用
     * 测试结果：ok
     */
    @Test
    void contextLoads_03(){
        LocalCache.put("123","123",15);
        LocalCache.put("123","12356",15);
        System.out.println(LocalCache.get("123"));
    }

    /**
     * 测试03
     * 测试模块：获取发送邮件的模块
     * 测试结果：ok
     */
    @Test
    void contextLoads_02(){
        //oojghdnuzasydidf
        //wqrnapchxwfwechb
        System.out.println(sendMail.mailAccount());
        System.out.println(MailUtil.send(
                sendMail.mailAccount(),
                "huchengyea@163.com",
                "测试ya",
                "邮件来自 Xiao Xun Yao 测试ya",
                false));

    }

    /**
     * 测试02
     * 测试模块：获取YML文件
     * 测试结果：ok
     */
    @Test
    void contextLoads_01() {
        System.out.println(sendMail.mailAccount());
    }

    /**
     * 测试01
     * 测试模块：测试获取系统的内部信息
     * 测试结果：ok
     */
    @Test
    void contextLoads_00() {
        System.out.println( "[系统名字](OshiUtil.getOs) ==> " + OshiUtil.getOs());
        System.out.println("---------------------------");
        System.out.println( "[系统内存](OshiUtil.getMemory.getTotal) ==> " + (OshiUtil.getMemory().getTotal() / 1024 / 1024 / 1024) + "G");
        System.out.println( "[系统剩余内存](OshiUtil.getMemory.getAvailable) ==> " + (OshiUtil.getMemory().getAvailable() / 1024 / 1024 / 1024) + "G");
        System.out.println("---------------------------");
        for (HWDiskStore diskStore : OshiUtil.getDiskStores()) {
            System.out.println(diskStore);
        }
        System.out.println("---------------------------");
        System.out.println( "[cpu信息](OshiUtil.getCpuInfo) ==> " + OshiUtil.getCpuInfo());
        System.out.println("---------------------------");
        System.out.println( "[内存信息](OshiUtil.getHardware.getMemory) ==> " + OshiUtil.getHardware().getMemory());
        System.out.println("---------------------------");
        System.out.println( "[系统信息](OshiUtil.getSystem) ==> " + OshiUtil.getSystem());
        System.out.println("---------------------------");
        System.out.println("网卡信息");
        for (NetworkIF networkIF : OshiUtil.getNetworkIFs()) {
            System.out.println(networkIF);
        }
        System.out.println("---------------------------");
        System.out.println( "[CPU状态信息](OshiUtil.getSensors) ==> " + OshiUtil.getSensors());
    }

}
