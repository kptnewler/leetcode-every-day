package com.newler.leetcode.linklist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by liule on 2020/9/22 17:09
 **/
public class ThreadLoacalTest {
    private static final LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        new Thread(() -> {
            while (true) {
                Integer value = list.pollFirst();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (value != null) {
                    System.out.println("值: "+value);
                } else {
                    System.out.println("队列为空");
                }
            }
        }).start();
    }
}
