package au.com.tilbrook.tasky.views.tasks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import javax.inject.Inject;

import au.com.tilbrook.tasky.R;
import au.com.tilbrook.tasky.application.TaskApplication;

public class TaskListsActivity extends AppCompatActivity {

    @Inject TaskAdapter taskAdapter;
    @Inject TaskItemSelected itemSelected;
    @Inject TaskQuery query;

    @Override protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        ((TaskApplication) getApplication())
            .getApplicationComponent()
            .newMyActivitySubcomponent(new ActivityModule(this))
            .inject(this);


        ListView taskList = (ListView) findViewById(R.id.taskList);
        taskList.setAdapter(taskAdapter);
        taskList.setOnItemClickListener(itemSelected);

    }

    @Override protected void onDestroy() {
        super.onDestroy();
        query.close();
    }
}
