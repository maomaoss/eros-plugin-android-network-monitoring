package com.example.eros_plugin_utils.receiver.neteork;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 文件描述：判断网络工具类
 * 作者：M、
 * 创建时间：2018/8/10
 * 更改时间：2018/8/10
 */
public class NetUtil {
    //网络未连接
    private static final boolean NETWORK_NONE = false;
    //移动数据或无线网络连接
    private static final boolean NETWORK_AVAILABLE = true;

    /**
     * 获取当前网络状态
     * @param context 上下文对象
     * @return boolean
     */
    public static boolean getNetStatus(Context context) {
        // 获取系统连接管理器对象
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        //获取网络状态信息
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager
                .getActiveNetworkInfo() : null;
        //判断网络NetworkInfo是否不为空且连接
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            //网络连接可用
            return NETWORK_AVAILABLE;

        } else {
            return NETWORK_NONE;//网络不可用（未连接）
        }

    }
}
