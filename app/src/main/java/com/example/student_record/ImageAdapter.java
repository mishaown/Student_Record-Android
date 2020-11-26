package com.example.student_record;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ImageAdapter extends PagerAdapter {
    private Context Ncontext;
    private int[] ImageID = new int[] {R.drawable.batch19, R.drawable.batch18, R.drawable.batch17};

    ImageAdapter(Context context)
    {
        Ncontext = context;
    }
    @Override
    public int getCount() {
        return ImageID.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView i =  new ImageView(Ncontext);
        i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        i.setImageResource(ImageID[position]);
        container.addView(i,0);

        return i;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView)object);
    }
}
