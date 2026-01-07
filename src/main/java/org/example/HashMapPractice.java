package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapPractice {

    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; // - total numbers of nodes
        private int N; // - total number of buckets
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets= new LinkedList[4];
            for(int i = 0; i < 4; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
           int hashedKey = key.hashCode();
           return Math.abs(hashedKey) % N;
        }

        private int searchInLL(K key, int bi){
           LinkedList<Node> ll = buckets[bi];
           for (int j = 0; j < ll.size(); j++){
               if(ll.get(j).key == key){
                   return j;
               }
           }
           return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBuckets[] = buckets;
            buckets = new LinkedList[N*2];
            for(int i = 0; i < N*2; i++){
                this.buckets[i] = new LinkedList<>();
            }

            for (LinkedList<Node> ll : oldBuckets) {
                for (Node node : ll) {
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key,bi); // data index - search in every linkedlist on that bucket index. 0 or > 0

            if(di ==-1) { // key doesn't exist
                 buckets[bi].add(new Node(key, value));
                 n++;
            }else{ // key exist
               Node node = buckets[bi].get(di);
               node.value = value;
            }
            double lambda = (double)n/N;
            if (lambda > 2.0){
               rehash();
            }
        }


        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);

            if(di ==-1) { // key doesn't exist
               return null;
            }else{ // key exist
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        public Boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            return di != -1;
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            if (di == -1){
                return null;
            }else{
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        public boolean isEmpty(){
            return n==0;
        }

        public ArrayList<K> keySet () {
            ArrayList<K> keys = new ArrayList<>();
            for (LinkedList<Node> ll : buckets) {
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }

}
