package 제네릭스_열거형_애너테이션.AnnotationEx;

import java.util.Arrays;

class MyArrayList<T>{
    T[] arr;

    @SafeVarargs
    @SuppressWarnings("varargs")
    MyArrayList(T...arr){
        this.arr = arr;
    }

//    @SafeVarargs
    @SuppressWarnings("unchecked")
    public static <T> MyArrayList<T> asList(T...a){
        return new MyArrayList<>(a);
    }

    public String toString(){
        return Arrays.toString(arr);
    }
}
public class AnnotationEx2 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        MyArrayList<String> list = MyArrayList.asList("1","2","3");
        System.out.println(list);
    }
}
