package com.wafflestudio.shafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CafeDetailActivity extends AppCompatActivity {

    @Bind(R.id.toolbar_main) Toolbar myToolbar;
    @Bind(R.id.cafe_name) TextView nameView;
    @Bind(R.id.cafe_image) ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_detail);

        //set toolbar
        ButterKnife.bind(this);
        setSupportActionBar(myToolbar);
        //enable up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //TODO : 아래 코드는 테스트 용도. 나중에 수정할 것
        Intent intent = this.getIntent();
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            String title = intent.getStringExtra(Intent.EXTRA_TEXT);
            nameView.setText(title);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.sample_5));
        }
    }
}
