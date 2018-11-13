package de.Wolfy7.AsseZiehn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {
  private static final int MENU_NEW_GAME = 0;
  private static final int MENU_SETTINGS = 1;

    ImageView imageview;
    TextView tvCard, tvAssignment, tvLeo, tvDeckSize;
    ArrayList<eCard> aleCards;
    Random randomCard = new Random();
    String CardDeck, sAce, sKing, sQueen, sJack, sTen, sNine, sEight, sSeven, sSix, sFive, sFour, sThree, sTwo;
    int card, decksize;
    boolean boLeo;
    SharedPreferences SP;
    Intent intent;

    public enum eCardType {
      ACE,
      KING,
      QUEEN,
      JACK,
      TEN,
      NINE,
      EIGHT,
      SEVEN,
      SIX,
      FIVE,
      FOUR,
      THREE,
      TWO
    }

  public enum eCard {
    /* clubs */
    ace_of_clubs(R.drawable.clubsace, R.string.ace_of_clubs, eCardType.ACE),
    king_of_clubs(R.drawable.clubsking, R.string.king_of_clubs, eCardType.KING),
    queen_of_clubs(R.drawable.clubsqueen, R.string.queen_of_clubs, eCardType.QUEEN),
    jack_of_clubs(R.drawable.clubsjack, R.string.jack_of_clubs, eCardType.JACK),
    ten_of_clubs(R.drawable.clubs10, R.string.ten_of_clubs, eCardType.TEN),
    nine_of_clubs(R.drawable.clubs9, R.string.nine_of_clubs, eCardType.NINE),
    eight_of_clubs(R.drawable.clubs8, R.string.eight_of_clubs, eCardType.EIGHT),
    seven_of_clubs(R.drawable.clubs7, R.string.seven_of_clubs, eCardType.SEVEN),
    six_of_clubs(R.drawable.clubs6, R.string.six_of_clubs, eCardType.SIX),
    five_of_clubs(R.drawable.clubs5, R.string.five_of_clubs, eCardType.FIVE),
    four_of_clubs(R.drawable.clubs4, R.string.four_of_clubs, eCardType.FOUR),
    three_of_clubs(R.drawable.clubs3, R.string.three_of_clubs, eCardType.THREE),
    two_of_clubs(R.drawable.clubs2, R.string.two_of_clubs, eCardType.TWO),
    /* spades */
    ace_of_spades(R.drawable.spadesace, R.string.ace_of_spades, eCardType.ACE),
    king_of_spades(R.drawable.spadesking, R.string.king_of_spades, eCardType.KING),
    queen_of_spades(R.drawable.spadesqueen, R.string.queen_of_spades, eCardType.QUEEN),
    jack_of_spades(R.drawable.spadesjack, R.string.jack_of_spades, eCardType.JACK),
    ten_of_spades(R.drawable.spades10, R.string.ten_of_spades, eCardType.TEN),
    nine_of_spades(R.drawable.spades9, R.string.nine_of_spades, eCardType.NINE),
    eight_of_spades(R.drawable.spades8, R.string.eight_of_spades, eCardType.EIGHT),
    seven_of_spades(R.drawable.spades7, R.string.seven_of_spades, eCardType.SEVEN),
    six_of_spades(R.drawable.spades6, R.string.six_of_spades, eCardType.SIX),
    five_of_spades(R.drawable.spades5, R.string.five_of_spades, eCardType.FIVE),
    four_of_spades(R.drawable.spades4, R.string.four_of_spades, eCardType.FOUR),
    three_of_spades(R.drawable.spades3, R.string.three_of_spades, eCardType.THREE),
    two_of_spades(R.drawable.spades2, R.string.two_of_spades, eCardType.TWO),
    /* hearts */
    ace_of_hearts(R.drawable.heartsace, R.string.ace_of_hearts, eCardType.ACE),
    king_of_hearts(R.drawable.heartsking, R.string.king_of_hearts, eCardType.KING),
    queen_of_hearts(R.drawable.heartsqueen, R.string.queen_of_hearts, eCardType.QUEEN),
    jack_of_hearts(R.drawable.heartsjack, R.string.jack_of_hearts, eCardType.JACK),
    ten_of_hearts(R.drawable.hearts10, R.string.ten_of_hearts, eCardType.TEN),
    nine_of_hearts(R.drawable.hearts9, R.string.nine_of_hearts, eCardType.NINE),
    eight_of_hearts(R.drawable.hearts8, R.string.eight_of_hearts, eCardType.EIGHT),
    seven_of_hearts(R.drawable.hearts7, R.string.seven_of_hearts, eCardType.SEVEN),
    six_of_hearts(R.drawable.hearts6, R.string.six_of_hearts, eCardType.SIX),
    five_of_hearts(R.drawable.hearts5, R.string.five_of_hearts, eCardType.FIVE),
    four_of_hearts(R.drawable.hearts4, R.string.four_of_hearts, eCardType.FOUR),
    three_of_hearts(R.drawable.hearts3, R.string.three_of_hearts, eCardType.THREE),
    two_of_hearts(R.drawable.hearts2, R.string.two_of_hearts, eCardType.TWO),
    /* diamonds */
    ace_of_diamonds(R.drawable.diamondsace, R.string.ace_of_diamonds, eCardType.ACE),
    king_of_diamonds(R.drawable.diamondsking, R.string.king_of_diamonds, eCardType.KING),
    queen_of_diamonds(R.drawable.diamondsqueen, R.string.queen_of_diamonds, eCardType.QUEEN),
    jack_of_diamonds(R.drawable.diamondsjack, R.string.jack_of_diamonds, eCardType.JACK),
    ten_of_diamonds(R.drawable.diamonds10, R.string.ten_of_diamonds, eCardType.TEN),
    nine_of_diamonds(R.drawable.diamonds9, R.string.nine_of_diamonds, eCardType.NINE),
    eight_of_diamonds(R.drawable.diamonds8, R.string.eight_of_diamonds, eCardType.EIGHT),
    seven_of_diamonds(R.drawable.diamonds7, R.string.seven_of_diamonds, eCardType.SEVEN),
    six_of_diamonds(R.drawable.diamonds6, R.string.six_of_diamonds, eCardType.SIX),
    five_of_diamonds(R.drawable.diamonds5, R.string.five_of_diamonds, eCardType.FIVE),
    four_of_diamonds(R.drawable.diamonds4, R.string.four_of_diamonds, eCardType.FOUR),
    three_of_diamonds(R.drawable.diamonds3, R.string.three_of_diamonds, eCardType.THREE),
    two_of_diamonds(R.drawable.diamonds2, R.string.two_of_diamonds, eCardType.TWO);

    private final int cardImage;
    private final int cardName;
    private final eCardType cardAssignment;

    private eCard(int cardImage, int cardName, eCardType cardAssignment) {
      this.cardImage = cardImage;
      this.cardName = cardName;
      this.cardAssignment = cardAssignment;
    }

    public int getCardImage() { return this.cardImage; }
    public int getCardName() { return this.cardName; }
    public eCardType getCardAssignment() { return this.cardAssignment; }
  }

    @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_game);
      PreferenceManager.setDefaultValues(this, R.xml.preference, false);

      aleCards = new ArrayList<eCard>();
      SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
      CardDeck = SP.getString("card_deck", "32");
      boLeo = SP.getBoolean("pref_leo", false);
      initCardAssignment();

      if(CardDeck.equals("32")){
        init32CardDeck();
      }else if(CardDeck.equals("52")){
        init52CardDeck();
      }

      changeCard();
    }

    /* Creates the menu items */
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_NEW_GAME, 0, "Neues Spiel");
     //   menu.add(0, MENU_SETTINGS, 0, "Einstellungen");
        return true;
    }

    /* Handles item selections */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case MENU_NEW_GAME:
            Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Spiel neustarten?");
            alert.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                newGame();
              }
            });
            alert.setNegativeButton("Nein", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
              }
            });
            alert.show();
          return true;
        case MENU_SETTINGS:
          Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show();
          return true;
        }
        return false;
    }

    public void changeCard() {
      imageview = (ImageView) findViewById(R.id.imageView_card);
      tvCard = (TextView) findViewById(R.id.textView_card);
      tvAssignment = (TextView) findViewById(R.id.textView_assignment);
      tvLeo = (TextView) findViewById(R.id.textView_leo);
      tvDeckSize = (TextView) findViewById(R.id.textView_decksize);

      imageview.setOnClickListener(new OnClickListener() {
          public void onClick(View v) {
            tvDeckSize.setText(aleCards.size()+"/"+decksize);
            if(!aleCards.isEmpty()){
              card = randomCard.nextInt(aleCards.size());
              if (boLeo){
                if(aleCards.get(card).getCardAssignment() == eCardType.ACE){
                  tvLeo.setText(R.string.leo);
                }else{
                  tvLeo.setText(R.string.empty_string);
                }
              }
              imageview.setImageResource(aleCards.get(card).getCardImage());
              tvCard.setText(aleCards.get(card).getCardName());

              switch (aleCards.get(card).getCardAssignment()) {
              case ACE:
                tvAssignment.setText(sAce);
                break;
              case KING:
                tvAssignment.setText(sKing);
                break;
              case QUEEN:
                tvAssignment.setText(sQueen);
                break;
              case JACK:
                tvAssignment.setText(sJack);
                break;
              case TEN:
                tvAssignment.setText(sTen);
                break;
              case NINE:
                tvAssignment.setText(sNine);
                break;
              case EIGHT:
                tvAssignment.setText(sEight);
                break;
              case SEVEN:
                tvAssignment.setText(sSeven);
                break;
              case SIX:
                tvAssignment.setText(sSix);
                break;
              case FIVE:
                tvAssignment.setText(sFive);
                break;
              case FOUR:
                tvAssignment.setText(sFour);
                break;
              case THREE:
                tvAssignment.setText(sThree);
                break;
              case TWO:
                tvAssignment.setText(sTwo);
                break;
              default:
                tvAssignment.setText(R.string.empty_string);
                break;
              }
              aleCards.remove(card);
            }else{
              newGame();
            }
          }
      });
  }

    private void newGame() {
      Toast.makeText(getBaseContext(), "Neues Spiel!", Toast.LENGTH_SHORT).show();
      onCreate(null);
    }

    private void init32CardDeck(){
      decksize = 32;
      eCard [] aeCards = {eCard.ace_of_clubs, eCard.king_of_clubs, eCard.queen_of_clubs, eCard.jack_of_clubs, eCard.ten_of_clubs,
          eCard.nine_of_clubs, eCard.eight_of_clubs, eCard.seven_of_clubs, eCard.ace_of_spades, eCard.king_of_spades,
          eCard.queen_of_spades, eCard.jack_of_spades, eCard.ten_of_spades, eCard.nine_of_spades, eCard.eight_of_spades,
          eCard.seven_of_spades, eCard.ace_of_hearts, eCard.king_of_hearts, eCard.queen_of_hearts, eCard.jack_of_hearts,
          eCard.ten_of_hearts, eCard.nine_of_hearts, eCard.eight_of_hearts, eCard.seven_of_hearts, eCard.ace_of_diamonds, eCard.king_of_diamonds,
          eCard.queen_of_diamonds, eCard.jack_of_diamonds, eCard.ten_of_diamonds, eCard.nine_of_diamonds, eCard.eight_of_diamonds,
          eCard.seven_of_diamonds
                  };
      for (int i = 0; i < aeCards.length; i++) {
        aleCards.add(aeCards[i]);
      }
      Collections.shuffle(aleCards);
    }

    private void init52CardDeck(){
      decksize = 52;
      eCard [] aeCards = {eCard.ace_of_clubs, eCard.king_of_clubs, eCard.queen_of_clubs, eCard.jack_of_clubs, eCard.ten_of_clubs,
            eCard.nine_of_clubs, eCard.eight_of_clubs, eCard.seven_of_clubs, eCard.six_of_clubs, eCard.five_of_clubs,
            eCard.four_of_clubs, eCard.three_of_clubs, eCard.two_of_clubs, eCard.ace_of_spades, eCard.king_of_spades,
            eCard.queen_of_spades, eCard.jack_of_spades, eCard.ten_of_spades, eCard.nine_of_spades, eCard.eight_of_spades,
            eCard.seven_of_spades, eCard.six_of_spades, eCard.five_of_spades, eCard.four_of_spades, eCard.three_of_spades,
            eCard.two_of_spades, eCard.ace_of_hearts, eCard.king_of_hearts, eCard.queen_of_hearts, eCard.jack_of_hearts,
            eCard.ten_of_hearts, eCard.nine_of_hearts, eCard.eight_of_hearts, eCard.seven_of_hearts, eCard.six_of_hearts,
            eCard.five_of_hearts, eCard.four_of_hearts, eCard.three_of_hearts, eCard.two_of_hearts, eCard.ace_of_diamonds,
            eCard.king_of_diamonds, eCard.queen_of_diamonds, eCard.jack_of_diamonds, eCard.ten_of_diamonds,
            eCard.nine_of_diamonds, eCard.eight_of_diamonds, eCard.seven_of_diamonds, eCard.six_of_diamonds,
            eCard.five_of_diamonds, eCard.four_of_diamonds, eCard.three_of_diamonds, eCard.two_of_diamonds
                    };
        for (int i = 0; i < aeCards.length; i++) {
          aleCards.add(aeCards[i]);
        }
        Collections.shuffle(aleCards);
      }

    private void initCardAssignment(){
        CardDeck = SP.getString("card_deck", null);
        sAce = SP.getString("pref_ace", null);
        sKing = SP.getString("pref_king", null);
        sQueen = SP.getString("pref_queen", null);
        sJack = SP.getString("pref_jack", null);
        sTen = SP.getString("pref_ten", null);
        sNine = SP.getString("pref_nine", null);
        sEight = SP.getString("pref_eight", null);
        sSeven = SP.getString("pref_seven", null);
        if(CardDeck.equals("52")){
          sSix = SP.getString("pref_six", null);
          sFive = SP.getString("pref_five", null);
          sFour = SP.getString("pref_four", null);
          sThree = SP.getString("pref_three", null);
          sTwo = SP.getString("pref_two", null);
        }

    }

}
