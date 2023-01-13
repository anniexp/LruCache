package com.company;

public class Main {

    public static void main(String[] args) {
        LruCache<Integer> res = new LruCache<>();

        res.addElement(1);
        System.out.println(res);
        res.addElement(2);
        System.out.println(res);
        res.addElement(3);
        System.out.println(res);
        res.addElement(3);
        System.out.println(res);
        res.addElement(2);
        System.out.println(res);
        res.addElement(4);
        System.out.println(res);
        res.addElement(5);
        System.out.println(res);

        LruCache<Character> res2 = new LruCache<>(4);

        res2.addElement('A');
        System.out.println(res2);
        res2.addElement('B');
        System.out.println(res2);
        res2.addElement('C');
        System.out.println(res2);
        res2.addElement('D');
        System.out.println(res2);
        res2.addElement('E');
        System.out.println(res2);
        res2.addElement('D');
        System.out.println(res2);
        res2.addElement('F');
        System.out.println(res2); //E(4), F(6), C(2), D(5)
    }
}
