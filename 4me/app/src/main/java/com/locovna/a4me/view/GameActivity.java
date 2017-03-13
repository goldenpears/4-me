package com.locovna.a4me.view;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import com.locovna.a4me.R;
import com.locovna.a4me.game.Game;

public class GameActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);
    FragmentManager fragmentManager = getFragmentManager();
    Fragment fragment = new Game();
    fragmentManager.beginTransaction()
        .replace(R.id.container, fragment)
        .commit();
  }
}
