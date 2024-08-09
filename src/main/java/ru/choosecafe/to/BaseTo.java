package ru.choosecafe.to;

import io.swagger.annotations.ApiModelProperty;
import ru.choosecafe.HasId;

public abstract class BaseTo implements HasId {
    @ApiModelProperty(hidden = true)
    protected Integer id;

    public BaseTo() {
    }

    public BaseTo(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }
}
