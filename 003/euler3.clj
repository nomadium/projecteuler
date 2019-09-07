; https://projecteuler.net/problem=3
; Largest prime factor

; Problem 3
; The prime factors of 13195 are 5, 7, 13 and 29.

; What is the largest prime factor of the number 600851475143 ?

(use 'clojure.test)

(defn euler3
  ([] (euler3 600851475143))
  ([n]
    (defn- candidate-factors [m]
      (filter #(or (odd? %) (= % 2))
              (range 2 (inc (int (Math/ceil (Math/sqrt m)))))))

    (defn- prime? [m]
      (or (= m 2)
          (every? pos? (map #(mod m %) (candidate-factors m)))))

    (defn- factors [m]
      (filter #(zero? (mod m %)) (candidate-factors m)))

    (if (empty? (factors n))
        n
        (apply max (filter prime? (factors n))))))

(is (= 6857 (euler3)))
(is (= 29 (euler3 13195)))
(is (= 7 (euler3 7)))
