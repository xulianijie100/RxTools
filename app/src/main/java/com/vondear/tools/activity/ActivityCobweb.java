package com.vondear.tools.activity;

import android.os.Bundle;
import android.widget.SeekBar;

import com.vondear.rxtools.RxBarTool;
import com.vondear.rxtools.activity.ActivityBase;
import com.vondear.rxtools.model.ModelSpider;
import com.vondear.rxtools.view.RxCobwebView;
import com.vondear.rxtools.view.RxTitle;
import com.vondear.tools.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityCobweb extends ActivityBase implements SeekBar.OnSeekBarChangeListener {

    @BindView(R.id.rx_title)
    RxTitle mRxTitle;
    @BindView(R.id.cobweb_view)
    RxCobwebView mCobwebView;
    @BindView(R.id.seekbar_level)
    SeekBar mSeekbarLevel;
    @BindView(R.id.seekbar_spider_number)
    SeekBar mSeekbarSpiderNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBarTool.setTransparentStatusBar(mContext);
        setContentView(R.layout.activity_cobweb);
        ButterKnife.bind(this);
        mRxTitle.setLeftFinish(mContext);
        mSeekbarLevel.setOnSeekBarChangeListener(this);
        mSeekbarSpiderNumber.setOnSeekBarChangeListener(this);
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.seekbar_level:
                mCobwebView.setSpiderMaxLevel(progress + 1);
                break;
            case R.id.seekbar_spider_number:
                int number = progress + 1;
                List<ModelSpider> modelSpiders = new ArrayList<>();
                for (int i = 0; i < number; i++) {
                    modelSpiders.add(new ModelSpider("" + (i + 1), 1 + new Random().nextInt(mCobwebView.getSpiderMaxLevel())));
                }
                mCobwebView.setSpiderList(modelSpiders);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
