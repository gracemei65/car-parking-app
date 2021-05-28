package com.gracie.parking.entity;

public enum Size {
    SMALL(1), MEDIUM(2), LARGE(3);

    private final int size;

    private Size(int size) {
        this.size = size;
    }

    public int getSize()
    {
        return this.size;
    }
}
