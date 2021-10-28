// Jakub Czerwinski

// Zadanie 1
def reverse4[A, B, C, D]  (tuple : (A, B, C, D)) = {
    (tuple._4, tuple._3, tuple._2, tuple._1)
}

reverse4(1, 2, 3, 4)
reverse4('D', 'C', 'B', 'A')
reverse4(1, 2.2, 'a', 'A')

// Zadanie 2
def substitute[A] (xs : List[A], x:A, y:A) : List[A] = {
    if xs == List() then List()
    else {
        if xs.head == x then y :: (substitute(xs.tail, x, y))
        else xs.head :: substitute(xs.tail, x, y)
    }
}

substitute(List(1,2,3,1), 1, 5)
substitute(List(), 1, 2)
substitute(List(1,2,3), 4, 5)
substitute(List('A', 'B', 'B'), 'B', 'C')

// Zadanie 3
def insert[A] (xs : List[A], elem : A, pos : Int) : List[A] = {
    if xs == List() then List()
    else {
        if pos < 1 then elem :: xs
        else xs.head :: insert(xs.tail, elem, pos - 1)
    }
}

insert(List(1, 2, 3, 4), 5, -1)
insert(List(1, 2, 3, 4), 5, 0)
insert(List(1, 2, 3, 4), 5, 1)
insert(List(1, 2, 3, 4), 5, 2)
insert(List(1, 2, 3, 4), 5, 3)

insert(List(1, 2, 3, 4), 5, 4)
insert(List(1, 2, 3, 4), 5, 5)
