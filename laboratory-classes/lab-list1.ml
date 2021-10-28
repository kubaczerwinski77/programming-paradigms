(* Jakub Czerwinski *)

(* Zadanie 1 *)
let reverse4 ((a:'a), (b:'b), (c:'c), (d:'d)) = 
    (d, c, b, a);;

reverse4(1, 2, 3, 4);;
reverse4('d', 'c', 3, 1);;

(* Zadanie 2 *)
let rec substitute (xs, x, y) = 
    if xs == [] then []
    else 
        if List.hd xs = x then y :: substitute(List.tl xs, x, y)
        else  List.hd xs :: substitute(List.tl xs, x, y);;

substitute([1;2;2;1;1], 1, 2);;
substitute([], 1, 2);;
substitute(['a'; 'b'; 'c'], 'a', 'c');;
    
(* Zadanie 3 *)
let rec insert (xs, elem, pos) =
    if xs = [] then []
    else 
        if pos < 1 then elem :: xs
        else List.hd xs :: insert(List.tl xs, elem, pos - 1);;

insert([1;2;3], 4, -1);;
insert([1;2;3], 4, 0);;
insert([1;2;3], 4, 1);;
insert([1;2;3], 4, 2);;
insert([1;2;3], 4, 3);;
insert([1;2;3], 4, 4);;
insert([1;2;3], 4, 5);;
