package com.example.mypc.intenalstorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    EditText editname,editpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editname = (EditText) findViewById(R.id.editName);
        editpass= (EditText) findViewById(R.id.editPass);

    }
    public  void save(View view)
    {
        File file =null;
        String name=editname.getText().toString();
        String password= editpass.getText().toString();
        FileOutputStream fileOutputStream= null;
        try{
            name=name+" ";
            file=getFilesDir();
            fileOutputStream= openFileOutput("Code.txt",MODE_PRIVATE);
            fileOutputStream.write(name.getBytes());
            fileOutputStream.write(password.getBytes());
            Toast.makeText(this,"Save \n"+"Path --"+file+"\tCode.txt",Toast.LENGTH_LONG).show();
            editname.setText("");
            editpass.setText("");
            return;
        }catch (Exception ex)
        {
            ex.getStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            }
            catch (Exception ex)
            {
                ex.getStackTrace();
            }
        }

    }
    public void next(View view)
    {
        Toast.makeText(this, "Next",Toast.LENGTH_LONG).show();
        Intent intent= new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }
}
