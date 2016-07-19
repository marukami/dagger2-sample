package au.com.tilbrook.tasky.views.tasks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import au.com.tilbrook.tasky.R;
import au.com.tilbrook.tasky.database.TaskModel;
import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

/**
 * Created by Mitchell Tilbrook on 17/07/2016.
 */

@PerActivity
public class TaskAdapter extends RealmBaseAdapter<TaskModel> {

    @Inject
    public TaskAdapter(final Context context, final OrderedRealmCollection<TaskModel> data) {
        super(context, data);
    }

    static class ViewHolder {
        TextView name;

        TextView done;
        public ViewHolder(final View view) {
            name = (TextView) view.findViewById(R.id.taskName);
            done = (TextView) view.findViewById(R.id.taskChecked);
        }

    }


    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        ViewHolder viewHolder;
        final View view;
        if (convertView == null) {
            view = LayoutInflater
                .from(context)
                .inflate(R.layout.row_task, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            view = convertView;
        }

        final TaskModel task = getItem(position);
        viewHolder.name.setText(task.getName());
        viewHolder.done.setText(task.isDone() ? "DONE" : "TODO");

        return view;
    }
}
