package com.bawei.moniceshi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager vp;
    String[] name = {"推荐","段子","视频"};
    List<String> list_tab = new ArrayList<>();
    List<Fragment> list_frag = new ArrayList<>();
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.butt);
        tabVeiw();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        });


    }

    private void tabVeiw() {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        vp = (ViewPager) findViewById(R.id.view_pager);
        for (String bean : name) {
            list_tab.add(bean);
            tabLayout.addTab(tabLayout.newTab().setText(bean));
        }
        FirstFragment firstFragment = new FirstFragment();
        DuanFragment duanFragment = new DuanFragment();
        ShiFragment shiFragment = new ShiFragment();


        list_frag.add(firstFragment);
        list_frag.add(duanFragment);
        list_frag.add(shiFragment);

        FragAdapter adapter=new FragAdapter(getSupportFragmentManager(), list_frag,list_tab);
        vp.setAdapter(adapter);
        tabLayout.setupWithViewPager(vp);

        tabLayout.getTabAt(0).setText(list_tab.get(0)).setIcon(R.mipmap.ic_launcher_round);
        tabLayout.getTabAt(1).setText(list_tab.get(1)).setIcon(R.mipmap.ic_launcher_round);
        tabLayout.getTabAt(2).setText(list_tab.get(2)).setIcon(R.mipmap.ic_launcher_round);


    }



}
