package com.example.androidnavigationexlistview.navermap;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidnavigationexlistview.R;
import com.example.androidnavigationexlistview.R;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.geometry.LatLngBounds;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;

public class ZoomMap extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_map);

        // 지도 객체 받아오기
        MapFragment mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.zoompos_map);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.zoompos_map, mapFragment).commit();
        }

        mapFragment.getMapAsync(this);
    }

    @UiThread
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        // 위치(위도,경도) 객체
        LatLng location = new LatLng(37.487936, 126.825071);

        // 카메라 위치와 줌 조절(숫자가 클수록 확대)
        CameraPosition cameraPosition = new CameraPosition(location, 17);
        naverMap.setCameraPosition(cameraPosition);

        // 줌 범위 제한
        naverMap.setMinZoom(5.0);   //최소
        naverMap.setMaxZoom(18.0);  //최대

        // 카메라 영역 제한
        LatLng northWest = new LatLng(31.43, 122.37);
        LatLng southEast = new LatLng(44.35, 132);
        naverMap.setExtent(new LatLngBounds(northWest, southEast));
    }
}
