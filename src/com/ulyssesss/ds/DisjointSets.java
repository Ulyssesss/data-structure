package com.ulyssesss.ds;

/**
 * 不相交集合
 *
 * @author jiangyue
 */
public class DisjointSets {

    private int[] s;

    public DisjointSets(int count) {
        s = new int[count];
        for (int i = 0; i < count; i++) {
            s[i] = -1;
        }
    }

    public int find(int x) {
        if (s[x] < 0) {
            return x;
        }
        int root = find(s[x]);
        s[x] = root;
        return root;
    }

    public void union(int index1, int index2) {
        int root1 = find(index1);
        int root2 = find(index2);
        if (root1 != root2) {
            s[root2] = root1;
        }
    }
}
