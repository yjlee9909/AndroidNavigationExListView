package com.example.androidnavigationexlistview.navermap;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidnavigationexlistview.R;
import com.example.androidnavigationexlistview.R;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.util.FusedLocationSource;

public class UiAndOverlay extends AppCompatActivity implements OnMapReadyCallback {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;   // 권한 요청 코
    private FusedLocationSource locationSource; //네이버 지도 SDK에 위치정보를 전달하는 객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_and_overlay);

        // 지도 객체 받아오기
        MapFragment mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.ui_map);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.ui_map, mapFragment).commit();
        }

        mapFragment.getMapAsync(this);
        locationSource = new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);

    }

    // 권한 요청 결과 코드 전달
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults)) {
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @UiThread
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        // UI 관련 설정 담당
        UiSettings uiSettings = naverMap.getUiSettings();

        // 위치 버튼 활성화
        uiSettings.setLocationButtonEnabled(true);

        // naver map에 locationSource 지정
        naverMap.setLocationSource(locationSource);

        // 위치 추적 모드 : FACE
        naverMap.setLocationTrackingMode(LocationTrackingMode.Face);

        // 위치 오버레이
        // LocationOverlay locationOverlay = naverMap.getLocationOverlay();
        // locationOverlay.setVisible(true);
    }

}
