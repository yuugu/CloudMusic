package com.yuugu.cloud.scaffold.manner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;
import com.yuugu.cloud.scaffold.R;
import com.yuugu.cloud.scaffold.utils.NetworkUtils;
import java.util.Objects;

/**
 * @author: yuugu
 * @date: 2020/7/16
 */
public class NetworkStateReceive extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Objects.equals(intent.getAction(), ConnectivityManager.CONNECTIVITY_ACTION)) {
            if (!NetworkUtils.isConnected()) {
                Toast.makeText(context, context.getString(R.string.network_not_good), Toast.LENGTH_SHORT).show();
            }
        }
    }
}