package com.example.T1interview.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Counter implements Comparable<Counter>{

    private Character symbol;

    private int count;

    public Counter(Character symbol) {
        this.symbol = symbol;
        this.count = 1;
    }

    @Override
    public String toString() {
        return "\'"+symbol+"\': "+count+", ";
    }

    public Counter updateValue(){
        this.count++;
        return this;
    }

    @Override
    public int compareTo(Counter o) {
        return Integer.compare(this.count,o.count);
    }
}
