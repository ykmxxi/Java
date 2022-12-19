package ch11.스택과큐;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack extends Vector {
    /**
     * 객체 저장
     *
     * @param item
     * @return item
     */
    public Object push(Object item) {
        addElement(item);
        return item;
    }

    /**
     * 객체 추출
     *
     * @return obj
     */
    public Object pop() {
        Object obj = peek();
        removeElementAt(size() - 1);
        return obj;
    }

    /**
     * 맨 위 객체 반환
     *
     * @return obj
     */
    public Object peek() {
        int length = size();

        if (length == 0) {
            throw new EmptyStackException();
        }

        return elementAt(length - 1);
    }

    /**
     * 스택이 비어있는지 확인
     *
     * @return boolean값
     */
    public boolean empty() {
        return size() == 0;
    }

    /**
     * 객체 탐색 끝에서부터 객체를 찾고, 찾은 경우 저장된 위치를 반환, 찾지 못하면 -1 반환
     *
     * @param o
     * @return 해당 객체의 index
     */
    public int search(Object o) {
        int i = lastIndexOf(o);

        if (i >= 0) {
            return size() - i;
        }
        return -1;
    }
}
