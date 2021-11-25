package com.example.youtubedownloaderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.SparseArray;
import android.view.View;
import android.widget.EditText;

import at.huber.youtubeExtractor.YouTubeUriExtractor;
import at.huber.youtubeExtractor.YtFile;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    String newLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.link);
    }

    public void DownloadMyVideo(View view) {

        String values=editText.getText().toString();

        YouTubeUriExtractor youTubeUriExtractor=new YouTubeUriExtractor(MainActivity.this) {
            @SuppressLint("StaticFieldLeak")
            @Override
            public void onUrisAvailable(String videoId, String videoTitle, SparseArray<YtFile> ytFiles) {

                if (ytFiles!=null){
                    int tag= 22;
                    newLink= ytFiles.get(tag).getUrl();
                    String title="MyDrama";
                    DownloadManager.Request request= new DownloadManager.Request(Uri.parse(newLink));
                    request.setTitle(title);
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,title+".mp4");
                    @SuppressLint({"StaticFieldLeak", "ServiceCast"}) DownloadManager downloadManager=(DownloadManager) getSystemService(Context.DISPLAY_SERVICE);
                    request.allowScanningByMediaScanner();
                    request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
                    downloadManager.enqueue(request);
                }

            }
        };
        youTubeUriExtractor.execute(values);

    }
}