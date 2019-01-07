package com.ld.animationguidepager.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.ld.animationguidepager.R;

/**
 * 最后一个fragment
 * Created by Billta on 2018-09-29.
 */

public class StereoscopicLauncherFragment extends LauncherBaseFragment implements View.OnClickListener {
    private static final float ZOOM_MAX = 1.3f;
    private static final  float ZOOM_MIN = 1.0f;

    private ImageView imgView_immediate_experience;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rooView=inflater.inflate(R.layout.fragment_stereoscopic_launcher, null);
        imgView_immediate_experience=(ImageView) rooView.findViewById(R.id.imgView_immediate_experience);
        imgView_immediate_experience.setOnClickListener(this);
        return rooView;
    }

    public void playHeartbeatAnimation(){
        /**
         * 放大动画
         */
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new ScaleAnimation(ZOOM_MIN, ZOOM_MAX, ZOOM_MIN, ZOOM_MAX, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,0.5f));
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.8f));

        animationSet.setDuration(500);
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.setFillAfter(true);

        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                /**
                 * 缩小动画
                 */
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(new ScaleAnimation(ZOOM_MAX, ZOOM_MIN, ZOOM_MAX,ZOOM_MIN, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f));
                animationSet.addAnimation(new AlphaAnimation(0.8f, 1.0f));
                animationSet.setDuration(600);
                animationSet.setInterpolator(new DecelerateInterpolator());
                animationSet.setFillAfter(false);
                // 实现心跳的View
                imgView_immediate_experience.startAnimation(animationSet);
            }
        });
        // 实现心跳的View
        imgView_immediate_experience.startAnimation(animationSet);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(),"跳转到登录界面",Toast.LENGTH_SHORT).show();
        //		Intent intent = new Intent();
        //		intent.setClass(getActivity(),MainActivity.class);
        //		startActivity(intent);
        //		getActivity().finish();
    }

    @Override
    public void startAnimation() {
        playHeartbeatAnimation();
    }

    @Override
    public void stopAnimation() {

    }
}
