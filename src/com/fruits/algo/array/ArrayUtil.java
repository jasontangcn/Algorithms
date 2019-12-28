package com.fruits.algo.array;

public class ArrayUtil {
    /*
    @return return error code.
     */
    public int insertNodeIntoCompactArrayByIndex(Object[] array, int size, Object obj, int index) {
        if (index < 0 || index > size)
            return 1;
        /* array is full */
        if (size == array.length)
            return 2;

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = obj;
        ++size;

        return 0;
    }

    public int insertNodeIntoArrayByIndex(Object[] array, Object obj, int index) {
        if(index < 0 || index >= array.length)
            return 1;

        /* find a space <= index */
        for(int i = index; i >= 0; i--) {
            if(array[i] == null) {
                for(int j = i; j < index; j++) {
                    array[j] = array[j+1];
                }
                array[i] = obj;
                return 0;
            }
        }

        /* find a space >= index */
        for(int i = index; i < array.length; i++) {
            if(array[i] == null) {
                for(int j = i; j > index; j--) {
                    array[j] = array[j-1];
                }
                array[i] = obj;
                return 0;
            }
        }

        return 2; /* no space for the new object. */
    }


}
