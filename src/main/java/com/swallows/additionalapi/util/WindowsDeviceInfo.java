package com.swallows.additionalapi.util;

import net.minecraftforge.fml.common.FMLLog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WindowsDeviceInfo {

    //CPU序列号
    public static String getCPUId() {
        return EXEC("wmic cpu get ProcessorId");
    }

    //设备UUID
    public static String getSystemUUID() {
        return EXEC("wmic csproduct get UUID");
    }

    //硬盘序列号
    public static String getDiskDriveID() {
        return EXEC("wmic diskdrive get SerialNumber");
    }

    //主板序列号
    public static String getBIOSID() {
        return EXEC("wmic baseboard get SerialNumber");
    }

    //系统ID
    public static String getOSID() {
        return EXEC("wmic os get SerialNumber");
    }

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().startsWith("windows");
    }

    public static String EXEC(String command) {

        String str = null;

        if(isWindows()){
            try {
                Process process = Runtime.getRuntime().exec(command);
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                reader.readLine();
                reader.readLine();
                str = reader.readLine().trim();
                reader.close();
            } catch (IOException e) {
                FMLLog.log.info("Exceptions");
            }
        }
        else {
            FMLLog.log.info("Not Windows");
        }
        return str;
    }
}
