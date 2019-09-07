; https://projecteuler.net/problem=4
; Largest palindrome product

; Problem 4
; A palindromic number reads the same both ways. The largest palindrome
; made from the product of two 2-digit numbers is 9009 = 91 × 99.

; Find the largest palindrome made from the product of two 3-digit numbers.

(use 'clojure.test)

(defn euler4
  ([] (euler4 3))
  ([n]
    (defn- expt [b e]
      (int (Math/pow b e)))
    (defn- palindrome? [m]
      (defn- rev [s]
        (String. (into-array Character/TYPE (reverse s))))
      (= (str m) (rev (str m))))

    (let [a (expt 10 (- n 1))
          b (expt 10 n)]
      (apply max
             (for [x (range a b)
                   y (range a b)
                   :when (palindrome? (* x y))] (* x y))))))

(is (= 9009 (euler4 2)))
(is (= 906609 (euler4)))
