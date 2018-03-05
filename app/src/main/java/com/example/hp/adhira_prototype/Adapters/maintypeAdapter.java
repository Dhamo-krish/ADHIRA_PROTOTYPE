package com.example.hp.adhira_prototype.Adapters;

/**
 * Created by HP on 11/16/2017.
 */

public class maintypeAdapter {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String type;
    public maintypeAdapter(String typename)
    {
        this.type=typename;
    }
}
