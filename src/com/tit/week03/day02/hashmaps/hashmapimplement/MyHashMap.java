package com.tit.week03.day02.hashmaps.hashmapimplement;

import java.util.LinkedList;

class MyHashMap<k , v>{
    public static final int Default_Capacity = 4 ; // our table size is 4
    public static final float Default_LoadFactor = .75f; // load factor is .75 => after 75% capacity , size doubles
    private int n; // contains the number of enteries in the map
    private LinkedList<Node>[] buckets; // we create an array of linked list

    //Helper function(constructor)
    private void initBuckets(int N) { // N - capacity/ size of buckets
        buckets = new LinkedList[N];
        for(int i =0;i<buckets.length;i++){
            buckets[i] =new LinkedList<>(); // this will create an empty linked at every arr[i]
        }
    }
    //Constructor
    public MyHashMap(){
        initBuckets(Default_Capacity); // this will make any array of LL with DC
    }

    //HashFuction
    private int hashFunc(k key){
        int hc = key.hashCode(); // this return us a hashcode but its range and sign can be any
        return ((Math.abs(hc)%buckets.length));
    }

    //traverse the LL the check for a node with key,if found it return its index else it returns -1
    private int searchInBucket(LinkedList<Node> ll,k key){
        for(int i=0;i<ll.size();i++){
            if(ll.get(i).key == key){
                return i;
            }
        }
        return -1;
    }

    private class Node{
        k key;
        v value;
        Node(k key,v value){

            this.key = key;
            this.value = value;
        }
    }
    //SIZE METHOD
    public int size(){  // returns the size of the map
        return n;
    }
    //PUT METHOD
    public void put(k key, v value){ //insert / update of key-value pair
        int bi = hashFunc(key); // bucket  index

        //treverse and check whether key exist or not
        LinkedList<Node> currBucket = buckets[bi];
        int ei = searchInBucket(currBucket,key);
        //if key exist : update if it doesnt then add a new node
        if(ei ==-1){ //key does not exist in currBucket || insert case
            Node newNode = new Node(key,value);
            currBucket.add(newNode);
            n++;
        }
        else{ //update case
            Node currNode = currBucket.get(ei); // this stores the node which we want to modify
            currNode.value = value;
        }

    }
    //GET  METHOD
    public v get(k key){ // gives value of corresponding key

        int bi = hashFunc(key); // bucket  index

        //treverse and check whether key exist or not
        LinkedList<Node> currBucket = buckets[bi];
        int ei = searchInBucket(currBucket,key);

        //if key exist : return the key value
        if(ei ==-1){ //key does not exist in currBucket
            return null;
        }
        else{
            Node currNode = currBucket.get(ei); //node
            return currNode.value;
        }
    }
    // REOMOVE METHOD
    public v remove(k key){
        int bi = hashFunc(key); // bucket  index

        //treverse and check whether key exist or not
        LinkedList<Node> currBucket = buckets[bi];
        int ei = searchInBucket(currBucket,key);


        if(ei ==-1){ //key does not exist in currBucket
            return null;
        }
        else{
            Node currNode = currBucket.get(ei); //node
            v val = currNode.value;
            currBucket.remove(ei);
            n--;
            return val;
        }

    }
}
