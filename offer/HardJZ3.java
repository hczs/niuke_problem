
import java.util.ArrayList;
public class HardJZ3{
    /**
     * 从尾到头打印链表
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     * 两遍遍历？放到栈里面再出栈？
     * no，既然想到栈了，那递归也是可以的啊
     * 直接递归
     */
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}