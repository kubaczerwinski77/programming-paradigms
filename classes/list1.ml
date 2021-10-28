(* Jakub Czerwinski *)

(* Zadanie 1 *)
let rec flatten1 (xss)=
    if xss = [] then []
    else List.hd xss @ flatten1 (List.tl xss);;

flatten1 [[5;6];[1;2;3]] = [5;6;1;2;3];;
flatten1 [[1;2];[];[3;4]] = [1;2;3;4];;
flatten1 [[];[1;2]] = [1;2];;
flatten1 [[];[]] = [];;

(* Zadanie 2 *)
let rec count(a, xss) : int = 
    if xss <> [] then (
        if List.hd xss = a then count(a, List.tl xss) + 1
        else count(a, List.tl xss)
    )
    else 0;;

count('a', ['a';'l';'a']) = 2;;
count('A', ['a';'A';'4']) = 1;;
count(1, []) = 0;;
count(2, [2;3;2;3;2]) = 3;;

(* Zadanie 3 *)
let rec replicate (x, n) =
    if n < 0 then raise (Failure "Negative argument")
    else (
        if n = 0 then []
        else x :: replicate(x, n - 1)
    );;

replicate("la", 3) = ["la"; "la"; "la"];;
replicate("a", 1) = ["a"];;
replicate(3, 2) = [3; 3];;
replicate("5", 0) = [];;
replicate("", 2) = ["";""];;
(* replicate("32", -5);; *)

(** Zadanie 4 *)
let rec sqrList (xs) = 
    if xs = [] then []
    else (List.hd xs * List.hd xs) :: sqrList (List.tl xs);;
sqrList [1; 2; 3; -4] = [1; 4; 9; 16];;
sqrList [] = [];;
sqrList [-10] = [100];;


(** Zadanie 5 *)
let palindrome (xs) = 
    if xs = (List.rev xs) then true
    else false;;

palindrome ['a'; 'l'; 'a'] = true;;
palindrome [] = true;;
palindrome ['k'; 'u'; 'b'; 'a'] = false;;
palindrome [1; 2; 1] = true;;


(** Zadanie 6 *)
let rec listLength (xs) =
    if xs = [] then 0
    else listLength(List.tl xs) + 1;;

listLength [1; 2] = 2;;
listLength [] = 0;;
(*listLength [1; 'a'; "Ala"] = 3;;*)
listLength [[]; []] = 2;
