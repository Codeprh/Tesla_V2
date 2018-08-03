package swordFingerOffer;

/**
 * 替换空格
 * 题目：请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为 We Are Happy. 则经过替换之后的字符串为 We%20Are%20Happy。
 * <p>
 * 解题思路
 * <p>
 * 在字符串尾部填充任意字符，使得字符串的长度等于字符串替换之后的长度。因为一个空格要替换成三个字符（%20），因此当遍历到一个空格时，需要在尾部填充两个任意字符。
 * <p>
 * 令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和 P2从后向前遍历，当 P1 遍历到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。
 * <p>
 * 从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容。
 */
public class d3_ReplaceSpace {


    public static void main(String[] args) {
        String str = "we are happy";
        long start = System.currentTimeMillis();
        String res = str.replaceAll(" ", "%20");
        System.out.println(res + "耗时为" + (System.currentTimeMillis() - start));
        long start2 = System.currentTimeMillis();
        String res2 = replaceSpace(new StringBuffer(str));
        System.out.println(res2 + "耗时为" + (System.currentTimeMillis() - start2));

    }

    public static String repalceSpaceMe(StringBuilder str) {
        
        return null;
    }

    public static String replaceSpace(StringBuffer str) {
        int oldLen = str.length();
        for (int i = 0; i < oldLen; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");

        int P1 = oldLen - 1, P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }
}
