; https://projecteuler.net/problem=6
; Sum square difference

; Problem 6
; The sum of the squares of the first ten natural numbers is,

; 1^2 + 2^2 + ... + 10^2 = 385

; The square of the sum of the first ten natural numbers is,

; (1 + 2 + ... + 10)^2 = 55^2 = 3025

; Hence the difference between the sum of the squares of the first ten
; natural numbers and the square of the sum is 3025 − 385 = 2640.
;
; Find the difference between the sum of the squares of the first one
; hundred natural numbers and the square of the sum.

(use 'clojure.test)

(defn euler6
  ([] (euler6 100))
  ([n]
    (letfn [(sum-of-first-n-squares [k]
              (reduce + (map #(* % %) (range (inc k)))))
            (sum-of-first-n [k]
              (reduce + (range (inc k))))
            (square [k] (* k k))]
      (Math/abs (- (sum-of-first-n-squares n)
                   (square (sum-of-first-n n)))))))

(is (= 2640 (euler6 10)))
(is (= 25164150 (euler6)))
