package com.inet;

import cn.hutool.system.SystemUtil;
import cn.hutool.system.oshi.OshiUtil;
import com.zfile.code.entity.systemInfo.cpu.vo.CentralProcessor;
import com.zfile.code.entity.systemInfo.systemInfo.vo.SystemInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import oshi.hardware.Display;
import oshi.hardware.HWDiskStore;
import oshi.hardware.NetworkIF;


@SpringBootTest(classes = SpringBootZfileApplicationTests.class)
class SpringBootZfileApplicationTests {

    @Test
    void contextLoads_01() {

    }

    @Test
    void contextLoads() {
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
