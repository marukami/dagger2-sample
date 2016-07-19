package au.com.tilbrook.tasky.application;

import javax.inject.Singleton;

import au.com.tilbrook.tasky.views.tasks.ActivityModule;
import au.com.tilbrook.tasky.views.tasks.TaskComponent;
import dagger.Component;

/**
 * Created by Mitchell Tilbrook on 17/07/2016.
 */
@Singleton
@Component(modules = {
    ApplicationModule.class
})
public interface ApplicationComponent {

    TaskComponent newMyActivitySubcomponent(ActivityModule activityModule);

    void inject(TaskApplication target);
}
