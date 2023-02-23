package com.example.sistemlogin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper ;

public class DataHelper extends SQLiteOpenHelper{
	
	private static final String DatabaseName = "dblogin";
	private static final int DatabaseVersion=1;
	public DataHelper(Context context) {
		super(context, DatabaseName, null, DatabaseVersion);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		String sql = "CREATE TABEL tbl_login(Username text primary key," +"Password text null)";
		arg0.execSQL(sql);
		
		sql = "INSERT INTO tbl_login VALUES('Salsabilaps', '12348')";
		arg0.execSQL(sql);
		
		sql = "INSERT INTO tbl_login VALUES('Salsabila', '12347')";
		arg0.execSQL(sql);
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
 
}
