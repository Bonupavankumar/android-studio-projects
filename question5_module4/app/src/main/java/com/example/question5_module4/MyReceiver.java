package com.example.question5_module4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private static final String TAG = "SmsBroadcastReceive";
    String msg, phoneNo = "";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        throw new UnsupportedOperationException("Not yet implemented");

        //Retrieves the general action to be performed and display on log
        Log.i(TAG,"Intent Received : " + intent.getAction());
        if(intent.getAction().equals(SMS_RECEIVED) )
        {
            //retreives  a map of extender data form the intent;
            Bundle dataBundle = intent.getExtras();
            if(dataBundle!=null){
                //creating PDU (Protocol Data unit) object which is a protocol for transferring the message

                Object[] mypdu = (Object[]) dataBundle.get("pdus");

                final SmsMessage[] messages = new SmsMessage[mypdu.length];

                for(int i = 0; i < mypdu.length; i++)
                {
                    //for build versions >= API level 23
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    {
                        String format = dataBundle.getString("format");
                        //from pdu we get all object and SmsMessage object using following line of code
                        messages[i] = SmsMessage.createFromPdu((byte[])mypdu[i], format);
                    }
                    else
                    {
                        //api level 23
                        messages[i] = SmsMessage.createFromPdu((byte[]) mypdu[i]);
                    }
                    msg = messages[i].getMessageBody();
                    phoneNo = messages[i].getOriginatingAddress();
                }
                Toast.makeText(context, "Message: " + msg + "\nNumber: " + phoneNo, Toast.LENGTH_LONG).show();
                return;
            }
        }
    }

}