package algorithm.graph;
// 트리 순회
// https://m.blog.naver.com/PostView.nhn?blogId=occidere&logNo=220899936160&proxyReferer=https:%2F%2Fwww.google.com%2F

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1991 {
    static Node root = null;

    static class Node {
        char data;
        Node left, right;

        public Node(char data) {
            this.data = data;
        }
    }

    static class Tree {
        Node root;

        void add(char data, char left, char right) {
            if (root == null) {
                if (data != '.') root = new Node(data);
                if (left != '.') root.left = new Node(left);
                if (right != '.') root.right = new Node(right);
            } else search(root, data, left, right);
        }

        void search(Node root, char data, char left, char right) {
            if (root == null) return;
            if (root.data == data) { // 자리 발견
                if (left != '.') root.left = new Node(left);
                if (right != '.') root.right = new Node(right);
            } else {
                search(root.left, data, left, right);
                search(root.right, data, left, right);
            }
        }

        void preOrder(Node root){
            System.out.print(root.data);
            if (root.left != null) preOrder(root.left);
            if (root.right != null) preOrder(root.right);
        }

        void inOrder(Node root){
            if (root.left != null) inOrder(root.left);
            System.out.print(root.data);
            if (root.right != null) inOrder(root.right);
        }

        void postOrder(Node root){
            if (root.left != null) postOrder(root.left);
            if (root.right != null) postOrder(root.right);
            System.out.print(root.data);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char data = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.add(data, left, right);
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
        System.out.println();
    }
}
