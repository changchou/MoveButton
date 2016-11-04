package com.jikexueyuan.movebutton;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2, button3, button4;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        imageView = (ImageView) findViewById(R.id.imageView);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animationRight = AnimationUtils.loadAnimation(MainActivity.this, R.anim.toright);
                final Animation animationBottom = AnimationUtils.loadAnimation(MainActivity.this, R.anim.tobottom);
                animationRight.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        button1.startAnimation(animationBottom);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                v.startAnimation(animationRight);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAnimation animationRight_btn2 = new TranslateAnimation(0, 200, 0, 0);
                animationRight_btn2.setDuration(1000);
                animationRight_btn2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        TranslateAnimation animationBottom_btn2 = new TranslateAnimation(200, 200, 0, 200);
                        animationBottom_btn2.setDuration(1000);
                        button2.startAnimation(animationBottom_btn2);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                v.startAnimation(animationRight_btn2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet animatorSetXML = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.animate);
                animatorSetXML.setTarget(v);
                animatorSetXML.start();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet animatorSetCode = new AnimatorSet();
                animatorSetCode.setDuration(1000);
                animatorSetCode.playSequentially(ObjectAnimator.ofFloat(v, "translationX", 0, 200),
                        ObjectAnimator.ofFloat(v, "translationY", 0, 200),
                        ObjectAnimator.ofFloat(v, "translationY", 200, 0),
                        ObjectAnimator.ofFloat(v, "translationX", 200, 0));
                animatorSetCode.start();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                AnimatorSet animatorSet = new AnimatorSet();
//                animatorSet.setDuration(1000);
//                animatorSet.playSequentially(ObjectAnimator.ofFloat(v,"rotationY",180),
//                        ObjectAnimator.ofFloat(v,"rotationY",0));
//                animatorSet.start();

                AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.rotae);
                animatorSet.setTarget(v);
                animatorSet.start();

            }
        });
    }
}
