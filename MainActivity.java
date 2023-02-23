package com.example.sistemlogin;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText user, pass;
	Button login, cancel;
	Cursor cursor;
	DataHelper dbCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        user = (EditText) findViewById(R.id.edtusername);
        pass = (EditText) findViewById(R.id.edtpass);
        login = (Button) findViewById(R.id.btnlogin);
        cancel = (Button) findViewById(R.id.btncancel);
        
        dbCenter = new DataHelper (this);
        
        login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String username = user.getText().toString();
				String password = pass.getText().toString();
				
				SQLiteDatabase db = dbCenter.getReadableDatabase();
				cursor = db.rawQuery("SELECT * FROM tbl_login WHERE username = '" +username + "' AND password = '" +password+ "'", null);
				
				if(cursor.getCount()>0){
					Toast.makeText(getApplicationContext(), "Login Anda Berhasil..", Toast.LENGTH_SHORT).show();
					Intent intent = new
							Intent(getApplicationContext(), UtamaActivity.class);
					startActivity(intent);
				}else{
					Toast.makeText(getApplicationContext(), "Silahkan Coba Lagi..", Toast.LENGTH_SHORT).show();
				}
			}
        	
        });
        cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				user.setText("");
				pass.setText("");
				user.requestFocus();
			}
        	
        });
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
