package au.com.tilbrook.tasky.views.tasks;

import dagger.Subcomponent;

/**
 * Created by Mitchell Tilbrook on 17/07/2016.
 */

@PerActivity
@Subcomponent(modules = {
    ActivityModule.class
})
public interface TaskComponent {

    void inject(TaskListsActivity target);
}
