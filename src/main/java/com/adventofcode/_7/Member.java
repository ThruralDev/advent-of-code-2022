package com.adventofcode._7;

public class Member {

    private int size;
    private Type type;

    public Member(int size, Type type) {

        this.size = size;
        this.type = type;
    }

    public int getSize() {

        return this.size;
    }

    public void setSize(int size) {

        this.size = size;
    }

    public Type getType() {

        return type;
    }

    public void setType(Type type) {

        this.type = type;
    }

    public int increaseSize(Integer summand) {

        return this.size += summand;
    }
}
