; Given an n by m grid give the number of paths from
; 1, 1 (top left) to n, m (bottom right)
; count the number of paths to go from 1, 1 to n, m
; Where the only two action allowed are a movement
; from (i, j) -> (i + 1, j) and (i, j) -> (i, j + 1)


(defn num-paths
  ([n m]
    (if (or (<= n 1) (<= m 1)) 1
    (+ (num-paths (- n 1) m) (num-paths n (- m 1))))
  ))

(num-paths 0 3)
(num-paths 1 3)
(num-paths 1 1)
(num-paths 10 1)
(num-paths 1 10)

(num-paths 2 2)
(num-paths 2 3)
(num-paths 3 2)
(num-paths 3 3)
(num-paths 10 10)
