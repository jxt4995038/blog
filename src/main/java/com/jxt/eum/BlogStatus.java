package com.jxt.eum;

public enum BlogStatus{

    VALID(1,"有效"),INVALID(2,"无效");

    private Integer index;

    private String description;

    private BlogStatus(Integer index,String description){
        this.index = index;
        this.description = description;
    }

    public Integer getIndex() {
        return index;
    }

}
