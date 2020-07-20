
package com.srikanth.androidcodingtest.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("rows")
    @Expose
    private List<Row> rows = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Model() {
    }

    /**
     * 
     * @param title
     * @param rows
     */
    public Model(String title, List<Row> rows) {
        super();
        this.title = title;
        this.rows = rows;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

}
