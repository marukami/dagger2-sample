package au.com.tilbrook.tasky.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Mitchell Tilbrook on 18/07/2016.
 */

public class TaskModel extends RealmObject {
    @PrimaryKey
    private int     id;
    private String  name;
    private boolean done;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(final boolean done) {
        this.done = done;
    }
}
