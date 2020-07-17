import java.util.Scanner;

public class Main {

    // 有一个二维数组 (n * n), 写程序实现从右上角到左下角沿主对角线方向打印。
    // 给定一个二位数组 arr 及题目中的参数 n，请返回结果数组。

    // 测试样例：
    // [ [1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16] ], 4
    // 返回：[4, 3, 8, 2, 7, 12, 1, 6, 11, 16, 5, 10, 15, 9, 14, 13]

    // 边界的处理：
    // 1. 沿着主对角线打印，所以每次打印之后 x 与 y 都要加 1，直到 x 或 y 超出边界。
    // 2. 每轮遍历的起始点，是遵循 (0, n - 1)...（0, 0）...（n - 1, 0）.
    // 也就是 y 先减小到 0，然后 x 增加到 n - 1。
    // 所以遍历的终止条件是 xStart >= n
    public int[] arrayPrint(int[][] arr, int n) {
        int[] ret = new int[n * n];
        int xStart = 0;
        int yStart = n - 1;
        int index = 0;
        while (xStart < n) {
            int x = xStart;
            int y = yStart;
            while (x < n && y < n) {
                ret[index++] = arr[x++][y++];
            }
            if (yStart > 0) {
                yStart--;
            } else {
                xStart++;
            }
        }
        return ret;
    }
}

class Test {

    // 给定一个字符串，问是否能通过添加一个字母将其变为回文串。

    // 输入描述:
    // 一行一个由小写字母构成的字符串，字符串长度小于等于 10。
    // 输出描述:
    // 输出答案(YES \ NO).

    // 示例:
    // 输入
    // coco
    // 输出
    // YES
    
    public static void main1(String as[]){
        // 大神递归版
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String s=in.next();
            System.out.println(getAns(s.toCharArray(),0,s.length()-1,false)?"YES":"NO");
        }
    }
    private static boolean getAns(char[] a,int start,int end,boolean flag){
        if(end<=start){
            return true;
        }
        if(a[start]==a[end]){
            return getAns(a,start+1,end-1,flag);
        }
        else{
            if(flag){
                return false;
            }
            return getAns(a,start,end-1,true)||getAns(a,start+1,end,true);
        }
    }

    public static void main(String[] args) {
        // 非递归版
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String strs = sc.next();
            char[] chars = strs.toCharArray();
            int len = chars.length;
            if(len == 1) {
                System.out.println("YES");
                continue;
            }
            int count = 0;
            int i = 0;
            int j = len - 1;;
            int head = i;
            int tail = j;
            while (head < tail) {
                head = i;
                tail = j;
                if (chars[head] != chars[tail]) {
                    count += 1;
                    if (count >= 2) {
                        System.out.println("NO");
                        break;
                    }
                    if (chars[head + 1] != chars[tail] && chars[head] != chars[tail - 1]) {
                        System.out.println("NO");
                        break;
                    } else if (chars[head + 1] == chars[tail]){
                        i++;
                        continue;
                    }else if (chars[head] == chars[tail - 1]) {
                        j--;
                        continue;
                    }
                }
                i++;
                j--;
                if(i >= j) {
                    System.out.println("YES");
                    break;
                }
            }
        }
    }
}