package qulei.android.dagger1.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import qulei.android.dagger1.demo.abs.AbsActivity;
import qulei.android.dagger1.demo.model.Message;
import qulei.android.dagger1.demo.provider.AuthProvider;
import qulei.android.dagger1.demo.provider.MessageProvider;
import qulei.android.dagger1.demo.view.adapter.MessageAdapter;

public class MainActivity extends AbsActivity {

    @Inject
    MessageProvider messageProvider;

    @Inject
    AuthProvider authProvider;

    @Inject
    MessageAdapter messageAdapter;

    ListView lvMessageItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Message unread = " + messageProvider.getMessageUnread(),
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!authProvider.isLogin()) {
                    startActivity(new Intent(getApplication(), LoginActivity.class));
                } else {
                    Toast.makeText(getApplication(), "logged", Toast.LENGTH_SHORT).show();
                }
            }
        });
        lvMessageItem = (ListView) findViewById(R.id.lvMessageItem);
        lvMessageItem.setAdapter(messageAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        messageProvider.findMessageItems(new MessageProvider.OnFindMessageListener() {
            @Override
            public void onItems(List<Message> items) {
                messageAdapter.setList(items);
            }
        });
    }

    @Override
    protected boolean isInject() {
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
