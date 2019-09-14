; https://projecteuler.net/problem=14
; Longest Collatz sequence

; Problem 14
; The following iterative sequence is defined for the set of positive integers:

; n → n/2 (n is even)
; n → 3n + 1 (n is odd)

; Using the rule above and starting with 13, we generate the following sequence:

; 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

; It can be seen that this sequence (starting at 13 and finishing at 1)
; contains 10 terms. Although it has not been proved yet (Collatz Problem),
; it is thought that all starting numbers finish at 1.

; Which starting number, under one million, produces the longest chain?

; NOTE: Once the chain starts the terms are allowed to go above one million.

(use 'clojure.test)

(defn collatz [n]
  (letfn [(collatz-elem [k] (if (odd? k) (+ (* 3 k) 1) (/ k 2)))]
    (concat (take-while #(not (= % 1)) (iterate collatz-elem n)) (list 1))))

(defn euler14
  "it return the number under n that produces the longest Collatz chain."
  ([] (euler14 1000000))
  ([n]
    (letfn [(collect [k] (hash-map :count (count (collatz k)), :n k))]
      (:n (apply max-key :count (map collect (rest (range n))))))))


(is (= 10 (count (collatz 13))))
(is (= 837799 (euler14)))
