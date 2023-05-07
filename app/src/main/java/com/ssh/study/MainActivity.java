package com.ssh.study;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView tvText;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

findViewById(R.id.btn1).setOnClickListener(mClick);
findViewById(R.id.btn2).setOnClickListener(mClick);

    }

    View.OnClickListener mClick = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn1 :
                    dlgShow1();

                    break;


                case R.id.btn2 :
                    dlgShow2();
                    break;
            }
        }
    };

    void dlgShow1()
    {
        Dialog dlgFinish = new Dialog(MainActivity.this);
        dlgFinish.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlgFinish.setContentView(R.layout.dlg_layout);

        TextView tvText = dlgFinish.findViewById(R.id.tvText);
        tvText.setText("           화면1로 이동하시겠습니까?           ");

        dlgFinish.show();

        Button noBtn = dlgFinish.findViewById(R.id.noBtn);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlgFinish.dismiss();
            }
        });
        dlgFinish.findViewById(R.id.yesBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Adapter.class);
                startActivity(intent);
                finish();
            }
        });
    }

    void dlgShow2()
    {
        Dialog dlgFinish = new Dialog(MainActivity.this);
        dlgFinish.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlgFinish.setContentView(R.layout.dlg_layout);

        TextView tvText = dlgFinish.findViewById(R.id.tvText);
        tvText.setText("           화면2로 이동하시겠습니까?           ");
        tvText.setText("           화면1로 이동하시겠습니까?           ");

        dlgFinish.show();

        Button noBtn = dlgFinish.findViewById(R.id.noBtn);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlgFinish.dismiss();
            }
        });
        dlgFinish.findViewById(R.id.yesBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity
                        .this, FragmentLayout.class);
                startActivity(intent);
                finish();
            }
        });
    }
}