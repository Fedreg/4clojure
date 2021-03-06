(ns exs.clj
  (:require
   [clojure.string :as str]
   [clojure.test   :refer :all]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; test all solutions (...ones with 'with-test')
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(run-tests 'exs.clj)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 1
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(is (= true true))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 2
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(is (= (- 10 (* 2 3)) 4))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 3
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(is (= "HELLO WORLD" (.toUpperCase "hello world")))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 4
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(is (= (list :a :b :c)'(:a :b :c)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 5
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(is (= '(1 2 3 4) (conj '(2 3 4) 1)))
(is (= '(1 2 3 4) (conj '(3 4) 2 1)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 6
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 7
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc7 [1 2 3 4])

  (is (= fc7 (conj [1 2 3] 4)))
  (is (= fc7 (conj [1 2] 3 4))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 8
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc8 #{:a :b :c :d})

(is (= fc8 (set '(:a :a :b :c :c :c :c :d :d))))
(is (= fc8 (clojure.set/union #{:a :b :c} #{:b :c :d}))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 9
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(= #{1 2 3 4} (conj #{1 4 3} 2))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 10
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc10 20)

  (is (= fc10 ((hash-map :a 10, :b 20, :c 30) :b)))
  (is (= fc10 (:b {:a 10, :b 20, :c 30}))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 11
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(= {:a 1, :b 2, :c 3} (conj {:a 1} {:b 2} [:c 3]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 12
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc12 3)

  (is (= fc12 (first '(3 2 1))))
  (is (= fc12 (second [2 3 4])))
  (is (= fc12 (last (list 1 2 3)))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 13
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(= [20 30 40] (rest [10 20 30 40]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 14
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc14 8)

  (is (= fc14 ((fn add-five [x] (+ x 5)) 3)))
  (is (= fc14 ((fn [x] (+ x 5)) 3)))
  (is (= fc14 (#(+ % 5) 3)))
  (is (= fc14 ((partial + 5) 3))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 15
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc15 #(* 2 %))

  (is (= (fc15 2) 4))
  (is (= (fc15 3) 6))
  (is (= (fc15 11) 22))
  (is (= (fc15 7) 14)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 16
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc16 #(str "Hello, " % "!"))

  (is (= (fc16  "Dave") "Hello, Dave!"))
  (is (= (fc16  "Jenn") "Hello, Jenn!"))
  (is (= (fc16  "Rhea") "Hello, Rhea!")))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 17
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

'(6 7 8)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 18
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

'(6 7)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 19
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc19 #(first (reverse %)))

  (is (= (fc19 [1 2 3 4 5]) 5))
  (is (= (fc19 '(5 4 3)) 3))
  (is (= (fc19 ["b" "c" "d"]) "d")))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 20
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc20 #(-> % butlast reverse first))

  (is (= (fc20 (list 1 2 3 4 5)) 4))
  (is (= (fc20 ["a" "b" "c"]) "b"))
  (is (= (fc20 [[1 2] [3 4]]) [1 2])))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 21
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc21 [s n]
    (last (take (inc n) s)))

  (is (= (fc21 '(4 5 6 7) 2) 6))
  (is (= (fc21 [:a :b :c] 0) :a))
  (is (= (fc21 [1 2 3 4] 1) 2))
  (is (= (fc21 '([1 2] [3 4] [5 6]) 2) [5 6])))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 22
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc22 [s]
    (.length (vec s)))

  (is (= (fc22 '(1 2 3 3 1)) 5))
  (is (= (fc22 "Hello World") 11))
  (is (= (fc22 [[1 2] [3 4] [5 6]]) 3))
  (is (= (fc22 '(13)) 1))
  (is (= (fc22 '(:a :b :c)) 3)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 23
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc23 [s]
    (into '() s))

  (is (= (fc23 [1 2 3 4 5]) [5 4 3 2 1]))
  (is (= (fc23 (sorted-set 5 7 2 7)) '(7 5 2)))
  (is (= (fc23 [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 24
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc24 [a]
    (reduce + a))

  (is (= (fc24 [1 2 3]) 6))
  (is (= (fc24 (list 0 -2 5 5)) 8))
  (is (= (fc24 #{4 2 1}) 7))
  (is (= (fc24 '(0 0 -1)) -1))
  (is (= (fc24 '(1 10 3)) 14)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 25
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc25 [coll]
    (filter odd? coll))

  (is (= (fc25 #{1 2 3 4 5}) '(1 3 5)))
  (is (= (fc25 [4 2 1 6]) '(1)))
  (is (= (fc25 [2 2 4 6]) '()))
  (is (= (fc25 [1 1 1 3]) '(1 1 1 3))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 26
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def fib
  (lazy-cat
   [1 1]
   (map + fib (rest fib))))

(with-test
  (defn fc26 [n]
    (take n fib))

  (is (= (fc26 3) '(1 1 2)))
  (is (= (fc26 6) '(1 1 2 3 5 8)))
  (is (= (fc26 8) '(1 1 2 3 5 8 13 21))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 27
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc27 [s]
    (let [cnt   (count s)
          split (if (odd? cnt) (/ (dec cnt) 2) (/ cnt 2))]
      (= (take split s) (take split (reverse s)))))

  (is (false? (fc27 '(1 2 3 4 5))))
  (is (true?  (fc27 "racecar")))
  (is (true?  (fc27 [:foo :bar :foo])))
  (is (true?  (fc27 '(1 1 3 3 1 1))))
  (is (false? (fc27 '(:a :b :c)))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 28
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc28 [s]
    (filter (complement sequential?)
          (rest (tree-seq sequential? seq s))))

  (is (= (fc28 '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)))
  (is (= (fc28 ["a" ["b"] "c"]) '("a" "b" "c")))
  (is (= (fc28 '((((:a))))) '(:a))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 29
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc29 [s]
    (->> s
         (filterv #(re-matches #"[A-Z]" (str %)))
         clojure.string/join))

  (is (= (fc29 "HeLlO, WoRlD!") "HLOWRD"))
  (is (empty? (fc29 "nothing")))
  (is (= (fc29 "$#A(*&987Zf") "AZ")))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 30
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn deduper [acc s]
  (let [xs   (first s)
        ss   (last acc)
        ys   (rest s)
        dup? (= xs ss)]
    (if (empty? ys)
      (reverse (into '() (if-not dup? (conj acc xs) acc)))
      (deduper (if-not dup? (conj acc xs) acc) ys))))

(with-test
  (defn fc30 [s]
    (deduper [] s))

  (is (= (apply str (fc30 "Leeeeeerrroyyy")) "Leroy"))
  (is (= (fc30 [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)))
  (is (= (fc30 [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 31
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc31 [s]
    (partition-by identity s))

  (is (= (fc31 [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3))))
  (is (= (fc31 [:a :a :b :b :c]) '((:a :a) (:b :b) (:c))))
  (is (= (fc31 [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 32
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc32 [s]
    (mapcat (fn [i] [i i]) s))

  (is (= (fc32 [1 2 3]) '(1 1 2 2 3 3)))
  (is (= (fc32 [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)))
  (is (= (fc32 [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))
  (is (= (fc32 [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 33
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc33 [s n]
    (mapcat #(repeat n %) s))

  (is (= (fc33 [1 2 3] 2) '(1 1 2 2 3 3)))
  (is (= (fc33 [:a :b] 4) '(:a :a :a :a :b :b :b :b)))
  (is (= (fc33 [4 5 6] 1) '(4 5 6)))
  (is (= (fc33 [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4])))
  (is (= (fc33 [44 33] 2) [44 44 33 33])))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 34
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc34 [start end]
    (loop [n start
           l '()]
      (if (< n end)
        (do
          (conj l n)
          (recur (inc n) (conj l n)))
        (sort l))))

  (is (= (fc34 1 4) '(1 2 3)))
  (is (= (fc34 -2 2) '(-2 -1 0 1)))
  (is (= (fc34 5 8) '(5 6 7))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 35
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc35 7)

  (is (= fc35 (let [x 3, y 10] (- y x))))
  (is (= fc35 (let [x 21] (let [y 3] (/ x y))))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 36
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc36 nil)

  (is (= 10 (let [x 7 y 3 z 1] (+ x y))))
  (is (= 4  (let [x 7 y 3 z 1] (+ y z))))
  (is (= 1  (let [x 7 y 3 z 1] z))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 37
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 38
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc38 [& n]
    (last (sort n)))

  (is (= (fc38 1 8 3 4) 8))
  (is (= (fc38 30 20) 30))
  (is (= (fc38 45 67 11) 67)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 39
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc39 [a b]
    (mapcat #(conj [] %1 %2) a b))

  (is (= (fc39 [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c)))
  (is (= (fc39 [1 2] [3 4 5 6]) '(1 3 2 4)))
  (is (= (fc39 [1 2 3 4] [5]) [1 5]))
  (is (= (fc39 [30 20] [25 15]) [30 25 20 15])))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 40
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc40 [v s]
    (butlast (mapcat #(conj [] % v) s)))

  (is (= (fc40 0 [1 2 3]) [1 0 2 0 3]))
  (is (= (apply str (fc40 ", " ["one" "two" "three"])) "one, two, three"))
  (is (= (fc40 :z [:a :b :c :d]) [:a :z :b :z :c :z :d])))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 41
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc41 [s n]
    (let [occurances (/ (count s) n)
          filters    (map dec (range n (inc (* n occurances)) n))
          block      (map #(nth s %) filters)]
      (filter #(not (contains? (set block) %)) s)))

  (is (= (fc41 [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]))
  (is (= (fc41 [:a :b :c :d :e :f] 2) [:a :c :e]))
  (is (= (fc41 [1 2 3 4 5 6] 4) [1 2 3 5 6])))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 42
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc42 [n]
    (reduce * (range 1 (inc n))))

  (is (= (fc42 1) 1))
  (is (= (fc42 3) 6))
  (is (= (fc42 5) 120))
  (is (= (fc42 8) 40320)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 43
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc43 [s n]
    (apply map list (partition n s)))

  (is (= (fc43 [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6))))
  (is (= (fc43 (range 9) 3) '((0 3 6) (1 4 7) (2 5 8))))
  (is (= (fc43 (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 44
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc44 [n s]
    (let [len  (count s)
          posn (if (> n 0) n (- n))
          -n   (cond
                 (> n len)   (- n len)
                 (> posn len)(- posn (dec len))
                 (< n 0)     (- len posn)
                 :else       n)]
      (concat (drop -n s) (take -n s))))

  (is (= (fc44 2 [1 2 3 4 5]) '(3 4 5 1 2)))
  (is (= (fc44 -2 [1 2 3 4 5]) '(4 5 1 2 3)))
  (is (= (fc44 6 [1 2 3 4 5]) '(2 3 4 5 1)))
  (is (= (fc44 1 '(:a :b :c)) '(:b :c :a)))
  (is (= (fc44 -4 '(:a :b :c)) '(:c :a :b))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 45
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc45 '(1 4 7 10 13))

  (is (= fc45 (take 5 (iterate #(+ 3 %) 1)))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 46
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc46 [f]
    (fn [& args]
      (eval (conj (reverse args) f))))

  (is (= 3 ((fc46 nth) 2 [1 2 3 4 5])))
  (is (= true ((fc46 >) 7 8)))
  (is (= 4 ((fc46 quot) 2 8)))
  (is (= [1 2 3] ((fc46 take) [1 2 3 4 5] 3))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 47
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(contains? #{4 5 6} 4)
(contains? [1 1 1 1 1] 1)
(contains? {4 :a 2 :b} :a)
(not (contains? [1 2 4] 3))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 48
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc48 6)

  (is (= fc48 (some #{2 7 6} [5 6 7 8])))
  (is (= fc48 (some #(when (even? %) %) [5 6 7 8]))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 49
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc49 [n s]
    (conj [] (vec (take n s)) (vec (drop n s))))

  (is (= (fc49 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]]))
  (is (= (fc49 1 [:a :b :c :d]) [[:a] [:b :c :d]]))
  (is (= (fc49 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 50
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc50 [s]
    (vals (group-by #(type %) s)))

  (is (= (set (fc50 [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]}))
  (is (= (set (fc50 [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]}))
  (is (= (set (fc50 [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 51
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc51 [1 2 3 4 5])

  (is (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] fc51] [a b c d]))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 52
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc52 [2 4])

  (is (= [2 4] (let [[a b c d e] [0 1 2 3 4]] fc52))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 53
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; This is terrible but works. refactor
(defn increase? [acc v]
  (let [xs (first  v)
        ss (second v)
        ys (rest v)]
    (if (empty? ys)
      acc
      (if (and (= xs (dec ss))
               (not= xs (last acc)))
        (recur (conj acc xs ss) (drop 2 v))
        (if (or (> (count acc) (count ys))
                (not= (first ys)
                      (dec (second ys))))
          acc
          (recur (if (not-empty acc)
                   (conj [] (last acc))
                   []) ys))))))

(with-test
  (defn fc53 [v]
    (increase? [] v))

  (is (= (fc53 [1 0 1 2 3 0 4 5]) [0 1 2 3]))
  (is (= (fc53 [5 6 1 3 2 7]) [5 6]))
  (is (= (fc53 [2 3 3 4 5]) [3 4 5]))
  (is (= (fc53 [7 6 5 4]) [])))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 54
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn split [acc n s]
  (let [xs (take n s)
        ys (drop n s)]
    (if (> n (count ys))
      (reduce conj '() (conj acc xs))
      (recur (conj acc xs) n ys))))

(with-test
  (defn fc54 [n s]
    (split '() n s))

  (is (= (fc54 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8))))
  (is (= (fc54 2 (range 8)) '((0 1) (2 3) (4 5) (6 7))))
  (is (= (fc54 3 (range 8)) '((0 1 2) (3 4 5)))))

;;;;5;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 55
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc55 [s]
    (reduce-kv
     (fn [m k v] (assoc m k (count v)))
     {}
     (group-by identity s)))

  (is (= (fc55 [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1}))
  (is (= (fc55 [:b :a :b :a :b]) {:a 2, :b 3}))
  (is (= (fc55 '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 56
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; cheated with the vector? thing but works
(with-test
  (defn fc56 [s]
    (if-not (vector? (first s))
      (sort (map first (vals (group-by identity s))))
      (map first (vals (group-by identity s)))))

  (is (= (fc56 [1 2 1 3 1 2 4]) [1 2 3 4]))
  (is (= (fc56 [:a :a :b :b :c :c]) [:a :b :c]))
  (is (= (fc56 '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3])))
  (is (= (fc56 (range 50)) (range 50))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 57
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc57 '(5 4 3 2 1))

(is (= fc57 ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 58
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc58 [& fns]
    (fn [& args]
    (first
     (reduce (fn [res f]
               (list (apply f res)))
             args
             (reverse fns)))))

  (is (= [3 2 1] ((fc58 rest reverse) [1 2 3 4])))
  (is (= 5       ((fc58 (partial + 3) second) [1 2 3 4])))
  (is (= true    ((fc58 zero? #(mod % 8) +) 3 5 7 9)))
  (is (= "HELLO" ((fc58 #(.toUpperCase %) #(apply str %) take) 5 "hello world"))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 59
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc59 [& fns]
    (fn [& args]
       (reduce (fn [res f]
                (conj res (apply f args)))
              []
              fns)))

  (is (= [21 6 1] ((fc59 + max min) 2 3 5 1 6 4)))
  (is (= ["HELLO" 5] ((fc59 #(.toUpperCase %) count) "hello")))
  (is (= [2 6 4] ((fc59 :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 60
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; this one took a long time!
(with-test
  (defn fc60
    ([f a b]
     (let [xs (first b)
           ys (rest b)]
       (lazy-seq (cons a (when (not-empty b)
                           (fc60 f (f a xs) ys))))))
    ([f a]
     (fc60 f (first a) (rest a))))

  (is (= (take 5 (fc60 + (range))) [0 1 3 6 10]))
  (is (= (fc60 conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]]))
  (is (= (last (fc60 * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 61
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc61 [vk vv]
    (reduce merge (map #(assoc {} %1 %2) vk vv)))

  (is (= (fc61 [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3}))
  (is (= (fc61 [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"}))
  (is (= (fc61 [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 62
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc62 [f a]
    (cons a (lazy-seq (fc62 f (f a)))))

  (is (= (take 5 (fc62 #(* 2 %) 1)) [1 2 4 8 16]))
  (is (= (take 100 (fc62 inc 0)) (take 100 (range))))
  (is (= (take 9 (fc62 #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 63
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc63 [f s]
    (let [a (reduce (fn [acc n] (conj acc {(f n) n})) [] s)]
      (reduce (fn [m data]
                (let [k (-> data keys first)
                      v (-> data vals first)]
                (if (get m k)
                  (update-in m [k] conj v)
                  (assoc m k [v]))))
              {}
              a)))

 (is (= (fc63 #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]}))
 (is (= (fc63 #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
        {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]}))
 (is (= (fc63 count [[1] [1 2] [3] [1 2 3] [2 3]])
        {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 64
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc64 +)

  (is (= 15 (reduce fc64 [1 2 3 4 5])))
  (is (=  0 (reduce fc64 [])))
  (is (=  6 (reduce fc64 1 [2 3]))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 65
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc65 [coll]
    (cond
      (true? (clojure.string/starts-with? (str coll) "[")) :vector
      (true? (clojure.string/starts-with? (str coll) "#")) :set
      (true? (clojure.string/starts-with? (str coll) "{")) :map
      :else                                                :list))

  (is (= :map (fc65 {:a 1, :b 2})))
  (is (= :list (fc65 (range (rand-int 20)))))
  (is (= :vector (fc65 [1 2 3 4 5 6])))
  (is (= :set (fc65 #{10 (rand-int 5)})))
  (is (= [:map :set :vector :list] (map fc65 [{} #{} [] ()]))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 66
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc66 [a b]
    (if (zero? b)
      a
      (recur b (mod a b))))

  (is (= (fc66 2 4) 2))
  (is (= (fc66 10 5) 5))
  (is (= (fc66 5 7) 1))
  (is (= (fc66 1023 858) 33)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 67
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn prime? [n]
  (if
    (some true? (map (fn [a] (zero? (mod n a))) (range 2 n)))
    false
    true))

(with-test
  (defn fc67 [n]
    (take n (filter #(and (prime? %)
                          (< 1 %))(range))))

  (is (= (fc67 2) [2 3]))
  (is (= (fc67 5) [2 3 5 7 11]))
  (is (= (last (fc67 100)) 541)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 68
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(list 7 6 5 4 3)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 69
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc69 [f & ms]
    (reduce-kv (fn [m k v]
                 (if (some? (get m k))
                   (assoc m k (f (get m k) v))
                   (assoc m k v)))
               (first ms)
               (into {} (rest ms))))

  (is (= (fc69 * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
         {:a 4, :b 6, :c 20}))
  (is (= (fc69 - {1 10, 2 20} {1 3, 2 10, 3 15})
         {1 7, 2 10, 3 15}))
  (is (= (fc69 concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
         {:a [3 4 5], :b [6 7], :c [8 9]})))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 70
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Lame Solution; fix
(defn third [s]
  (when (>= (count s) 3)
    (nth s 2)))

(defn fourth [s]
  (when (>= (count s) 4)
    (nth s 3)))

(defn fifth [s]
  (when (>= (count s) 5)
    (nth s 4)))

(with-test
  (defn fc70 [s]
    (as-> s -s
      (clojure.string/split -s #" ")
      (sort-by #((juxt first second third fourth fifth)
                 (clojure.string/lower-case %)) -s)
      (mapv #(clojure.string/replace % #"[!.]" "") -s)))

  (is (= (fc70  "Have a nice day.")
         ["a" "day" "Have" "nice"]))
  (is (= (fc70  "Clojure is a fun language!")
         ["a" "Clojure" "fun" "is" "language"]))
  (is (= (fc70  "Fools fall for foolish follies.")
         ["fall" "follies" "foolish" "Fools" "for"])))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 71
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc71 last)

  (is (= (fc71 (sort (rest (reverse [2 5 4 1 3 6]))))
         (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (fc71))
         5)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 72
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc72 (partial reduce +))

  (is (= (fc72 (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
         (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (fc72))
         11)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 73
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Lame Solution; fix
(with-test
  (defn fc73 [board]
    (let [snb  #(set (nth board %))
          vert #(mapv (fn [arr] (nth arr %)) board)
          sv   #(set (vert %))
          ldiag? (= (get-in board [0 0])
                    (get-in board [1 1])
                    (get-in board [2 2]))
          rdiag? (= (get-in board [0 2])
                    (get-in board [1 1])
                    (get-in board [2 0]))]
      (cond
          (and
            (= 1 (count (snb 0)))
            (= :e (first (snb 0))))         nil
          (= 1 (count (snb 0)))  (first (snb 0))
          (= 1 (count (snb 1)))  (first (snb 1))
          (= 1 (count (snb 2)))  (first (snb 2))
          (= 1 (count (sv 0)))   (first (sv 0))
          (= 1 (count (sv 1)))   (first (sv 1))
          (= 1 (count (sv 2)))   (first (sv 2))
          ldiag?                 (get-in board [0 0])
          rdiag?                 (get-in board [0 2])
          :else nil)))

  (is (= nil (fc73 [[:e :e :e]
                    [:e :e :e]
                    [:e :e :e]])))
  (is (= :x (fc73  [[:x :e :o]
                    [:x :e :e]
                    [:x :e :o]])))
  (is (= :o (fc73  [[:e :x :e]
                    [:o :o :o]
                    [:x :e :x]])))
  (is (= nil (fc73 [[:x :e :o]
                    [:x :x :e]
                    [:o :x :o]])))
  (is (= :x (fc73  [[:x :e :e]
                    [:o :x :e]
                    [:o :e :x]])))
  (is (= :o (fc73  [[:x :e :o]
                    [:x :o :e]
                    [:o :e :x]])))
  (is (= nil (fc73 [[:x :o :x]
                    [:x :o :x]
                    [:o :x :o]]))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 74
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn perfect-square? [n]
  (str/ends-with? (str (Math/sqrt n)) ".0"))

(with-test
  (defn fc74 [s]
    (let [splits (str/split s #",")
          ints   (mapv #(Integer/parseInt %) splits)]
      (str/join "," (filter perfect-square? ints))))

(is (= (fc74 "4,5,6,7,8,9") "4,9"))
(is (= (fc74 "15,16,25,36,37") "16,25,36")))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 75
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;Two numbers are coprime if their greatest common divisor equals 1. Euler's totient function f(x) is defined as the number of positive integers less than x which are coprime to x. The special case f(1) equals 1. Write a function which calculates Euler's totient function.
(with-test
  (defn fc75 [n]
    :TODO)

  (is (= (fc75 1) 1))
  (is (= (fc75 10) (count '(1 3 7 9)) 4))
  (is (= (fc75 40) 16))
  (is (= (fc75 99) 60)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 76
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;The trampoline function takes a function f and a variable number of parameters. Trampoline calls f with any parameters that were supplied. If f returns a function, trampoline calls that function with no arguments. This is repeated, until the return value is not a function, and then trampoline returns that non-function value. This is useful for implementing mutually recursive algorithms in a way that won't consume the stack.
(with-test
  (defn fc76 [f & xs]
    :TODO
    )
  (is (= fc76
         (letfn
             [(foo [x y] #(bar (conj x y) y))
              (bar [x y] (if (> (last x) 10)
                           x
                           #(foo x (+ 2 y))))]
           (trampoline foo [] 1)))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 77
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;Write a function which finds all the anagrams in a vector of words. A word x is an anagram of word y if all the letters in x can be rearranged in a different order to form y. Your function should return a set of sets, where each sub-set is a group of words which are anagrams of each other. Each sub-set should have at least two words. Words without any anagrams should not be included in the result.

(with-test
  (defn fc77 [n]
    :TODO )

  (is (= (fc77 ["meat" "mat" "team" "mate" "eat"])
         #{#{"meat" "team" "mate"}}))
  (is (= (fc77 ["veer" "lake" "item" "kale" "mite" "ever"])
         #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 78
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;Reimplement the function described in "Intro to Trampoline".
(with-test
  (defn fc78 [x]
    :TODO)

  (is (= (letfn [(triple [x] #(sub-two (* 3 x)))
                 (sub-two [x] #(stop?(- x 2)))
                 (stop? [x] (if (> x 50) x #(triple x)))]
           (fc78 triple 2))
         82))
  (is (= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
                 (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
           (map (partial fc77 my-even?) (range 6)))
         [true false true false true false])))
Special Restrictions
trampoline

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 79
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;Write a function which calculates the sum of the minimal path through a triangle. The triangle is represented as a collection of vectors. The path should start at the top of the triangle and move to an adjacent number on the next row until the bottom of the triangle is reached.
(with-test
  (defn fc79 [x]
    :TODO)

  (is (= 7 (fc79 '([1]
                   [2 4]
                   [5 1 4]
                   [2 3 4 5])))) ; 1->2->1->3
  (is (= 20 (fc79 '([3]
                    [2 4]
                    [1 9 3]
                    [9 9 2 4]
                    [4 6 6 7 8]
                    [5 7 3 5 1 4]))))) ; 3->4->3->2->7->1

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 80
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;A number is "perfect" if the sum of its divisors equal the number itself. 6 is a perfect number because 1+2+3=6. Write a function which returns true for perfect numbers and false otherwise.
(with-test
  (defn fc80 [n]
    :TODO)

  (is (= (fc80 6) true))
  (is (= (fc80 7) false))
  (is (= (fc80 496) true))
  (is (= (fc80 500) false))
  (is (= (fc80 8128) true)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 97
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn pascals-triangle [acc max]
  (let [row #(conj (into [1] (map (fn [c] (reduce + c)) (partition 2 1 %))) 1)]
    (if (= (count acc) max)
      acc
      (recur (conj acc (row (last acc))) max))))

(with-test
  (defn fc97 [n]
    (last (pascals-triangle [[1]] n)))

  (is (= (fc97 1) [1]))
  (is (= (map fc97 (range 1 6))
      [[1]
       [1 1]
       [1 2 1]
       [1 3 3 1]
       [1 4 6 4 1]]))
  (is (= (fc97 11)
        [1 10 45 120 210 252 210 120 45 10 1])))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 115
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (def fc115
    (fn [n]
      (if (zero? n)
        true
        (let [num (str n)
              cnt (count num)
              div (if (odd? cnt)
                    (dec (/ cnt 2))
                    (/ cnt 2))
              a   (reduce + (map #(Integer/parseInt (str %)) (take div num)))
              b   (reduce + (map #(Integer/parseInt (str %)) (take div (reverse num))))]
          (= a b)))))

  (is (= true  (fc115 11)))
  (is (= true  (fc115 121)))
  (is (= false (fc115 123)))
  (is (= true  (fc115 0)))
  (is (= false (fc115 88099)))
  (is (= true  (fc115 89098)))
  (is (= true  (fc115 89089)))
  (is (= (take 20 (filter fc115 (range)))
         [0 1 2 3 4 5 6 7 8 9 11 22 33 44 55 66 77 88 99 101])))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 146
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(with-test
  (defn fc146 [m]
    (into {}
          (apply concat
                 (for [[k v] m]
                   (map #(vector [k (first %)] (second %)) v)))))

  (is (= (fc146 '{a {p 1, q 2}
                  b {m 3, n 4}})
         '{[a p] 1, [a q] 2
           [b m] 3, [b n] 4}))
  (is (= (fc146 '{[1] {a b c d}
                  [2] {q r s t u v w x}})
         '{[[1] a] b, [[1] c] d,
           [[2] q] r, [[2] s] t,
           [[2] u] v, [[2] w] x}))
  (is (= (fc146 '{m {1 [a b c] 3 nil}})
         '{[m 1] [a b c], [m 3] nil})))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 1
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 1
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 1
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 1
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 1
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 1
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

