package com.codingblocks.restapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "REST";

    Button btnDownload;
    RecyclerView rvListPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDownload = (Button) findViewById(R.id.btnDownload);
        rvListPost = (RecyclerView) findViewById(R.id.listPosts);
        rvListPost.setLayoutManager(new LinearLayoutManager(this));
        final PostsAdapter postsAdapter = new PostsAdapter(
                new ArrayList<Post>(),
                MainActivity.this
        );
        rvListPost.setAdapter(postsAdapter);
        postsAdapter.setOnItemClickListener(new PostsAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(int pos) {
                Intent i = new Intent(MainActivity.this, PostCommentActivity.class);
                i.putExtra("postId", pos);
                startActivity(i);
            }
        });


        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadTask dTask = new DownloadTask(new DownloadTask.OnDownloadListener() {
                    @Override
                    public void onDownloaded(ArrayList<Post> posts) {
                        Toast.makeText(MainActivity.this,
                                "posts downloaded = " + posts.size(),
                                Toast.LENGTH_SHORT).show();

                        postsAdapter.updatePostList(posts);
                    }
                });

                dTask.execute("http://jsonplaceholder.typicode.com/posts");
            }
        });

    }


}
