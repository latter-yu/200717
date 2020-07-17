public class Test {
    public int getLCA(int a, int b) {

        // 有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。
        // 现在有两个结点 a，b。请设计一个算法，求出 a 和 b 点的最近公共祖先的编号。
        // 给定两个 int a, b 为给定结点的编号。
        // 请返回 a 和 b 的最近公共祖先的编号。
        // 注意这里结点本身也可认为是其祖先。

        // 测试样例：
        // 2，3
        // 返回：1

        // 2, 6
        // 返回：1

        // parent = child / 2;
        int aParent = 0;
        int bParent = 1;
        while (aParent != bParent) {
            // a 与 b 不一定是同层节点
            if (a > b) {
                aParent = a / 2;
                a = aParent;
            } else if (a < b) {
                bParent = b / 2;
                b = bParent;
            } else if (a == b) {
                aParent = a / 2;
                bParent = b / 2;
                a = aParent;
                b = bParent;
            }
        }
        return aParent;
    }

    public String replaceSpace(String iniString, int length) {

        // 请编写一个方法，将字符串中的空格全部替换为 “ %20 ”。
        // 假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于 1000)，
        // 同时保证字符串由大小写的英文字母组成。
        // 给定一个 string iniString 为原始的串，以及串的长度 int len, 返回替换后的 string。

        // 测试样例：
        // "Mr John Smith”, 13
        // 返回："Mr%20John%20Smith"
        // ”Hello  World”, 12
        // 返回：”Hello%20%20World”
        
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char chars = iniString.charAt(i);
            if (chars == ' ') {
                str.append("%20");
            } else {
                str.append(chars);
            }
        }
        return str.toString();
    }
}
