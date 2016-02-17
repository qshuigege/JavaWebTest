package com.ayo.helloworld;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class HelloDBHelper extends SQLiteOpenHelper{

	public HelloDBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table if not exists mypassword(id integer primary key autoincrement, name varchar(20), mycontent varchar(32))");
		db.execSQL("insert into mypassword(name, mycontent) values('name', '123456')");
		db.execSQL("create table if not exists myinfo(id integer primary key autoincrement, name varchar(20), mycontent varchar(4000))");
		db.execSQL("insert into myinfo(name, mycontent) values('name', 'defaultinfo')");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
