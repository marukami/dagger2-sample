package au.com.tilbrook.tasky.views.tasks;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mitchell Tilbrook on 18/07/2016.
 */

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(final Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    public Context providesContext() {
        return activity;
    }

    @Provides
    @PerActivity
    public TaskAdapter providesTaskAdapter(TaskQuery query) {
        return new TaskAdapter(activity, query.getTasks());
    }

}