package com.technoface.app.campaigns.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.piasy.biv.indicator.progresspie.ProgressPieIndicator;
import com.github.piasy.biv.view.BigImageView;
import com.technoface.app.campaigns.AppController;
import com.technoface.app.campaigns.R;

/**
 * Created by Ahmet on 13.10.2017.
 */

public class AnaMenuPagerAdapter  extends PagerAdapter {
    private Context ctx;
    private int numberOfRes = 2;
    private String[] res = {AppController.getInstance().bimlink1,
            AppController.getInstance().bimlink2
            ,AppController.getInstance().bimlink3};

    public AnaMenuPagerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return numberOfRes;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(R.layout.item_ana_menu_pager, null);

        BigImageView bigImageView = (BigImageView) v.findViewById(R.id.ivpager);
        bigImageView.setProgressIndicator(new ProgressPieIndicator());
        bigImageView.showImage(
                Uri.parse(AppController.getInstance().bimlink1)
        );
        container.addView(v, 0);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
