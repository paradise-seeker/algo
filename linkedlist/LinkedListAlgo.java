/**
 * 链表基础操作集合
 * 
 * @author hxl
 * 2018-12-02
 */

class LinkedList {
	private Node head;
	private Node tail;

	public Node getHead(){
		return head;
	}
	//头插法
	public void addNode(char ch) {
		 Node newNode=new Node(ch);
		 
		 if(head==null){
			 tail=newNode;
		 }
		 
		 newNode.next=head;
		 head=newNode;
	}
	//字符串集中插入
	public  void addString(String str){
		if(str.length()==0){
			return ;
		}
		
		char []ch=str.toCharArray();
		
		for(int i=0;i<ch.length;++i){
			addNode(ch[i]);
		}
	}
	//成环操作
	public  void toRing(){
		if(tail==null) return ;
		
		tail.next=head;
	}
	//解除环
	public void cannelRing(){
		if(tail==null) return ;
		
		tail.next=null;
	}
	// 检测环
	public static boolean checkCircle(Node list) {
		if (list == null) {
			return false;
		}

		Node slowNode = list;
		Node quickNode = list.next;

		while (quickNode != null && quickNode.next != null) {
			slowNode = slowNode.next;
			quickNode = quickNode.next.next;

			if (quickNode == slowNode) {
				return true;
			}
		}
		return false;
	}
	// 单链表反转
	public static Node reverse(Node list) {
		 Node headNode=null;
		 
         Node preNode=null;
         Node currentNode=list;
         Node nextNode=null;
         
        while(currentNode!=null){
        	 nextNode=currentNode.next;
        	 
        	 if(nextNode==null){
        		 headNode=currentNode;
        	 }
        	 
        	 currentNode.next=preNode;
        	 preNode=currentNode;
        	 currentNode=nextNode;
        	 }
         
        return headNode;
	}
	// 有序链表合并
	public static Node mergeSortedLists(Node la, Node lb) {
		if (la == null) return lb;
		if (lb == null) return la;
		
		Node nodeLA=la;
		Node nodeLB=lb;
		
		Node newHead=null;
		if(nodeLA.data<=nodeLB.data){
			newHead=nodeLA;
			nodeLA=nodeLA.next;
		}
		else{
			newHead=nodeLB;
			nodeLB=nodeLB.next;
		}
		
		Node newNode=newHead;
		
		while(nodeLA!=null&&nodeLB!=null){
			if(nodeLA.data<=nodeLB.data){
				   newNode.next=nodeLA;
		           nodeLA=nodeLA.next;
		    }
			else{
				newNode.next=nodeLB;
				nodeLB=nodeLB.next;
		    }
			newNode=newNode.next;
		}
		
		if(nodeLA!=null){
			newNode.next=nodeLA;
		}
		
		if(nodeLB!=null){
			newNode.next=nodeLB;
		}
		return newHead;
	}
	// 删除倒数第K个结点
	public static Node deleteLastKth(Node list, int k) {
	    Node quickNode=list;
		int i=1;
		
		while(quickNode!=null&&i<k){
			quickNode=quickNode.next;
			++i;
		}
		
		if(quickNode==null)  return list;
		
		Node slowNode=list;
		Node preNode=null;
		
		while(quickNode.next!=null){
			preNode=slowNode;
			slowNode=slowNode.next;
			quickNode=quickNode.next;
		}
		
		if(preNode==null){
			list=slowNode.next;
		}
		else{
		preNode.next=slowNode.next;
		}
		return list;
	}
	// 求中间结点
	public static Node findMiddleNode(Node list) {
		Node slowNode=list;
		Node quickNode=list;
		
		if(list==null)
			return null;
		
		while(quickNode.next!=null&&quickNode.next.next!=null){
			slowNode=slowNode.next;
			quickNode=quickNode.next.next;
		}
		return slowNode;
	}
	//遍历
	public static void travelList(Node list) {
		Node node=list;
		
		while(node!=null){
			System.out.print(node.data+" ");
			node=node.next;
		}
	}
    
	public static class Node {
		char data;
		Node next;

		public Node(char data) {
			this.data = data;
		}
	}
}
public class LinkedListAlgo{
	public static void main(String[] args) {
		LinkedList l1=new LinkedList();
		l1.addString("987321");
		
		LinkedList l2=new LinkedList();
		l2.addString("654");
		}
}
