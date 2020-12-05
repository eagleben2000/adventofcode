import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("input.txt");
		Scanner scan = new Scanner(f);

		int n = 200;
		int t = 2020;
		int[] data = new int[n];
		BinaryTree tree = new BinaryTree();

		for (int i = 0; i < n; i++) {
			int next = scan.nextInt();
			data[i] = next;
			tree.insert(next);
		}

		System.out.println("Pair that sums to 2020: " + findPair(data, tree, t));
		System.out.println("Pair that sums to 2020: " + findPair(data, t));
		System.out.println("Triple that sums to 2020: " + findPair(data, tree, t));

	}

	/*
	 * Part One: This solution finds a pair that sums to 2020 in 𝒪(𝑛⋅ℎ) where ℎ is
	 * the height of the binary tree. Using an AVL-Tree one could get ℎ = 𝑙𝑜𝑔₂ 𝑛
	 */

	public static int findPair(int[] data, BinaryTree tree, int target) {
		for (int k = 0; k < data.length; k++) {
			int num = data[k];
			int key = target - num;

			if (tree.search(key)) {
				if (num + key == target) {
					return num * key;
				}
			}
		}
		return -1;
	}
	/*
	 * Part One: This solution finds a pair that sums to 2020 in 𝒪(𝑛) using 𝒪(t)
	 * memory assuming all number are smaller than t.
	 */

	public static int findPair(int[] data, int t) {
		boolean[] exists = new boolean[t];
		for (int i = 0; i < data.length; i++) {
			exists[data[i]] = true;
		}
		for (int k = 0; k < data.length; k++) {
			int num = data[k];
			int key = t - num;

			if (exists[key]) {
				if (num + key == t) {
					return num * key;
				}
			}
		}
		return -1;
	}

	/*
	 * Part Two: This solution finds a triple that sums to 2020.
	 */
	public static int findTriple(int[] data, int t) {
		int n = data.length;

		// DP table
		int[][] A = new int[n][t];

		return -1;
	}
}

class Node {
	int key;
	Node left;
	Node right;

	Node(int key) {
		this.key = key;
		left = null;
		right = null;
	}
}

class BinaryTree {
	Node root;
	int size;

	public void insert(int key) {
		if (root == null) {
			size++;
			root = new Node(key);
		} else {
			insert(root, key);
		}
	}

	public void insert(Node node, int key) {
		if (node.key > key) {
			if (node.left == null) {
				size++;
				node.left = new Node(key);
			} else {
				insert(node.left, key);
			}
		} else if (node.key < key) {
			if (node.right == null) {
				size++;
				node.right = new Node(key);
			} else {
				insert(node.right, key);
			}
		} else {
			return;
		}
	}

	public boolean search(int key) {
		if (root == null) {
			return false;
		} else {
			return search(root, key);
		}
	}

	public boolean search(Node node, int key) {
		if (node == null) {
			return false;
		} else if (node.key > key) {
			return search(node.left, key);
		} else if (node.key < key) {
			return search(node.right, key);
		} else {
			return true;
		}
	}

}
