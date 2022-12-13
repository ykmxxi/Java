package ch11.arraylist;

import java.util.Vector;

public class VectorSizeCapacityTest {
    public static void main(String[] args) {
        /*
         * capacity 가 5인 Vector인스턴스(0x100) 생성하고 3개의 객체를 저장
         * [1, 2, 3, null, null]
         */
        Vector vector = new Vector(5);
        vector.add("1");
        vector.add("2");
        vector.add("3");
        print(vector);

        /*
         * 빈 공간을 없애 size == capacity
         * 배열은 크기를 변경할 수 없기 때문에 새로운 배열을 생성해서 주소값(0x200)을 참조변수에 할당
         * 기존의 Vector인스턴스(0x100)는 더 이상 사용할 수 없으며, garbage collector에 의해서 제거됨
         */
        vector.trimToSize(); // remove empty space. (capacity == size)
        System.out.println("After trimToSize()");
        print(vector);

        /*
         * capacity가 최소 6이 되도록 만듦
         * 새로운 배열을 생성(0x300)해서 기존 인스턴스의 내용을 복사
         */
        vector.ensureCapacity(6); // set minCapacity as 6
        System.out.println("After ensureCapacity(6)");
        print(vector);

        /*
         * 기존의 capacity보다 큰 size를 설정
         * Vector는 capacity가 부족할 경우 자동적으로 기존의 크기보다 2배의 크기로 증가 (6 -> 12)
         * 새로운 배열을 생성(0x400)해 기존 인스턴스의 내용을 복사
         */
        vector.setSize(7);
        System.out.println("Set size as 7");
        print(vector);

        vector.clear();
        System.out.println("After clear");
        print(vector);
    }

    public static void print(Vector vector) {
        System.out.println(vector);
        System.out.println("size: " + vector.size());
        System.out.println("capacity: " + vector.capacity());
        System.out.println();
    }
}
