package au.com.tilbrook.tasky.views.tasks;

import javax.inject.Inject;

import au.com.tilbrook.tasky.database.TaskModel;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Mitchell Tilbrook on 18/07/2016.
 */

@PerActivity
public class TaskQuery {

    private final Realm realm;

    @Inject
    public TaskQuery(final RealmConfiguration realmConfiguration) {
        realm = Realm.getInstance(realmConfiguration);
    }

    public RealmResults<TaskModel> getTasks() {
        return realm.where(TaskModel.class)
            .findAll();
    }

    public void close() {
        realm.close();
    }
}
