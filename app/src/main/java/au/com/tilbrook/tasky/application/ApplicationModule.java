package au.com.tilbrook.tasky.application;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.RealmConfiguration;

/**
 * Created by Mitchell Tilbrook on 17/07/2016.
 */

@Module
public class ApplicationModule {

    private final Application app;

    public ApplicationModule(final Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public RealmConfiguration providesDatabaseConf() {
        return new RealmConfiguration.Builder(app)
            .deleteRealmIfMigrationNeeded()
            .build();
    }

}
