// Jakub Czerwinski

// Zadanie 1
def flatten1[A] (xss : List[List[A]]) : List[A] = {
  if xss == List() then List()
  else xss.head ::: flatten1(xss.tail)
}

flatten1(List(List(5, 6), List(1, 2, 3))) == List(5, 6, 1, 2, 3)
flatten1(List(List(1, 2), List(), List(3, 4))) == List(1, 2, 3, 4)
flatten1(List(List("Ala"), List(4.5, true))) == List("Ala", 4.5, true)
flatten1(List(List(), List(1, 2))) == List(1, 2)
flatten1(List(List(), List())) == List()
flatten1(List()) == List()

// Zadanie 2
def count[A] (x : A, xs : List[A]) : Int = {
  if xs.length != 0 then {
    if xs.head == x then 1 + count(x, xs.tail)
    else count(x, xs.tail)
  }
  else 0
}

count('a', List('a', 'l', 'a')) == 2
count('a', List('a', 'A', 4)) == 1
count(1, List()) == 0
count(2, List(22, 2, 22, 2, 0 , 2)) == 3

// Zadanie 3
def replicate[A] (x : A, n : Int) : List[A] = {
  if n < 0 then throw new Exception("Negative argument")
  else {
    if n == 0 then List()
    else x :: replicate(x, n - 1)
  }
}

replicate("la", 3) == List("la", "la", "la")
replicate("a", 1) == List("a")
replicate(3, 2) == List(3, 3)
replicate("5", 0) == List()
replicate("", 3) == List("", "", "")
// replicate("kuba", -5)

// Zadanie 4
def sqrList (xs : List[Int]) : List[Int] = {
  if xs.length == 0 then List()
  else (xs.head * xs.head) :: sqrList(xs.tail)
}

val sqrList1 = sqrList _

sqrList(List(1, 2, 3, -4)) == List(1, 4, 9, 16)
sqrList(List()) == List()
sqrList(List(-1, -2, -3, 0)) == List(1, 4, 9, 0)

// Zadanie 5
def palindrome[A] (xs : List[A]) : Boolean = {
  if xs.reverse == xs then true
  else false
}

palindrome(List('a', 'l', 'a')) == true
palindrome(List()) == true
palindrome(List(1, 2, 1)) == true
palindrome(List('k', 'u', 'b', 'a')) == false

// Zadanie 6
def listLength[A] (xs : List[A]) : Int = {
  if xs == List() then 0
  else 1 + listLength(xs.tail)
}

listLength(List(1, 2)) == 2
listLength(List()) == 0
listLength(List("A", 3, 4.0)) == 3
listLength(List(List())) == 1