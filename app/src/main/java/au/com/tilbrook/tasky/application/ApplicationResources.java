package au.com.tilbrook.tasky.application;

import android.app.Application;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Mitchell Tilbrook on 18/07/2016.
 */

@Singleton
public class ApplicationResources {
    private final Application application;

    @Inject
    public ApplicationResources(final Application application) {
        this.application = application;
    }

    @NonNull
    public String getString(@StringRes int resId) {
        return application.getString(resId);
    }

    @NonNull
    public String getString(@StringRes int resId, Object... arg) {
        return application.getString(resId, arg);
    }

    @ColorInt
    public int getColor(@ColorRes int colorRes) {
        return ContextCompat.getColor(application, colorRes);
    }
}
