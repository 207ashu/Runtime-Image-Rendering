package com.example.imagehandling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout layout=findViewById(R.id.layout);

        final ImageView img=findViewById(R.id.imageView);
        final TextView lang=findViewById(R.id.keyboard_language);


        layout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                float imgWid=img.getWidth();
                float imgHei=img.getHeight();

                if (imgWid > 0 && imgHei > 0) {
                    float rY= (float)(448.0/534.0);
                    float newY=imgHei*(rY);
                    lang.setY(newY);

                }

                float spaceWid=(float)(119.0/313.0)*imgWid;
                float spaceHei=(float)(33.0/342.0)*imgHei;

                int initialWidth=lang.getWidth();
                int initialHeight=lang.getHeight();

                int wnss=(int)spaceWid;
                int hnss=(int)spaceHei;
//                lang.setVisibility(View.INVISIBLE);
                boolean isFit=true;
                if((initialWidth>wnss-4)||(initialHeight>hnss-4)){
                    isFit=false;
//                    lang.setVisibility(View.INVISIBLE);
                    float currSize=lang.getTextSize()/2;
                    while(!isFit && currSize>12){
                        ViewGroup.LayoutParams params1=lang.getLayoutParams();
                        lang.setTextSize(currSize-1);
                        currSize=currSize-1;
                        lang.setVisibility(View.INVISIBLE);
                        lang.setLayoutParams(params1);
                        ViewGroup.LayoutParams params2=lang.getLayoutParams();
                        int a= lang.getWidth();
                        int c=params1.width;
                        int b=params2.width;

                        if((params2.width>wnss-4)||(params2.height>hnss-4)){
                            isFit=false;
//                            lang.setVisibility(View.INVISIBLE);

                        }else{
                            isFit=true;
//                            lang.setVisibility(View.VISIBLE);


                        }
                    }

                }
                if(isFit)
                    lang.setVisibility(View.VISIBLE);
                else
                    lang.setVisibility(View.INVISIBLE);

            }

        });

    }

}
