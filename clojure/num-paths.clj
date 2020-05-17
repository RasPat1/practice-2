;Given an n by m grid, where 1, 1 represents the
;top-left and n, m represents the bottom-right
;Output the number of distinct paths leading from
;1, 1 to n, m with the constraint that from each
;cell you can only move either right or down.
;Or in other words (i, j) -> (i + 1, j) and
;i(i, j) -> (i, j + 1)


(defn num-paths
  ([n m]
    (if (or (<= n 1) (<= m 1)) 1
    (+ (num-paths (- n 1) m) (num-paths n (- m 1))))
  ))

; tests
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
