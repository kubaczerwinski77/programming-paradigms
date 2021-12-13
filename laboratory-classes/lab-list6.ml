(* Jakub Czerwinski *)
(* Testowanie *)
let arr = [| 1; 2; 3 |];;
arr.(1);;

arr.(1) <- 5;;
arr;;

(* Zadanie 1 *)
let (+=) arr1 arr2 =
  if Array.length arr1 <> Array.length arr2 then invalid_arg "Arrays are not the same length" else
  let i = ref 0 in
  while !i < Array.length arr1 do
    arr1.(!i) <- arr1.(!i) + arr2.(!i);
    i := !i + 1;
  done;
  print_newline();;

let arr1 = [| 1; 2; 3 |];;
let arr2 = [| 1; 2; 3 |];;
let arr3 = [| 1; 2 |];;

(* test 1 *)
arr1 += arr2;;
arr1;;

(* test 2 *)
(* arr1 += arr3;;
arr1;; *)

(* test 3 *)
arr1 += arr1;;
arr1;;
