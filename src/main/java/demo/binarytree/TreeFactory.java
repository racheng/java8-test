package demo.binarytree;
/**
 * Created by leicheng on 16-9-27.
 */
public class TreeFactory {

	public static TreeNode getTreeRoot() {
		TreeNode treeNode = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
				new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
		return treeNode;
	}
}
