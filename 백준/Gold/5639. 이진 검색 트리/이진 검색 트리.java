import java.util.Scanner;
import java.util.Stack;

class TreeNode{
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    int value = -1;
    boolean state = false;
    public TreeNode(int value){
        this.left = null;
        this.right = null;
        this.parent = null;
        this.value = value;
    }
    public void insert(int num){
        if(num<this.value){
            if(this.left == null){
                this.left = new TreeNode(num);
                this.left.parent = this;
            }else {
                this.left.insert(num);
            }
        }else{
            if(this.right == null){
                this.right = new TreeNode(num);
                this.right.parent = this;
            }else {
                this.right.insert(num);
            }
        }
    }
}
public class Main {
    public static void back(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode current = root;
        TreeNode temp;
        while(!stack.isEmpty()){
            if(current.left!=null&& !current.left.state){
                stack.add(current.left);
                current.left.state = true;
                current = current.left;
            } else if (current.right!=null&& !current.right.state) {
                stack.add(current.right);
                current.right.state = true;
                current = current.right;
            }else{
                temp = stack.pop();
                current = temp.parent;
                System.out.println(temp.value);
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int rootInt = s.nextInt();
        TreeNode root = new TreeNode(rootInt);
        while(s.hasNext()){
            String get = s.next();
            int getNum = Integer.parseInt(get);
            root.insert(getNum);
        }
        back(root);

    }
}