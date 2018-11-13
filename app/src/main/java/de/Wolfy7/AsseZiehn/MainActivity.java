package de.Wolfy7.AsseZiehn;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

private static final int MENU_SETTINGS = 0;
private static final int MENU_INFO = 1;

@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void startGame(View v){
      Intent intent = new Intent(this, GameActivity.class);
      startActivity(intent);
    }

    public void setOptions(View v) {
        Intent intent = new Intent(this, Preferences.class);
        startActivity(intent);

    }

    public void showInfo(){
      final Dialog dialog = new Dialog(this);
      dialog.setContentView(R.layout.info_dialog);
      dialog.setTitle("AsseZiehn - Info");
      dialog.setCancelable(true);

      String sVersion;
      try {
        PackageInfo  pinfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        sVersion = pinfo.versionName;
      } catch (NameNotFoundException e) {
        sVersion = "----";
      }

      TextView tvVersion = (TextView) dialog.findViewById(R.id.textView_version);
      tvVersion.setText(sVersion);

      TextView tvURL = (TextView) dialog.findViewById(R.id.textView_url);
      Linkify.addLinks(tvURL, Linkify.ALL);

      Button button = (Button) dialog.findViewById(R.id.button1);
      button.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
          dialog.dismiss();

        }
      });
      dialog.show();
  }


    /* Creates the menu items */
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_SETTINGS, 0, "Einstellungen");
        menu.add(0, MENU_INFO , 0, "Info");
        return true;
    }

    /* Handles item selections */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case MENU_SETTINGS:
          setOptions(this.getCurrentFocus());
          return true;
        case MENU_INFO:
          showInfo();
          return true;
        }
        return false;
    }

}
