/*
 *  Copyright (c) 2011 by Twilio, Inc., all rights reserved.
 *
 *  Use of this software is subject to the terms and conditions of 
 *  the Twilio Terms of Service located at http://www.twilio.com/legal/tos
 */

package com.twilio.example.hellomonkey;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class HelloMonkeyActivity extends Activity implements View.OnClickListener
{
    private MonkeyPhone phone;
    private EditText numberField;

    @Override
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.main);

        phone = new MonkeyPhone(getApplicationContext());

        ImageButton dialButton = (ImageButton)findViewById(R.id.dialButton);
        dialButton.setOnClickListener(this);

        ImageButton hangupButton = (ImageButton)findViewById(R.id.hangupButton);
        hangupButton.setOnClickListener(this);

        numberField = (EditText)findViewById(R.id.numberField);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.dialButton) {
            AudioManager audioManager = (AudioManager)this.getSystemService(Context.AUDIO_SERVICE);
            //audioManager.setSpeakerphoneOn(true);
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, audioManager.getStreamMaxVolume(audioManager.STREAM_MUSIC), 0);

            phone.connect(numberField.getText().toString());
        }
        else if (view.getId() == R.id.hangupButton)
            phone.disconnect();
        else if(view.getId() == R.id.speakerButton)
        {
            AudioManager audioManager = (AudioManager)this.getSystemService(Context.AUDIO_SERVICE);
            audioManager.setSpeakerphoneOn(true);
        }
    }

    @Override
    public void onDestroy(){
        numberField = null;

        super.onDestroy();
    }
}