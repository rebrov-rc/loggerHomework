package com.logger.app;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Filter
 */
public class Filter {

    private final int f;
    private int counter;

    public Filter (int f){
        this.f = f;
    }

    public int getCount(){
        return this.counter;
    }

    public List<Integer> filterOut(List<Integer> list){
        return list.stream().filter(x ->{
            Logger logger = Logger.getInstance();
            if (x < f){
                logger.log("Элемент \'" + x +"\' не проходит");
                return false;
            }
            logger.log("Элемент \'" + x +"\' проходит");
            this.counter++;
            return true;
        }).collect(Collectors.toList());
    }

}