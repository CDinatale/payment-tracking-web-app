package ca.gbc.comp3095.comp3095rockstars.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    private long id;

    public long getId(){return id;}

    public void setId(Long id){this.id = id;}
}
