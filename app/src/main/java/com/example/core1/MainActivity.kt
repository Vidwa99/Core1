package com.example.core1

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var counter = 0;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonScore = findViewById<Button>(R.id.btnScore)
        val buttonReset = findViewById<Button>(R.id.btnRest)
        val buttonSteal = findViewById<Button>(R.id.btnSteal)
        val textScore = findViewById<TextView>(R.id.textcounter)

        buttonScore.setOnClickListener {
            if (counter < 15) {
                counter++;
                textScore.setText("" + counter);
            }
            else
            {
                var mediaPlayer = MediaPlayer.create(applicationContext, R.raw.bugle_tune)
                mediaPlayer.start()
            }

        }

        buttonSteal.setOnClickListener {
               if (counter>0){
                counter = counter - 1 ;
                textScore.setText("" + counter);}
            }

        buttonReset.setOnClickListener {

            counter=0;
            textScore.setText("" + counter);
        }



    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("key_counter", counter);
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counter = savedInstanceState.getInt("key_counter", 0);
        val textScore = findViewById<TextView>(R.id.textcounter)
        textScore.setText(""+counter);

    }
}