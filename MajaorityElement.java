
// input - 7,2,3,7,7,6,4,7,7
// output - 7

// input - 7,2,2,3,4,7,5,6,

// input - 7,2,3,7,7,6,4,7,5,8,2,4,3
// output - There is no majority element

/*
1. 2 solutions
2. print a element whose its occurance is gretaer than half of the length(n) of array
3. define another array with any length buth element occurence not more than half the length
4. Print the element.

*/

// diff arr lengths, types, negatives, all same values, diff orders,

import java.io.*;
import java.util.*;

class MajorityElement {

    public static void main(String[] args) {
        int[] inputArray = new int[]{7,2,3,7,7,6,4,7,7};
        marjorityElement(inputArray);

    }

    public static void marjorityElement(int[] nums) {

        int n=nums.length;
        int maxCount=0;
        int index=-1; //sentinels

        for (int i=0; i<nums.length; i++)
        {
            int count=0;
            for (int j = 0; j < n; j++)
            {
                if(nums[i] == nums[j])
                    count++;
            }
            if(count > maxCount)
            {
                maxCount = count;
                index = i;
            }
                }

            if (maxCount>nums.length/2)

                System.out.println("Most repetitive Element: "+ nums[index]);

            else
                System.out.println ("No Majority Element");

    }

}

