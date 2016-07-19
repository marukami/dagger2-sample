package au.com.tilbrook.tasky.views.tasks;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;


/**
 * Created by Mitchell Tilbrook on 17/07/2016.
 *
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {}
