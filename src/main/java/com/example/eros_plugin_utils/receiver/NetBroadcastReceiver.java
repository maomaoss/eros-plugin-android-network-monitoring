package com.example.eros_plugin_utils.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.example.eros_plugin_utils.receiver.neteork.NetUtil;

/**
 * 文件描述：监听网络状态变化
 * 作者：M、
 * 创建时间：2018/8/10
 * 更改时间：2018/8/10
 */
public class NetBroadcastReceiver extends BroadcastReceiver {
    //网络状态监听接口
    private NetStatusMonitor netStatusMonitor;

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            //获取网络状态的类型
            boolean netStatus = NetUtil.getNetStatus(context);
            if (netStatusMonitor != null)
                // 接口传递网络状态的类型到注册广播的页面
                netStatusMonitor.onNetChange(netStatus);
        }
    }

    /**
     * 网络状态类型改变的监听接口
     */
    public interface NetStatusMonitor {
        void onNetChange(boolean netStatus);
    }

    /**
     * 设置网络状态监听接口
     */
    public void setStatusMonitor(NetStatusMonitor netStatusMonitor) {
        this.netStatusMonitor = netStatusMonitor;
    }
}
