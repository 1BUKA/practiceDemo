package com.jay.algorithm.stack;

import lombok.Data;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

/**
 * 栈的实现
 */
@Data
@ToString
public class Stack<AnyType> {
    private List<AnyType> elemList;
    private int point;

    public Stack(){
        elemList = new LinkedList<>();
        point = -1;
    }

    // 出栈
    public AnyType pop(){
        if(point < 0){
            throw new IndexOutOfBoundsException("数组越界");
        }
        AnyType anyType = elemList.get(point);
        point--;
        return anyType;
    }


    // 入栈
    public void push(AnyType element){
        elemList.add(element);
        point++;
    }

    // 获取顶部数据
    public AnyType top(){
        if(point < 0){
            throw new IndexOutOfBoundsException("数组越界");
        }
        return elemList.get(point);
    }
}
