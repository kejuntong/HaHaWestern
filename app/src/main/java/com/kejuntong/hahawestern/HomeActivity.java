package com.kejuntong.hahawestern;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.kejuntong.hahawestern.ModelClasses.User;
import com.kejuntong.hahawestern.UtilClasses.UtilMethods;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {

    ImageButton menuButton;
    SlidingMenu slidingMenu;

    CircleImageView profileImage;
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

        setSlidingMenu();

        profileImage = (CircleImageView) findViewById(R.id.profile_image);
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, CropImageActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        profileImage.setImageBitmap(UtilMethods.getBitmapFromMemory("test"));
    }

    private void setSlidingMenu(){
        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        slidingMenu.setShadowDrawable(R.drawable.menu_shadow);
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        slidingMenu.setFadeDegree(0.35f);
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setMenu(R.layout.view_sliding_menu);

        menuButton = (ImageButton) findViewById(R.id.menu_button);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingMenu.toggle();
            }
        });
    }

}
