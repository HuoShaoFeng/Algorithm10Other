package com.jumfens.WordCountMax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class WordAndCounts {
    String word;
    Integer count;

    public WordAndCounts() {
    }
    public WordAndCounts(String word, Integer count) {
        this.word = word;
        this.count = count;
    }
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "WordAndCounts{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }
}

class WordAndCountsComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        WordAndCounts wc1 = null;
        WordAndCounts wc2 = null;

        if(o1 instanceof WordAndCounts)
            wc1 =(WordAndCounts) o1;
        if (o2 instanceof WordAndCounts)
            wc2 = (WordAndCounts)o2;

        if(wc1.count==wc2.count)
            return wc1.word.compareTo(wc2.word);
        else
            return wc2.count-wc1.count;//按照次数进行比较
    }
}


public class Main {

    public static void main(String[] args) {

        String fileName= "e:/words.txt";
        Map<String,Integer> map = new HashMap<>();


        map = WordCounts(fileName);
        System.out.println("文件中单词的种数 = "+map.size());

        Set<WordAndCounts> set = WordOrder(map);
        //遍历输出set中的内容
        System.out.println("排序后Set中单词的种数 = "+set.size());

        int i=5;
        for(Iterator iter = set.iterator(); iter.hasNext(); ) {
            WordAndCounts wordAndCounts = (WordAndCounts) iter.next();
            if(i-->=1)
                System.out.println(wordAndCounts.word+"出现了 "+wordAndCounts.count+"次");
        }


    }

    private static Set<WordAndCounts> WordOrder(Map<String, Integer> map) {
        //遍历map中的键值对，封装为一个对象
        Set<WordAndCounts> set = new TreeSet<>(new WordAndCountsComparator());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            WordAndCounts wordAndCounts = new WordAndCounts(entry.getKey(),entry.getValue());
            set.add(wordAndCounts);
        }

        return set;
    }

    static public Map<String ,Integer> WordCounts(String fileName){
        Map<String,Integer> map = new HashMap<>();
        //字符统计
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = null;

            while((line=reader.readLine())!=null){
                line = line.toLowerCase();
                String str[] = line.split("\\s+");
                for(int i = 0; i<str.length; i++){
                    String word = str[i].trim();
                    if(map.containsKey(word)){
                        map.put(word, map.get(word)+1);
                    }else{
                        map.put(word, 1);
                    }
                }
            }
            //输出我们想要的字符串格式
//            System.out.println("按字典序输出为：");
//            Iterator iterator=map.entrySet().iterator();
//            while(iterator.hasNext())
//            {
//                System.out.println(iterator.next());
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}