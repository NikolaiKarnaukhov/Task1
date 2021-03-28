package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class StackExample {

    public static int SizeOfArray = 10;
    public static String StackName;

    public static Integer[] StackArray;
    public static int size;

    StackExample(Integer[] values, String StackName)
    {
        StackName = StackName;
        StackArray = new Integer[SizeOfArray];
        AddValues(values);
        System.out.printf("Сформирован стек %s:%s%s", StackName, System.lineSeparator(), System.lineSeparator());
    }


    public static boolean Empty() {
        System.out.printf("\nПроверка стека %s на пустоту:%s%s%s", StackName, System.lineSeparator(), size == 0 ? "\nСтэк пустой" : "\nСтэк не пустой", System.lineSeparator());
        return size == 0;
    }

    public static void AddLength()
    {
        if(size == StackArray.length)
        {
            StackArray = Arrays.copyOf(StackArray, StackArray.length+1);
        }
    }

    public static void AddValues(Integer[] values)
    {
        if(values !=null && values.length >0)
        {
            for (Integer value : values) {
                push(value);
            }
        }
    }

    public static Integer push(Integer value)
    {
        if (value != null)
        {
            AddLength();
            System.arraycopy(StackArray, 0,StackArray,1,StackArray.length - 1 );
            StackArray[0] = value;
            size++;
        }

        System.out.printf("Стек после добавления элемента:%s%s\n", System.lineSeparator(), System.lineSeparator());
        for(int i = 0; i < StackArray.length; i++){
            System.out.print(StackArray[i] + " ");
        }
        return value;
    }

    public static Integer peek()
    {
        System.out.println("Стэк: ");
        for(int i = 0; i < StackArray.length; i++){
            System.out.print(StackArray[i] + " ");
        }
        System.out.printf("\nВозвращаем верхний элемент из стека %s:%s%s%s\n", StackName, System.lineSeparator(), size == 0 ? "Стэк пустой" : StackArray[0], System.lineSeparator());
        return size !=0 ? StackArray[0] : null;
    }

    public static Integer pop()
    {
        Integer value = null;
        if(size != 0)
        {
            value = StackArray[0];
            StackArray[0] = null;
            System.arraycopy(StackArray, 1, StackArray, 0, StackArray.length - 1);
            size--; SizeOfArray--;
        }



        System.out.print("Стек после удаления элемента " + value + " : ");
        for(int i = 0; i < StackArray.length; i++){
            System.out.print(StackArray[i] + " ");
        }

        return value;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        Integer[] array = {1,2,3,4,5,6,7,8,9,0};

        StackExample stack = new StackExample(array,"Test");

        while(true)
        {

            Empty();
            System.out.println("\n 1. push()\n 2. peek()\n 3. pop()\n");
            int num = in.nextInt();

            switch (num)
            {
                case 1: {System.out.println("Введите элемент: "); int x = in.nextInt();
                        StackExample.push(x); System.lineSeparator(); break; }

                case 2:{StackExample.peek();System.lineSeparator(); break;}

                case 3: {StackExample.pop(); System.lineSeparator(); break;}

                default: break;

            }

        }
    }



}



