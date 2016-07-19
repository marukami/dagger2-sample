package au.com.tilbrook.tasky.views.tasks;

import android.view.View;
import android.widget.AdapterView;

import javax.inject.Inject;

import au.com.tilbrook.tasky.database.TaskModel;


/**
 * Created by Mitchell Tilbrook on 18/07/2016.
 */

@PerActivity
public class TaskItemSelected implements AdapterView.OnItemClickListener {

    private final MarkTaskDoneCommand command;
    private final TaskQuery query;
    private final TaskAdapter adapter;

    @Inject
    public TaskItemSelected(final MarkTaskDoneCommand command, final TaskQuery query, final TaskAdapter adapter) {
        this.command = command;
        this.query = query;
        this.adapter = adapter;
    }

    @Override
    public void onItemClick(final AdapterView<?> adapterView, final View view, final int i, final long l) {
        final TaskModel task = query.getTasks().get(i);
        command.execute(task.getId());
        adapter.updateData(query.getTasks());
    }
}
