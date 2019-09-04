; https://projecteuler.net/problem=1
; Multiples of 3 and 5

; Problem 1
; If we list all the natural numbers below 10 that are multiples of 3 or 5,
; we get 3, 5, 6 and 9. The sum of these multiples is 23.

; Find the sum of all the multiples of 3 or 5 below 1000.

(use 'clojure.test)

(defn euler1
  ([] (euler1 1000))
  ([n]
    (defn multiple-of-3-or-5? [x]
      (or (zero? (mod x 3))
          (zero? (mod x 5))))
    (reduce + (filter multiple-of-3-or-5? (range 1 n)))))

(is (= 233168 (euler1)))
