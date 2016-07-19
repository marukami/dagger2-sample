package au.com.tilbrook.tasky.views.tasks;

import javax.inject.Inject;

import au.com.tilbrook.tasky.database.TaskModel;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Mitchell Tilbrook on 18/07/2016.
 */

@PerActivity
public class MarkTaskDoneCommand {

    private final RealmConfiguration realmConfiguration;

    @Inject
    public MarkTaskDoneCommand(final RealmConfiguration realmConfiguration) {
        this.realmConfiguration = realmConfiguration;
    }

    public void execute(int taskId) {
        final Realm realm = Realm.getInstance(realmConfiguration);
        final TaskModel model = realm.where(TaskModel.class)
            .equalTo("id", taskId)
            .findFirst();

        realm.executeTransaction(new Realm.Transaction() {
            @Override public void execute(final Realm realm) {
                model.setDone(true);
                realm.insertOrUpdate(model);
            }
        });

        realm.close();
    }
}
