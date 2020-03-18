package org.zzy.make.talk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "org.zzy.make.talk.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, MainActivity.EXTRA_MESSAGE)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("测试")
                .setContentText("这是一条测试通知")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1,builder.build());
        Intent intent = new Intent(this,DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText);
        String msg = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,msg);
        startActivity(intent);
    }

}
