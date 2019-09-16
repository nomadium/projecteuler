; https://projecteuler.net/problem=21
; Amicable numbers

; Problem 21
; Let d(n) be defined as the sum of proper divisors of n (numbers less than n
; which divide evenly into n).
; If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair
; and each of a and b are called amicable numbers.

; For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
; 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
; 71 and 142; so d(284) = 220.

; Evaluate the sum of all the amicable numbers under 10000.

(use 'clojure.test)

(defn euler21
  "it returns the sum of all the amicable numbers under n."
  ([] (euler21 10000))
  ([n]
    (letfn [(proper-divisors [k] (filter #(zero? (mod k %)) (range 1 k)))
            (d [k] (reduce + (proper-divisors k)))
            (search-amicable-numbers-under [k]
              (for [x (range n)
                    y (range n)
                    :when (and (not (= x y)) (= (d x) y) (= (d y) x))]
                [x y]))
            (amicable-numbers-under [k]
              (seq (set (flatten (search-amicable-numbers-under k)))))]

      (reduce + (amicable-numbers-under n)))))


(is (= 31626 (euler21)))
