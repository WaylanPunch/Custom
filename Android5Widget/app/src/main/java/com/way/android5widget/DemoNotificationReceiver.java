package com.way.android5widget;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static android.app.PendingIntent.FLAG_CANCEL_CURRENT;
import static android.app.PendingIntent.FLAG_UPDATE_CURRENT;
import static com.way.android5widget.DemoAppWidget.CHANGE_STATE;
import static com.way.android5widget.DemoAppWidget.IMAGE_COUNT;
import static com.way.android5widget.DemoAppWidget.mAvatars;
import static com.way.android5widget.DemoAppWidget.mNames;

/**
 * 更新通知栏
 * <p>
 * <p>
 * Created by pc on 2016/12/14.
 */

public class DemoNotificationReceiver extends BroadcastReceiver {
    public static int sId = new AtomicInteger(0).incrementAndGet();

    // 修改通知栏状态
    public static final String NOTIFICATION_STATE = "com.way.android5widget.action.NOTIFICATION_STATE";

    private static boolean sIsUpdate = false; // 是否启动更新时间
    private static long sUpdateImageLastTime = 0L; // 上次更新图片的时间
    private static int sImageIndex = 0; // 图片位置

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }

        String action = intent.getAction();
        switch (action) {
            case CHANGE_STATE:
                setUpdate(context);
                break;
            case NOTIFICATION_STATE:
                updateData(context);
                break;
            default:
                break;
        }
    }

    /**
     * 设置更新状态
     *
     * @param context 上下文
     */
    private void setUpdate(Context context) {
        sIsUpdate = !sIsUpdate;
        if (sIsUpdate) {
            startUpdate(context); // 开始更新
        } else {
            stopUpdate(context); // 结束更新
        }
    }

    /**
     * 更新数据
     *
     * @param context 上下文
     */
    private void updateData(Context context) {
        NotificationCompat.Builder builder = getNotification(context);

        // 获取布局, 并设置关闭显示
        RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.notification_demo);

        Date date = new Date();

        // 设置文字
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH);
        rv.setTextViewText(R.id.widget_tv_text, sdf.format(date)); // 设置文字

        // 更换图片
        long seconds = TimeUnit.MILLISECONDS.toSeconds(date.getTime());
        long interval = seconds - sUpdateImageLastTime; // 每隔5秒更换图片与图片文字
        if (sUpdateImageLastTime == 0 || interval % 5 == 0) {
            sImageIndex++;
            rv.setImageViewResource(R.id.widget_tv_image, mAvatars[sImageIndex % IMAGE_COUNT]); // 设置图片
            rv.setTextViewText(R.id.widget_tv_image_text, context.getString(mNames[sImageIndex % IMAGE_COUNT]));
            sUpdateImageLastTime = seconds;
        }

        builder.setCustomContentView(rv);
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(sId, notification);
    }

    /**
     * 设置通知栏
     *
     * @param context 上下文
     */
    public static NotificationCompat.Builder getNotification(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.drawable.avatar_jessica);
        builder.setWhen(System.currentTimeMillis());
        builder.setOngoing(true); // 始终存在

        // 开启或关闭时间的控制
        RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.notification_demo);

        // 点击更新状态按钮
        Intent changeIntent = new Intent(CHANGE_STATE);
        PendingIntent changePi = PendingIntent.getBroadcast(context, 0, changeIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        // 点击头像跳转主页
        Intent mainIntent = new Intent(context, MainActivity.class);
        PendingIntent mainPi = PendingIntent.getActivity(context, 0, mainIntent, FLAG_UPDATE_CURRENT);

        rv.setOnClickPendingIntent(R.id.widget_tv_image, mainPi); // 设置头像
        rv.setOnClickPendingIntent(R.id.widget_b_control, changePi); // 设置更新

        builder.setCustomContentView(rv);

        return builder;
    }

    /**
     * 启动更新小插件的时间
     *
     * @param context 上下文
     */
    public void startUpdate(Context context) {
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        // 设置更新
        am.setRepeating(AlarmManager.RTC, System.currentTimeMillis(),
                1000, getUpdateIntent(context, true));
    }

    /**
     * 停止更新小插件的时间
     *
     * @param context 上下文
     */
    public void stopUpdate(Context context) {
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        // 取消更新
        am.cancel(getUpdateIntent(context, false));
    }

    /**
     * 获取需要更新的延迟消息
     *
     * @param context 上下文
     * @return 延迟消息
     */
    private PendingIntent getUpdateIntent(Context context, boolean isStart) {
        NotificationCompat.Builder builder = getNotification(context);

        RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.notification_demo);
        if (isStart) {
            rv.setTextViewText(R.id.widget_b_control, context.getString(R.string.stop));
        } else {
            rv.setTextViewText(R.id.widget_b_control, context.getString(R.string.start));
        }
        builder.setCustomContentView(rv);

        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(sId, notification);

        Intent alertIntent = new Intent(NOTIFICATION_STATE); // 设置更新活动
        return PendingIntent.getBroadcast(context, 0, alertIntent, FLAG_CANCEL_CURRENT); // 取消前一个更新
    }
}
