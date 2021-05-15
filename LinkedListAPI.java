public class LinkedListAPI {
	class ListNode{
		private int data;
		private ListNode next;

		public ListNode() {
			this(0);
		}

		public ListNode(int data) {
			this(data, null);
		}

		public ListNode(int data, ListNode next) {
			this.data = data;
			this.next = next;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public ListNode getNext() {
			return next;
		}

		public void setNext(ListNode next) {
			this.next = next;
		}


	}

	private ListNode head;
	private ListNode tail;
	private int nodeCount;

	public LinkedListAPI() {
		head = null;
		tail = null;
		nodeCount = 0;
	}

  public void add(int e, int i){
    if(i == 0){
      addFirst(e);
    } else if(i == nodeCount){
      addLast(e);
    } else {
      ListNode newNode = new ListNode(e);
      ListNode temp = head;
      for(int j = 0; j < i-1; j++){
        temp = temp.getNext();
      }
      newNode.setNext(temp.getNext());
      temp.setNext(newNode);
      nodeCount++;
    }
  }

	public void add(int e){
    ListNode newNode = new ListNode(e);
    if(isEmpty()){
      head = newNode;
    } else {
      tail.setNext(newNode);
    }
    tail = newNode;
    nodeCount++;
  }

  public void addFirst(int e){
    ListNode newNode = new ListNode(e);
    if(isEmpty()){
      tail = newNode;
    } else {
      newNode.setNext(head);
    }
    head = newNode;
    nodeCount++;
  }

  public void addLast(int e){
    ListNode newNode = new ListNode(e);
    if(isEmpty()){
      head = newNode;
    } else {
      tail.setNext(newNode);
    }
    tail = newNode;
    nodeCount++;
  }

  public boolean contains(int i){
    ListNode temp = head;
    while(temp != null){
      if(temp.getData() == i){
        return true;
      }
      temp = temp.getNext();
    }
    return false;
  }

  public int remove(int i){
		if(i < 0 || i > nodeCount){
			//ERROR
		}
		if(i == 0){
			return removeFirst();
		}
		if(i == nodeCount-1){
			return removeLast();
		}
		ListNode temp = head;
		for(int j = 0; j< i-1; j++){
			temp=temp.getNext();
		}
		int removedElement = temp.getNext().getData();
		temp.setNext(temp.getNext().getNext());
		nodeCount--;
		return removedElement;
  }

  public int removeFirst(){
		if(isEmpty()){
			//ERROR
		}
		int returnElement = head.getData();
		head = head.getNext();
		if(nodeCount == 1){
			tail = null;
		}
		nodeCount--;
		return returnElement;
  }

  public int removeLast(){
		if(isEmpty()){
			//ERROR
		}
		int returnElement = tail.getData();
		ListNode temp = head;
		for(int j = 1; j < nodeCount-1; j++){
			temp = temp.getNext();
		}
		tail = temp;
		if(nodeCount == 1){
			head = null;
		}
		nodeCount--;
		return returnElement;
  }

	public int size() {
		return nodeCount;
	}

  private boolean isEmpty(){
    return nodeCount == 0;
  }
	/*
	 * This method should print the list elements in order
	 * for example: if the linkedlist has three element 3, 5, 8
	 * this method would print following:
	 * 3-> 5-> 8
	 *
	 * then if add element 10 at the beginning (addFirst) and
	 * then call this method, it will print following:
	 * 10-> 3-> 5-> 8
	 * */
	public void printList() {
		ListNode temp = head;
		for(int i = 0; i < nodeCount; i++){
			System.out.print(temp.getData() + " --> ");
			temp = temp.getNext();
		}
		System.out.println();
	}

	public static void main(String[] args){
		LinkedListAPI test = new LinkedListAPI();
		test.add(1);
		test.printList(); //should print 1
		test.addFirst(2);
		test.printList(); //2 --> 1
		test.addLast(9);
		test.printList(); //2, 1, 9
		test.add(10, 2);
		test.printList(); //2, 1, 10, 9
		System.out.println(test.contains(1)); //true
		System.out.println(test.contains(85)); //false
		test.removeFirst();
		test.printList(); //1, 10, 9
		test.removeLast();
		test.printList(); //1, 10
		test.addLast(4);
		test.addLast(26); //1, 10, 4, 26
		test.remove(2);
		test.printList(); //1, 10, 26
	}
}
