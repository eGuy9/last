package com.example.last;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class LastApplicationTests {

    @Test
    void contextLoads() {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();
        int maxlen = in.nextInt();
        int runs = in.nextInt();
        int max = 0;
        String[] s = str.split(" ");
        Map<Integer,Integer> map0 = new TreeMap();
        for(int i=0;i<s.length;i++){
            int key = Integer.valueOf(s[i]);
            int val = Integer.valueOf(s[i + 1]);
            map0.put(key,val);
            if(i == str.length()-1){
                max = key;
            }
            i++;
        }

        Map<Integer, Integer> map = new TreeMap();
        int count = 1;
        int nums = 0;
        List<Integer> list = new ArrayList();
        Map<Integer, Integer> set = new TreeMap();

        int key = Integer.valueOf(s[0]);
        int val = Integer.valueOf(s[1]);
        map.put(key,val);
        count++;

        for (int i = 0; i < key; i++) {

            for (int x : set.keySet()) {
                if (set.get(x) == count) {
                    list.add(x);
                }
            }
            for(int j=0;j<list.size();j++){
                set.remove(list.get(j));
            }
            list.clear();

            for (int keys : map.keySet()) {
                if (count >= keys && set.size() < runs) {
                    set.put(keys, keys + map.get(keys));
                    list.add(keys);
                }
            }
            for(int j=0;j<list.size();j++){
                map.remove(list.get(j));
            }
            list.clear();

            if (map.size() < maxlen) {
                for(int x : map0.keySet()){
                    if(x == count){
                        map.put(key, val);
                    }
                }
            }else if (map.size() == maxlen) {
                nums++;
            }
            i++;
            count++;
        }

        while (true) {
            for (int x : set.keySet()) {
                if (set.get(x) == count) {
                    list.add(x);
                }
            }
            for (int j = 0; j < list.size(); j++) {
                set.remove(list.get(j));
            }
            list.clear();

            for (int keys : map.keySet()) {
                if (set.size() < runs) {
                    set.put(keys,keys+map.get(keys));
                    list.add(keys);
                }
            }
            for (int j = 0; j < list.size(); j++) {
                map.remove(list.get(j));
            }
            list.clear();

            count++;
            if (set.size() == 0 && map.size() == 0) {
                break;
            }
        }
        count += 2;
        System.out.print(count + " " + nums);
    }

}
