package de.Wolfy7.AsseZiehn;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.widget.Toast;

public class Preferences extends PreferenceActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      addPreferencesFromResource(R.xml.preference);

      Preference customPref = (Preference)findPreference("pref_custom");

      customPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
        public boolean onPreferenceClick(Preference preference) {
          ListPreference lpCardDeck = (ListPreference)findPreference("card_deck");
          CheckBoxPreference cbpLeo = (CheckBoxPreference)findPreference("pref_leo");

          lpCardDeck.setValue("32");
          cbpLeo.setChecked(false);
          setEditTextPreference("pref_ace", getString(R.string.ace));
          setEditTextPreference("pref_king", getString(R.string.king));
          setEditTextPreference("pref_queen", getString(R.string.queen));
          setEditTextPreference("pref_jack", getString(R.string.jack));
          setEditTextPreference("pref_ten", getString(R.string.ten));
          setEditTextPreference("pref_nine", getString(R.string.nine));
          setEditTextPreference("pref_eight", getString(R.string.eight));
          setEditTextPreference("pref_seven", getString(R.string.seven));
          setEditTextPreference("pref_six", getString(R.string.empty_string));
          setEditTextPreference("pref_five", getString(R.string.empty_string));
          setEditTextPreference("pref_four", getString(R.string.empty_string));
          setEditTextPreference("pref_three", getString(R.string.empty_string));
          setEditTextPreference("pref_two", getString(R.string.empty_string));

          Toast.makeText(getBaseContext(), "Default Einstellungen wurden geladen.", Toast.LENGTH_SHORT).show();
          return true;
        }
      });
    }

    private void setEditTextPreference(String preference, String Text) {
      EditTextPreference etpPreference = (EditTextPreference)findPreference(preference);
      etpPreference.setText(Text);
  }
}
