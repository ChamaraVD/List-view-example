package com.damithdev.jsonex.model;

import java.io.Serializable;

/**
 * Created by Damith on 3/5/2017.
 */

public class Score implements Serializable{

    private String id;
    private String title;
    private String type;

    public Score(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public Score(String id, String title, String type) {
        this.id = id;
        this.title = title;
        this.type = type;
    }

    /**
     * Gets id
     *
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id value of id
     */

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets title
     *
     * @return value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title value of title
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets type
     *
     * @return value of type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type value of type
     */

    public void setType(String type) {
        this.type = type;
    }
}
