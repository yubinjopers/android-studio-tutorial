package kr.ai.listsqlite;

import androidx.annotation.NonNull;

public class Person {
    String name;

    public Person(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return "Person{" + "name= " + name + '\'' + "{";
    }
}
