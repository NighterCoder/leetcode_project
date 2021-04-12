package com.leetcode.study.bfs;

import java.util.*;

/**
 * 最短的桥
 * 不会做 需要加强记忆
 *
 * https://leetcode-cn.com/problems/shortest-bridge/
 */
public class ShortestBridge {

    public static void main(String[] args) {

    }


    public static int shortestBridge(int[][] A) {
        // 二维数组
        int R = A.length;
        int C = A[0].length;

        // 使用DFS搜索两个岛
        int[][] colors = getComponents(A);

        Queue<Node> queue = new LinkedList();
        Set<Integer> target = new HashSet();

        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (colors[r][c] == 1) {
                    queue.add(new Node(r, c, 0));
                } else if (colors[r][c] == 2) {
                    target.add(r * C + c);
                }
            }
        }

        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (target.contains(node.r+C+node.c)){
                return node.depth - 1;
            }

            for (int nei: neighbours(A, node.r, node.c)) {
                int nr = nei / C, nc = nei % C;
                if (colors[nr][nc] != 1) {
                    queue.add(new Node(nr, nc, node.depth + 1));
                    colors[nr][nc] = 1;
                }
            }
        }

        throw null;
    }


    /**
     * 两座孤岛,用1和2表示
     * @param A
     */
    public static int[][] getComponents(int[][] A){
        int R = A.length;
        int C = A[0].length;
        int[][] colors = new int[R][C];
        int t=0;

        for (int r0=0;r0<R;r0++){
            for (int c0 = 0; c0 < C; c0++) {
                if (colors[r0][c0]==0 && A[r0][c0] ==1 ){
                    // Start dfs
                    Stack<Integer> stack = new Stack<>();
                    // 压栈
                    stack.push(r0*C+c0);
                    colors[r0][c0] = ++t;

                    while (!stack.isEmpty()){
                        int node = stack.pop();
                        int r = node / C, c = node % C;
                        for (int nei:neighbours(A,r,c)) {
                            int nr=nei/C,nc=nei%C;
                            if (A[nr][nc] == 1 && colors[nr][nc] == 0) {
                                colors[nr][nc] = t;
                                stack.push(nr * C + nc);
                            }
                        }
                    }
                }
            }
        }
        return colors;
    }


    /**
     * 找到节点的四周元素
     * @param A
     * @param r
     * @param c
     */
    public static List<Integer> neighbours(int[][] A,int r,int c){
        int R = A.length, C = A[0].length;
        List<Integer> ans = new ArrayList();
        if (0 <= r-1) ans.add((r-1) * R + c);
        if (0 <= c-1) ans.add(r * R + (c-1));
        if (r+1 < R) ans.add((r+1) * R + c);
        if (c+1 < C) ans.add(r * R + (c+1));
        return ans;
    }



    static class Node {
        int r, c, depth;
        Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            depth = d;
        }
    }



}
