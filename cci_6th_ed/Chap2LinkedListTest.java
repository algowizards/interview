public class Chap2LinkedListTest
{
	public static void main(String args[]){
		//TestDeleteDup();
		TestDeleteDupWithoutBuffer();
	}
	
	public static void TestDeleteDup(){
		
		MyLinkedList<Integer> list = MyLinkedList.GenerateTestLinkedListOfIntegers(5, true);
		list.Print();
		list.editNode(0,1);
		list.editNode(2,1);
		list.editNode(3,1);
		list.editNode(4,1);
		Chap2LinkedList.Q1RemoveDups(list.GetHead());
		list.Print();
	}
	
	public static void TestDeleteDupWithoutBuffer(){
		
		MyLinkedList<Integer> list = MyLinkedList.GenerateTestLinkedListOfIntegers(5, true);
		list.Print();
		list.editNode(0,1);
		list.editNode(2,1);
		list.editNode(3,1);
		list.editNode(4,1);
		Chap2LinkedList.Q1RemoveDupsNoBuffer(list.GetHead());
		list.Print();
	}
	
}