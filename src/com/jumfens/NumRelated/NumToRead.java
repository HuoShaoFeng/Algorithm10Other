package com.jumfens.NumRelated;

import java.util.HashMap;
import java.util.Map;

/**
 * 将5位以内的整数 转化成 汉语形式
 */
public class NumToRead {

    private static String[] unit = {"","拾","百","千","万","拾","百","千","亿"};
    static Map<String ,String > map = new HashMap<>();

    public static void main(String[] args) {
        map.put("0","零");
        map.put("1","壹");
        map.put("2","贰");
        map.put("3","叁");
        map.put("4","肆");
        map.put("5","伍");
        map.put("6","陆");
        map.put("7","柒");
        map.put("8","捌");
        map.put("9","玖");
        map.put("10","拾");

        String input = "10103";
        System.out.println(input);
        String trans = transfer(input);
        System.out.println("translate : "+trans);

        String pro = process(trans);
        System.out.println("process :   "+pro);
    }

    public static String process(String trans){
        String pro = trans;
        pro = pro.replace("零拾","零");
        pro = pro.replace("零百","零");
        pro = pro.replace("零千","零");

        pro = pro.replace("零零","零");

        if(pro.endsWith("零")){
            pro = pro.substring(0,pro.length()-1);
        }
        System.out.println(pro);
        if (pro.startsWith("零万") ||pro.startsWith("零千") || pro.startsWith("零百")||pro.startsWith("零拾") )
            pro = pro.substring(2);

        return pro;
    }

    public static String transfer(String input) {
        StringBuilder out = new StringBuilder();
        int numInt = Integer.parseInt(input);
        input = numInt+"";

        for (int i = 0; i < input.length(); i++) {
            String  c = input.charAt(i)+"";
            String numBit = map.get(c);
            out.append(numBit);

            out.append(unit[input.length()-i-1]);
        }

        return out.toString();
    }

}
