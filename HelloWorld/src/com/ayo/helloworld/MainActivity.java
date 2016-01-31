package com.ayo.helloworld;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.button1);
        Button btnHid = (Button)findViewById(R.id.btn_hidden);
        
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Button btn = (Button)v;
				Date d = new Date(System.currentTimeMillis());
				btn.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("cn")).format(d));
				
			}
		});
        
        btnHid.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				//Toast.makeText(MainActivity.this, "hidden-long", Toast.LENGTH_SHORT).show();
				final EditText et = new EditText(MainActivity.this);
				
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("请输入密码");
				builder.setIcon(android.R.drawable.ic_dialog_info);
				builder.setView(et);
				builder.setNegativeButton("取消", null);
				builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//Toast.makeText(MainActivity.this, et.getText()+"-->"+which, Toast.LENGTH_SHORT).show();
						//显示意图启动新activity
						Intent intent = new Intent(MainActivity.this, FirstActivity.class);
						startActivity(intent);
						
						//隐式意图启动activity
						//Intent intentt = new Intent();
						//intentt.setAction("com.ayo.helloworld.FirstActivity");
						//startActivity(intentt);
					}
				});
				builder.show();
				
				return true;//按钮同时设置了长按事件和点击事件，return true，则不会触发点击事件;return false,则两个事件都会触发。
			}
		});
        btnHid.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "Hello, World!", Toast.LENGTH_SHORT).show();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
