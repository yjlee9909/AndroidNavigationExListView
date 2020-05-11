package com.example.androidnavigationexlistview.Helper;

import androidx.fragment.app.FragmentManager;

import com.example.androidnavigationexlistview.Interface.NavigationManager;
import com.example.androidnavigationexlistview.MainActivity_list;

public class FragmentNavigationManager implements NavigationManager {
    private static FragmentNavigationManager mInstance;

    private FragmentManager mFragmentManager;
    private MainActivity_list mainActivity;


    public static FragmentNavigationManager getmInstance(MainActivity_list mainActivity)
    {
        if(mInstance == null)
            mInstance = new FragmentNavigationManager();

        mInstance.configure(mainActivity);
        return mInstance;
    }

    private void configure(MainActivity_list mainActivity) {
        mainActivity = mainActivity;
        mFragmentManager = mainActivity.getSupportFragmentManager();
    }

    @Override
    public void showFragment(String title) {


    }
}
