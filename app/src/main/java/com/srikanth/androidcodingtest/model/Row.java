
package com.srikanth.androidcodingtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Row {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("imageHref")
    @Expose
    private Object imageHref;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Row() {
    }

    /**
     * 
     * @param imageHref
     * @param description
     * @param title
     */
    public Row(String title, String description, Object imageHref) {
        super();
        this.title = title;
        this.description = description;
        this.imageHref = imageHref;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getImageHref() {
        return imageHref;
    }

    public void setImageHref(Object imageHref) {
        this.imageHref = imageHref;
    }

}
