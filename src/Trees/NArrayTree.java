package Trees;

class NNode {
    String data;
    NNode[] child;
    NNode(String data) {
        this.data = data;
        this.child = new NNode[4];
    }
}
public class NArrayTree {
    public static void main(String[] args) {
        NNode root = new NNode("Root NNode");
        root.child[0] = new NNode("Child1");
        root.child[1] = new NNode("Child2");
        root.child[2] = new NNode("Child3");
        root.child[3] = new NNode("Child4");

        root.child[0].child[0] = new NNode("Child1-1");
        root.child[0].child[1] = new NNode("Child1-2");
        root.child[0].child[2] = new NNode("Child1-3");
        root.child[0].child[3] = new NNode("Child1-4");

        root.child[1].child[0] = new NNode("Child2-1");
        root.child[1].child[1] = new NNode("Child2-2");
        root.child[1].child[2] = new NNode("Child2-3");
        root.child[1].child[3] = new NNode("Child2-4");

        root.child[2].child[0] = new NNode("Child3-1");
        root.child[2].child[1] = new NNode("Child3-2");
        root.child[2].child[2] = new NNode("Child3-3");
        root.child[2].child[3] = new NNode("Child3-4");

        root.child[3].child[0] = new NNode("Child4-1");
        root.child[3].child[1] = new NNode("Child4-2");
        root.child[3].child[2] = new NNode("Child4-3");
        root.child[3].child[3] = new NNode("Child4-4");

        for(NNode r : root.child) {
            System.out.print(r.data + "=>");
            for(NNode c : r.child) {
                System.out.print(c.data + "=>");
            }
            System.out.println("NULL");
        }
    }
}
