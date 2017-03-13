package com.locovna.a4me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {
  public static final String TAG = MainActivity.class.getSimpleName();

  @BindView (R.id.hotseat_button) Button hotseatButton;
  @BindView (R.id.vs_ai_button) Button vsAiButton;
  @BindView (R.id.about_button) Button aboutButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    hotseatButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, HotseatActivity.class);
        startActivity(intent);
      }
    });

    vsAiButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, AiActivity.class);
        startActivity(intent);
      }
    });

    aboutButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
      }
    });
  }
}
