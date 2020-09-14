package 제네릭스_열거형_애너테이션.AnnotationEx;

import java.util.ArrayList;

class NewClass{
    int newField;

    int getNewField(){
        return newField;
    }
    @Deprecated
    int oldField;

    @Deprecated
    int getOldField(){
        return oldField;
    }
}


public class AnnotationEx1 {
    @SuppressWarnings("deprecation") //deprecation관련 경고를 억제
    public static void main(String[] args) {
        NewClass newClass = new NewClass();

        newClass.oldField = 10; //@Deprecated가 붙은 대상을 사용
        System.out.println(newClass.getOldField());  //@Deprecated가 붙은 대상을 사용

        @SuppressWarnings("unchecked")//제네릭스 관련 경고를 억제
        ArrayList<NewClass> list = new ArrayList(); //타입을 지정하지 않았음
        list.add(newClass);

    }
}
