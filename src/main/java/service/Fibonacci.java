package service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public static List<BigDecimal> fibonacciCount(Integer fn) {

        List<BigDecimal> out = new ArrayList<>();
        for(int i=0; i<= fn ;i++){
            if (i==0 || i==1){
                out.add((BigDecimal.valueOf(i)));
            } else {
                out.add(out.get(i-1).add(out.get(i-2)));
            }
        }

        return out;
    }
}
