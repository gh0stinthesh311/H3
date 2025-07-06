package io.github.gh0stinthesh311;


import io.github.gh0stinthesh311.domain.Column;

public class Main {
    public static void main(String[] args) {

        String inter = "INT";

        Column clm = new Column(inter);
        System.out.println(clm.getDataType().getAssociatedClass());


    }
}





