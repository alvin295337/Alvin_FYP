package com.fyp.alvin.abel;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

public class CallNotification {

    MainActivity mainActivity;

    public CallNotification() {
    }

    public void addNotification(Intent intent) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplication, "notify_001");
        PendingIntent pendingIntent = PendingIntent.getActivity(mainActivity, 0, intent, 0);

        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.bigText("topic covered:java and c++");
        bigText.setBigContentTitle("Midterm is on 3/5/2019");
        bigText.setSummaryText("New date for exam");

        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
        mBuilder.setContentTitle("Courseoutline Updated");
        mBuilder.setContentText("Dr.Moamin");
        mBuilder.setPriority(Notification.PRIORITY_MAX);
        mBuilder.setStyle(bigText);

        NotificationManager mNotificationManager = (NotificationManager) mainActivity.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("notify_001",
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            mNotificationManager.createNotificationChannel(channel);
        }
        mNotificationManager.notify(0, mBuilder.build());
    }
}
