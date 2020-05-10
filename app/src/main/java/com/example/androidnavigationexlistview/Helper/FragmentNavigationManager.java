package com.example.androidnavigationexlistview.Helper;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.androidnavigationexlistview.Fragments.FragmentContent;
import com.example.androidnavigationexlistview.Interface.NavigationManager;
import com.example.androidnavigationexlistview.MainActivity;

public class FragmentNavigationManager implements NavigationManager {
    private static FragmentNavigationManager mInstance;

    private FragmentManager mFragmentManager;
    private MainActivity mainActivity;


    public static FragmentNavigationManager getmInstance(MainActivity mainActivity)
    {
        if(mInstance == null)
            mInstance = new FragmentNavigationManager();

        mInstance.configure(mainActivity);
        return mInstance;
    }

    private void configure(MainActivity mainActivity) {
        mainActivity = mainActivity;
        mFragmentManager = mainActivity.getSupportFragmentManager();
    }

    @Override
    public void showFragment(String title) {


    }
}
