package com.zfile.code.entity.systemInfo.systemInfo.vo;

import cn.hutool.system.oshi.CpuInfo;
import cn.hutool.system.oshi.OshiUtil;
import com.zfile.code.entity.systemInfo.cpu.vo.CentralProcessor;
import com.zfile.code.entity.systemInfo.dist.vo.Dist;
import com.zfile.code.entity.systemInfo.memory.vo.Memory;
import com.zfile.code.entity.systemInfo.network.vo.Network;
import com.zfile.code.entity.systemInfo.os.vo.OperatingSystem;
import lombok.*;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HWDiskStore;
import oshi.hardware.Sensors;
import oshi.util.FormatUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [系统的信息实体类](Information entity class of system)
 * @description: zh - 系统的信息实体类
 * @description: en - Information entity class of system
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/5/31 12:44 下午
*/
@Getter
@ToString
public class SystemInfo {

    /**
     * CPU 的具体信息
     */
    private CentralProcessor centralProcessor;

    /**
     * 磁盘信息
     */
    private List<Dist> distS;

    /**
     * 内存信息
     */
    private Memory memory;

    /**
     * 网卡的具体信息
     */
    private List<Network> networks;

    /**
     * 系统信息
     */
    private OperatingSystem operatingSystem;

    /**
     * [通过无参方法构建出系统属性](The system attributes are constructed by nonparametric method)
     * @description: zh - 通过无参方法构建出系统属性
     * @description: en - The system attributes are constructed by nonparametric method
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/1 11:03 上午
    */
    public SystemInfo() {
        setCentralProcessor();
        setDistS();
        setMemory();
    }

    /**
     * [获取到用户的 CPU 的信息](Get the user's CPU information)
     * @description: zh - 获取到用户的 CPU 的信息
     * @description: en - Get the user's CPU information
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/1 11:04 上午
    */
    public void setCentralProcessor() {
        DecimalFormat format = new DecimalFormat("#.00");
        CpuInfo info = OshiUtil.getCpuInfo();
        Sensors sensors = OshiUtil.getSensors();
        this.centralProcessor = new CentralProcessor(
                info.getCpuNum(),
                info.getSys() + "%",
                info.getUsed() + "%",
                info.getFree() + "%",
                String.valueOf(Double.parseDouble(format.format(100.0D - info.getFree()))) + "%",
                info.getCpuModel(),
                String.valueOf(sensors.getCpuTemperature()) + " °C",
                Arrays.toString(sensors.getFanSpeeds()));
    }

    /**
     * [获取用户的硬盘信息 ](Get user's hard disk information)
     * @description: zh - 获取用户的硬盘信息
     * @description: en - Get user's hard disk information
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/1 11:12 上午
    */
    public void setDistS() {
        List<Dist> list = new ArrayList<>();
        for (HWDiskStore diskStore : OshiUtil.getDiskStores()) {
            boolean readwrite = diskStore.getReads() > 0L || diskStore.getWrites() > 0L;
            list.add(new Dist(
                    diskStore.getName(),
                    diskStore.getSize() > 0L ? FormatUtil.formatBytesDecimal(diskStore.getSize()) : "?",
                    readwrite ? String.valueOf(diskStore.getReads()) : "?",
                    readwrite ? String.valueOf(diskStore.getWrites()) : "?"));
        }
        this.distS = list;
    }

    /**
     * [获取用户的计算机的内存信息](Gets the memory information of the user's computer)
     * @description: zh - 获取用户的计算机的内存信息
     * @description: en - Gets the memory information of the user's computer
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/1 6:30 下午
    */
    public void setMemory() {
        GlobalMemory memory = OshiUtil.getHardware().getMemory();
        this.memory = new Memory(
                FormatUtil.formatBytes(memory.getAvailable()),
                FormatUtil.formatBytes(memory.getTotal()));
    }
}
