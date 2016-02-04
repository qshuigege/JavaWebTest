package com.ayo.helloworld;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		
		final EditText et = (EditText) findViewById(R.id.activity_first_et_myinfo);
		Button btnSave = (Button)findViewById(R.id.activity_first_btn_save);
		Button btnCancel = (Button)findViewById(R.id.activity_first_btn_cancel);
		
		btnCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FirstActivity.this.finish();
			}
		});
		
		HelloDBHelper dbHelper = new HelloDBHelper(this, "hellodb", null, 1);
		final SQLiteDatabase db = dbHelper.getReadableDatabase();
		
		String sql = "select * from myinfo where name = ?";
		Cursor cursor = db.rawQuery(sql, new String[]{"myinfo"});
//		String name = null;
		String content = null;
		while (cursor.moveToNext()) {
//			name = cursor.getString(0);
			content = cursor.getString(1);
		}
		et.setText(content);
		
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name = "myinfo";
				String content = et.getText().toString();
				db.execSQL("insert into myinfo(name, content) values(?,?)", new Object[]{name, content});
			}
		});
	}
}
