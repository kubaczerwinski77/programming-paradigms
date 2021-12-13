// Jakub Czerwinski

// Zadanie 2a
def modifiedPascalF (n: Int) : List[Int]=
  if n == 0 then List(1)
  else
    val prev = modifiedPascalF(n - 1)
    1 :: prev.zip(prev.tail).map((k: (Int, Int)) => {
      if n % 2 == 0 then k._1 + k._2 else k._1 - k._2
    }) ::: List(1)

modifiedPascalF(0)
modifiedPascalF(1)
modifiedPascalF(2)
modifiedPascalF(3)
modifiedPascalF(4)
modifiedPascalF(5)
modifiedPascalF(6)
modifiedPascalF(7)

// Zadanie 2b
def modifiedPascalI (n: Int) : Array[Int] =
  val arr = Array.fill(n + 1)(1)
  var toIndex = 0
  var i = 0

  while toIndex <= n do
    i = toIndex - 1

    while i >= 1 do
      if (toIndex % 2 == 0)
      then arr(i) = arr(i - 1) + arr(i)
      else arr(i) = arr(i - 1) - arr(i)
      i -= 1
    toIndex += 1
  arr
    
modifiedPascalI(0)
modifiedPascalI(1)
modifiedPascalI(2)
modifiedPascalI(3)
modifiedPascalI(4)
modifiedPascalI(5)
modifiedPascalI(6)
modifiedPascalI(7)
