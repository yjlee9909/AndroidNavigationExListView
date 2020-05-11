package com.example.androidnavigationexlistview.navermap;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.androidnavigationexlistview.R;
import com.example.androidnavigationexlistview.R;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int loactionpermissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);//위치권한
        if(loactionpermissionCheck == PackageManager.PERMISSION_DENIED){  // 권한거부 되있다면
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1); //권한허용창
        }

        Button btBasic = (Button) findViewById(R.id.btBasic);
        Button btZoomPos = (Button) findViewById(R.id.btZoomPos);
        Button btMarker = (Button) findViewById(R.id.btMarker);
        Button btUiOverlay =(Button)findViewById(R.id.btUiOverlay);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                switch (v.getId()) {
                    case R.id.btBasic:
                        intent = new Intent(MainActivity3.this,BasicMap.class);
                        break;
                    case R.id.btZoomPos:
                        intent = new Intent(MainActivity3.this,ZoomMap.class);
                        break;
                    case R.id.btMarker:
                        intent = new Intent(MainActivity3.this,MarkerMap.class);
                        break;
                    case R.id.btUiOverlay:
                        intent = new Intent(MainActivity3.this, UiAndOverlay.class);
                        break;
                }
                startActivity(intent);
            }
        };

        btBasic.setOnClickListener(listener);
        btZoomPos.setOnClickListener(listener);
        btMarker.setOnClickListener(listener);
        btUiOverlay.setOnClickListener(listener);
    }
}
