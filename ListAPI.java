public class ListAPI<E>{
  private int capacity; //total capacity of underlying array
  private int length;
  private E arrayList[];


  //constructor
  public ListAPI(int capacity){
    this.capacity = capacity;
    this.length = 0;
    arrayList[capacity] = null;
  } //IntArrayList(int)

  //default constructor
  public ListAPI(){
    this(10);
  } //IntArrayList()

  //retuns element at given index i
  public E get(int i){
    E returnElement = null;
    if(isValid(i)){
      returnElement = arrayList[i];
    } //if
    return returnElement;
  } //get(int)

  //sets index i to new element e and returns old elements
  private E set(int i, E e){
    E oldElement = null;
    if(isValid(i)){
      oldElement = arrayList[i];
      arrayList[i] = e;
    }
    return oldElement;
  } //set(int, T)

  //appends given integer e to the end of list
  public void add(E e){
    if(isFull()){
      resize(capacity*2);
    } //if
    arrayList[length] = e;
    length++;
  } //add(T)

  //inserts given integer e at given index i
  public void add(int i, E e){
    if(isFull()){
      resize(capacity*2);
    } //if
    for(int index = length-1; index > i; index--){
      arrayList[index+1] = arrayList[index];
    } //for
    arrayList[i] = e;
    length++;
  } //insert(int, T)

  //removes an element at given index, and returns it
  public E remove(int i){
    E removedElement = arrayList[i];
    if(isValid(i)){
      if(i < length-1){
        for (int j = i+1; j < length+1; j++){
          arrayList[j-1] = arrayList[j];
        } //for
      } else {
        arrayList[i] = null;
      }//if else
      length--;
      if (length < capacity/4){
          resize(capacity/2);
      }//if
    } //if
    return removedElement;
  } //remove(int)

  //removes first instance of element e. returns true if successful, false otherwise
  public boolean remove(E e){
    int index = indexOf(e);
    if(index == -1){
      return false;
    } //if
    remove(index);
    return true;
  } //remove(T)

  //returns the index of first instance of element e, and -1 if it does not exist
  public int indexOf(E e){
    for(int index = 0; index < length-1; index++){
      if(arrayList[index] == e){
        return index;
      } //if
    } //for
    return -1;
  } //indexOf(T)

  //returns number of elements in list
  public int size(){
    return length;
  } //size()

  //returns true if list is empty, false if not
  public boolean isEmpty(){
    return length == 0;
  } //isEmpty()

  //returns true if array is full, false if not
  private boolean isFull(){
    return length == capacity;
  } //isFull()

  //creates new underlying array of different size
  private void resize(int newCapacity){
    E oldArray[] = arrayList;
    arrayList[newCapacity] = null;
    for(int i = 0; i < length; i++){
      arrayList[i] = oldArray[i];
    } //for
    oldArray = null;
    capacity = newCapacity;
  } //resize

  //returns true if given element e is in the list, false if not
  public boolean contains(E e){
    for(int i = 0; i < length; i++){
      if(arrayList[i] == e){
        return true;
      } //if
    } //for
    return false;
  } //contains(T)

  private boolean isValid(int i){
    return i < 0 || i >= length;
  } //isValid(int)

  public static void main(String[] args){


  } //main()

} //class
