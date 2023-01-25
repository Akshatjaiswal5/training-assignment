class QuadraticProbing implements CollisionHandler
{
 ProbingNode[] hashTable;
 int capacity;

 public int add(int val)
 {
  int hashKey=HashAlgorithm.calculateHash(val)%capacity;
  if(hashTable[hashKey]==null)
  {
   hashTable[hashKey]=new ProbingNode(val);
   return 0;
  }

  int i=1;
  while(true)
  {
   if((hashKey+i)%capacity==hashKey)
    throw new RuntimeException("Loop reached");
   if(hashTable[(hashKey+i*i)%capacity]==null)
   {
    hashTable[i]=new ProbingNode(val);
    break;
   }
   i++;
  }
  
  return 1;
 }

 public QuadraticProbing(int capacity)
 {
  this.hashTable=new ProbingNode[capacity];
  this.capacity=capacity;
 }
}