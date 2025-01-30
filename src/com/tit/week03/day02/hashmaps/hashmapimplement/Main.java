package com.tit.week03.day02.hashmaps.hashmapimplement;


class Main {
    public static void main(String[] args) {
        MyHashMap<String,Integer> hm = new MyHashMap<>();
        hm.put("Aadarsh",21);
        hm.put("Anand",20);
        hm.put("Ash",15);
        hm.put("yash",5);
        hm.put("Aadarsh",0);
        hm.put("hello",266);
        System.out.println("size : " + hm.size());
        System.out.println(hm.get("Aadarsh"));
        System.out.println(hm.get("Ash"));
        System.out.println(hm.get("hello"));
        System.out.println(hm.get("Anand"));
        System.out.println(hm.get("xyz"));
        System.out.println(hm.remove("Aadarsh"));
        System.out.println("Size : "+ hm.size());
    }
}

