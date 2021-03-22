import java.util.*;

class TreeNode {
	private String dirName;
	private List<TreeNode> child = new ArrayList<>();
	private Date createDate;
	private TreeNode parent;

	TreeNode(String dirname) {
		this.dirName = dirname;
		this.parent = null;
		this.createDate = new Date();
	}

	public TreeNode getParent() {
		return parent;
	}

	public String returnDate() {
		return createDate.toString();
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public void addChild(TreeNode node) {
		child.add(node);
	}

	public String getDirName() {
		return dirName;
	}

	public List<TreeNode> getChild() {
		return child;
	}
}

public class VirtualCommandPrompt {
	public TreeNode root;

	VirtualCommandPrompt() {
		root = new TreeNode("R:");
		System.out.println("Welcome to the Virtual Command Prompt");
	}

	/**
	 * Function create a directory of passed name
	 * 
	 * @param dirname
	 * @return
	 */
	public String createDirectory(String dirname) {
		String message = "Directory Created";
		List<TreeNode> list = root.getChild();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getDirName().equals(dirname)) {
				root = list.get(i);
				message += "Directory Already Present";
				return message;
			}
		}
		TreeNode newDir = new TreeNode(dirname);
		newDir.setParent(root);
		root.addChild(newDir);
		return message;
	}

	/**
	 * Function to change directory to given diretory
	 * 
	 * @param dirname
	 * @return
	 */
	public String changeDirectory(String dirname) {
		String message = "";
		List<TreeNode> list = root.getChild();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getDirName().equals(dirname)) {
				root = list.get(i);
				return message;
			}
		}
		message = "Directory Not Found";
		return message;
	}

	/**
	 * Change the current directory to parent directory
	 * 
	 * @return
	 */
	public String back() {
		String message = "";
		if (root.getParent() == null) {
			message += "Already in Root Directory";
		} else {
			root = root.getParent();
		}
		return message;
	}

	/**
	 * Display the data of current directory
	 * 
	 * @return
	 */
	public List<String> displayData() {
		List<String> data = new ArrayList<>();
		String time = "";
		for (int i = 0; i < root.getChild().size(); i++) {
			time += root.getChild().get(i).returnDate() + "  "
					+ root.getChild().get(i).getDirName() + " "
					+ root.getChild().get(i).getChild().size() + " Folders";
			data.add(time);
			time = "";
		}
		return data;
	}

	/**
	 * To find the location of current directory
	 * 
	 * @param name
	 * @return
	 */
	public List<String> findDir(String name) {
		List<String> s = new ArrayList<>();
		int i = 0;
		checkAllFolder(name, i, root, s, 0);
		for (i = 0; i < s.size(); i++) {
			System.out.println(s.get(i));
			;
		}
		return s;
	}

	public String getName(TreeNode currNode) {
		String dirname = "";
		while (currNode != root) {
			dirname = "\\" + currNode.getDirName() + dirname;
			currNode = currNode.getParent();
		}
		return (".." + dirname);
	}

	public void checkAllFolder(String name, int index, TreeNode currNode,
			List<String> s, int childIndex) {
		if (currNode.getChild().size() <= childIndex) {
			return;
		} else if (currNode.getChild().get(childIndex).getDirName()
				.equals(name)) {
			s.add(getName(currNode));
		}
		checkAllFolder(name, index, currNode.getChild().get(childIndex), s,
				childIndex);
		while (index + 1 < currNode.getChild().size()) {
			if (currNode.getChild().get(index + 1).getDirName().equals(name)) {
				s.add(getName(currNode));
			}
			index += 1;
			checkAllFolder(name, index, currNode.getChild().get(index), s, 0);
		}
	}

	/**
	 * Show the tree structure of directories
	 */
	public void treeCommand() {
		showTree(root, 0, 0, 0, root);
	}

	public void showTree(TreeNode currNode, int index, int check, int count,
			TreeNode root) {
		if (check == 0) {
			System.out.println(currNode.getDirName());
			if (currNode.getChild().size() > index
					&& currNode.getChild().size() != 0) {
				for (int i = 0; i < 5 * count; i++)
					System.out.print(" ");
				System.out.print('\u2514');
				for (int i = 0; i < 5; i++)
					System.out.print('\u2500');
			}
		}
		if (currNode.getChild().size() <= index) {
			return;
		} else if (check == 1 && currNode == root && currNode != this.root) {
			for (int i = 0; i < 5 * count; i++)
				System.out.print(" ");
			System.out.print('\u2514');
			for (int i = 0; i < 5; i++)
				System.out.print('\u2500');
		} else if (currNode == this.root && check == 1) {
			System.out.print('\u2514');
			for (int i = 0; i < 5; i++)
				System.out.print('\u2500');
		}
		showTree(currNode.getChild().get(index), 0, 0, count + 1, currNode);
		showTree(currNode, index + 1, 1, count, currNode);
	}

	public String presentDirectory() {
		String dir = "";
		TreeNode reverse = root;
		while (reverse != null) {
			if (reverse.getParent() == null)
				dir = reverse.getDirName() + dir;
			else
				dir = ("\\" + reverse.getDirName() + dir);
			reverse = reverse.getParent();
		}
		return dir;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		VirtualCommandPrompt V = new VirtualCommandPrompt();
		String task[];
		while (true) {
			System.out.print(V.presentDirectory() + "> ");
			task = scan.nextLine().split(" ");
			if (task[0].equals("mkdir")) {
				if (task.length == 1) {
					System.out.println("Syntax of the command is incorrect.");
				} else {
					System.out.println(V.createDirectory(task[1]));
				}
			} else if (task[0].equals("cd")) {
				if (task.length == 1) {
					System.out.println("Syntax of the command is incorrect.");
				} else {
					System.out.println(V.changeDirectory(task[1]));
				}
			} else if (task[0].equals("ls") && task.length == 1) {
				List<String> data = V.displayData();
				for (int i = 0; i < data.size(); i++) {
					System.out.println(data.get(i));
				}
			} else if (task[0].equals("bk") && task.length == 1) {
				System.out.println(V.back());
			} else if (task[0].equals("find") && task.length == 2) {
				V.findDir(task[1]);
			} else if (task[0].equals("tree") && task.length == 1) {
				V.treeCommand();
			} else if (task[0].equals("exit") && task.length == 1) {
				break;
			} else {
				System.out.println("Command Not Found...");
			}
		}
		scan.close();
	}
}