package com.inet;

import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.system.SystemUtil;
import cn.hutool.system.oshi.OshiUtil;
import com.xiaoTools.core.randomUtil.RandomUtil;
import com.zfile.SpringBootZfileApplication;
import com.zfile.code.entity.mail.vo.SendMail;
import com.zfile.code.entity.systemInfo.cpu.vo.CentralProcessor;
import com.zfile.code.entity.systemInfo.systemInfo.vo.SystemInfo;
import com.zfile.code.service.CipherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import oshi.hardware.Display;
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

    /**
     * 测试04
     * 测试模块：缓存cache的使用
     * 测试结果：ok
     */
    @Test
    void contextLoads_03(){
        TimedCache<String , String> cache = new TimedCache<String , String>(60 * 15);
        //存入74bd
        cache.put("123", RandomUtil.randomStringLow(4));
        System.out.println(cache.get("123"));
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
