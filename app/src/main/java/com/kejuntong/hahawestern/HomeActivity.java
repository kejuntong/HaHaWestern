package com.kejuntong.hahawestern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.kejuntong.hahawestern.ModelClasses.User;

public class HomeActivity extends AppCompatActivity {

    Firebase fireBaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // test write data
//        fireBaseRef = new Firebase("https://hahawestern.firebaseio.com/");
//        User user = new User("test_id", "test_name");
//        Firebase child = fireBaseRef.child("User").push();
//        child.setValue(user, new Firebase.CompletionListener() {
//            @Override
//            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
//                System.out.println("finished");
//            }
//        });


        SlidingMenu menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//        menu.setShadowWidthRes(R.dimen.shadow_width);
//        menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.view_sliding_menu);


    }
}
