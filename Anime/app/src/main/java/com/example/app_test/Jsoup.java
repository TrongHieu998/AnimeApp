//package com.example.app_test;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.example.app_test.Adapter.Jsoup_Adapter;
//import com.example.app_test.Model.Jsoup_model;
//
//import org.jsoup.nodes.Document;
//import org.jsoup.select.Elements;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class Jsoup extends AppCompatActivity {
//    RecyclerView recyclerView;
//    static Jsoup_Adapter adapter;
//    ArrayList<Jsoup_model> jsoup_models=new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_jsoup);
//        recyclerView=findViewById(R.id.recycleview_jsoup);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
//        adapter= new Jsoup_Adapter(jsoup_models,this);
//        recyclerView.setAdapter(adapter);
//        Content content= new Content();
//        content.execute();
//    }
//    public static class Content extends AsyncTask<Void,Void,Void>{
//        private ArrayList<Jsoup_model> jsoup_models;
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//            adapter.notifyDataSetChanged();
//        }
//
//        @Override
//        protected void onCancelled() {
//            super.onCancelled();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//          try {
//             // String url="https://www10.gogoanime.io/?fbclid=IwAR1oWXolOfxrs9gVuoOXlcaBsXen-dMHWQn8arNDQUk9_V_uGxnCMklveZ0";
//              String url="https://ajax.apimovie.xyz/ajax/page-recent-release.html?page=1&type=2";
//              Document doc= org.jsoup.Jsoup.connect(url).get();
//              Elements data=doc.select("div.last_episodes.loaddub li");
//             // Elements data=doc.select("div.img");
//              int size=data.size();
//              Log.d("doc","doc"+doc);
//              Log.d("data","data"+data);
//              Log.d("size","size"+size);
//              for(int i=0;i<size;i++)
//                  {
//                  String imgUrl=data.select("div.img")
//                          .select("img")
//                          .eq(i)
//                          .attr("src");
//                  String ten=data.select("p.name")
//                          .select("a")
//                          .eq(i)
//                          .attr("title");
//                  String tap=data.select("p.episode")
//                          .eq(i)
//                          .text();
//                  jsoup_models.add(new Jsoup_model(imgUrl,ten,tap));
//                  Log.d("last_episodes.loaddub","img: " + imgUrl + " . title:" +ten+ "episode:" +tap);
//              }
//          } catch (IOException e) {
//              e.printStackTrace();
//          }
//            return null;
//        }
//    }
//
//}
