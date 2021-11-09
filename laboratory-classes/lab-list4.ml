(* Jakub Czerwinski *)

(* Zadanie 1a *)
type 'a tree3 = Empty | Node of 'a * 'a tree3 * 'a tree3 * 'a tree3;;

let t = Node(1, Node(2, Empty, Empty, Empty), Node(3, Empty, Node(4, Empty, Empty, Empty), Empty), Node(5, Empty, Empty, Empty));;
let tt = Node(1, Empty, Empty, Empty);;
let ttt = Empty;;

(* Zadanie 1b *)
let rec mapTree3 = function f -> function tree ->
  match tree with
    Empty -> Empty
    | Node(v, l, m, r) -> Node(f v, mapTree3 f l, mapTree3 f m, mapTree3 f r)
;;

mapTree3 (fun x -> x * x) t;;
mapTree3 (fun x -> x + 1) tt;;
mapTree3 (fun x -> x - 10) ttt;

(* Zadanie 2a *)
type word = Word of char * string;;
type typeOfSent = Affirmative | Question | Exclamation;;
type sentence = Sentence of word * word list * typeOfSent;;
type text = Text of sentence * sentence list;;

let wordToString (Word(first, other)) pred =
  if pred then String.make 1 (Char.uppercase_ascii first) ^ other
  else String.make 1 first ^ other;;

let w1 = Word('k', "uba");;
wordToString w1 true;;
wordToString w1 false;;

let sentenceToString (Sentence(first, other, typeOf)) =
  let sign = match typeOf with
    Affirmative -> "."
    | Question -> "?"
    | Exclamation -> "!"
  in
    match other with
      [] -> wordToString first true ^ sign
      | list -> List.fold_left (fun sentence word -> sentence ^ " " ^ word)
                               (wordToString first true)
                               (List.map (fun x -> wordToString x false) list) ^ sign
;;

let s1 = Sentence(Word('h', "ere"), [Word('w', "e"); Word('g', "o"); Word('a', "gain")], Exclamation);;
sentenceToString s1;;

let textToString (Text(first, other)) =
  List.fold_left (fun text sentence -> text ^ " " ^ sentence)(sentenceToString first)(List.map (fun x -> sentenceToString x) other);;

let t1 = Text(Sentence(Word('h', "ere"), [Word('w', "e"); Word('g', "o"); Word('a', "gain")], Exclamation), [Sentence(Word('l', "ubie"), [Word('p', "lacki")], Affirmative); Sentence(Word('a', ""), [Word('t', "y")], Question)]);;
let t2 = Text(Sentence(Word('q', ""), [], Exclamation), []);;

textToString t1;;
textToString t2;;