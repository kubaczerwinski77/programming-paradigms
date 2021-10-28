(* Jakub Czerwinski *)

(* Zadanie 1 *)
let rec find xs x =
  match xs with
    [] -> false 
    | h :: t when h = x -> true
    | _ :: t -> find t x;;

find [1; 2] 3;;
find [1; 2] 1;;
find [] 5;;

let find123 = find [1; 2; 3];;
find123 3;;
find123 5;;

let findabc = find ['a'; 'b'; 'c'];;
findabc 'a';;
findabc 'x';;

(* Zadanie 2 *)
let rec split2Rec xs =
  match xs with
    [] -> ([], [])
    | [x] -> ([], [x])
    | h1 :: h2 :: t -> 
      let (left, right) = split2Rec t
      in (h1 :: left, h2 :: right);;

split2Rec [];;
split2Rec [1; 2; 3; 4];;
split2Rec [1; 2; 3];;
split2Rec [1];;
split2Rec ["Ala"; "ma"; "kota"];;

let split2Tail xs =
  let rec splitIter(xs, alist, blist, n) =
    if xs = [] then (alist, blist)
    else 
      if n mod 2 = 0 then splitIter(List.tl xs, List.hd xs :: alist, blist, n + 1)
      else splitIter(List.tl xs, alist, List.hd xs :: blist, n + 1)
  in splitIter(xs, [], [], 0);;

split2Tail [];;
split2Tail [1; 2; 3; 4];;
split2Tail [1; 2; 3];;
split2Tail [1];;
split2Tail ["Ala"; "ma"; "kota"];;
