package com.tele.tscheckeye.model.lib_tools.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * 光线传感器工具
 * 1，注册光线传感器
 * 3，注销光线传感器
 */
public class LightSensorUtil {

    private LightSensorUtil() {
    }

    public static SensorManager getSenosrManager(Context context) {
        return (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
    }

    /**
     * 注册光线传感器监听器
     *
     * @param sensorManager
     * @param listener
     */
    public static boolean registerLightSensor(SensorManager sensorManager, SensorEventListener listener) {
        boolean flag = false;
        if (sensorManager == null || listener == null) {
            return flag;
        }
        Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT); // 获取光线传感器
        if (lightSensor != null) { // 光线传感器存在时
            flag = sensorManager.registerListener(listener, lightSensor, SensorManager.SENSOR_DELAY_NORMAL); // 注册事件监听
        }
        return flag;
    }

    /**
     * 注销光线传感器监听器
     *
     * @param sensorManager
     * @param listener
     */
    public static void unregisterLightSensor(SensorManager sensorManager, SensorEventListener listener) {
        if (sensorManager == null || listener == null) {
            return;
        }
        sensorManager.unregisterListener(listener);
    }

}
