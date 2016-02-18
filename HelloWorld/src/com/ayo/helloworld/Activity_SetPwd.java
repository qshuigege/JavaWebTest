package com.ayo.helloworld;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_SetPwd extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set_pwd);

		final EditText etOldpwd = (EditText) findViewById(R.id.activity_set_pwd_et_oldpwd);
		final EditText etNewpwd = (EditText) findViewById(R.id.activity_set_pwd_et_newpwd);
		final EditText etNewpwd2 = (EditText) findViewById(R.id.activity_set_pwd_et_newpwd2);
		Button btnSave = (Button)findViewById(R.id.activity_set_pwd_btn_save);
		Button btnCancel = (Button)findViewById(R.id.activity_set_pwd_btn_cancel);
		
		btnCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Activity_SetPwd.this.finish();
			}
		});
		
		
		
		//修改密码按钮点击事件
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				HelloDBHelper dbHelper = new HelloDBHelper(Activity_SetPwd.this, "hellodb", null, 1);
				final SQLiteDatabase db = dbHelper.getReadableDatabase();
				
				String sql = "select * from mypassword where name = ?";
				Cursor cursor = db.rawQuery(sql, new String[]{"name"});
//				String name = null;
				String content = null;
				while (cursor.moveToNext()) {
//					name = cursor.getString(0);
					content = cursor.getString(2);
				}
				String oldpwd = etOldpwd.getText().toString();
				if (oldpwd!=null&&!"".equals(oldpwd)) {
					if(content!=null&&!"".equals(content)){
						if(!oldpwd.equals(content)){//旧密码输入错误
							Toast.makeText(Activity_SetPwd.this, "密码错误", Toast.LENGTH_LONG).show();
						}else{//旧密码输对了
							String newpwd = etNewpwd.getText().toString();
							String newpwd2 = etNewpwd2.getText().toString();
							if(newpwd!=null&&!"".equals(newpwd)){
								if (newpwd2!=null&&!"".equals(newpwd2)) {
									if (newpwd.equals(newpwd2)) {
										db.execSQL("update mypassword set mycontent=? where name=?", new String[]{newpwd, "name"});
										Toast.makeText(Activity_SetPwd.this, "密码修改成功！", Toast.LENGTH_SHORT).show();
									}else {
										Toast.makeText(Activity_SetPwd.this, "两次输入的密码不一致！", Toast.LENGTH_LONG).show();
									}
								}else{
									Toast.makeText(Activity_SetPwd.this, "两次输入的密码不一致！", Toast.LENGTH_LONG).show();
								}
							}else{
								Toast.makeText(Activity_SetPwd.this, "两次输入的密码不一致！", Toast.LENGTH_LONG).show();
							}
						}
					}else{
						Toast.makeText(Activity_SetPwd.this, "系统错误！", Toast.LENGTH_LONG).show();
					}
				}else{
					Toast.makeText(Activity_SetPwd.this, "请输入旧密码！", Toast.LENGTH_LONG).show();
				}
				
				//String name = "name";
				//String content = et.getText().toString();
				//db.execSQL("update myinfo set mycontent=? where name=?", new Object[]{content, name});
				
			}
		});
	}
}
