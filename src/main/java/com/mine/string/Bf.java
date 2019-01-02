package com.mine.string;

/**
 * 模式匹配算法,即子串定位问题
 * 算法的时间复杂度：
 */
public class Bf {

    /**
     * bf算法
     *
     * @param target
     * @param pattern
     * @return
     */
    public int bf(String target, String pattern) {
        char[] targetArray = target.toCharArray();
        char[] patternArray = pattern.toCharArray();
        //注，这里的i和j分别值得是在目标串和模式串中的下标位置，i可以理解为下标位置，也可以理解为比较的开始位置都可以
        //我这种理解，是默认为i不动，通过i+j的值去判断目标串现在的索引位置的
        int i = 0, j = 0;
        while (i <= targetArray.length - patternArray.length && j < patternArray.length) {
            if (targetArray[i + j] == patternArray[j]) {
                j++;
            } else {
                i++;
                j = 0;
            }
        }
        //这个时候得到了一个i的下标和一个j的下标
        //注1：这里可以有很多判断方法，可以是j>p.length-1，也可以是i+j和target.length的比较
        //注2：必须是大于，即使是等于也不可以，而且最终j的值，要不是0，要不是length+1的值
        return j > patternArray.length - 1 ? i : -1;
    }

    public static void main(String[] args) {
        String target = "ababcabcacbab";
        String pattern = "abcac";
        Bf bf = new Bf();
        int index = bf.bf(target, pattern);
        System.out.println(index);
    }
}
