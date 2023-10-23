public class test {
    public static void main(String[] args) {
        int j = Integer.MAX_VALUE - 1;
        int i = 0;
        int m = (i + j) / 2;
        System.out.println(m);
        i = m + 1;
        m = (i + j) >>> 1;
        System.out.println(m);
    }
}
