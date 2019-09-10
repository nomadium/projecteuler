; https://projecteuler.net/problem=10
; Summation of primes

; Problem 10
; The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

; Find the sum of all the primes below two million.

(use 'clojure.test)

(defn euler10
  "it returns the sum of all the primes below n."
  ([] (euler10 2000000))
  ([n]
    (letfn [(prime? [k]
              (and (>= k 2) (every? pos? (map #(mod k %) (range 2 k)))))]

      ; to-do: need to review this approach because it takes hours to
      ; calculate the solution. However, I think the code is clear enough.
      (reduce + (take-while #(< % n) (filter prime? (range)))))))

(is (= 17 (euler10 10)))
(is (= 142913828922 (euler10)))
