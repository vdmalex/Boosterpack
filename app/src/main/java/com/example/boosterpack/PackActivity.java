package com.example.boosterpack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;




public class PackActivity extends AppCompatActivity {



    private class DownloadImageTask extends AsyncTask<Void, Void, Bitmap> {
        ImageView bmImage;
        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(Void... urls) {
            java.lang.String urldisplay="";

            Request request2 = new Request.Builder()
                    .url("https://api.scryfall.com/cards/random")
                    .method("GET", null)
                    .build();
            try {
                OkHttpClient client2 = new OkHttpClient();

                Response response = client2.newCall(request2).execute();
                JSONObject json = new JSONObject(response.body().string());
                urldisplay = json.getJSONObject("image_uris").getString("large");
            }
                catch (IOException | JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);

        }


    }



//    public class GetCardInfo extends AsyncTask<Void, Void, Card[]> {
//        @Override
//        protected Card[] doInBackground(Void... params) {
//            Card card[] = new Card[10];
//            int b = (int)(Math.random()*(1000-1+1)+1);
//
//            try{
//                for(int i =0;i<1;++i) {
//                    card[i] = CardAPI.getCard(b);
//
//                }
//            }
//            catch(Exception e){
//                Log.e("Error", e.getMessage());
//                e.printStackTrace();
//
//            }
//            return card;
//        }
//
//        @Override
//        protected void onPostExecute(Card result[]){
//
//            TextView textValue = findViewById(R.id.text_pack);
//            textValue.setText(result[0].getName());
//
//
//        }
//
//
//
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pack);

        //TextView name = findViewById(R.id.text_pack);
        final Button buttonBack = (Button) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(PackActivity.this, MainActivity.class);

                // currentContext.startActivity(activityChangeIntent);

                PackActivity.this.startActivity(activityChangeIntent);
            }
        });

        final Button buttonCard = (Button) findViewById(R.id.button_get_card);
        buttonCard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ProgressBar pgsBar = (ProgressBar) findViewById(R.id.progressBar1);
                new DownloadImageTask((ImageView) findViewById(R.id.image_card)).execute();
                new DownloadImageTask((ImageView) findViewById(R.id.image_card2)).execute();
                new DownloadImageTask((ImageView) findViewById(R.id.image_card3)).execute();
                new DownloadImageTask((ImageView) findViewById(R.id.image_card4)).execute();
                new DownloadImageTask((ImageView) findViewById(R.id.image_card5)).execute();
                new DownloadImageTask((ImageView) findViewById(R.id.image_card6)).execute();
                pgsBar.setVisibility(View.INVISIBLE);


            }
        });
    }
}