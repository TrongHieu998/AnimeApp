//package com.example.app_test.Activity;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.ProgressDialog;
//import android.media.MediaPlayer;
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.MediaController;
//import android.widget.ProgressBar;
//import android.widget.VideoView;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//import com.example.app_test.Model.SiteTools;
//import com.example.app_test.R;
//
//public class VideoView_Activity extends AppCompatActivity {
//    VideoView video;
//   // private String url ="http://st3.anime1.com/Darling in the FranXX Episode 15.mp4?st=5hjUoXuMBfTplZ49TKn8oQ&e=1529135685";
//    private MediaController ctlr;
//    private ProgressBar progressBar;
//    private RequestQueue requestQueue;
//    private StringRequest stringRequest;
//    String url="https://www.youtube.com/watch?v=WH3DwwxbH3c";
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_video_view);
//
//        Bundle bundle=getIntent().getExtras();
//        if(bundle!=null)
//        {
//           url=bundle.getString("url");
//        }
//        else{
//        }
//
//
//        video= findViewById(R.id.videoView);
//        video.setVisibility(View.INVISIBLE);
//        ctlr=new MediaController(this);
//        ctlr.setVisibility(View.INVISIBLE);
//        requestQueue= Volley.newRequestQueue(this);
//        stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                video.setVisibility(View.VISIBLE);
//                ctlr.setVisibility(View.VISIBLE);
//                String videoUrl = SiteTools.getVideoURL(response);
//                Uri uri = Uri.parse(videoUrl);
//                video.setVideoURI(uri);
//                ctlr.setMediaPlayer(video);
//                video.setMediaController(ctlr);
//                video.requestFocus();
//                video.start();
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//            }
//        });
//        requestQueue.add(stringRequest);
//
//    }
//}
