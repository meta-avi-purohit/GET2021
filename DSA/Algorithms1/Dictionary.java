import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import org.json.*;

class KeyAndValue {
	private int key;
	private String value;

	public KeyAndValue(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}

class TreeNode {
	private KeyAndValue data;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(KeyAndValue data) {
		this.data = data;
		this.setLeft(null);
		this.setRight(null);
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getKey() {
		return data.getKey();
	}

	public void setData(KeyAndValue data) {
		this.data = data;
	}

	public KeyAndValue getData() {
		return data;
	}

	public String getValue() {
		return data.getValue();
	}
}

class BinarySearchTree {
	private TreeNode root;

	BinarySearchTree() {
		this.root = null;
	}

	BinarySearchTree(List<KeyAndValue> keys) {
		this();
		for (int i = 0; i < keys.size(); i++) {
			addNode(keys.get(i));
		}
	}

	/**
	 * Function to Add a Node to the Tree
	 * @param data
	 */
	public void addNode(KeyAndValue data) {
		TreeNode newNode = new TreeNode(data);
		if (root == null) {
			root = newNode;
		} else {
			TreeNode currNode = root;
			while (true) {
				if (currNode.getKey() > newNode.getKey()
						&& currNode.getLeft() == null) {
					currNode.setLeft(newNode);
					break;
				} else if (currNode.getKey() < newNode.getKey()
						&& currNode.getRight() == null) {
					currNode.setRight(newNode);
					break;
				} else if (currNode.getKey() > newNode.getKey()) {
					currNode = currNode.getLeft();
				} else {
					currNode = currNode.getRight();
				}
			}
		}
	}

	/**
	 * Function to get the Value of a specific key
	 * @param key
	 * @return
	 */
	public String getValue(int key) {
		String value = "";
		TreeNode currNode = root;
		while (currNode != null) {
			if (key > currNode.getData().getKey()) {
				currNode = currNode.getLeft();
			} else if (key < currNode.getData().getKey()) {
				currNode = currNode.getRight();
			} else {
				value = currNode.getData().getValue();
				break;
			}
		}
		return value;
	}

	/**
	 * Function to traversal of the Tree  
	 * @param currNode
	 * @param list
	 */
	public void inOrder(TreeNode currNode, List<KeyAndValue> list) {
		if (currNode == null) {
			return;
		}
		inOrder(currNode.getLeft(), list);
		list.add(currNode.getData());
		inOrder(currNode.getRight(), list);
	}

	/**
	 * Function to sort
	 * @return
	 */
	public List<KeyAndValue> sort() {
		List<KeyAndValue> list = new ArrayList<KeyAndValue>();
		inOrder(root, list);
		return list;
	}

	/**
	 * Traversal of the tree from k1 to k2
	 * @param currNode
	 * @param list
	 * @param k1
	 * @param k2
	 */
	public void inOrder(TreeNode currNode, List<KeyAndValue> list, int k1,
			int k2) {
		if (currNode == null) {
			return;
		}
		inOrder(currNode.getLeft(), list, k1, k2);
		if (currNode.getData().getKey() >= k1
				&& currNode.getData().getKey() <= k2) {
			list.add(currNode.getData());
		}
		inOrder(currNode.getRight(), list, k1, k2);
	}

	/**
	 * return the list of node present between k1 to k2
	 * @param k1
	 * @param k2
	 * @return
	 */
	public List<KeyAndValue> sort(int k1, int k2) {
		List<KeyAndValue> list = new ArrayList<>();
		inOrder(root, list, k1, k2);
		return list;
	}

	/**
	 * Function to delete
	 * @param key
	 */
	public void delete(int key) {
		root = deleteNode(root, key);
	}

	/**
	 * delete a specific key data
	 * @param currNode
	 * @param key
	 * @return
	 */
	public TreeNode deleteNode(TreeNode currNode, int key) {
		if (currNode == null) {
			return currNode;
		}
		if (key < currNode.getKey()) {
			currNode.setLeft(deleteNode(currNode.getLeft(), key));
		} else if (key > currNode.getKey()) {
			currNode.setRight(deleteNode(currNode.getRight(), key));
		} else {
			if (currNode.getLeft() == null) {
				return currNode.getRight();
			} else if (currNode.getRight() == null) {
				return currNode.getLeft();
			} else {
				currNode.setData(minNext(currNode.getRight()));
				currNode.setRight(deleteNode(currNode.getRight(),
						currNode.getKey()));
			}
		}
		return currNode;
	}

	public KeyAndValue minNext(TreeNode currNode) {
		KeyAndValue min = currNode.getData();
		while (currNode.getLeft() != null) {
			min = currNode.getLeft().getData();
			currNode = currNode.getLeft();
		}
		return min;
	}

	public void inOrder(TreeNode currNode) {
		if (currNode == null) {
			return;
		}
		inOrder(currNode.getLeft());
		System.out.println(currNode.getData().getKey() + " "
				+ currNode.getData().getValue());
		inOrder(currNode.getRight());
	}

	public void displayTree() {
		inOrder(root);
	}
}

public class Dictionary {
	public static void main(String[] args) {

		List<KeyAndValue> result = new ArrayList<>();

		try {
			String text = new String(Files.readAllBytes(Paths
					.get("D:\\data.json")), StandardCharsets.UTF_8);
			JSONObject obj = new JSONObject(text);
			Iterator<String> keys = obj.keys();
			while (keys.hasNext()) {
				String key = keys.next();
				result.add(new KeyAndValue(Integer.parseInt(key), obj.get(key)
						.toString()));
			}

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		BinarySearchTree tree = new BinarySearchTree(result);
		System.out.println("################################");
		tree.displayTree();
		tree.delete(1);
		System.out.println("################################");
		tree.displayTree();
		System.out.println("################################");
		List<KeyAndValue> B = tree.sort(7, 18);
		for (int i = 0; i < B.size(); i++) {
			System.out.println(B.get(i).getKey());
		}
	}
}
