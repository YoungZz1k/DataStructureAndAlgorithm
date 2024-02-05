package com.YoungZz1k.LeetCode.General.String;

/**
 * Z字形变换[mid]
 */
public class LeetCode6 {

    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     * 请你实现这个将字符串进行指定行数变换的函数：
     * string convert(string s, int numRows);
     * 示例 1：
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     * 示例 2：
     * 输入：s = "PAYP AL ISHI RING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * 0 1 2 3 45 6
     * 示例 3：
     * 输入：s = "A", numRows = 1
     * 输出："A"
     */
    public String convert(String s, int numRows) {
        if (s.length() <= 2 || numRows == 1) {
            return s;
        }
        if (s.length() == numRows){
            return s;
        }
        char[][] ch = new char[numRows][s.length()];
        int i = 0, j = 0, k = 0, preK = 0;
        if (numRows == 2) { // numRows == 2 特殊处理
            while (i < s.length() && k < s.length() * numRows) {

                while ( j < numRows && i < s.length()){
                    ch[j][k] = s.charAt(i);
                    i++;
                    if (j == 1){
                        j =0;
                        k++;
                        break;
                    }
                    j++;
                }
            }
        } else {
            while (i < s.length() && k < s.length() * numRows) {
                // 行优先
                if ((k - preK) % (numRows - 1) == 0 && i < s.length()) { // 按行排列
                    while (j < numRows && i < s.length()) {// 控制换行
                        ch[j][k] = s.charAt(i);
                        j++;
                        i++;
                    }
                    preK = k; // 记录上一次按行排列的位置
                    k++;// numRows行放完后 增1下一列
                } else {// z字展开
                    // j递减 k递增
                    j = numRows - 2;
                    while (j >= 0 && i < s.length()) {
                        ch[j][k] = s.charAt(i);
                        if ((k - preK) % (numRows - 1) == 0 && i < s.length()) {
                            j++;
                            i++;
                            break;
                        }
                        j--;
                        k++;
                        i++;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int l = 0; l < numRows; l++) {
            for (int m = 0; m < s.length(); m++) {
                if ((ch[l][m] >= 'a' && ch[l][m] <= 'z') || (ch[l][m] >= 'A' && ch[l][m] <= 'Z') || ch[l][m] == ',' || ch[l][m] == '.') {
                    sb.append(ch[l][m]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode6 leetCode6 = new LeetCode6();
        System.out.println(leetCode6.convert("PAYPALISHIRING", 4));
        System.out.println(leetCode6.convert("PAYPALISHIRING", 3));
        System.out.println(leetCode6.convert("ABC", 2));
        System.out.println(leetCode6.convert("hjouvsuyoypayulyeimuotehzriicfskpggkbbipzzrzucxamludfykgruowzgiooobppleqlwphapjnadqhdcnvwdtxjbmyppphauxnspusgdhiixqmbfjxjcvudjsuyibyebmwsiqyoygyxymzevypzvjegebeocfuftsxdixtigsieehkchzdflilrjqfnxztqrsvbspkyhsenbppkqtpddbuotbbqcwivrfxjujjddntgeiqvdgaijvwcyaubwewpjvygehljxepbpiwuqzdzubdubzvafspqpqwuzifwovyddwyvvburczmgyjgfdxvtnunneslsplwuiupfxlzbknhkwppanltcfirjcddsozoyvegurfwcsfmoxeqmrjowrghwlkobmeahkgccnaehhsveymqpxhlrnunyfdzrhbasjeuygafoubutpnimuwfjqsjxvkqdorxxvrwctdsneogvbpkxlpgdirbfcriqifpgynkrrefx", 503));
    }
}
