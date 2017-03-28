package com.waylanpunch.interviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.waylanpunch.interviewdemo.widget.cycleviewpager.CycleViewPagerFragment;

import java.util.ArrayList;

public class ViewPager2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);


        ArrayList<Integer> imageIds = new ArrayList<Integer>();
        imageIds.add(R.drawable.a);
        imageIds.add(R.drawable.b);
        imageIds.add(R.drawable.c);
        imageIds.add(R.drawable.d);
        imageIds.add(R.drawable.e);
//    //存放图片的id
//    private int[] imageIds = new int[]{
//            R.drawable.a,
//            R.drawable.b,
//            R.drawable.c,
//            R.drawable.d,
//            R.drawable.e
//    };
//    //存放图片的标题
//    private String[] titles = new String[]{
//            "巩俐不低俗，我就不能低俗",
//            "扑树又回来啦！再唱经典老歌引万人大合唱",
//            "揭秘北京电影如何升级",
//            "乐视网TV版大派送",
//            "热血屌丝的反杀"
//    };
        ArrayList<String> titles = new ArrayList<String>();
        titles.add("巩俐不低俗，我就不能低俗");
        titles.add("扑树又回来啦！再唱经典老歌引万人大合唱");
        titles.add("揭秘北京电影如");
        titles.add("乐视网TV版大派送");
        titles.add("热血屌丝的反杀");

        CycleViewPagerFragment cycleViewPagerFragment = CycleViewPagerFragment.newInstance(imageIds, titles);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_content, cycleViewPagerFragment).commit();
    }
}
