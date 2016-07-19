package au.com.tilbrook.tasky.application;

import android.app.Application;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import au.com.tilbrook.tasky.database.TaskModel;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Mitchell Tilbrook on 17/07/2016.
 */

public class TaskApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Inject RealmConfiguration realmConfiguration;

    @Override public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(new ApplicationModule(this))
            .build();

        applicationComponent.inject(this);
        setupDatabase();

    }

    @NonNull public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    private void setupDatabase() {
        final Realm realm = Realm.getInstance(realmConfiguration);
        realm.executeTransaction(new Realm.Transaction() {
            @Override public void execute(final Realm realm) {
                for (int i = 0; i < 6; i++) {
                    final TaskModel model = new TaskModel();
                    model.setId(i + 1);
                    model.setName("Task " + i + 1);
                    model.setDone(false);

                    realm.insertOrUpdate(model);
                }
            }
        });

        realm.close();
    }
}
