package com.wafflestudio.shafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class CafeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_detail);

        //set toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(myToolbar);
        //enable up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //TODO : 아래 코드는 테스트 용도. 나중에 수정할 것
        Intent intent = this.getIntent();
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            String title = intent.getStringExtra(Intent.EXTRA_TEXT);
            ((TextView) this.findViewById(R.id.cafe_name))
                    .setText(title);
            ((ImageView) this.findViewById(R.id.cafe_image))
                    .setImageDrawable(getResources().getDrawable(R.drawable.sample_5));
        }
    }
}
